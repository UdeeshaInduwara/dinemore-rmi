package lk.ijse.gdse.dinemore.dto;

public class OrderUpdateDTO extends SuperDTO {
    private String oid;
    private String status;
    private String emplId;

    public OrderUpdateDTO() {
    }

    public OrderUpdateDTO(String oid, String status, String emplId) {
        this.oid = oid;
        this.status = status;
        this.emplId = emplId;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmplId() {
        return emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    @Override
    public String toString() {
        return "OrderUpdateDTO{" +
                "oid='" + oid + '\'' +
                ", status='" + status + '\'' +
                ", emplId='" + emplId + '\'' +
                '}';
    }
}
