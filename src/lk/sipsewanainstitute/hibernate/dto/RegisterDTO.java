package lk.sipsewanainstitute.hibernate.dto;

import lk.sipsewanainstitute.hibernate.entity.Student;

public class RegisterDTO {
    //    private String registerID;
//    private String nic;
//    private String orderDate;
//    private String orderTime;
//
//    public RegisterDTO() {
//    }
//
//    public RegisterDTO(String registerID, String nic, String orderDate, String orderTime) {
//        this.registerID = registerID;
//        this.nic = nic;
//        this.orderDate = orderDate;
//        this.orderTime = orderTime;
//    }
//
//    public RegisterDTO(String registerID, String orderDate, String orderTime) {
//        this.registerID = registerID;
//        this.orderDate = orderDate;
//        this.orderTime = orderTime;
//    }
//
//
//
//    public String getRegisterID() {
//        return registerID;
//    }
//
//    public void setRegisterID(String registerID) {
//        this.registerID = registerID;
//    }
//
//    public String getNic() {
//        return nic;
//    }
//
//    public void setNic(String nic) {
//        this.nic = nic;
//    }
//
//    public String getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(String orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public String getOrderTime() {
//        return orderTime;
//    }
//
//    public void setOrderTime(String orderTime) {
//        this.orderTime = orderTime;
//    }
//
//    @Override
//    public String toString() {
//        return "RegisterDTO{" +
//                "registerID='" + registerID + '\'' +
//                ", nic='" + nic + '\'' +
//                ", orderDate='" + orderDate + '\'' +
//                ", orderTime='" + orderTime + '\'' +
//                '}';
//    }
    private String registerID;
    private String nic;
    private String name;
    private int age;
    private String gender;
    private String programID;
    private String programName;
    private double fee;
    private String orderDate;
    private String orderTime;

    public RegisterDTO() {
    }

    public RegisterDTO(String registerID, String nic, String name, int age, String gender, String programID, String programName, double fee) {
        this.registerID = registerID;
        this.nic = nic;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.programID = programID;
        this.programName = programName;
        this.fee = fee;

    }

    public RegisterDTO(String registerID, String orderDate, String orderTime) {
        this.registerID = registerID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
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
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", programID='" + programID + '\'' +
                ", programName='" + programName + '\'' +
                ", fee=" + fee +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                '}';
    }
}
