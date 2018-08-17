package be.oak3.persistence;

import be.oak3.model.Parfum;
import be.oak3.model.Product;

import javax.persistence.*;
import java.util.Comparator;

public class OrderDaoImpl implements Order {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction tx = null;

    @Override
    public void addProduct(Product product) {
        tx = openDb();
        tx.begin();
        em.persist(product);
        closeDb();
    }

    @Override
    public void sortOnBrandName() {
        tx = openDb();
        tx.begin();
        TypedQuery<Product> query = em.createQuery("select p from Product as p", Product.class);
        query.getResultStream().sorted(Product.sortOnBrandName()).forEach(System.out::println);
        closeDb();
    }

    @Override
    public void showProductsOfBrandName(String brandName) {
        tx = openDb();
        tx.begin();
        TypedQuery<Product> query = em.createQuery("select p from Product as p where p.brandName =:name", Product.class);
        query.setParameter("name", brandName);
        query.getResultStream().forEach(System.out::println);
        closeDb();
    }

    @Override
    public void showOnlyParfums() {
        tx = openDb();
        tx.begin();
        TypedQuery<Product> query = em.createQuery("select p from Product as p", Product.class);
        query.getResultStream().filter(product -> product instanceof Parfum).forEach(System.out::println);
        closeDb();
    }

    @Override
    public Product searchMostExpensiveProduct() {
        tx = openDb();
        tx.begin();
        TypedQuery<Product> query = em.createQuery("select p from Product as p", Product.class);
        Product product = query.getResultStream().max(Comparator.comparingDouble(Product::getPrice)).get();
        closeDb();
        return product;
    }

    @Override
    public void sort() {
        tx = openDb();
        tx.begin();
        TypedQuery<Product> query = em.createQuery("select p from Product as p", Product.class);
        query.getResultStream().sorted(Product::compareTo).forEach(System.out::println);
        closeDb();
    }

    @Override
    public void sortOnVolume() {
        tx = openDb();
        tx.begin();
        TypedQuery<Product> query = em.createQuery("select p from Product as p", Product.class);
        query.getResultStream().sorted(Comparator.comparingInt(Product::getVolume)).forEach(System.out::println);
        closeDb();
    }

    @Override
    public void showAllProductsWithPriceLowerThen50() {
        tx = openDb();
        tx.begin();
        TypedQuery<Product> query = em.createQuery("select p from Product as p where p.price <= 50", Product.class);
        query.getResultStream().forEach(System.out::println);
        closeDb();
    }

    @Override
    public double totalPrice() {
        tx = openDb();
        tx.begin();
        TypedQuery<Product> query = em.createQuery("select p from Product as p", Product.class);
        Double sum = query.getResultStream().mapToDouble(Product::getPrice).sum();
        closeDb();
        return sum;
    }

    private EntityTransaction openDb(){
        emf = Persistence.createEntityManagerFactory( "hibernate-course"  );
        em = emf.createEntityManager();
        tx = em.getTransaction();
        return tx;
    }

    private void closeDb(){
        tx.commit();
        em.close();
        emf.close();
    }

}
