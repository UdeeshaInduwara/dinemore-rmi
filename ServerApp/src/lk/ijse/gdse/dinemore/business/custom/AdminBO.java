package lk.ijse.gdse.dinemore.business.custom;

import lk.ijse.gdse.dinemore.business.SuperBO;
import lk.ijse.gdse.dinemore.dto.ChefDTO;
import lk.ijse.gdse.dinemore.dto.DeliverBoyDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.ReceptionDTO;

import java.util.ArrayList;

public interface AdminBO extends SuperBO {
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
}
