package vez.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vez.jpa.model.SubjArea;

public interface AreaRepo extends JpaRepository<SubjArea, Long> {
}
