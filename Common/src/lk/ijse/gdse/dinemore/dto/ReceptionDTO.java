package lk.ijse.gdse.dinemore.dto;

public class ReceptionDTO extends SuperDTO{
    private String recId;
    private String name;
    private int contactNo;
    private String password;

    public ReceptionDTO() {
    }

    public ReceptionDTO(String recId, String name, int contactNo, String password) {
        this.recId = recId;
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

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "ReceptionDTO{" +
                "recId='" + recId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo=" + contactNo +
                ", password='" + password + '\'' +
                '}';
    }
}
