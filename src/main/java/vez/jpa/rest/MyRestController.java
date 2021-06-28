package vez.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vez.jpa.model.Chart;
import vez.jpa.repo.ChartRepo;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired ChartRepo repo;

    @GetMapping("/chart")
    public List<Chart> getAll() {
        return repo.findAll();
    }
}
