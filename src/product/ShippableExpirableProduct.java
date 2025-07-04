package product;

import java.time.LocalDate;

public class ShippableExpirableProduct extends ExpirableProduct implements Shippable {

    private double weight;

    public ShippableExpirableProduct(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
    