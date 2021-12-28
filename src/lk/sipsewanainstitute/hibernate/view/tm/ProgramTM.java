package lk.sipsewanainstitute.hibernate.view.tm;


import javafx.scene.control.Button;

public class ProgramTM {
    private String programID;
    private String programName;
    private String duration;
    private double fee;
    private String date;
    private String time;
    private Button update;
    private Button delete;

    public ProgramTM() {
    }

    public ProgramTM(String programID, String programName, String duration, double fee, String date, String time, Button update, Button delete) {
        this.programID = programID;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
        this.date = date;
        this.time = time;
        this.update = update;
        this.delete = delete;
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

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "ProgramTM{" +
                "programID='" + programID + '\'' +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", update=" + update +
                ", delete=" + delete +
                '}';
    }
}
