package lk.ijse.gdse.dinemore.dao.custom.impl;

import lk.ijse.gdse.dinemore.dao.CrudUtil;
import lk.ijse.gdse.dinemore.dao.custom.OrderDetailDAO;
import lk.ijse.gdse.dinemore.entity.OrderDetail;
import lk.ijse.gdse.dinemore.entity.OrderDetailEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetailEntity entity) throws Exception {
        return CrudUtil.executeUpdate("insert into orderdetail(fId, name, price, orders_orderId) values(?,?,?,?)",
                entity.getfId(),
                entity.getName(),
                entity.getPrice(),
                entity.getOrderId()) >0;
    }

    @Override
    public boolean update(OrderDetailEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public OrderDetailEntity search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDetailEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public ArrayList<String> getOrderedFoodList(String oid) throws Exception {
        ArrayList<String> oList=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select name from orderdetail where orders_orderId=? ", oid);
        while (rst.next()){
            oList.add(rst.getString(1));
        }
        return oList;
    }
}
