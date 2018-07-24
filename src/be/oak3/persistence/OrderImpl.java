package be.oak3.persistence;

import be.oak3.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements Order {

    // INSTANCE VARIABELEN
    private List<Product> products;
    private static int productNumber = 1000;

    // CONSTRUCTORS
    public OrderImpl() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        product.setProductNumber(productNumber++);
        products.add(product);
    }

    @Override
    public void sortOnBrandName() {
        //TODO: implement method using lambda's and streams
    }

    @Override
    public void showProductsOfBrandName(String brandName) {
        //TODO: implement method using lambda's and streams
    }

    @Override
    public void showOnlyParfums() {
        //TODO: implement method using lambda's and streams
    }

    @Override
    public Product searchMostExpensiveProduct() {
        //TODO: implement method using lambda's and streams
        return null;
    }

    @Override
    public void sort() {
        //TODO: implement method using lambda's and streams
    }

    @Override
    public void sortOnVolume() {
        //TODO: implement method using lambda's and streams
    }

    @Override
    public void showAllProductsWithPriceLowerThen50() {
        //TODO: implement method using lambda's and streams
    }

    @Override
    public double totalPrice() {
        //TODO: implement method using lambda's and streams
        return 0;
    }
}
