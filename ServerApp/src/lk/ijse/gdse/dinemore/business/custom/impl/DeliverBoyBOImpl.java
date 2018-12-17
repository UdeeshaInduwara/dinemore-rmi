package lk.ijse.gdse.dinemore.business.custom.impl;

import lk.ijse.gdse.dinemore.business.custom.DeliverBoyBO;
import lk.ijse.gdse.dinemore.dao.DAOFactory;
import lk.ijse.gdse.dinemore.dao.custom.DeliverBoyDAO;
import lk.ijse.gdse.dinemore.dao.custom.OrderDAO;
import lk.ijse.gdse.dinemore.dto.CookedOrdersDTO;
import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.entity.DeliverBoy;
import lk.ijse.gdse.dinemore.entity.OrdersEntity;

import java.util.ArrayList;

public class DeliverBoyBOImpl implements DeliverBoyBO {
    OrderDAO orderDAO=null;
    DeliverBoyDAO deliverBoyDAO=null;
    public DeliverBoyBOImpl() {
        orderDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        deliverBoyDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DELIVERBOY);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getCookedOrder() throws Exception {
        ArrayList<OrdersEntity> order = orderDAO.getCookedOrder();
        ArrayList<ViewOrdersDTO> dtos=new ArrayList<>();
        for (OrdersEntity v : order) {
            dtos.add(new ViewOrdersDTO(v.getOrderId(),v.getCookingEndTime(),v.getCookingStartTime(),v.getDeliverEndTime(),v.getDeliverStartTime(),v.getOrderDateTime(),v.getOrderStatus(),v.getOrderType(),v.getPaymentStatus(),v.getChefId(),v.getCustomerId(),v.getDeliverBoyId(),v.getReceptionId()));
        }
        return dtos;
    }

    @Override
    public boolean setDeliverStartTime(OrderUpdateDTO dto) throws Exception {
        OrdersEntity entity = new OrdersEntity();
        entity.setOrderId(dto.getOid());
        entity.setOrderStatus(dto.getStatus());
        entity.setDeliverBoyId(dto.getEmplId());
        return orderDAO.setDeliverStartTime(entity);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getDeliverBoySelectedOrder(String deliverBId) throws Exception {
        ArrayList<ViewOrdersDTO> dtos=new ArrayList<>();
        ArrayList<OrdersEntity> allOrder = orderDAO.getDeliverBoySelectedOrder(deliverBId);
        for (OrdersEntity v : allOrder) {
            dtos.add(new ViewOrdersDTO(v.getOrderId(),v.getCookingEndTime(),v.getCookingStartTime(),v.getDeliverEndTime(),v.getDeliverStartTime(),v.getOrderDateTime(),v.getOrderStatus(),v.getOrderType(),v.getPaymentStatus(),v.getChefId(),v.getCustomerId(),v.getDeliverBoyId(),v.getReceptionId()));
        }
        return dtos;
    }

    @Override
    public boolean setDeliverEndTime(String oid) throws Exception {
        return orderDAO.setDeliverEndTime(oid);
    }

    @Override
    public ArrayList<ViewOrdersDTO> getDeliveredOrder() throws Exception {
        ArrayList<OrdersEntity> order = orderDAO.getDeliveredOrder();
        ArrayList<ViewOrdersDTO> dtos=new ArrayList<>();
        for (OrdersEntity v : order) {
            dtos.add(new ViewOrdersDTO(v.getOrderId(),v.getCookingEndTime(),v.getCookingStartTime(),v.getDeliverEndTime(),v.getDeliverStartTime(),v.getOrderDateTime(),v.getOrderStatus(),v.getOrderType(),v.getPaymentStatus(),v.getChefId(),v.getCustomerId(),v.getDeliverBoyId(),v.getReceptionId()));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllDeliverBoyId() throws Exception {
        ArrayList<String> list=new ArrayList<>();
        ArrayList<DeliverBoy> all = deliverBoyDAO.getAll();
        for (DeliverBoy d : all) {
            list.add(d.getDelBId());
        }
        return list;
    }
}
