package vez.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vez.jpa.model.Activity;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
