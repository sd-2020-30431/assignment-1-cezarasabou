package wasteless.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wasteless.server.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

