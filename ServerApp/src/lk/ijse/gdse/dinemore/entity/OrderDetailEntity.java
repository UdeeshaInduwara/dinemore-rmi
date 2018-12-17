package lk.ijse.gdse.dinemore.entity;

public class OrderDetailEntity {
    private String fId;
    private String name;
    private double price;
    private String orderId;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(String fId, String name, double price, String orderId) {
        this.fId = fId;
        this.name = name;
        this.price = price;
        this.orderId = orderId;
    }



    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "fId='" + fId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
