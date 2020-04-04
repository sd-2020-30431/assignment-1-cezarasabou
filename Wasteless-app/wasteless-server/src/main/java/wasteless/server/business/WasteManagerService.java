package wasteless.server.business;

import org.springframework.stereotype.Service;
import wasteless.server.model.Item;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class WasteManagerService {

    private List<Item> itemList = new LinkedList<>();
    private int wasteLimit;
    private int idealBurndownRate;

    private int getTotalCalories(int PeriodInDays){

        int totalCalories = 0;
        for(Item item : itemList){
            if(!item.checkIfAlreadyExpired()) {
                totalCalories += item.getCalorieValue();
            }
        }

        return totalCalories;
    }

    private int getActualBurndownRate(int periodInDays){
        int calories = 0;
        LocalDate currentDate = LocalDate.now();
        LocalDate dateAfterRequiredDays = currentDate.plusDays(periodInDays);

        for(Item item : itemList){
            if(item.getExpirationDate().isBefore(dateAfterRequiredDays)){
                calories += item.getCalorieValue();
            }
        }


        return calories/periodInDays;
    }

    //from here we notify the user if the waste levels exceed the limits
    private boolean wasteExceedsLimits(int periodInDays){
        return getActualBurndownRate(periodInDays) > idealBurndownRate;
    }
}
