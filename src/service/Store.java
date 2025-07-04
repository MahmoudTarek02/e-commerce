package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<Product> inventory = new ArrayList<>();

    public static void addProduct(Product product) {
        inventory.add(product);
    }
    
    public static List<Product> getInventory() {
        return new ArrayList<>(inventory);
    }

    public static void clearInventory() {
        inventory.clear();
    }

    public static void showInventory() {
        System.out.println("** Store Inventory **");
        for (Product p : inventory) {
            System.out.println(p.getName() + " - Price: " + p.getPrice() +
                    ", Stock: " + p.getQuantity());
        }
        System.out.println();
    }

    public static Product findProductByName(String name) {
        for (Product p : inventory) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}
