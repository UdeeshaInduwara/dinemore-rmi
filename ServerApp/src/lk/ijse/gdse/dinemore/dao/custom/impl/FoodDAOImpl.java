package lk.ijse.gdse.dinemore.dao.custom.impl;

import lk.ijse.gdse.dinemore.dao.custom.FoodDAO;
import lk.ijse.gdse.dinemore.entity.Food;
import lk.ijse.gdse.dinemore.utill.HibernateUtill;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;

public class FoodDAOImpl implements FoodDAO {
    @Override
    public boolean save(Food entity) throws Exception {
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Food entity) throws Exception {
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Food food = session.get(Food.class, entity.getFoodId());
            food.setName(entity.getName());
            food.setPrice(entity.getPrice());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Food food = session.get(Food.class, s);
            session.delete(food);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public Food search(String s) throws Exception {
        return null;
    }


    @Override
    public ArrayList<Food> getAll() throws Exception {
        ArrayList<Food> entries=null;
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query =session.createNativeQuery("SELECT * FROM food");
            query.setResultTransformer(Transformers.aliasToBean(Food.class));
            entries = (ArrayList<Food>) query.getResultList();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            return null;
        }
        return entries;
    }
}
