package models;

public class Product {
    private final int id;
    private String productName;
    private double price;
    private int quantity;
    private Brand brand;
    private static int count = 1;

    public Product() {
        this.id = count++;
    }

    public Product(String productName, double price, int quantity, Brand brand) {
        this.id = count++;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", brand=" + brand +
                '}';
    }
}
