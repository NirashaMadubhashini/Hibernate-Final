package lk.sipsewanainstitute.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student implements SuperEntity{
    @Id
    private String nic;
    private String name;
    private String birthDay;
    private String address;
    private int age;
    private String mobileNumber;
    private String gender;
    private String date;
    private String time;

    @OneToMany(mappedBy = "student")
    private List<Register> registers;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Program> programList = new ArrayList<>();

    public Student() {
    }

    public Student(String nic, String name, String birthDay, String address, int age, String mobileNumber, String gender
            , String date, String time, List<Register> registers, List<Program> programList) {
        this.nic = nic;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.date = date;
        this.time = time;
        this.registers = registers;
        this.programList = programList;
    }

    public Student(String nic, String name, String birthDay, String address, int age, String mobileNumber, String gender, String date, String time) {
    }

    public Student(String name, String birthDay, String address, int age, String mobileNumber, String gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }
}
