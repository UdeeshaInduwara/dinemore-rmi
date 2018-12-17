package lk.ijse.gdse.dinemore.service.custom.impl;

import lk.ijse.gdse.dinemore.business.BOFactory;
import lk.ijse.gdse.dinemore.business.custom.AdminBO;
import lk.ijse.gdse.dinemore.db.DBConnection;
import lk.ijse.gdse.dinemore.dto.ChefDTO;
import lk.ijse.gdse.dinemore.dto.DeliverBoyDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.ReceptionDTO;
import lk.ijse.gdse.dinemore.service.custom.AdminService;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminServiceImpl extends UnicastRemoteObject implements AdminService {
    AdminBO adminBO=null;
    public AdminServiceImpl() throws RemoteException {
        adminBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.ADMIN);
    }

    @Override
    public boolean addFood(FoodDTO dto) throws Exception {
        return adminBO.addFood(dto);
    }

    @Override
    public boolean updateFood(FoodDTO dto) throws Exception {
        return adminBO.updateFood(dto);
    }

    @Override
    public boolean deleteFood(String id) throws Exception {
        return adminBO.deleteFood(id);
    }

    @Override
    public ArrayList<FoodDTO> getAllFood() throws Exception {
        return adminBO.getAllFood();
    }

    @Override
    public boolean addReception(ReceptionDTO dto) throws Exception {
        return adminBO.addReception(dto);
    }

    @Override
    public boolean updateReception(ReceptionDTO dto) throws Exception {
        return adminBO.updateReception(dto);
    }

    @Override
    public boolean deleteReception(String id) throws Exception {
        return adminBO.deleteReception(id);
    }

    @Override
    public ArrayList<ReceptionDTO> getAllReception() throws Exception {
        return adminBO.getAllReception();
    }

    @Override
    public boolean addChef(ChefDTO dto) throws Exception {
        return adminBO.addChef(dto);
    }

    @Override
    public boolean updateChef(ChefDTO dto) throws Exception {
        return adminBO.updateChef(dto);
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
        return adminBO.deleteChef(id);
    }

    @Override
    public ArrayList<ChefDTO> getAllChef() throws Exception {
        return adminBO.getAllChef();
    }

    @Override
    public boolean addDeliverBoy(DeliverBoyDTO dto) throws Exception {
        return adminBO.addDeliverBoy(dto);
    }

    @Override
    public boolean updateDeliverBoy(DeliverBoyDTO dto) throws Exception {
        return adminBO.updateDeliverBoy(dto);
    }

    @Override
    public boolean deleteDeliverBoy(String id) throws Exception {
        return adminBO.deleteDeliverBoy(id);
    }

    @Override
    public ArrayList<DeliverBoyDTO> getAllDeliverBoy() throws Exception {
        return adminBO.getAllDeliverBoy();
    }

    @Override
    public JasperPrint getReceptionReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/ReceptionList.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getChefReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/ChefList.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getDeliverBoyReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/DeliverBoyList.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getFoodReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/FoodList.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getOrderReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/AllOrdersList.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getCustomerReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/CustomerList.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getBestCustomerOfMonthReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/BestCustomerOfMonth.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getBestCustomerYearReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/BestCustomerOfYear.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getCurrentDayOrdersReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/CurrentDayOrdersList.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getCurrentMonthOrdersReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/CurrentMonthOrdersList.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getMonthlyOrdersCountReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/MonthlyOrderCount.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

    @Override
    public JasperPrint getBestChefOfMonthReport() throws Exception {
        InputStream resourceAsStream = getClass().getResourceAsStream("/lk/ijse/gdse/dinemore/reports/BestChefOfMonth.jasper");
        HashMap map= new HashMap();
        return JasperFillManager.fillReport(resourceAsStream, map, DBConnection.getInstance().getConnection());
    }

}
