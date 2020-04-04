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

@RestController
public class GroceryListController {
    private final GroceryListRepository groceryListRepository;

    public GroceryListController(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    @GetMapping("/groceryLists")
    public List<GroceryList> getAllGroceryLists() {
        return groceryListRepository.findAll();
    }

    @GetMapping("/groceryList/{id}")
    public ResponseEntity<GroceryList> getGroceryListById(@PathVariable(value = "id") Long groceryListId)
            throws ResourceNotFoundException {
        GroceryList groceryList = groceryListRepository.findById(groceryListId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + groceryListId));
        return ResponseEntity.ok().body(groceryList);
    }

    @PostMapping("{userId}/createGroceryList")
    public GroceryList createGroceryList(@PathVariable(value = "userId") Long userId, @Valid @RequestBody String groceryListName) {
        GroceryList groceryList = new GroceryList(groceryListName);
        return groceryListRepository.save(groceryList);
    }

    @PutMapping("/updateGroceryListItem/{userId}")
    public ResponseEntity<GroceryList> updateGroceryList(@PathVariable(value = "userId") Long groceryListId,
                                                         @Valid @RequestBody GroceryList groceryListDetails) throws ResourceNotFoundException {
        GroceryList groceryList = groceryListRepository.findById(groceryListId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + groceryListId));


        //aici nu stiu cum sa preiau datele din items
        groceryList.setGroceryListName(groceryListDetails.getGroceryListName());
        groceryList.setGroceryItems(groceryListDetails.getGroceryItems());

        final GroceryList updatedGroceryList = groceryListRepository.save(groceryList);
        return ResponseEntity.ok(updatedGroceryList);
    }

    @DeleteMapping("/deleteGroceryList/{id}")
    public Map<String, Boolean> deleteGroceryList(@PathVariable(value = "id") Long groceryListId)
            throws ResourceNotFoundException {
        GroceryList groceryList = groceryListRepository.findById(groceryListId)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery list not found for this id :: " + groceryListId));

        groceryListRepository.delete(groceryList);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
