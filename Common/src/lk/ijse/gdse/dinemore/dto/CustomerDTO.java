package lk.ijse.gdse.dinemore.dto;

public class CustomerDTO extends SuperDTO {
    private String custId;
    private String name;
    private int contactNo;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String custId, String name, int contactNo, String address) {
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

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "custId='" + custId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", address='" + address + '\'' +
                '}';
    }
}
