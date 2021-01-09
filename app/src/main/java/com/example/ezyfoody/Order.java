package com.example.ezyfoody;

public class Order {
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Order(String foodName, int price, int quantity) {
        this.foodName = foodName;
        this.price = price;
        this.quantity=quantity;
    }

    protected String foodName;
    protected int price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected int quantity;

}
