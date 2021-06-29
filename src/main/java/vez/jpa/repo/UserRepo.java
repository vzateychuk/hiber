package vez.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vez.jpa.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
