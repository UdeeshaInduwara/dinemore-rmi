package lk.ijse.gdse.dinemore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reception {
    @Id
    private String recId;
    private String name;
    private int contactNo;
    private String password;
    @OneToMany(mappedBy = "reception",cascade = {CascadeType.PERSIST})
    private List<Orders> orders=new ArrayList<>();

    public Reception() {
    }

    public Reception(String recId, String name, int contactNo, String password) {
        this.recId = recId;
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

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
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
        return "Reception{" +
                "recId='" + recId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                '}';
    }
}
