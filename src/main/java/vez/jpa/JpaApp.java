package vez.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vez.jpa.model.Chart;
import vez.jpa.model.SubjArea;
import vez.jpa.repo.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

@SpringBootApplication
public class JpaApp implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApp.class);

    @Autowired ChartRepo chartRepo;
    @Autowired SubjAreaRepo subjAreaRepo;
    @Autowired UserRepo userRepo;
    @Autowired CategoryRepo categoryRepo;
    @Autowired ActivityRepo activityRepo;

    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*
        //region Create Categories
        log.info("******** Create Categories: **********");
        LongStream.range(1L, 4L)
                .mapToObj(l -> new Category( "Category_"+l) )
                .map(categoryRepo::save)
                .forEach(item -> log.info(item.toString()));
        //endregion
        //region Create Charts
        log.info("******** Save Activity with Ref to Category: **********");
        LongStream.range(1L, 11L)
                .mapToObj(l -> {
                    long catId = ThreadLocalRandom.current().nextLong(3L)+1;
                    Category catProxy = categoryRepo.getById(catId);   // получаем proxy
                    Activity activity = new Activity(catProxy, "Activity_"+catId+"-"+l);
                    return activityRepo.save(activity);
                } )
                .forEach(activity -> log.info(activity.toString()));

        log.info("******** Selecting Activities: **********");
        // activityRepo.findAll().forEach(activity -> log.info(activity.toString()));
        Activity act = activityRepo.findById(8L).orElseThrow(()-> new RuntimeException("Not found by id: 8"));
        log.info(String.valueOf( act.getCategory().getId() ));
        //endregion
*/

/*
        log.info("******** Create Users: **********");
        User user = new User("johndoe");
        Address address = new Address(user,"12345");
        User saved = userRepo.save(user);

        Optional<User> found = userRepo.findById(saved.getId());
        log.info(found.orElse(new User("notfound")).getUsername());
*/

        //region Create SubjectArea with Charts
        log.info("******** Create SubjArea: **********");
        LongStream.range(1L, 4L)
                .mapToObj(l -> new SubjArea(l, "SubjectArea_"+l) )
                .map(subjAreaRepo::save)
                .forEach(item -> log.info(item.toString()));

        log.info("******** Create Charts with Refs: **********");
        LongStream.range(1L, 11L)
                .mapToObj(l -> {
                    long subjId = ThreadLocalRandom.current().nextLong(3L)+1;
                    SubjArea subjArea = subjAreaRepo.getById(subjId);   // получаем proxy
                    Chart chart = new Chart( subjArea, "Chart_"+subjId+"-"+l);
                    return chartRepo.save(chart);
                } )
                .forEach(chart -> log.info(chart.toString()));

        log.info("******** Selecting Charts with Ref: **********");
        chartRepo.findAll()
                .forEach(chart -> log.info(chart.toString()));
        log.info("******** Selecting SubjAreas: **********");
/*
        subjAreaRepo.findAll()
                .forEach(subjArea -> log.info(subjArea.toString()));
*/

        subjAreaRepo.findById(1L).ifPresent(subjArea -> log.info(subjArea.toString()));
        //endregion

    }
}
