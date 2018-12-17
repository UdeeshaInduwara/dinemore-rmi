package lk.ijse.gdse.dinemore.business.custom;

import lk.ijse.gdse.dinemore.business.SuperBO;
import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.entity.OrdersEntity;

import java.util.ArrayList;

public interface ChefBO extends SuperBO {
    public ArrayList<ViewOrdersDTO> getAllOrder() throws Exception;
    public boolean setCookingStartTime(OrderUpdateDTO dto) throws Exception;
    public ArrayList<ViewOrdersDTO> getChefSelectedOrder(String chefId) throws Exception;
    public boolean setCookingEndTime(OrderUpdateDTO dto) throws Exception;
    public ArrayList<String> getOrderedFoodList(String oid) throws Exception;
    public ArrayList<String> getAllChefId() throws Exception;
}
