package lk.ijse.gdse.dinemore.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.gdse.dinemore.dto.CustomerDTO;
import lk.ijse.gdse.dinemore.dto.FoodDTO;
import lk.ijse.gdse.dinemore.dto.PlaceOrderDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.service.custom.ReceptionService;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReceptionFormController implements Initializable {

    public JFXTextField txtCustomerId;
    public TableView<CustomerDTO> tblCustomer;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerContactNo;
    public JFXTextField txtCustomerAddress;
    public TableView<FoodDTO> tblFood;
    public TableView<FoodDTO> tblOrderedFood;
    public JFXRadioButton rbtnTakeAway;
    public ToggleGroup orderType;
    public JFXRadioButton rbtnDelivery;
    public TextField txtOrderId;
    public TableView<ViewOrdersDTO> tblReservedOrders;
    public JFXComboBox<String> cmbReceptionId;
    public JFXPasswordField txtPassword;
    public Label lblTime;
    public Label lblDate;
    public TextField txtFoodPriceTotal;

    private ReceptionService receptionStub=null;
    private ArrayList<FoodDTO> selectedFoodList=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            receptionStub = (ReceptionService)Naming.lookup("rmi://localhost:5050/reception");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("custId"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        loadCustomerTbl();

        tblFood.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        tblFood.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblFood.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        loadFoodTbl();

        tblOrderedFood.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("foodId"));
        tblOrderedFood.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblOrderedFood.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));

        tblReservedOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblReservedOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderType"));
        tblReservedOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderDateTime"));
        tblReservedOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        tblReservedOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        tblReservedOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("receptionId"));
        tblReservedOrders.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("chefId"));
        tblReservedOrders.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("deliverBoyId"));
        tblReservedOrders.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        loadReservedOrdersTbl();

        loadReceptionId();
        setDateAndTime();
    }

    private void setDateAndTime() {
        Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }

        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }

    private void loadReceptionId() {
        try {
            ArrayList<String> allReceptionId = receptionStub.getAllReceptionId();
            cmbReceptionId.setItems(FXCollections.observableArrayList(allReceptionId));
            cmbReceptionId.getSelectionModel().select(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadReservedOrdersTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblReservedOrders.setItems(FXCollections.observableArrayList(receptionStub.getAllOrder()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),500);
    }

    private void loadFoodTbl() {
        try {
            tblFood.setItems(FXCollections.observableArrayList(receptionStub.getAllFood()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCustomerTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblCustomer.setItems(FXCollections.observableArrayList(receptionStub.getAllCustomer()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),5000);
    }

    public void addFoodToOrderedFoodTbl(MouseEvent mouseEvent) {
        FoodDTO foodDTO = tblFood.getSelectionModel().getSelectedItem();
        selectedFoodList.add(foodDTO);
        tblOrderedFood.setItems(FXCollections.observableArrayList(selectedFoodList));
        double total=0;
        for (FoodDTO x : selectedFoodList) {
            total +=x.getPrice();
        }
        txtFoodPriceTotal.setText(String.valueOf(total));
    }

    public void selectCustomer(MouseEvent mouseEvent) {
        CustomerDTO customerDTO = tblCustomer.getSelectionModel().getSelectedItem();
        txtCustomerId.setText(customerDTO.getCustId());
        txtCustomerName.setText(customerDTO.getName());
        txtCustomerContactNo.setText(String.valueOf(customerDTO.getContactNo()));
        txtCustomerAddress.setText(customerDTO.getAddress());
    }

    public void placeOrder(ActionEvent actionEvent) {
        String customerIdText = txtCustomerId.getText();
        String customerNameText = txtCustomerName.getText();
        int customerContactNoText = Integer.parseInt(txtCustomerContactNo.getText());
        String customerAddressText = txtCustomerAddress.getText();
        CustomerDTO customerDTO = new CustomerDTO(customerIdText, customerNameText, customerContactNoText, customerAddressText);

        String orderType="Take Away";
        if (rbtnDelivery.isSelected()){
            orderType="Deliver";
        }

        String receptionId=cmbReceptionId.getSelectionModel().getSelectedItem();
        if (receptionId==null){
            cmbReceptionId.requestFocus();
        }

        String orderIdText = txtOrderId.getText();
        try {
            boolean isOk = receptionStub.saveOrder(new PlaceOrderDTO(orderIdText, orderType, "pending","not payed", customerDTO, selectedFoodList,receptionId));
            if (isOk){
                txtCustomerId.clear();
                txtCustomerName.clear();
                txtCustomerContactNo.clear();
                txtCustomerAddress.clear();
                txtOrderId.clear();
                txtFoodPriceTotal.clear();
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

    public void deSelectFood(MouseEvent mouseEvent) {
        FoodDTO selectedItem = tblOrderedFood.getSelectionModel().getSelectedItem();
        int i = selectedFoodList.indexOf(selectedItem);
        selectedFoodList.remove(i);
        tblOrderedFood.setItems(FXCollections.observableArrayList(selectedFoodList));
    }
}
