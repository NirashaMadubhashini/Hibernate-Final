package lk.sipsewanainstitute.hibernate.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
public class Register implements SuperEntity{
    @Id
    private String registerID;
    private String orderDate;
    private String orderTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    public Register() {
    }

    public Register(String registerID, String orderDate, String orderTime, Student student) {
        this.registerID = registerID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.student = student;
    }
    public Register(String registerID, String orderDate, String orderTime) {
        this.registerID = registerID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
