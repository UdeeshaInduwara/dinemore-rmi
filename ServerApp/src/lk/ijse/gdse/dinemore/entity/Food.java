package lk.ijse.gdse.dinemore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Food {
    @Id
    private String foodId;
    private String name;
    private double price;

    public Food() {
    }

    public Food(String foodId, String name, double price) {
        this.foodId = foodId;
        this.name = name;
        this.price = price;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
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

    @Override
    public String toString() {
        return "Food{" +
                "foodId='" + foodId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
