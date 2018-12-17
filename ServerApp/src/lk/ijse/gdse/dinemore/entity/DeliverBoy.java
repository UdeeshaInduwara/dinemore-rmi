package lk.ijse.gdse.dinemore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DeliverBoy {
    @Id
    private String delBId;
    private String name;
    private int contactNo;
    private String password;
    @OneToMany(mappedBy = "deliverBoy",cascade = {CascadeType.PERSIST})
    private List<Orders> orders=new ArrayList<>();

    public DeliverBoy() {
    }

    public DeliverBoy(String delBId, String name, int contactNo, String password) {
        this.delBId = delBId;
        this.name = name;
        this.contactNo = contactNo;
        this.password = password;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getDelBId() {
        return delBId;
    }

    public void setDelBId(String delBId) {
        this.delBId = delBId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DeliverBoy{" +
                "delBId='" + delBId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                '}';
    }
}
