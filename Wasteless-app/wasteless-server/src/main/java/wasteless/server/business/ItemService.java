package wasteless.server.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import wasteless.server.exception.ResourceNotFoundException;
import wasteless.server.model.Item;
import wasteless.server.persistance.ItemRepository;

import javax.validation.Valid;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long itemId) throws ResourceNotFoundException{
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));
        return item;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long itemId, Item itemDetails) throws ResourceNotFoundException{
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

        item.setItemName(itemDetails.getItemName());
        item.setCalorieValue(itemDetails.getCalorieValue());
        item.setExpirationDate(itemDetails.getExpirationDate());
        item.setConsumptionDate(itemDetails.getConsumptionDate());
        item.setPurchaseDate(itemDetails.getPurchaseDate());
        item.setQuantity(itemDetails.getQuantity());

        final Item updatedItem = itemRepository.save(item);
        return updatedItem;
    }

    public void deleteItem(Long itemId) throws ResourceNotFoundException{
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

        itemRepository.delete(item);
    }

}
