package lk.ijse.gdse.dinemore.service.custom.impl;

import lk.ijse.gdse.dinemore.business.BOFactory;
import lk.ijse.gdse.dinemore.business.custom.ReceptionBO;
import lk.ijse.gdse.dinemore.dto.CustomerDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.PlaceOrderDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.service.custom.ReceptionService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService {
    ReceptionBO receptionBO=null;
    public ReceptionServiceImpl() throws RemoteException {
        receptionBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.RECEPTION);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        return receptionBO.getAllCustomer();
    }

    @Override
    public ArrayList<FoodDTO> getAllFood() throws Exception {
        return receptionBO.getAllFood();
    }

    @Override
    public boolean saveOrder(PlaceOrderDTO dto) throws Exception {
        return receptionBO.saveOrder(dto);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getAllOrder() throws Exception {
        return receptionBO.getAllOrder();
    }

    @Override
    public ArrayList<String> getAllReceptionId() throws Exception {
        return receptionBO.getAllReceptionId();
    }
}
