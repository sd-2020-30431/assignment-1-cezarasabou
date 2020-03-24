package wasteless.server.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wasteless.server.business.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
