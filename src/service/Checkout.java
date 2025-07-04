package service;

import model.Cart;
import model.CartItem;
import model.Customer;
import model.Product;
import product.Shippable;


import java.util.ArrayList;
import java.util.List;

public class Checkout {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        List <CartItem> items = cart.getItems();
        double subTotal = 0.0;
        double shippingCost = 0.0;

        List<CartItem> shippableItems = new ArrayList<>();

        double ratePerKg = 1.0;


        for (CartItem item : items) {
            Product product = item.product;

            if (product.isExpired()) {
                System.out.println("Product " + product.getName() + " is expired");
                return;
            }

            if (item.quantity > product.getQuantity()) {
                System.out.println("Requested quantity for " + product.getName() + " exceeds available stock.");
                return;
            }

            subTotal += item.getTotalPrice(); // quantity * price

            if (product instanceof Shippable) {
                double itemWeight = ((Shippable) product).getWeight();
                double shippingForThisItem = item.quantity * itemWeight * ratePerKg;
                shippableItems.add(item);
                // shipping is dependent on the weight and quantity of the item
                shippingCost += shippingForThisItem; // quantity * weight * ratePerKg
            }

        }

        double total = subTotal + shippingCost;
        if (!customer.canAfford(total)) {
            System.out.println("Customer cannot afford " + total + ".");            
            return;
        }
        customer.decrementBalance(total);

        ShippingService.ship(shippableItems);

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.quantity + "x " + item.product.getName() + " " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subTotal);
        System.out.println("Shipping: " + shippingCost);
        System.out.println("Amount: " + total);
        System.out.println("Remaining Balance: " + customer.getBalance());
    }

}
