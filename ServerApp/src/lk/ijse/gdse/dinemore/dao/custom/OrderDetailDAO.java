package lk.ijse.gdse.dinemore.dao.custom;

import lk.ijse.gdse.dinemore.dao.CrudDAO;
import lk.ijse.gdse.dinemore.entity.OrderDetail;
import lk.ijse.gdse.dinemore.entity.OrderDetailEntity;

import java.util.ArrayList;

public interface OrderDetailDAO extends CrudDAO<OrderDetailEntity,String> {
    public ArrayList<String> getOrderedFoodList(String oid) throws Exception;
}
