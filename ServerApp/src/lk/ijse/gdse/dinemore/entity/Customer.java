package lk.ijse.gdse.dinemore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String custId;
    private String name;
    private int contactNo;
    private String address;
    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST})
    private List<Orders> orders=new ArrayList<>();

    public Customer() {
    }

    public Customer(String custId, String name, int contactNo, String address) {
        this.custId = custId;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId='" + custId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
