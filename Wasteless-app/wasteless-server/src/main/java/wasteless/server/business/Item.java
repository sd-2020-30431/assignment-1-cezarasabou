package wasteless.server.business;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
public class Item {
    private Long itemId;


    private String itemName;
    private Float quantity;
    private Float calorieValue;
    private Date purchaseDate;
    private Date expirationDate;
    private Date consumptionDate;

    public Item(String itemName, Float quantity, Float calorieValue, Date purchaseDate, Date expirationDate, Date consumptionDate) {
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
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Column(name = "expiration_date", nullable = false)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Column(name = "consumption_date", nullable = false)
    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }
}
