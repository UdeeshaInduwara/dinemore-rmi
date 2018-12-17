package lk.ijse.gdse.dinemore.entity;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int odid;
    private String fId;
    private String name;
    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Orders orders;

    public OrderDetail() {
    }

    public OrderDetail(String fId, String name, double price) {
        this.fId = fId;
        this.name = name;
        this.price = price;
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "fId=" + fId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orders=" + orders +
                '}';
    }
}
