package lk.sipsewanainstitute.hibernate.view.tm;

public class StudentDetailTM {
    private String name;
    private String nic;
    private String birthDay;
    private String address;
    private int age;
    private String mobileNumber;
    private String gender;
    private String date;
    private String time;

    public StudentDetailTM() {
    }

    public StudentDetailTM(String name, String nic, String birthDay, String address, int age, String mobileNumber, String gender, String date, String time) {
        this.name = name;
        this.nic = nic;
        this.birthDay = birthDay;
        this.address = address;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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
        return "StudentDetailTM{" +
                "name='" + name + '\'' +
                ", nic='" + nic + '\'' +
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
