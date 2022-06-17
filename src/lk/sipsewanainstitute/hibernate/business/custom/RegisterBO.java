package lk.sipsewanainstitute.hibernate.business.custom;

import lk.sipsewanainstitute.hibernate.business.SuperBO;
import lk.sipsewanainstitute.hibernate.dto.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RegisterBO extends SuperBO {

    boolean purchaseOrder(RegistrationDTO dto) throws SQLException, ClassNotFoundException;

    List<RegistrationDTO> findAll() throws Exception;

//    boolean add(RegisterDTO registerDTO) throws Exception;
//
//    boolean update(RegisterDTO registerDTO) throws Exception;

    boolean ifRegisterExist(String id) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws Exception;

    StudentDTO findStudent(String value) throws Exception;

    ProgramDTO findProgram(String value) throws Exception;

    String generateNewOrderId() throws SQLException, ClassNotFoundException;

    ArrayList<StudentDTO> getAllStudents() throws Exception;

    ArrayList<ProgramDTO> getAllPrograms() throws Exception;

    RegisterDTO find(String value) throws Exception;

    RegistrationDTO getRegister(String registerID) throws Exception;
}
