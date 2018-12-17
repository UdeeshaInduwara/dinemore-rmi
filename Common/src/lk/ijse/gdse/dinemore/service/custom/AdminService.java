package lk.ijse.gdse.dinemore.service.custom;

import lk.ijse.gdse.dinemore.dto.ChefDTO;
import lk.ijse.gdse.dinemore.dto.DeliverBoyDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.ReceptionDTO;
import net.sf.jasperreports.engine.JasperPrint;

import java.rmi.Remote;
import java.util.ArrayList;

public interface AdminService extends Remote {
    public boolean addFood(FoodDTO dto) throws Exception;

    public boolean updateFood(FoodDTO dto) throws Exception;

    public boolean deleteFood(String id) throws Exception;

    public ArrayList<FoodDTO> getAllFood() throws Exception;

    public boolean addReception(ReceptionDTO dto) throws Exception;

    public boolean updateReception(ReceptionDTO dto) throws Exception;

    public boolean deleteReception(String id) throws Exception;

    public ArrayList<ReceptionDTO> getAllReception() throws Exception;

    public boolean addChef(ChefDTO dto) throws Exception;

    public boolean updateChef(ChefDTO dto) throws Exception;

    public boolean deleteChef(String id) throws Exception;

    public ArrayList<ChefDTO> getAllChef() throws Exception;

    public boolean addDeliverBoy(DeliverBoyDTO dto) throws Exception;

    public boolean updateDeliverBoy(DeliverBoyDTO dto) throws Exception;

    public boolean deleteDeliverBoy(String id) throws Exception;

    public ArrayList<DeliverBoyDTO> getAllDeliverBoy() throws Exception;

    public JasperPrint getReceptionReport() throws Exception;
    public JasperPrint getChefReport() throws Exception;
    public JasperPrint getDeliverBoyReport() throws Exception;
    public JasperPrint getFoodReport() throws Exception;
    public JasperPrint getOrderReport() throws Exception;
    public JasperPrint getCustomerReport() throws Exception;
    public JasperPrint getBestCustomerOfMonthReport() throws Exception;
    public JasperPrint getBestCustomerYearReport() throws Exception;
    public JasperPrint getCurrentDayOrdersReport() throws Exception;
    public JasperPrint getCurrentMonthOrdersReport() throws Exception;
    public JasperPrint getMonthlyOrdersCountReport() throws Exception;
    public JasperPrint getBestChefOfMonthReport() throws Exception;

}
