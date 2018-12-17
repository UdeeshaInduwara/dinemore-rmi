package lk.ijse.gdse.dinemore.dto;

public class ChefDTO extends SuperDTO{
    private String chefId;
    private String name;
    private int contactNo;
    private String password;

    public ChefDTO() {
    }

    public ChefDTO(String chefId, String name, int contactNo, String password) {
        this.chefId = chefId;
        this.name = name;
        this.contactNo = contactNo;
        this.password = password;
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

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ChefDTO{" +
                "chefId='" + chefId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", password='" + password + '\'' +
                '}';
    }
}
