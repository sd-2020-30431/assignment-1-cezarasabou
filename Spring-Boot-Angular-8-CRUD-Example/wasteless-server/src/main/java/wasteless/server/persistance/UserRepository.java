package wasteless.server.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import wasteless.server.business.User;
import wasteless.server.model.Employee;

public interface UserRepository extends JpaRepository<User, Long> {
}
