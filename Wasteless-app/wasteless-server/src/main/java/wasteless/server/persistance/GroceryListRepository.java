package wasteless.server.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wasteless.server.business.GroceryList;
import wasteless.server.business.User;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Long> {

}
