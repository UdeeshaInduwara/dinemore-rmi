package lk.ijse.gdse.dinemore.dao.custom.impl;

import lk.ijse.gdse.dinemore.dao.custom.ReceptionDAO;
import lk.ijse.gdse.dinemore.entity.Reception;
import lk.ijse.gdse.dinemore.utill.HibernateUtill;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;

public class ReceptionDAOImpl implements ReceptionDAO {
    @Override
    public boolean save(Reception entity) throws Exception {
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
    public boolean update(Reception entity) throws Exception {
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Reception reception = session.get(Reception.class, entity.getRecId());
            reception.setName(entity.getName());
            reception.setContactNo(entity.getContactNo());
            reception.setPassword(entity.getPassword());
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
            Reception reception = session.get(Reception.class, s);
            session.delete(reception);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public Reception search(String s) throws Exception {
        return null;
    }


    @Override
    public ArrayList<Reception> getAll() throws Exception {
        ArrayList<Reception> entries=null;
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query =session.createNativeQuery("SELECT * FROM reception");
            query.setResultTransformer(Transformers.aliasToBean(Reception.class));
            entries = (ArrayList<Reception>) query.getResultList();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            return null;
        }
        return entries;
    }
}
