package lk.ijse.gdse.dinemore.business.custom.impl;

import lk.ijse.gdse.dinemore.business.custom.ChefBO;
import lk.ijse.gdse.dinemore.dao.DAOFactory;
import lk.ijse.gdse.dinemore.dao.custom.ChefDAO;
import lk.ijse.gdse.dinemore.dao.custom.OrderDAO;
import lk.ijse.gdse.dinemore.dao.custom.OrderDetailDAO;
import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.entity.Chef;
import lk.ijse.gdse.dinemore.entity.OrdersEntity;

import java.util.ArrayList;

public class ChefBOImpl implements ChefBO {
    OrderDAO orderDAO=null;
    OrderDetailDAO orderDetailDAO=null;
    ChefDAO chefDAO=null;
    public ChefBOImpl() {
        orderDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        orderDetailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
        chefDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHEF);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getAllOrder() throws Exception {
        ArrayList<ViewOrdersDTO> dtos=new ArrayList<>();
        ArrayList<OrdersEntity> allOrder = orderDAO.getPendingOrder();
        for (OrdersEntity v : allOrder) {
            dtos.add(new ViewOrdersDTO(v.getOrderId(),v.getCookingEndTime(),v.getCookingStartTime(),v.getDeliverEndTime(),v.getDeliverStartTime(),v.getOrderDateTime(),v.getOrderStatus(),v.getOrderType(),v.getPaymentStatus(),v.getChefId(),v.getCustomerId(),v.getDeliverBoyId(),v.getReceptionId()));
        }
        return dtos;
    }

    @Override
    public boolean setCookingStartTime(OrderUpdateDTO dto) throws Exception {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setOrderId(dto.getOid());
        ordersEntity.setOrderStatus(dto.getStatus());
        ordersEntity.setChefId(dto.getEmplId());
        return orderDAO.setCookingStartTime(ordersEntity);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getChefSelectedOrder(String chefId) throws Exception {
        ArrayList<ViewOrdersDTO> dtos=new ArrayList<>();
        ArrayList<OrdersEntity> allOrder = orderDAO.getChefSelectedOrder(chefId);
        for (OrdersEntity v : allOrder) {
            dtos.add(new ViewOrdersDTO(v.getOrderId(),v.getCookingEndTime(),v.getCookingStartTime(),v.getDeliverEndTime(),v.getDeliverStartTime(),v.getOrderDateTime(),v.getOrderStatus(),v.getOrderType(),v.getPaymentStatus(),v.getChefId(),v.getCustomerId(),v.getDeliverBoyId(),v.getReceptionId()));
        }
        return dtos;
    }

    @Override
    public boolean setCookingEndTime(OrderUpdateDTO dto) throws Exception {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setOrderId(dto.getOid());
        ordersEntity.setOrderStatus(dto.getStatus());
        ordersEntity.setChefId(dto.getEmplId());
        return orderDAO.setCookingEndTime(ordersEntity);
    }

    @Override
    public ArrayList<String> getOrderedFoodList(String oid) throws Exception {
        return orderDetailDAO.getOrderedFoodList(oid);
    }

    @Override
    public ArrayList<String> getAllChefId() throws Exception {
        ArrayList<String> idList=new ArrayList<>();
        ArrayList<Chef> all = chefDAO.getAll();
        for (Chef c : all) {
            idList.add(c.getChefId());
        }
        return idList;
    }
}
