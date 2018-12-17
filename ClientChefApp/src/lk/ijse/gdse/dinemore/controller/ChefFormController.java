package lk.ijse.gdse.dinemore.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.gdse.dinemore.dto.OrderUpdateDTO;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.service.custom.ChefService;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChefFormController implements Initializable {
    public TableView<ViewOrdersDTO> tblPendingOrders;
    public TableView<ViewOrdersDTO> tblSelectedOrder;
    public JFXListView<String> listFood;
    public JFXComboBox<String> cmbChefId;
    public JFXPasswordField txtChefPw;
    public Label lblTime;
    public Label lblDate;

    private ChefService chefStub=null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            chefStub = (ChefService) Naming.lookup("rmi://localhost:5050/chef");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        tblPendingOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblPendingOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderType"));
        tblPendingOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderDateTime"));
        tblPendingOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        tblPendingOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cookingStartTime"));
        tblPendingOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("cookingEndTime"));
        tblPendingOrders.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("chefId"));
        loadOrdersTbl();

        tblSelectedOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblSelectedOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderType"));
        tblSelectedOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderDateTime"));
        tblSelectedOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        tblSelectedOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cookingStartTime"));
        tblSelectedOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("cookingEndTime"));
        tblSelectedOrder.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("chefId"));
        loadSelectedOrderTbl();

        loadChefId();
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

    private void loadChefId() {
        try {
            ArrayList<String> allChefId = chefStub.getAllChefId();
            cmbChefId.setItems(FXCollections.observableArrayList(allChefId));
            cmbChefId.getSelectionModel().select(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadSelectedOrderTbl() {
        try {
            String chefId = cmbChefId.getSelectionModel().getSelectedItem();
            tblSelectedOrder.setItems(FXCollections.observableArrayList(chefStub.getChefSelectedOrder(chefId)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadOrdersTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblPendingOrders.setItems(FXCollections.observableArrayList(chefStub.getAllOrder()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),5000);
    }

    public void selectOrder(ActionEvent actionEvent) {
        ViewOrdersDTO selectedItem = tblPendingOrders.getSelectionModel().getSelectedItem();
        String chefId = cmbChefId.getSelectionModel().getSelectedItem();
        try {
            boolean isOk = chefStub.setCookingStartTime(new OrderUpdateDTO(selectedItem.getOrderId(), "Cooking", chefId));
            if (isOk){
                loadSelectedOrderTbl();
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

    public void finishOrder(ActionEvent actionEvent) {
        ViewOrdersDTO selectedItem = tblSelectedOrder.getSelectionModel().getSelectedItem();
        String chefId = cmbChefId.getSelectionModel().getSelectedItem();
        try {
            boolean isOk = chefStub.setCookingEndTime(new OrderUpdateDTO(selectedItem.getOrderId(), "Cooked", chefId));
            if (isOk){
                loadSelectedOrderTbl();
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

    public void selectToShowFoods(MouseEvent mouseEvent) {
        ViewOrdersDTO selectedItem = tblPendingOrders.getSelectionModel().getSelectedItem();
        try {
            ArrayList<String> orderedFoodList = chefStub.getOrderedFoodList(selectedItem.getOrderId());
            listFood.setItems(FXCollections.observableArrayList(orderedFoodList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
