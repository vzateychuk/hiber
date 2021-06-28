package vez.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vez.jpa.model.Chart;
import vez.jpa.model.SubjArea;
import vez.jpa.repo.ChartRefRepo;
import vez.jpa.repo.ChartRepo;
import vez.jpa.repo.SubjAreaRepo;

import java.util.stream.LongStream;

@SpringBootApplication
public class JpaApp implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApp.class);

    @Autowired ChartRepo chartRepo;
    @Autowired SubjAreaRepo subjAreaRepo;
    @Autowired
    ChartRefRepo refRepo;

    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //region Create SubjectArea
        log.info("******** Save SubjArea: **********");
        LongStream.range(1L, 4L)
                .mapToObj(l -> new SubjArea(l, "Area_"+l) )
                .map(subjAreaRepo::save)
                .forEach(item -> log.info(item.toString()));
        //endregion
        //region Create Charts
        log.info("******** Save Chart: **********");
        LongStream.range(1L, 10L)
                .mapToObj(l -> new Chart( l, "Chart_"+l) )
                .map(chartRepo::save)
                .forEach(chart -> log.info(chart.toString()));
        //endregion
        //region Create Refs
        log.info("******** Save Refs: **********");
/*
        chartRepo.findAll().stream()
                .map(chart -> {
                    long subjAreaId = ThreadLocalRandom.current().nextLong(3L)+1;
                    ChartRef ref = new ChartRef(chart.getChartId(), subjAreaId);
                    ref.setChart(chart);
                    log.info(ref.toString());
                    return refRepo.save(ref);
                })
                .forEach(ref -> log.info(ref.toString()));
*/
    }
}
