package lk.ijse.gdse.dinemore.business.custom.impl;

import lk.ijse.gdse.dinemore.business.custom.AdminBO;
import lk.ijse.gdse.dinemore.dao.DAOFactory;
import lk.ijse.gdse.dinemore.dao.custom.ChefDAO;
import lk.ijse.gdse.dinemore.dao.custom.DeliverBoyDAO;
import lk.ijse.gdse.dinemore.dao.custom.FoodDAO;
import lk.ijse.gdse.dinemore.dao.custom.ReceptionDAO;
import lk.ijse.gdse.dinemore.dto.ChefDTO;
import lk.ijse.gdse.dinemore.dto.DeliverBoyDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.ReceptionDTO;
import lk.ijse.gdse.dinemore.entity.Chef;
import lk.ijse.gdse.dinemore.entity.DeliverBoy;
import lk.ijse.gdse.dinemore.entity.Food;
import lk.ijse.gdse.dinemore.entity.Reception;

import java.util.ArrayList;

public class AdminBOImpl implements AdminBO {
    FoodDAO foodDAO=null;
    ReceptionDAO receptionDAO=null;
    ChefDAO chefDAO=null;
    DeliverBoyDAO deliverBoyDAO=null;
    public AdminBOImpl() {
        foodDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FOOD);
        receptionDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTION);
        chefDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHEF);
        deliverBoyDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DELIVERBOY);
    }

    @Override
    public boolean addFood(FoodDTO dto) throws Exception {
        return foodDAO.save(new Food(dto.getFoodId(),dto.getName(),dto.getPrice()));
    }

    @Override
    public boolean updateFood(FoodDTO dto) throws Exception {
        return foodDAO.update(new Food(dto.getFoodId(),dto.getName(),dto.getPrice()));
    }

    @Override
    public boolean deleteFood(String id) throws Exception {
        return foodDAO.delete(id);
    }

    @Override
    public ArrayList<FoodDTO> getAllFood() throws Exception {
        ArrayList<Food> all = foodDAO.getAll();
        ArrayList<FoodDTO> dtos=new ArrayList<>();
        for (Food f : all) {
            dtos.add(new FoodDTO(f.getFoodId(),f.getName(),f.getPrice()));
        }
        return dtos;
    }

    @Override
    public boolean addReception(ReceptionDTO dto) throws Exception {
        return receptionDAO.save(new Reception(dto.getRecId(),dto.getName(),dto.getContactNo(),dto.getPassword()));
    }

    @Override
    public boolean updateReception(ReceptionDTO dto) throws Exception {
        return receptionDAO.update(new Reception(dto.getRecId(),dto.getName(),dto.getContactNo(),dto.getPassword()));
    }

    @Override
    public boolean deleteReception(String id) throws Exception {
        return receptionDAO.delete(id);
    }

    @Override
    public ArrayList<ReceptionDTO> getAllReception() throws Exception {
        ArrayList<Reception> all = receptionDAO.getAll();
        ArrayList<ReceptionDTO> dtos=new ArrayList<>();
        for (Reception r : all) {
            dtos.add(new ReceptionDTO(r.getRecId(),r.getName(),r.getContactNo(),r.getPassword()));
        }
        return dtos;
    }

    @Override
    public boolean addChef(ChefDTO dto) throws Exception {
        return chefDAO.save(new Chef(dto.getChefId(),dto.getName(),dto.getContactNo(),dto.getPassword()));
    }

    @Override
    public boolean updateChef(ChefDTO dto) throws Exception {
        return chefDAO.update(new Chef(dto.getChefId(),dto.getName(),dto.getContactNo(),dto.getPassword()));
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
        return chefDAO.delete(id);
    }

    @Override
    public ArrayList<ChefDTO> getAllChef() throws Exception {
        ArrayList<Chef> all = chefDAO.getAll();
        ArrayList<ChefDTO> dtos=new ArrayList<>();
        for (Chef c : all) {
            dtos.add(new ChefDTO(c.getChefId(),c.getName(),c.getContactNo(),c.getPassword()));
        }
        return dtos;
    }

    @Override
    public boolean addDeliverBoy(DeliverBoyDTO dto) throws Exception {
        return deliverBoyDAO.save(new DeliverBoy(dto.getDelBId(),dto.getName(),dto.getContactNo(),dto.getPassword()));
    }

    @Override
    public boolean updateDeliverBoy(DeliverBoyDTO dto) throws Exception {
        return deliverBoyDAO.update(new DeliverBoy(dto.getDelBId(),dto.getName(),dto.getContactNo(),dto.getPassword()));
    }

    @Override
    public boolean deleteDeliverBoy(String id) throws Exception {
        return deliverBoyDAO.delete(id);
    }

    @Override
    public ArrayList<DeliverBoyDTO> getAllDeliverBoy() throws Exception {
        ArrayList<DeliverBoy> all = deliverBoyDAO.getAll();
        ArrayList<DeliverBoyDTO> dtos=new ArrayList<>();
        for (DeliverBoy d : all) {
            dtos.add(new DeliverBoyDTO(d.getDelBId(),d.getName(),d.getContactNo(),d.getPassword()));
        }
        return dtos;
    }

}
