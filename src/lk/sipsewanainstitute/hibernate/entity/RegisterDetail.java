package lk.sipsewanainstitute.hibernate.entity;

import javax.persistence.*;

@Entity
public class RegisterDetail implements SuperEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pid", referencedColumnName = "programID")
    private Program pid;

    @ManyToOne
    @JoinColumn(name = "sid", referencedColumnName = "nic")
    private Student sid;

    public RegisterDetail() {
    }

    public RegisterDetail(Long id, Program pid, Student sid) {
        this.id = id;
        this.pid = pid;
        this.sid = sid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Program getPid() {
        return pid;
    }

    public void setPid(Program pid) {
        this.pid = pid;
    }

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }
}
