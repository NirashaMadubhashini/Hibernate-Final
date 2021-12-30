package lk.sipsewanainstitute.hibernate.business.custom.impl;

import lk.sipsewanainstitute.hibernate.business.custom.StudentBO;
import lk.sipsewanainstitute.hibernate.dao.DAOFactory;
import lk.sipsewanainstitute.hibernate.dao.custom.StudentDAO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<StudentDTO> findAll() throws Exception {
        List<Student> all = studentDAO.findAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();

        for (Student student : all) {
            dtoList.add(new StudentDTO(
                    student.getNic(),
                    student.getName(),
                    student.getBirthDay(),
                    student.getAddress(),
                    student.getAge(),
                    student.getMobileNumber(),
                    student.getGender(),
                    student.getDate(),
                    student.getTime()
            ));
        }
        return dtoList;
    }

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        studentDAO.add(new Student(
                studentDTO.getNic(),
                studentDTO.getName(),
                studentDTO.getBirthDay(),
                studentDTO.getAddress(),
                studentDTO.getAge(),
                studentDTO.getMobileNumber(),
                studentDTO.getGender(),
                studentDTO.getDate(),
                studentDTO.getTime()
        ));

        return false;
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getName(),
                studentDTO.getBirthDay(),
                studentDTO.getAddress(),
                studentDTO.getAge(),
                studentDTO.getGender(),
                studentDTO.getMobileNumber()
        ));
    }

    @Override
    public boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.ifStudentExist(id);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public StudentDTO find(String id) throws Exception {
        Student student= studentDAO.find(id);
        return new StudentDTO(student.getNic(), student.getName(), student.getBirthDay(),
                student.getAddress(), student.getAge(), student.getGender(),student.getMobileNumber());
    }
}
