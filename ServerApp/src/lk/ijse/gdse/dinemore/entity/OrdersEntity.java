package lk.ijse.gdse.dinemore.entity;

public class OrdersEntity {
    private String orderId;
    private String cookingEndTime;
    private String cookingStartTime;
    private String deliverEndTime;
    private String deliverStartTime;
    private String orderDateTime;
    private String orderStatus;
    private String orderType;
    private String paymentStatus;
    private String chefId;
    private String customerId;
    private String deliverBoyId;
    private String receptionId;

    public OrdersEntity() {
    }



    public OrdersEntity(String orderId, String cookingEndTime, String cookingStartTime, String deliverEndTime, String deliverStartTime, String orderDateTime, String orderStatus, String orderType, String paymentStatus, String chefId, String customerId, String deliverBoyId, String receptionId) {
        this.orderId = orderId;
        this.cookingEndTime = cookingEndTime;
        this.cookingStartTime = cookingStartTime;
        this.deliverEndTime = deliverEndTime;
        this.deliverStartTime = deliverStartTime;
        this.orderDateTime = orderDateTime;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.paymentStatus = paymentStatus;
        this.chefId = chefId;
        this.customerId = customerId;
        this.deliverBoyId = deliverBoyId;
        this.receptionId = receptionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCookingEndTime() {
        return cookingEndTime;
    }

    public void setCookingEndTime(String cookingEndTime) {
        this.cookingEndTime = cookingEndTime;
    }

    public String getCookingStartTime() {
        return cookingStartTime;
    }

    public void setCookingStartTime(String cookingStartTime) {
        this.cookingStartTime = cookingStartTime;
    }

    public String getDeliverEndTime() {
        return deliverEndTime;
    }

    public void setDeliverEndTime(String deliverEndTime) {
        this.deliverEndTime = deliverEndTime;
    }

    public String getDeliverStartTime() {
        return deliverStartTime;
    }

    public void setDeliverStartTime(String deliverStartTime) {
        this.deliverStartTime = deliverStartTime;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDeliverBoyId() {
        return deliverBoyId;
    }

    public void setDeliverBoyId(String deliverBoyId) {
        this.deliverBoyId = deliverBoyId;
    }

    public String getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "orderId='" + orderId + '\'' +
                ", cookingEndTime='" + cookingEndTime + '\'' +
                ", cookingStartTime='" + cookingStartTime + '\'' +
                ", deliverEndTime='" + deliverEndTime + '\'' +
                ", deliverStartTime='" + deliverStartTime + '\'' +
                ", orderDateTime='" + orderDateTime + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderType='" + orderType + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", chefId='" + chefId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", deliverBoyId='" + deliverBoyId + '\'' +
                ", receptionId='" + receptionId + '\'' +
                '}';
    }
}
