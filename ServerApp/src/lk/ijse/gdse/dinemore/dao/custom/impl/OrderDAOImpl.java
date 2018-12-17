package lk.ijse.gdse.dinemore.dao.custom.impl;

import lk.ijse.gdse.dinemore.dao.CrudUtil;
import lk.ijse.gdse.dinemore.dao.custom.OrderDAO;
import lk.ijse.gdse.dinemore.entity.Orders;
import lk.ijse.gdse.dinemore.entity.OrdersEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(OrdersEntity entity) throws Exception {
        return CrudUtil.executeUpdate("insert into orders(orderId, cookingEndTime, cookingStartTime, deliverEndTime, deliverStartTime, orderDateTime, orderStatus, orderType, paymentStatus, chef_chefId, customer_custId, deliverBoy_delBId, reception_recId) values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
                entity.getOrderId(),
                entity.getCookingEndTime(),
                entity.getCookingStartTime(),
                entity.getDeliverEndTime(),
                entity.getDeliverStartTime(),
                new Date(),
                entity.getOrderStatus(),
                entity.getOrderType(),
                entity.getPaymentStatus(),
                entity.getChefId(),
                entity.getCustomerId(),
                entity.getDeliverBoyId(),
                entity.getReceptionId()) >0;
    }

    @Override
    public boolean update(OrdersEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public OrdersEntity search(String s) throws Exception {
        return null;
    }


    @Override
    public ArrayList<OrdersEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrdersEntity> getAllOrder() throws Exception {
        ArrayList<OrdersEntity> dtos=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from orders");
        while (rst.next()){
            dtos.add(new OrdersEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13)));
        }
        return dtos;
    }

    @Override
    public boolean setCookingStartTime(OrdersEntity dto) throws Exception {
        return CrudUtil.executeUpdate("update orders set orderStatus=?,chef_chefId=?,cookingStartTime=current_time where orderId=? ",
                dto.getOrderStatus(),
                dto.getChefId(),
                dto.getOrderId()) > 0;
    }

    @Override
    public ArrayList<OrdersEntity> getChefSelectedOrder(String chefId) throws Exception {
        ArrayList<OrdersEntity> dtos=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from orders where chef_chefId=? and orderStatus=? ",chefId,"cooking");
        while (rst.next()){
            dtos.add(new OrdersEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13)));
        }
        return dtos;
    }

    @Override
    public ArrayList<OrdersEntity> getPendingOrder() throws Exception {
        ArrayList<OrdersEntity> dtos=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from orders where orderStatus=? ","pending");
        while (rst.next()){
            dtos.add(new OrdersEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13)));
        }
        return dtos;
    }

    @Override
    public boolean setCookingEndTime(OrdersEntity dto) throws Exception {
        return CrudUtil.executeUpdate("update orders set orderStatus=?,cookingEndTime=current_time where orderId=? ",
                dto.getOrderStatus(),
                dto.getOrderId()) > 0;
    }

    @Override
    public ArrayList<OrdersEntity> getCookedOrder() throws Exception {
        ArrayList<OrdersEntity> dtos=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from orders where orderStatus=? ","Cooked");
        while (rst.next()){
            dtos.add(new OrdersEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13)));
        }
        return dtos;
    }

    @Override
    public boolean setDeliverStartTime(OrdersEntity dto) throws Exception {
        return CrudUtil.executeUpdate("update orders set orderStatus=?,deliverBoy_delBId=?,deliverStartTime=current_time where orderId=? ",
                dto.getOrderStatus(),
                dto.getDeliverBoyId(),
                dto.getOrderId()) > 0;
    }

    @Override
    public ArrayList<OrdersEntity> getDeliverBoySelectedOrder(String deliverBId) throws Exception {
        ArrayList<OrdersEntity> dtos=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from orders where deliverBoy_delBId=? and orderStatus=? ",deliverBId,"delivering");
        while (rst.next()){
            dtos.add(new OrdersEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13)));
        }
        return dtos;
    }

    @Override
    public boolean setDeliverEndTime(String oid) throws Exception {
        return CrudUtil.executeUpdate("update orders set orderStatus=?,paymentStatus=?,deliverEndTime=current_time where orderId=? ","delivered","payed",oid) >0;
    }

    @Override
    public ArrayList<OrdersEntity> getDeliveredOrder() throws Exception {
        ArrayList<OrdersEntity> dtos=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from orders where orderStatus=? ","delivered");
        while (rst.next()){
            dtos.add(new OrdersEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13)));
        }
        return dtos;
    }


}
