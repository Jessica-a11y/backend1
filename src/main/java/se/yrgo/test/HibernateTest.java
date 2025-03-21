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

        /* Category hairCare = new Category("Hair Care");
        Product p1 = new Product(1567, "Moisture Shampoo", "XL", 349);
        Product p2 = new Product(1568, "Moisture Conditioner", "XL", 349);
        Product p3 = new Product(1570, "Leave-in Conditioner", "XL", 169);
        hairCare.addProductToList(p1);
        hairCare.addProductToList(p2);
        hairCare.addProductToList(p3);

        session.save(hairCare);
        session.save(p1);
        session.save(p2);
        session.save(p3); */

        Category myCategory = (Category)session.get(Category.class, 1);
        List<Product> productList = myCategory.getProducts();
        for(Product p : productList) {
            System.out.println(p);
        }
        
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
