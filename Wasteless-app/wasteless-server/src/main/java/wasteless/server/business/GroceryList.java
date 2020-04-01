package wasteless.server.business;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "grocery_lists")
public class GroceryList {
    private List<Item> groceryItems = new LinkedList<>();
    private int groceryListId;
    private String groceryListName;

    public GroceryList(String groceryListName) {
        this.groceryListName = groceryListName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(int groceryListId) {
        this.groceryListId = groceryListId;
    }

    public List<Item> getGroceryItems() {
        return groceryItems;
    }

    public void setGroceryItems(List<Item> groceryItems) {
        this.groceryItems = groceryItems;
    }

    @Column(name = "list_name", nullable = false)
    public String getGroceryListName() {
        return groceryListName;
    }

    public void setGroceryListName(String groceryListName) {
        this.groceryListName = groceryListName;
    }

    public void addGroceryItem(Item newItem){
        groceryItems.add(newItem);
    }
}
