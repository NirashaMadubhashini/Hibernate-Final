package lk.sipsewanainstitute.hibernate.dto;

import lk.sipsewanainstitute.hibernate.entity.Student;

public class StudentDTO {
    private String nic;
    private String name;
    private String birthDay;
    private String address;
    private int age;
    private String mobileNumber;
    private String gender;
    private String date;
    private String time;


    public StudentDTO() {
    }

    public StudentDTO(String nic, String name, String birthDay, String address, int age, String mobileNumber, String gender, String date, String time) {
        this.nic = nic;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.date = date;
        this.time = time;
    }

    public StudentDTO(String nic,String name, String birthDay, String address, int age, String gender, String mobileNumber) {
        this.nic = nic;
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
