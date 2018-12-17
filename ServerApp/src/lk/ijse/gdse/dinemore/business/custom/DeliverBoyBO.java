package lk.ijse.gdse.dinemore.business.custom;

import lk.ijse.gdse.dinemore.business.SuperBO;
import lk.ijse.gdse.dinemore.dto.CookedOrdersDTO;
import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;

import java.util.ArrayList;

public interface DeliverBoyBO extends SuperBO {
    public ArrayList<ViewOrdersDTO> getCookedOrder() throws Exception;
    public boolean setDeliverStartTime(OrderUpdateDTO dto) throws Exception;
    public ArrayList<ViewOrdersDTO> getDeliverBoySelectedOrder(String deliverBId) throws Exception;
    public boolean setDeliverEndTime(String oid) throws Exception;
    public ArrayList<ViewOrdersDTO> getDeliveredOrder() throws Exception;
    public ArrayList<String> getAllDeliverBoyId() throws Exception;
}
