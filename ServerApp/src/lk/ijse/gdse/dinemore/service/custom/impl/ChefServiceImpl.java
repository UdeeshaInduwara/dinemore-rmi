package lk.ijse.gdse.dinemore.service.custom.impl;

import lk.ijse.gdse.dinemore.business.BOFactory;
import lk.ijse.gdse.dinemore.business.custom.ChefBO;
import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.service.custom.ChefService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChefServiceImpl extends UnicastRemoteObject implements ChefService {
    ChefBO chefBO=null;
    public ChefServiceImpl() throws RemoteException {
        chefBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.CHEF);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getAllOrder() throws Exception {
        return chefBO.getAllOrder();
    }

    @Override
    public boolean setCookingStartTime(OrderUpdateDTO dto) throws Exception {
        return chefBO.setCookingStartTime(dto);
    }

    @Override
    public boolean setCookingEndTime(OrderUpdateDTO dto) throws Exception {
        return chefBO.setCookingEndTime(dto);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getChefSelectedOrder(String chefId) throws Exception {
        return chefBO.getChefSelectedOrder(chefId);
    }

    @Override
    public ArrayList<String> getOrderedFoodList(String oid) throws Exception {
        return chefBO.getOrderedFoodList(oid);
    }

    @Override
    public ArrayList<String> getAllChefId() throws Exception {
        return chefBO.getAllChefId();
    }
}
