package lk.sipsewanainstitute.hibernate.dto;

public class RegisterDetailDTO {
    private Long id;
    private String pid;
    private String sid;

    public RegisterDetailDTO() {
    }

    public RegisterDetailDTO(Long id, String pid, String sid) {
        this.id = id;
        this.pid = pid;
        this.sid = sid;
    }

    public RegisterDetailDTO(String pid, String sid) {
        this.pid = pid;
        this.sid = sid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "RegisterDetailDTO{" +
                "id=" + id +
                ", pid='" + pid + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}
