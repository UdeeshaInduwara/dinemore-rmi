package lk.ijse.gdse.dinemore.dao.custom.impl;

import lk.ijse.gdse.dinemore.dao.custom.DeliverBoyDAO;
import lk.ijse.gdse.dinemore.entity.DeliverBoy;
import lk.ijse.gdse.dinemore.utill.HibernateUtill;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.List;

public class DeliverBoyDAOImpl implements DeliverBoyDAO {
    @Override
    public boolean save(DeliverBoy entity) throws Exception {
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
    public boolean update(DeliverBoy entity) throws Exception {
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            DeliverBoy deliverBoy = session.get(DeliverBoy.class, entity.getDelBId());
            deliverBoy.setName(entity.getName());
            deliverBoy.setContactNo(entity.getContactNo());
            deliverBoy.setPassword(entity.getPassword());
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
            DeliverBoy deliverBoy = session.get(DeliverBoy.class, s);
            session.delete(deliverBoy);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public DeliverBoy search(String s) throws Exception {
        return null;
    }


    @Override
    public ArrayList<DeliverBoy> getAll() throws Exception {
        ArrayList<DeliverBoy> entries=null;
        SessionFactory sessionFactory = HibernateUtill.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query =session.createNativeQuery("SELECT * FROM deliverboy");
            query.setResultTransformer(Transformers.aliasToBean(DeliverBoy.class));
            entries = (ArrayList<DeliverBoy>) query.getResultList();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            return null;
        }
        return entries;
    }
}
