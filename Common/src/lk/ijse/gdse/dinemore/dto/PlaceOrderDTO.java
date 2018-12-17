package lk.ijse.gdse.dinemore.dto;

import java.util.ArrayList;

public class PlaceOrderDTO extends SuperDTO {
    private String oid;
    private String orderType;
    private String orderStatus;
    private String paymentStatus;
    private CustomerDTO customerDTO;
    private ArrayList<FoodDTO> foodList;
    private String receptionId;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(String oid, String orderType, String orderStatus, String paymentStatus, CustomerDTO customerDTO, ArrayList<FoodDTO> foodList, String receptionId) {
        this.oid = oid;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.customerDTO = customerDTO;
        this.foodList = foodList;
        this.receptionId = receptionId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public ArrayList<FoodDTO> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<FoodDTO> foodList) {
        this.foodList = foodList;
    }

    public String getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
    }

    @Override
    public String toString() {
        return "PlaceOrderDTO{" +
                "oid='" + oid + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", customerDTO=" + customerDTO +
                ", foodList=" + foodList +
                ", receptionId='" + receptionId + '\'' +
                '}';
    }
}
