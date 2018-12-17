package lk.ijse.gdse.dinemore.service.custom.impl;

import lk.ijse.gdse.dinemore.business.BOFactory;
import lk.ijse.gdse.dinemore.business.custom.DeliverBoyBO;
import lk.ijse.gdse.dinemore.dto.CookedOrdersDTO;
import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.service.custom.DeliverBoyService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DeliverBoyServiceImpl extends UnicastRemoteObject implements DeliverBoyService {
    DeliverBoyBO deliverBoyBO=null;
    public DeliverBoyServiceImpl() throws RemoteException {
        deliverBoyBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.DELIVERBOY);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getCookedOrder() throws Exception {
        return deliverBoyBO.getCookedOrder();
    }

    @Override
    public boolean setDeliverStartTime(OrderUpdateDTO dto) throws Exception {
        return deliverBoyBO.setDeliverStartTime(dto);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getDeliverBoySelectedOrder(String deliverBId) throws Exception {
        return deliverBoyBO.getDeliverBoySelectedOrder(deliverBId);
    }

    @Override
    public boolean setDeliverEndTime(String oid) throws Exception {
        return deliverBoyBO.setDeliverEndTime(oid);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getDeliveredOrder() throws Exception {
        return deliverBoyBO.getDeliveredOrder();
    }

    @Override
    public ArrayList<String> getAllDeliverBoyId() throws Exception {
        return deliverBoyBO.getAllDeliverBoyId();
    }
}
