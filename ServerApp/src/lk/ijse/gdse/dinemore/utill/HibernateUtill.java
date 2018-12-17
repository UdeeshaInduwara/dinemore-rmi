package lk.ijse.gdse.dinemore.utill;

import lk.ijse.gdse.dinemore.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtill {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .loadProperties("dinemore.properties").build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Reception.class)
                .addAnnotatedClass(Chef.class)
                .addAnnotatedClass(DeliverBoy.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Food.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetail.class)
                .buildMetadata();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
