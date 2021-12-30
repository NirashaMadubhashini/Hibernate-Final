package lk.sipsewanainstitute.hibernate.business.custom;


import lk.sipsewanainstitute.hibernate.business.SuperBO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO  extends SuperBO {

    List<StudentDTO> findAll() throws Exception;

    boolean add(StudentDTO studentDTO) throws Exception;

    boolean update(StudentDTO studentDTO) throws Exception;

    boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws Exception;

    boolean find(String value) throws Exception;
}
