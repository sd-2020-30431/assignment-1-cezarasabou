package wasteless.server.business;

import org.springframework.stereotype.Service;
import wasteless.server.model.GroceryList;
import wasteless.server.model.Item;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class WasteManagerService {

    private int wasteLimit;
    private int idealBurndownRate;


    private int getTotalCalories(GroceryList groceryList, int userGoal, LocalDate calculationDay) {

        int totalCalories = 0;
        for(Item item : groceryList.getGroceryItems()){
            if(!item.checkIfAlreadyExpired(calculationDay)) {
                totalCalories += item.getCalorieValue();
            }
        }

        return totalCalories;
    }




}
