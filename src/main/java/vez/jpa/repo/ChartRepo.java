package vez.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vez.jpa.model.Chart;

public interface ChartRepo extends JpaRepository<Chart, Long> {
}
