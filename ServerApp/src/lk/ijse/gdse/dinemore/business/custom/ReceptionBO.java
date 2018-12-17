package lk.ijse.gdse.dinemore.business.custom;

import lk.ijse.gdse.dinemore.business.SuperBO;
import lk.ijse.gdse.dinemore.dto.CustomerDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.PlaceOrderDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;

import java.util.ArrayList;

public interface ReceptionBO extends SuperBO {
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception;
    public ArrayList<FoodDTO> getAllFood() throws Exception;
    public boolean saveOrder(PlaceOrderDTO dto) throws Exception;
    public ArrayList<ViewOrdersDTO> getAllOrder() throws Exception;
    public ArrayList<String> getAllReceptionId() throws Exception;
}
