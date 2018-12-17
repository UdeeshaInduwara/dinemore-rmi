package lk.ijse.gdse.dinemore.dao.custom;

import lk.ijse.gdse.dinemore.dao.CrudDAO;
import lk.ijse.gdse.dinemore.entity.Orders;
import lk.ijse.gdse.dinemore.entity.OrdersEntity;

import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<OrdersEntity,String> {
    public ArrayList<OrdersEntity> getAllOrder() throws Exception;
    public boolean setCookingStartTime(OrdersEntity dto) throws Exception;
    public ArrayList<OrdersEntity> getChefSelectedOrder(String chefId) throws Exception;
    public ArrayList<OrdersEntity> getPendingOrder() throws Exception;
    public boolean setCookingEndTime(OrdersEntity dto) throws Exception;

    public ArrayList<OrdersEntity> getCookedOrder() throws Exception;
    public boolean setDeliverStartTime(OrdersEntity dto) throws Exception;
    public ArrayList<OrdersEntity> getDeliverBoySelectedOrder(String deliverBId) throws Exception;
    public boolean setDeliverEndTime(String oid) throws Exception;
    public ArrayList<OrdersEntity> getDeliveredOrder() throws Exception;
}
