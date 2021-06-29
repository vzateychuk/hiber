package vez.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vez.jpa.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
