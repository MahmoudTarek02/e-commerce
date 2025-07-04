package model;

public class Product {

    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public boolean isExpired() {
        // will be overridden in subclasses exprirable products
        return false;
    }

    public boolean isShippable() {
        // will be overridden in subclasses for specific shipping conditions
        return false;
    }   

    public void decrementQuantity(int amount) {
        this.quantity -= amount;
    }

}