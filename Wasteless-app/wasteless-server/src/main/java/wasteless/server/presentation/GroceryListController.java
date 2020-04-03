package wasteless.server.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wasteless.server.model.GroceryList;
import wasteless.server.exception.ResourceNotFoundException;
import wasteless.server.persistance.GroceryListRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class GroceryListController {
    private final GroceryListRepository groceryListRepository;

    public GroceryListController(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    @GetMapping("/grocery_lists")
    public List<GroceryList> getAllItems() {
        return groceryListRepository.findAll();
    }

    @GetMapping("/grocery_lists/{id}")
    public ResponseEntity<GroceryList> getItemById(@PathVariable(value = "id") Long groceryListId)
            throws ResourceNotFoundException {
        GroceryList groceryList = groceryListRepository.findById(groceryListId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + groceryListId));
        return ResponseEntity.ok().body(groceryList);
    }

    @PostMapping("/grocery_lists")
    public GroceryList createGroceryList(@Valid @RequestBody GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

    @PutMapping("/grocery_lists/{id}")
    public ResponseEntity<GroceryList> updateItem(@PathVariable(value = "list_id") Long groceryListId,
                                           @Valid @RequestBody GroceryList groceryListDetails) throws ResourceNotFoundException {
        GroceryList groceryList = groceryListRepository.findById(groceryListId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + groceryListId));


        //aici nu stiu cum sa preiau datele din items
        groceryList.setGroceryListName(groceryListDetails.getGroceryListName());
        groceryList.setGroceryItems(groceryListDetails.getGroceryItems());

        final GroceryList updatedGroceryList = groceryListRepository.save(groceryList);
        return ResponseEntity.ok(updatedGroceryList);
    }

    @DeleteMapping("/grocery_lists/{id}")
    public Map<String, Boolean> deleteGroceryList(@PathVariable(value = "list_id") Long groceryListId)
            throws ResourceNotFoundException {
        GroceryList groceryList = groceryListRepository.findById(groceryListId)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery list not found for this id :: " + groceryListId));

        groceryListRepository.delete(groceryList);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
