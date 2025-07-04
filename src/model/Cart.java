package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Error: Requested quantity exceeds available.");
            return;
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void clearCart() {
        items.clear();
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.product.equals(product));
    }

    public void decrementItemQuantity(Product product, int amount) {
        for (CartItem item : items) {
            if (item.product.equals(product)) {
                if (item.quantity >= amount) {
                    item.quantity -= amount;
                    if (item.quantity == 0) {
                        items.remove(item);
                    }
                } else {
                    System.out.println("Error: Not enough quantity to decrement.");
                }
                return;
            }
        }
        System.out.println("Error: Product not found in cart.");
    }

    public void incrementItemQuantity(Product product, int amount) {
        for (CartItem item : items) {
            if (item.product.equals(product)) {
                item.quantity += amount;
                return;
            }
        }
        System.out.println("Error: Product not found in cart.");
    }

    
}
