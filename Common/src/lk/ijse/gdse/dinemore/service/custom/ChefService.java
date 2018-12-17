package lk.ijse.gdse.dinemore.service.custom;

import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;

import java.rmi.Remote;
import java.util.ArrayList;

public interface ChefService extends Remote {
    public ArrayList<ViewOrdersDTO> getAllOrder() throws Exception;
    public boolean setCookingStartTime(OrderUpdateDTO dto) throws Exception;
    public boolean setCookingEndTime(OrderUpdateDTO dto) throws Exception;
    public ArrayList<ViewOrdersDTO> getChefSelectedOrder(String chefId) throws Exception;
    public ArrayList<String> getOrderedFoodList(String oid) throws Exception;
    public ArrayList<String> getAllChefId() throws Exception;
}
