package lk.sipsewanainstitute.hibernate.entity;

public class Student_Program {
    private String nic;
    private String programID;

    public Student_Program() {
    }

    public Student_Program(String nic, String programID) {
        this.nic = nic;
        this.programID = programID;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }
}
