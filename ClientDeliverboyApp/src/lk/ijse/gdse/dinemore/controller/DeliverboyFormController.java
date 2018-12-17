package lk.ijse.gdse.dinemore.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import lk.ijse.gdse.dinemore.dto.CookedOrdersDTO;
import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.service.custom.DeliverBoyService;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DeliverboyFormController implements Initializable {
    public TableView<ViewOrdersDTO> tblCookedOrders;
    public TableView<ViewOrdersDTO> tblDeliveredOrders;
    public TableView<ViewOrdersDTO> tblSelectedOrders;
    public JFXComboBox<String> cmbDeliverBoyId;
    public JFXPasswordField txtDeliverBoyPw;
    public Label lblDate;
    public Label lblTime;

    DeliverBoyService deliverBStub=null;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            deliverBStub = (DeliverBoyService) Naming.lookup("rmi://localhost:5050/deliverBoy");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        tblCookedOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblCookedOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderDateTime"));
        tblCookedOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        tblCookedOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        tblCookedOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cookingEndTime"));
        tblCookedOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("deliverStartTime"));
        tblCookedOrders.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("deliverEndTime"));
        tblCookedOrders.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("deliverBoyId"));
        loadCookedOrdersTbl();

        tblSelectedOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblSelectedOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderDateTime"));
        tblSelectedOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        tblSelectedOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        tblSelectedOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cookingEndTime"));
        tblSelectedOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("deliverStartTime"));
        tblSelectedOrders.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("deliverEndTime"));
        tblSelectedOrders.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("deliverBoyId"));
        loadSelectedOrdersTbl();

        tblDeliveredOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblDeliveredOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderDateTime"));
        tblDeliveredOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        tblDeliveredOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        tblDeliveredOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cookingEndTime"));
        tblDeliveredOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("deliverStartTime"));
        tblDeliveredOrders.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("deliverEndTime"));
        tblDeliveredOrders.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("deliverBoyId"));
        loadDeliveredOrdersTbl();

        loadDeliverBoyId();
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

    private void loadDeliverBoyId() {
        try {
            ArrayList<String> allDeliverBoyId = deliverBStub.getAllDeliverBoyId();
            cmbDeliverBoyId.setItems(FXCollections.observableArrayList(allDeliverBoyId));
            cmbDeliverBoyId.getSelectionModel().select(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDeliveredOrdersTbl() {
        try {
            tblDeliveredOrders.setItems(FXCollections.observableArrayList(deliverBStub.getDeliveredOrder()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadSelectedOrdersTbl() {
        String deliverBId = cmbDeliverBoyId.getSelectionModel().getSelectedItem();
        try {
            tblSelectedOrders.setItems(FXCollections.observableArrayList(deliverBStub.getDeliverBoySelectedOrder(deliverBId)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCookedOrdersTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblCookedOrders.setItems(FXCollections.observableArrayList(deliverBStub.getCookedOrder()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),5000);
    }

    public void selectOrderToDeliver(ActionEvent actionEvent) {
        ViewOrdersDTO cookedOrdersDTO = tblCookedOrders.getSelectionModel().getSelectedItem();
        String deliverBId = cmbDeliverBoyId.getSelectionModel().getSelectedItem();
        try {
            boolean isOk = deliverBStub.setDeliverStartTime(new OrderUpdateDTO(cookedOrdersDTO.getOrderId(), "delivering", deliverBId));
            if (isOk){
                loadSelectedOrdersTbl();
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

    public void finishDeliver(ActionEvent actionEvent) {
        ViewOrdersDTO selectedItem = tblSelectedOrders.getSelectionModel().getSelectedItem();
        try {
            boolean isOk = deliverBStub.setDeliverEndTime(selectedItem.getOrderId());
            if (isOk){
                loadSelectedOrdersTbl();
                loadDeliveredOrdersTbl();
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
