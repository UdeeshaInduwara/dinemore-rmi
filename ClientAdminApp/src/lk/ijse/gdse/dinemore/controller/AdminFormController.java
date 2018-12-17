package lk.ijse.gdse.dinemore.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.gdse.dinemore.dto.ChefDTO;
import lk.ijse.gdse.dinemore.dto.DeliverBoyDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.ReceptionDTO;
import lk.ijse.gdse.dinemore.service.custom.AdminService;
import lk.ijse.gdse.dinemore.validation.Validator;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class AdminFormController implements Initializable {

    public JFXTextField txtReceptionId;
    public JFXTextField txtReceptionName;
    public JFXTextField txtReceptionContactNo;
    public TableView<FoodDTO> tblFood;
    public JFXTextField txtFoodName;
    public JFXTextField txtFoodPrice;
    public JFXTextField txtFoodId;
    public TableView<ReceptionDTO> tblReception;
    public TableView<ChefDTO> tblChef;
    public JFXTextField txtChefId;
    public JFXTextField txtChefName;
    public JFXTextField txtChefContactNo;
    public JFXTextField txtDeliverboyId;
    public JFXTextField txtDeliverboyName;
    public JFXTextField txtDeliverboyContactNo;
    public TableView<DeliverBoyDTO> tblDeliverBoy;
    public JFXTextField txtReceptionPw;
    public JFXTextField txtChefPw;
    public JFXTextField txtDeliverboyPw;
    public JFXButton btnReceptionDelete;
    public JFXButton btnReceptionUpdate;
    public JFXButton btnReceptionAdd;
    public JFXButton btnChefDelete;
    public JFXButton btnChefUpdate;
    public JFXButton btnChefAdd;
    public JFXButton btnDeliverBDelete;
    public JFXButton btnDeliverBUpdate;
    public JFXButton btnDeliverBAdd;
    public JFXButton btnFoodDelete;
    public JFXButton btnFoodUpdate;
    public JFXButton btnFoodAdd;

    AdminService adminStub=null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnReceptionDelete.setDisable(true);
        btnReceptionUpdate.setDisable(true);
        btnChefDelete.setDisable(true);
        btnChefUpdate.setDisable(true);
        btnDeliverBDelete.setDisable(true);
        btnDeliverBUpdate.setDisable(true);
        btnFoodDelete.setDisable(true);
        btnFoodUpdate.setDisable(true);

        try {
            adminStub = (AdminService)Naming.lookup("rmi://localhost:5050/admin");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        tblFood.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        tblFood.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblFood.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        loadFoodTbl();

        tblReception.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("recId"));
        tblReception.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblReception.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblReception.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("password"));
        loadReceptionTbl();

        tblChef.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("chefId"));
        tblChef.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblChef.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblChef.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("password"));
        loadChefTbl();

        tblDeliverBoy.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("delBId"));
        tblDeliverBoy.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDeliverBoy.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblDeliverBoy.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("password"));
        loadDeliverBoyTbl();
    }

    private void loadDeliverBoyTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblDeliverBoy.setItems(FXCollections.observableArrayList(adminStub.getAllDeliverBoy()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),500);
    }

    private void loadChefTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblChef.setItems(FXCollections.observableArrayList(adminStub.getAllChef()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),5000);
    }

    private void loadReceptionTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblReception.setItems(FXCollections.observableArrayList(adminStub.getAllReception()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),5000);
    }

    private void loadFoodTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblFood.setItems(FXCollections.observableArrayList(adminStub.getAllFood()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),5000);
    }

    public void updateFood(ActionEvent actionEvent) {
        boolean setAction=false;
        String foodId = txtFoodId.getText();
        String foodName = txtFoodName.getText();
        String foodPrice = txtFoodPrice.getText();
        if (Validator.foodIdValidation(foodId)){
            if (Validator.nameValidation(foodName)){
                if (Validator.doubleValueValidation(foodPrice)){
                         setAction=true;
                }else {
                    txtFoodPrice.requestFocus();
                }
            }else {
                txtFoodName.requestFocus();
            }
        }else {
            txtFoodId.requestFocus();
        }
        if (setAction){
            try {
                boolean isOk = adminStub.updateFood(new FoodDTO(foodId,foodName, Double.parseDouble(foodPrice)));
                if (isOk){
                    btnFoodAdd.setDisable(false);
                    btnFoodDelete.setDisable(true);
                    btnFoodUpdate.setDisable(true);
                    txtFoodId.clear();
                    txtFoodName.clear();
                    txtFoodPrice.clear();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                    a.show();
                }else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                    a.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addFood(ActionEvent actionEvent) {
        boolean setAction=false;
        String foodId = txtFoodId.getText();
        String foodName = txtFoodName.getText();
        String foodPrice = txtFoodPrice.getText();
        if (Validator.foodIdValidation(foodId)){
            if (Validator.nameValidation(foodName)){
                if (Validator.doubleValueValidation(foodPrice)){
                    setAction=true;
                }else {
                    txtFoodPrice.requestFocus();
                }
            }else {
                txtFoodName.requestFocus();
            }
        }else {
            txtFoodId.requestFocus();
        }
        if (setAction) {
            try {
                boolean isOk = adminStub.addFood(new FoodDTO(foodId, foodName, Double.parseDouble(foodPrice)));
                if (isOk) {
                    txtFoodId.clear();
                    txtFoodName.clear();
                    txtFoodPrice.clear();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                    a.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteFood(ActionEvent actionEvent) {
        String foodId = txtFoodId.getText();
        try {
            boolean isOk = adminStub.deleteFood(foodId);
            if (isOk){
                btnFoodAdd.setDisable(false);
                btnFoodDelete.setDisable(true);
                btnFoodUpdate.setDisable(true);
                txtFoodId.clear();
                txtFoodName.clear();
                txtFoodPrice.clear();
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                a.show();
            }else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                a.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteReception(ActionEvent actionEvent) {
        String receptionId = txtReceptionId.getText();
        try {
            boolean isOk = adminStub.deleteReception(receptionId);
            if (isOk){
                btnReceptionAdd.setDisable(false);
                btnReceptionDelete.setDisable(true);
                btnReceptionUpdate.setDisable(true);
                txtReceptionId.clear();
                txtReceptionName.clear();
                txtReceptionContactNo.clear();
                txtReceptionPw.clear();
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                a.show();
            }else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                a.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateReception(ActionEvent actionEvent) {
        boolean setAction=false;
        String receptionId = txtReceptionId.getText();
        String receptionName = txtReceptionName.getText();
        String receptionContactNo = txtReceptionContactNo.getText();
        String receptionPwText = txtReceptionPw.getText();
        if (Validator.receptionIdValidation(receptionId)){
            if (Validator.nameValidation(receptionName)){
                if (Validator.contactNoValidation(receptionContactNo)){
                    if (Validator.isNotEmptyValidation(receptionPwText)){
                        setAction=true;
                    }else {
                        txtReceptionPw.requestFocus();
                    }
                }else {
                    txtReceptionContactNo.requestFocus();
                }
            }else {
                txtReceptionName.requestFocus();
            }
        }else {
            txtReceptionId.requestFocus();
        }
        if (setAction) {
            try {
                boolean isOk = adminStub.updateReception(new ReceptionDTO(receptionId, receptionName, Integer.parseInt(receptionContactNo), receptionPwText));
                if (isOk) {
                    btnReceptionAdd.setDisable(false);
                    btnReceptionDelete.setDisable(true);
                    btnReceptionUpdate.setDisable(true);
                    txtReceptionId.clear();
                    txtReceptionName.clear();
                    txtReceptionContactNo.clear();
                    txtReceptionPw.clear();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                    a.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addReception(ActionEvent actionEvent) {
        boolean setAction=false;
        String receptionId = txtReceptionId.getText();
        String receptionName = txtReceptionName.getText();
        String receptionContactNo = txtReceptionContactNo.getText();
        String receptionPwText = txtReceptionPw.getText();
        if (Validator.receptionIdValidation(receptionId)){
            if (Validator.nameValidation(receptionName)){
                if (Validator.contactNoValidation(receptionContactNo)){
                    if (Validator.isNotEmptyValidation(receptionPwText)){
                        setAction=true;
                    }else {
                        txtReceptionPw.requestFocus();
                    }
                }else {
                    txtReceptionContactNo.requestFocus();
                }
            }else {
                txtReceptionName.requestFocus();
            }
        }else {
            txtReceptionId.requestFocus();
        }
        if (setAction) {
            try {
                boolean isOk = adminStub.addReception(new ReceptionDTO(receptionId, receptionName, Integer.parseInt(receptionContactNo), receptionPwText));
                if (isOk) {
                    txtReceptionId.clear();
                    txtReceptionName.clear();
                    txtReceptionContactNo.clear();
                    txtReceptionPw.clear();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                    a.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteChef(ActionEvent actionEvent) {
        String chefId = txtChefId.getText();
        try {
            boolean isOk = adminStub.deleteChef(chefId);
            if (isOk){
                btnChefAdd.setDisable(false);
                btnChefDelete.setDisable(true);
                btnChefUpdate.setDisable(true);
                txtChefId.clear();
                txtChefName.clear();
                txtChefContactNo.clear();
                txtChefPw.clear();
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                a.show();
            }else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                a.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateChef(ActionEvent actionEvent) {
        boolean setAction=false;
        String chefId = txtChefId.getText();
        String chefName = txtChefName.getText();
        String chefContactNo = txtChefContactNo.getText();
        String txtChefPwText = txtChefPw.getText();
        if (Validator.chefIdValidation(chefId)){
            if (Validator.nameValidation(chefName)){
                if (Validator.contactNoValidation(chefContactNo)){
                    if (Validator.isNotEmptyValidation(txtChefPwText)){
                        setAction=true;
                    }else {
                        txtChefPw.requestFocus();
                    }
                }else {
                    txtChefContactNo.requestFocus();
                }
            }else {
                txtChefName.requestFocus();
            }
        }else {
            txtChefId.requestFocus();
        }
        if (setAction) {
            try {
                boolean isOk = adminStub.updateChef(new ChefDTO(chefId, chefName, Integer.parseInt(chefContactNo), txtChefPwText));
                if (isOk) {
                    btnChefAdd.setDisable(false);
                    btnChefDelete.setDisable(true);
                    btnChefUpdate.setDisable(true);
                    txtChefId.clear();
                    txtChefName.clear();
                    txtChefContactNo.clear();
                    txtChefPw.clear();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                    a.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addChef(ActionEvent actionEvent) {
        boolean setAction=false;
        String chefId = txtChefId.getText();
        String chefName = txtChefName.getText();
        String chefContactNo = txtChefContactNo.getText();
        String txtChefPwText = txtChefPw.getText();
        if (Validator.chefIdValidation(chefId)){
            if (Validator.nameValidation(chefName)){
                if (Validator.contactNoValidation(chefContactNo)){
                    if (Validator.isNotEmptyValidation(txtChefPwText)){
                        setAction=true;
                    }else {
                        txtChefPw.requestFocus();
                    }
                }else {
                    txtChefContactNo.requestFocus();
                }
            }else {
                txtChefName.requestFocus();
            }
        }else {
            txtChefId.requestFocus();
        }
        if (setAction) {
            try {
                boolean isOk = adminStub.addChef(new ChefDTO(chefId, chefName, Integer.parseInt(chefContactNo), txtChefPwText));
                if (isOk) {
                    txtChefId.clear();
                    txtChefName.clear();
                    txtChefContactNo.clear();
                    txtChefPw.clear();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                    a.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteDeliverboy(ActionEvent actionEvent) {
        String deliverboyId = txtDeliverboyId.getText();
        try {
            boolean isOk = adminStub.deleteDeliverBoy(deliverboyId);
            if (isOk){
                btnDeliverBAdd.setDisable(false);
                btnDeliverBDelete.setDisable(true);
                btnDeliverBUpdate.setDisable(true);
                txtDeliverboyId.clear();
                txtDeliverboyName.clear();
                txtDeliverboyContactNo.clear();
                txtDeliverboyPw.clear();
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                a.show();
            }else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                a.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDeliverboy(ActionEvent actionEvent) {
        boolean setAction=false;
        String deliverboyId = txtDeliverboyId.getText();
        String deliverboyName = txtDeliverboyName.getText();
        String deliverboyContactNo = txtDeliverboyContactNo.getText();
        String deliverboyPwText = txtDeliverboyPw.getText();
        if (Validator.deliverBoyIdValidation(deliverboyId)){
            if (Validator.nameValidation(deliverboyName)){
                if (Validator.contactNoValidation(deliverboyContactNo)){
                    if (Validator.isNotEmptyValidation(deliverboyPwText)){
                        setAction=true;
                    }else {
                        txtDeliverboyPw.requestFocus();
                    }
                }else {
                    txtDeliverboyContactNo.requestFocus();
                }
            }else {
                txtDeliverboyName.requestFocus();
            }
        }else {
            txtDeliverboyId.requestFocus();
        }
        if (setAction) {
            try {
                boolean isOk = adminStub.updateDeliverBoy(new DeliverBoyDTO(deliverboyId, deliverboyName, Integer.parseInt(deliverboyContactNo), deliverboyPwText));
                if (isOk) {
                    btnDeliverBAdd.setDisable(false);
                    btnDeliverBDelete.setDisable(true);
                    btnDeliverBUpdate.setDisable(true);
                    txtDeliverboyId.clear();
                    txtDeliverboyName.clear();
                    txtDeliverboyContactNo.clear();
                    txtDeliverboyPw.clear();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                    a.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addDeliverboy(ActionEvent actionEvent) {
        boolean setAction=false;
        String deliverboyId = txtDeliverboyId.getText();
        String deliverboyName = txtDeliverboyName.getText();
        String deliverboyContactNo = txtDeliverboyContactNo.getText();
        String deliverboyPwText = txtDeliverboyPw.getText();
        if (Validator.deliverBoyIdValidation(deliverboyId)){
            if (Validator.nameValidation(deliverboyName)){
                if (Validator.contactNoValidation(deliverboyContactNo)){
                    if (Validator.isNotEmptyValidation(deliverboyPwText)){
                        setAction=true;
                    }else {
                        txtDeliverboyPw.requestFocus();
                    }
                }else {
                    txtDeliverboyContactNo.requestFocus();
                }
            }else {
                txtDeliverboyName.requestFocus();
            }
        }else {
            txtDeliverboyId.requestFocus();
        }
        if (setAction) {
            try {
                boolean isOk = adminStub.addDeliverBoy(new DeliverBoyDTO(deliverboyId, deliverboyName, Integer.parseInt(deliverboyContactNo), deliverboyPwText));
                if (isOk) {
                    txtDeliverboyId.clear();
                    txtDeliverboyName.clear();
                    txtDeliverboyContactNo.clear();
                    txtDeliverboyPw.clear();
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Successfully", ButtonType.OK);
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK);
                    a.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void selectReception(MouseEvent mouseEvent) {
        ReceptionDTO selectedItem = tblReception.getSelectionModel().getSelectedItem();
        txtReceptionId.setText(selectedItem.getRecId());
        txtReceptionName.setText(selectedItem.getName());
        txtReceptionContactNo.setText(String.valueOf(selectedItem.getContactNo()));
        txtReceptionPw.setText(selectedItem.getPassword());

        btnReceptionAdd.setDisable(true);
        btnReceptionDelete.setDisable(false);
        btnReceptionUpdate.setDisable(false);
    }

    public void selectChef(MouseEvent mouseEvent) {
        ChefDTO selectedItem = tblChef.getSelectionModel().getSelectedItem();
        txtChefId.setText(selectedItem.getChefId());
        txtChefName.setText(selectedItem.getName());
        txtChefContactNo.setText(String.valueOf(selectedItem.getContactNo()));
        txtChefPw.setText(selectedItem.getPassword());

        btnChefAdd.setDisable(true);
        btnChefDelete.setDisable(false);
        btnChefUpdate.setDisable(false);
    }

    public void selectDeliverboy(MouseEvent mouseEvent) {
        DeliverBoyDTO selectedItem = tblDeliverBoy.getSelectionModel().getSelectedItem();
        txtDeliverboyId.setText(selectedItem.getDelBId());
        txtDeliverboyName.setText(selectedItem.getName());
        txtDeliverboyContactNo.setText(String.valueOf(selectedItem.getContactNo()));
        txtDeliverboyPw.setText(selectedItem.getPassword());

        btnDeliverBAdd.setDisable(true);
        btnDeliverBDelete.setDisable(false);
        btnDeliverBUpdate.setDisable(false);
    }

    public void selectFood(MouseEvent mouseEvent) {
        FoodDTO selectedItem = tblFood.getSelectionModel().getSelectedItem();
        txtFoodId.setText(selectedItem.getFoodId());
        txtFoodName.setText(selectedItem.getName());
        txtFoodPrice.setText(String.valueOf(selectedItem.getPrice()));

        btnFoodAdd.setDisable(true);
        btnFoodDelete.setDisable(false);
        btnFoodUpdate.setDisable(false);
    }

    public void reportAllOrders(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/OrderDetail.fxml"));
        stage.setTitle("Admin Form");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public void getReceptionReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getReceptionReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getChefReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getChefReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getDeliverBoyReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getDeliverBoyReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getFoodReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getFoodReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCustomerReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getCustomerReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void monthlyBestCustomerReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getBestCustomerOfMonthReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void yearlyBestCustomerReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getBestCustomerYearReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void monthlyBestChefReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getBestChefOfMonthReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void currentDayOrdersReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getCurrentDayOrdersReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void currentMonthOrdersReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getCurrentMonthOrdersReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void monthlyOrdersCountReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getMonthlyOrdersCountReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
