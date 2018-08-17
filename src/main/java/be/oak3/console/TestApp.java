package be.oak3.console;

import be.oak3.model.Product;
import be.oak3.persistence.Data;
import be.oak3.persistence.Order;
import be.oak3.persistence.OrderDaoImpl;
import be.oak3.persistence.OrderImpl;

import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        System.out.printf("Solution of %s %s\n", "Kenneth Van Gijsel ",
                "Java Trainer");

        Order order = new OrderDaoImpl();
        if (order.totalPrice() == 0) {
            List<Product> lijst = Data.getData();

            for (Product artikel : lijst) {
                order.addProduct(artikel);
            }
        }

        System.out.println("List sorted on NATURAL ORDER: ");
        order.sort();

        System.out.println("\nList sorted on brandName: ");
        order.sortOnBrandName();

        System.out.println("\nList sorted on volume: ");
        order.sortOnVolume();

        System.out.println("\nAll products of brandname Georgio Armani");
        order.showProductsOfBrandName("Georgio Armani");

        System.out.println("\nAll Parfums:");
        order.showOnlyParfums();

        System.out.println("\nAll products lower then €50; ");
        order.showAllProductsWithPriceLowerThen50();

        Product product = order.searchMostExpensiveProduct();
        System.out.println("\nMost expensive product:\n" + product);

        System.out.printf("\nTotal price of all products: €%.2f", order.totalPrice());

    }
}
