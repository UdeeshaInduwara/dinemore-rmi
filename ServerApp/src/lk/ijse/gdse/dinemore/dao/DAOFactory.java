package lk.ijse.gdse.dinemore.dao;

import lk.ijse.gdse.dinemore.dao.custom.impl.*;

public class DAOFactory {
    public enum DAOTypes{
        CUSTOMER,RECEPTION,CHEF,DELIVERBOY,FOOD,ORDER,ORDERDETAIL
    }
    private static DAOFactory daoFactory;
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    private DAOFactory(){
    }
    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch(daoType){
            case CUSTOMER: return (T) new CustomerDAOImpl();
            case RECEPTION: return (T) new ReceptionDAOImpl();
            case CHEF: return (T) new ChefDAOImpl();
            case DELIVERBOY: return (T) new DeliverBoyDAOImpl();
            case FOOD: return (T) new FoodDAOImpl();
            case ORDER: return (T) new OrderDAOImpl();
            case ORDERDETAIL: return (T) new OrderDetailDAOImpl();
            default: return null;
        }
    }
}
