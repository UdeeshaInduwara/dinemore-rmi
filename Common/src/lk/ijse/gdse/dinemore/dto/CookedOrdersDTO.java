package lk.ijse.gdse.dinemore.dto;

public class CookedOrdersDTO extends SuperDTO {
    private String orderId;
    private String orderDateTime;
    private String status;
    private String paymentStatus;
    private String cookingEndTime;
    private String deliverStartTime;
    private String deliverEndTime;
    private String deliverBOy;

    public CookedOrdersDTO() {
    }

    public CookedOrdersDTO(String orderId, String orderDateTime, String status, String paymentStatus, String cookingEndTime, String deliverStartTime, String deliverEndTime, String deliverBOy) {
        this.orderId = orderId;
        this.orderDateTime = orderDateTime;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.cookingEndTime = cookingEndTime;
        this.deliverStartTime = deliverStartTime;
        this.deliverEndTime = deliverEndTime;
        this.deliverBOy = deliverBOy;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCookingEndTime() {
        return cookingEndTime;
    }

    public void setCookingEndTime(String cookingEndTime) {
        this.cookingEndTime = cookingEndTime;
    }

    public String getDeliverStartTime() {
        return deliverStartTime;
    }

    public void setDeliverStartTime(String deliverStartTime) {
        this.deliverStartTime = deliverStartTime;
    }

    public String getDeliverEndTime() {
        return deliverEndTime;
    }

    public void setDeliverEndTime(String deliverEndTime) {
        this.deliverEndTime = deliverEndTime;
    }

    public String getDeliverBOy() {
        return deliverBOy;
    }

    public void setDeliverBOy(String deliverBOy) {
        this.deliverBOy = deliverBOy;
    }

    @Override
    public String toString() {
        return "CookedOrdersDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderDateTime='" + orderDateTime + '\'' +
                ", status='" + status + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", cookingEndTime='" + cookingEndTime + '\'' +
                ", deliverStartTime='" + deliverStartTime + '\'' +
                ", deliverEndTime='" + deliverEndTime + '\'' +
                ", deliverBOy='" + deliverBOy + '\'' +
                '}';
    }
}
