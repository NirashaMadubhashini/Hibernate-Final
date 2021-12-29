package lk.sipsewanainstitute.hibernate.dao.custom;


import lk.sipsewanainstitute.hibernate.dao.SuperDAO;
import lk.sipsewanainstitute.hibernate.entity.Student;

import java.sql.SQLException;

public interface StudentDAO extends SuperDAO<Student,String> {
    boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException;
}
