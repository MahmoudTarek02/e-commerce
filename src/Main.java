import model.Cart;
import model.Customer;
import product.*;
import service.Checkout;
import model.Admin;
import model.Product;
import service.Store;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        

        Admin admin = new Admin("Admin1");

        // Adding products to stock 
        Product cheese = new ShippableExpirableProduct(
                "Cheese",
                10.0,
                5,
                LocalDate.of(2025, 10, 1),
                0.4);

        Product TV = new ShippableProduct(
                "TV",
                500.0,
                2,
                50.0);

        Product biscuit = new ShippableExpirableProduct(
                "Biscuit",
                2.0,
                10,
                LocalDate.of(2025, 12, 31),
                0.5);

        Product mobileScratchCard = new Product("Mobile Scratch Card", 10.0, 50);
        
        // Adding products to store inventory by admin 

        admin.addProductToStore(cheese);
        admin.addProductToStore(TV);
        admin.addProductToStore(biscuit);
        admin.addProductToStore(mobileScratchCard);

        Customer customer = new Customer("Mahmoud Tarek", 1000.0);
        Cart cart = new Cart();

        // Adding products to cart by customer

        cart.add(Store.findProductByName("Cheese"), 2);
        cart.add(Store.findProductByName("TV"), 1);
        cart.add(Store.findProductByName("Biscuit"), 3);
        cart.add(Store.findProductByName("Mobile Scratch Card"), 5);

        Checkout.checkout(customer, cart);
    }
}


