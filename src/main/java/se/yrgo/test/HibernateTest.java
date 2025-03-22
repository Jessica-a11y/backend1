package se.yrgo.test;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Category;
import se.yrgo.domain.Product;

import org.hibernate.Transaction;

public class HibernateTest {
    private static SessionFactory sessionFactory = null;
    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Run this code first to create tables and save data. Change to 'create'.
        Category electronics = new Category("Electronics");
        Product product1 = new Product(1567, "Smartphone", "Apple", 12800);
        Product product2 = new Product(1568, "Wierless Headphones", "Sonos", 2299);
        Product product3 = new Product(1570, "DSLR Camera", "Nikon", 5499);
        electronics.addProductToList(product1);
        electronics.addProductToList(product2);
        electronics.addProductToList(product3);

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(electronics);

        // Get products from a category. Change to 'update'.
        /* Category aCategory = (Category)session.get(Category.class, 4);
        List<Product> productList = aCategory.getProducts();
        for(Product p : productList) {
            System.out.println(p);
        } */ 
        
        tx.commit();
        session.close();
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration config = new Configuration();
            config.configure();
            sessionFactory = config.buildSessionFactory();
        }
        
        return sessionFactory;
    }
}
