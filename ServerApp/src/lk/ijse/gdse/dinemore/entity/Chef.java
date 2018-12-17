package lk.ijse.gdse.dinemore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chef {
    @Id
    private String chefId;
    private String name;
    private int contactNo;
    private String password;
    @OneToMany(mappedBy = "chef",cascade = {CascadeType.PERSIST})
    private List<Orders> orders=new ArrayList<>();

    public Chef() {
    }

    public Chef(String chefId, String name, int contactNo, String password) {
        this.chefId = chefId;
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

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
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
        return "Chef{" +
                "chefId='" + chefId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                '}';
    }
}
