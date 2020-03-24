package wasteless.server.business;

import java.util.Date;

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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getCalorieValue() {
        return calorieValue;
    }

    public void setCalorieValue(Float calorieValue) {
        this.calorieValue = calorieValue;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }
}
