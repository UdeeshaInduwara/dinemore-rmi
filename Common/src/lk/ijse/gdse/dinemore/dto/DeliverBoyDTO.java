package lk.ijse.gdse.dinemore.dto;

public class DeliverBoyDTO extends SuperDTO {
    private String delBId;
    private String name;
    private int contactNo;
    private String password;

    public DeliverBoyDTO() {
    }

    public DeliverBoyDTO(String delBId, String name, int contactNo, String password) {
        this.delBId = delBId;
        this.name = name;
        this.contactNo = contactNo;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "DeliverBoyDTO{" +
                "delBId='" + delBId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", password='" + password + '\'' +
                '}';
    }
}
