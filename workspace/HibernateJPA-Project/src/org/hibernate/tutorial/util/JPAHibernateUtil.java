package org.hibernate.tutorial.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class JPAHibernateUtil {

    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	//return new Configuration().configure("oracle.cfg.xml").buildSessionFactory();

        	//by default it would search hibernate.cfg.xml file
            //return new Configuration().configure().buildSessionFactory();
        	
        	return Persistence.createEntityManagerFactory("Hibernate-JPA");
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}