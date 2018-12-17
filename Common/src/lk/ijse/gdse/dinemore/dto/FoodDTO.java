package lk.ijse.gdse.dinemore.dto;

public class FoodDTO extends SuperDTO {
    private String foodId;
    private String name;
    private double price;

    public FoodDTO() {
    }

    public FoodDTO(String foodId, String name, double price) {
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
        return "FoodDTO{" +
                "foodId='" + foodId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
