package be.oak3.persistence;

import be.oak3.model.Product;

public interface Order {

    void addProduct(Product product);

    void sortOnBrandName();

    void showProductsOfBrandName(String brandName);

    void showOnlyParfums();

    Product searchMostExpensiveProduct();

    void sort();

    void sortOnVolume();

    void showAllProductsWithPriceLowerThen50();

    double totalPrice();
}
