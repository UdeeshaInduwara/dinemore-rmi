package lk.ijse.gdse.dinemore.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.dinemore.dto.ViewOrdersDTO;
import lk.ijse.gdse.dinemore.service.custom.AdminService;
import lk.ijse.gdse.dinemore.service.custom.ReceptionService;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class OrderDetailFormController implements Initializable {
    public TableView<ViewOrdersDTO> tblReservedOrders;

    ReceptionService receptionStub=null;
    AdminService adminStub=null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            receptionStub = (ReceptionService) Naming.lookup("rmi://localhost:5050/reception");
            adminStub = (AdminService)Naming.lookup("rmi://localhost:5050/admin");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        tblReservedOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblReservedOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderType"));
        tblReservedOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderDateTime"));
        tblReservedOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        tblReservedOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        tblReservedOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("receptionId"));
        tblReservedOrders.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("chefId"));
        tblReservedOrders.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("deliverBoyId"));
        tblReservedOrders.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblReservedOrders.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("cookingStartTime"));
        tblReservedOrders.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("cookingEndTime"));
        tblReservedOrders.getColumns().get(11).setCellValueFactory(new PropertyValueFactory<>("deliverStartTime"));
        tblReservedOrders.getColumns().get(12).setCellValueFactory(new PropertyValueFactory<>("deliverEndTime"));
        loadOrdersTbl();
    }

    private void loadOrdersTbl() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    tblReservedOrders.setItems(FXCollections.observableArrayList(receptionStub.getAllOrder()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(),5000);
    }

    public void printReport(ActionEvent actionEvent) {
        try {
            JasperPrint receptionReport = adminStub.getOrderReport();
            JasperViewer.viewReport(receptionReport,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
