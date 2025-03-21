package se.yrgo.test;

import java.util.Set;

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
