package wasteless.server.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wasteless.server.business.GroceryListService;
import wasteless.server.model.GroceryList;
import wasteless.server.exception.ResourceNotFoundException;
import wasteless.server.model.User;
import wasteless.server.presentation.dto.GroceryListDTO;
import wasteless.server.presentation.dto.UserDTO;
import wasteless.server.presentation.mapper.GroceryListMapper;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class GroceryListController {

    private final GroceryListService groceryListService;
    private final GroceryListMapper groceryListMapper;

    public GroceryListController(GroceryListService groceryListService, GroceryListMapper groceryListMapper) {
        this.groceryListService = groceryListService;
        this.groceryListMapper = groceryListMapper;
    }

    //aici am ramas sa fac o functie care converteste cu mapperul din lista in dto
    @GetMapping("/groceryLists")
    public List<GroceryListDTO> getAllGroceryLists() {
        return groceryListService.getAllGroceryLists()
                .stream()
                .map(groceryListMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/groceryList/{id}")
    public ResponseEntity<GroceryListDTO> getGroceryListById(@PathVariable(value = "id") Long groceryListId)
            throws ResourceNotFoundException {
        GroceryList groceryList = groceryListService.getGroceryListById(groceryListId);
        return ResponseEntity.ok().body(groceryListMapper.convertToDTO(groceryList));
    }

    @PostMapping("{userId}/createGroceryList")
    public GroceryListDTO createGroceryList(@PathVariable(value = "userId") Long userId, @Valid @RequestBody String groceryListName) {
        GroceryList groceryList = groceryListService.createGroceryList(userId,groceryListName);
        return groceryListMapper.convertToDTO(groceryList);
    }

    @PutMapping("/updateGroceryListItem/{userId}")
    public ResponseEntity<GroceryListDTO> updateGroceryList(@PathVariable(value = "userId") Long groceryListId,
                                                         @Valid @RequestBody GroceryList groceryListDetails) throws ResourceNotFoundException {

        final GroceryList updatedGroceryList = groceryListService.updateGroceryList(groceryListId,groceryListDetails);
        return ResponseEntity.ok(groceryListMapper.convertToDTO(updatedGroceryList));
    }

    @DeleteMapping("/deleteGroceryList/{id}")
    public Map<String, Boolean> deleteGroceryList(@PathVariable(value = "id") Long groceryListId)
            throws ResourceNotFoundException {
        groceryListService.deleteGroceryList(groceryListId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
