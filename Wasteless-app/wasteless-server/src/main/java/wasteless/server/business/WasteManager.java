package wasteless.server.business;

import java.time.LocalDate;
import java.util.*;

public class WasteManager {

    private List<Item> itemList = new LinkedList<>();
    private int wasteLimit;
    private int idealBurndownRate;

    public WasteManager(List<Item> itemList, int wasteLimit) {
        this.itemList = itemList;
        this.wasteLimit = wasteLimit;
    }

    private int getTotalCalories(int PeriodInDays){

        int totalCalories = 0;
        for(Item item : itemList){
            if(item.checkIfAlreadyExpired() == false) {
                totalCalories += item.getCalorieValue();
            }
        }

        return totalCalories;
    }




    int getActualBurndownRate(int periodInDays){
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
