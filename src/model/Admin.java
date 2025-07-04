package model;

import service.Store;

public class Admin {
    
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public void addProductToStore(Product product) {
        Store.addProduct(product);
        System.out.println("Admin " + name + " added product: " + product.getName() + " to the store.");
    }
}
