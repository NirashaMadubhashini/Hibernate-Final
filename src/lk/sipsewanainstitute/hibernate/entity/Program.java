package lk.sipsewanainstitute.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Program implements SuperEntity{
    @Id
    private String programID;
    private String programName;
    private String duration;
    private double fee;
    private String date;
    private String time;


    @OneToMany(mappedBy = "pid", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<RegisterDetail> pid;


    public Program() {
    }

    public Program(String programID, String programName, String duration, double fee, String date, String time) {
        this.programID = programID;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
        this.date = date;
        this.time = time;
    }

    public Program(String programID, String programName, String duration, double fee, String date, String time, List<RegisterDetail> pid) {
        this.programID = programID;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
        this.date = date;
        this.time = time;
        this.pid = pid;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
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

    public List<RegisterDetail> getPid() {
        return pid;
    }

    public void setPid(List<RegisterDetail> pid) {
        this.pid = pid;
    }
}
