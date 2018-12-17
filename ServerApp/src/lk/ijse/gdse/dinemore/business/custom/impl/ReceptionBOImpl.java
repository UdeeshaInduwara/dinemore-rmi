package lk.ijse.gdse.dinemore.business.custom.impl;

import lk.ijse.gdse.dinemore.business.custom.ReceptionBO;
import lk.ijse.gdse.dinemore.dao.DAOFactory;
import lk.ijse.gdse.dinemore.dao.custom.*;
import lk.ijse.gdse.dinemore.db.DBConnection;
import lk.ijse.gdse.dinemore.dto.CustomerDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.PlaceOrderDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.entity.*;
import lk.ijse.gdse.dinemore.utill.HibernateUtill;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

public class ReceptionBOImpl implements ReceptionBO {
    CustomerDAO customerDAO = null;
    FoodDAO foodDAO = null;
    OrderDAO orderDAO = null;
    ReceptionDAO receptionDAO = null;
    OrderDetailDAO orderDetailDAO = null;

    public ReceptionBOImpl() {
        customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        foodDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
        orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        receptionDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTION);
        orderDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        ArrayList<Customer> list = customerDAO.getAll();
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        for (Customer c : list) {
            dtos.add(new CustomerDTO(c.getCustId(), c.getName(), c.getContactNo(), c.getAddress()));
        }
        return dtos;
    }

    @Override
    public ArrayList<FoodDTO> getAllFood() throws Exception {
        ArrayList<Food> all = foodDAO.getAll();
        ArrayList<FoodDTO> dtos = new ArrayList<>();
        for (Food f : all) {
            dtos.add(new FoodDTO(f.getFoodId(), f.getName(), f.getPrice()));
        }
        return dtos;
    }

    @Override
    public boolean saveOrder(PlaceOrderDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try {
            CustomerDTO customerDTO = dto.getCustomerDTO();
            Customer customer = customerDAO.search(customerDTO.getCustId());
            if (customer == null) {
                Customer customerEntity = new Customer(customerDTO.getCustId(), customerDTO.getName(), customerDTO.getContactNo(), customerDTO.getAddress());
                boolean result = customerDAO.save(customerEntity);
                if (!result) {
                    System.out.println("customer down");
                    conn.rollback();
                    return false;
                }
            }
            boolean result = orderDAO.save(new OrdersEntity(dto.getOid(), null, null, null, null, null, dto.getOrderStatus(), dto.getOrderType(), dto.getPaymentStatus(), null, customerDTO.getCustId(), null, dto.getReceptionId()));
            if (!result) {
                System.out.println("orderr down");
                conn.rollback();
                return false;
            }
            for (FoodDTO f : dto.getFoodList()) {
                result = orderDetailDAO.save(new OrderDetailEntity(f.getFoodId(), f.getName(), f.getPrice(), dto.getOid()));
                if (!result) {
                    System.out.println("order detail down");
                    conn.rollback();
                    return false;
                }
            }
            conn.commit();
            return true;
        }finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<ViewOrdersDTO> getAllOrder() throws Exception {
        ArrayList<ViewOrdersDTO> dtos = new ArrayList<>();
        ArrayList<OrdersEntity> allOrder = orderDAO.getAllOrder();
        for (OrdersEntity v : allOrder) {
            dtos.add(new ViewOrdersDTO(v.getOrderId(), v.getCookingEndTime(), v.getCookingStartTime(), v.getDeliverEndTime(), v.getDeliverStartTime(), v.getOrderDateTime(), v.getOrderStatus(), v.getOrderType(), v.getPaymentStatus(), v.getChefId(), v.getCustomerId(), v.getDeliverBoyId(), v.getReceptionId()));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllReceptionId() throws Exception {
        ArrayList<String> receptionIdList = new ArrayList<>();
        ArrayList<Reception> all = receptionDAO.getAll();
        for (Reception r : all) {
            receptionIdList.add(r.getRecId());
        }
        return receptionIdList;
    }
}
