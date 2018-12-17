package lk.ijse.gdse.dinemore.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    private String orderId;
    private String orderType;
    private Date orderDateTime;
    private String orderStatus;
    private String paymentStatus;
    private Time cookingStartTime;
    private Time cookingEndTime;
    private Time deliverStartTime;
    private Time deliverEndTime;
    @ManyToOne
    private Reception reception;
    @ManyToOne
    private Chef chef;
    @ManyToOne
    private DeliverBoy deliverBoy;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "orders",cascade = CascadeType.PERSIST)
    private List<OrderDetail> orderDetails=new ArrayList<>();

    public Orders() {
    }

    public Orders(String orderId, String orderType, Date orderDateTime, String orderStatus, String paymentStatus, Time cookingStartTime, Time cookingEndTime, Time deliverStartTime, Time deliverEndTime) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.orderDateTime = orderDateTime;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.cookingStartTime = cookingStartTime;
        this.cookingEndTime = cookingEndTime;
        this.deliverStartTime = deliverStartTime;
        this.deliverEndTime = deliverEndTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Time getCookingStartTime() {
        return cookingStartTime;
    }

    public void setCookingStartTime(Time cookingStartTime) {
        this.cookingStartTime = cookingStartTime;
    }

    public Time getCookingEndTime() {
        return cookingEndTime;
    }

    public void setCookingEndTime(Time cookingEndTime) {
        this.cookingEndTime = cookingEndTime;
    }

    public Time getDeliverStartTime() {
        return deliverStartTime;
    }

    public void setDeliverStartTime(Time deliverStartTime) {
        this.deliverStartTime = deliverStartTime;
    }

    public Time getDeliverEndTime() {
        return deliverEndTime;
    }

    public void setDeliverEndTime(Time deliverEndTime) {
        this.deliverEndTime = deliverEndTime;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public DeliverBoy getDeliverBoy() {
        return deliverBoy;
    }

    public void setDeliverBoy(DeliverBoy deliverBoy) {
        this.deliverBoy = deliverBoy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDateTime=" + orderDateTime +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", cookingStartTime=" + cookingStartTime +
                ", cookingEndTime=" + cookingEndTime +
                ", deliverStartTime=" + deliverStartTime +
                ", deliverEndTime=" + deliverEndTime +
                ", reception=" + reception +
                ", chef=" + chef +
                ", deliverBoy=" + deliverBoy +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
