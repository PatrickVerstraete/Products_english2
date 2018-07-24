package be.oak3.model;

import java.util.Comparator;

public abstract class Product implements Comparable<Product> {

    // INSTANCE VARIABELEN
    private int productNumber;
    private String brandName;
    private String name;
    private int volume;
    private double price;

    // CONSTRUCTOR
    public Product(int productNumber, String brandName, String name, int volume,
                   double price) {
        this.setProductNumber(productNumber);
        this.setBrandName(brandName);
        this.setName(name);
        this.setPrice(price);
        this.setVolume(volume);
    }

    // GETTERS
    public int getProductNumber() {
        return productNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public double getPrice() {
        return price;
    }

    // SETTERS
    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Other methods
    public String getProductCode() {
        //TODO: return first three letters of brandName then first 3 letters of Name and then the volume. Spaces should be replaced by underscore and everything should be in uppercase! EXAMPLE: Brandname: Dolce & Gabbana   Name: Light Blue  Volume: 100ml  Code: DOLLIG100
        return null;
    }

    public static Comparator<Product> sortOnBrandName() {

        //TODO: implement using LAMBDAS
        return null;
    }

    // OVERSCHRIJVEN VAN METHODS
    @Override
    public String toString() {

        return String.format(
                "%d %s %-20s %10s %-24s %10s %3sml %8s %4.2f %5s %s",
                productNumber, "Merk:", brandName, "Naam:", name, "Volume:", volume,
                "Prijs:", price, "Code:", getProductCode());
    }

    @Override
    public int compareTo(Product o) {
        return this.productNumber - o.productNumber;
    }
}
