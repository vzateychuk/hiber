package vez.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vez.jpa.model.Chart;
import vez.jpa.model.ChartRef;
import vez.jpa.model.SubjArea;
import vez.jpa.repo.ChartRepo;
import vez.jpa.repo.SubjAreaRepo;
import vez.jpa.repo.UserRepo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

@SpringBootApplication
public class JpaApp implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApp.class);

    @Autowired ChartRepo chartRepo;
    @Autowired SubjAreaRepo subjAreaRepo;
    @Autowired UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*
        log.info("******** Create Users: **********");
        User user = new User("johndoe");
        Address address = new Address(user,"12345");
        User saved = userRepo.save(user);

        Optional<User> found = userRepo.findById(saved.getId());
        log.info(found.orElse(new User("notfound")).getUsername());
*/

        //region Create SubjectArea
        log.info("******** Save SubjArea: **********");
        LongStream.range(1L, 4L)
                .mapToObj(l -> new SubjArea(l, "Area_"+l) )
                .map(subjAreaRepo::save)
                .forEach(item -> log.info(item.toString()));
        //endregion
        //region Create Charts
        log.info("******** Save Chart with Refs: **********");
        LongStream.range(1L, 10L)
                .mapToObj(l -> {
                    Chart chart = new Chart( "Chart_"+l);
                    long subjAreaId = ThreadLocalRandom.current().nextLong(3L)+1;
                    ChartRef ref = new ChartRef(chart, subjAreaId);
                    chart.setRef(ref);
                    return chartRepo.save(chart);
                } )
                .forEach(chart -> log.info(chart.toString()));

        log.info("******** Selecting Charts with Ref: **********");
        chartRepo.findAll().stream()
                .forEach(chart -> log.info(chart.toString()));
        //endregion

    }
}
