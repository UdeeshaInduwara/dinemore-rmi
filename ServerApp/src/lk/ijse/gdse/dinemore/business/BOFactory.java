package lk.ijse.gdse.dinemore.business;

import lk.ijse.gdse.dinemore.business.custom.impl.AdminBOImpl;
import lk.ijse.gdse.dinemore.business.custom.impl.ChefBOImpl;
import lk.ijse.gdse.dinemore.business.custom.impl.DeliverBoyBOImpl;
import lk.ijse.gdse.dinemore.business.custom.impl.ReceptionBOImpl;

public class BOFactory {
    public enum BOTypes{
        RECEPTION,ADMIN,CHEF,DELIVERBOY
    }
    private static BOFactory boFactory;
    public static BOFactory getInstance(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    private BOFactory(){
    }
    public <T extends SuperBO> T getBO(BOTypes boType){
        switch(boType){
            case RECEPTION: return (T) new ReceptionBOImpl();
            case ADMIN: return (T) new AdminBOImpl();
            case CHEF: return (T) new ChefBOImpl();
            case DELIVERBOY:return (T) new DeliverBoyBOImpl();
            default: return null;
        }
    }
}
