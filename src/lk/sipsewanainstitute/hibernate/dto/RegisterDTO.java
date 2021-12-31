package lk.sipsewanainstitute.hibernate.dto;

import lk.sipsewanainstitute.hibernate.entity.Student;

public class RegisterDTO {
    private String registerID;
    private String nic;
    private String orderDate;
    private String orderTime;

    public RegisterDTO() {
    }

    public RegisterDTO(String registerID, String nic, String orderDate, String orderTime) {
        this.registerID = registerID;
        this.nic = nic;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public RegisterDTO(String registerID, String orderDate, String orderTime, Student student) {
    }

//    public RegisterDTO(String registerID, String orderDate, String orderTime) {
//        this.registerID = registerID;
//        this.orderDate = orderDate;
//        this.orderTime = orderTime;
//    }

    public RegisterDTO(String registerID, String nic) {
        this.registerID = registerID;
        this.nic = nic;
    }

    public RegisterDTO(String registerID, String studentNic, String name, String birthDay, int age, String gender, String mobile, String programId, String programName, String duration, double fee) {
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

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "registerID='" + registerID + '\'' +
                ", nic='" + nic + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                '}';
    }
}
