package lk.sipsewanainstitute.hibernate.view.tm;

public class ProgramDetailTM {
    private String programID;
    private String programName;
    private String duration;
    private double fee;
    private String date;
    private String time;

    public ProgramDetailTM() {
    }

    public ProgramDetailTM(String programID, String programName, String duration, double fee, String date, String time) {
        this.programID = programID;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
        this.date = date;
        this.time = time;
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

    @Override
    public String toString() {
        return "ProgramDetailTM{" +
                "programID='" + programID + '\'' +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
