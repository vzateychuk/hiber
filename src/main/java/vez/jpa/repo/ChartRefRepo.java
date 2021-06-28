package vez.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vez.jpa.model.ChartRef;
import vez.jpa.model.RefId;

public interface ChartRefRepo extends JpaRepository<ChartRef, RefId> {
}
