package lk.sipsewanainstitute.hibernate.view.tm;

public class RegisterTM {
    private String registerID;
    private String nic;
    private String name;
    private int age;
    private String gender;
    private String programID;
    private String programName;
    private double fee;

    public RegisterTM() {
    }

    public RegisterTM(String registerID, String nic, String name, int age, String gender, String programID, String programName, double fee) {
        this.registerID = registerID;
        this.nic = nic;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.programID = programID;
        this.programName = programName;
        this.fee = fee;
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

    @Override
    public String toString() {
        return "RegisterTM{" +
                "registerID='" + registerID + '\'' +
                ", nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", programID='" + programID + '\'' +
                ", programName='" + programName + '\'' +
                ", fee=" + fee +
                '}';
    }
}
