package service;

import model.CartItem;
import model.Product;
import product.Shippable;

import java.util.List;

public class ShippingService {
    public static void ship(List<CartItem> shippableItems) {
        if (shippableItems.isEmpty()) {
            System.out.println("No items to ship.");
            return;
        }

        double totalWeight = 0.0;
        System.out.println("** Shipment notice **");
        for (CartItem item : shippableItems) {
            Product product = item.product;
            
            if(product instanceof Shippable) {
                Shippable shippableProduct = (Shippable) product;
                int quantity = item.quantity;
                double weight = shippableProduct.getWeight() * quantity;

                System.out.println(quantity + "x " + product.getName() + "  " + String.format("%.1f", weight) + "kg");
                totalWeight += weight;
                
            }
        }

        System.out.println("Total package weight " + String.format("%.1f", totalWeight) + "kg");
        System.out.println();
    }
}
