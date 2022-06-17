package lk.sipsewanainstitute.hibernate.dto;

import lk.sipsewanainstitute.hibernate.entity.Student;

import java.util.List;

public class RegistrationDTO {
    private String registerID;
    private String nic;
    private String pid;
    private String orderDate;
    private String orderTime;
    private List<RegisterDetailDTO> registerDetail;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String registerID, String nic, String pid, String orderDate, String orderTime, List<RegisterDetailDTO> registerDetail) {
        this.registerID = registerID;
        this.nic = nic;
        this.pid = pid;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.registerDetail = registerDetail;
    }
    public RegistrationDTO(String registerID, String nic, String pid, String orderDate, String orderTime
    ) {
        this.registerID = registerID;
        this.nic = nic;
        this.pid = pid;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public RegistrationDTO(String registerID, String nic, String orderDate, String orderTime) {
        this.registerID = registerID;
        this.nic = nic;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public RegistrationDTO(String toString, String nic, String programID) {
    }




    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public List<RegisterDetailDTO> getRegisterDetail() {
        return registerDetail;
    }

    public void setRegisterDetail(List<RegisterDetailDTO> registerDetail) {
        this.registerDetail = registerDetail;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "registerID='" + registerID + '\'' +
                ", nic='" + nic + '\'' +
                ", pid='" + pid + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", registerDetail=" + registerDetail +
                '}';
    }
}
