package DAO;

import models.Brand;
import models.Product;

import java.util.ArrayList;

public class ProductDAO {
    private static final ArrayList<Product> products = new ArrayList<>();

    public static ArrayList<Product> getAllProducts() {
        return products;
    }

    public static void addProduct(String productName, double price, int quantity, Brand brand) {
        Product product = new Product(productName, price, quantity, brand);
        products.add(product);
    }
}
