package lk.ijse.gdse.dinemore.dao.custom.impl;

import lk.ijse.gdse.dinemore.dao.custom.ChefDAO;
import lk.ijse.gdse.dinemore.entity.Chef;
import lk.ijse.gdse.dinemore.utill.HibernateUtill;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;

public class ChefDAOImpl implements ChefDAO {
    @Override
    public boolean save(Chef entity) throws Exception {
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
    public boolean update(Chef entity) throws Exception {
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Chef chef = session.get(Chef.class, entity.getChefId());
            chef.setName(entity.getName());
            chef.setContactNo(entity.getContactNo());
            chef.setPassword(entity.getPassword());
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
            Chef chef = session.get(Chef.class, s);
            session.delete(chef);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public Chef search(String s) throws Exception {
        return null;
    }


    @Override
    public ArrayList<Chef> getAll() throws Exception {
        ArrayList<Chef> entries=null;
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query =session.createNativeQuery("SELECT * FROM chef");
            query.setResultTransformer(Transformers.aliasToBean(Chef.class));
            entries = (ArrayList<Chef>) query.getResultList();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            return null;
        }
        return entries;
    }
}
