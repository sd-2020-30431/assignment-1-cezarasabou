package wasteless.server.business;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Table(name = "items")
public class Item {
    private Long itemId;


    private String itemName;
    private Float quantity;
    private Float calorieValue;
    private LocalDate purchaseDate;
    private LocalDate expirationDate;
    private LocalDate consumptionDate;

    public Item() {

    }

    public Item(String itemName, Float quantity, Float calorieValue, LocalDate purchaseDate, LocalDate expirationDate, LocalDate consumptionDate) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.calorieValue = calorieValue;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Column(name = "item_name", nullable = false)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Column(name = "item_quantity", nullable = false)
    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    @Column(name = "calorie_value", nullable = false)
    public Float getCalorieValue() {
        return calorieValue;
    }

    public void setCalorieValue(Float calorieValue) {
        this.calorieValue = calorieValue;
    }

    @Column(name = "purchase_date", nullable = false)
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Column(name = "expiration_date", nullable = false)
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Column(name = "consumption_date", nullable = false)
    public LocalDate getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(LocalDate consumptionDate) {
        this.consumptionDate = consumptionDate;

    }

    boolean checkIfAlreadyExpired(){
        LocalDate currentDate = LocalDate.now();
        return this.expirationDate.isAfter(currentDate);
    }



    private int daysUntilExpired(){
        LocalDate currentDate = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(currentDate,expirationDate);
    }


}
