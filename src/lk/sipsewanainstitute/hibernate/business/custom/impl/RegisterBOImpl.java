package lk.sipsewanainstitute.hibernate.business.custom.impl;

import lk.sipsewanainstitute.hibernate.business.custom.RegisterBO;
import lk.sipsewanainstitute.hibernate.dao.DAOFactory;
import lk.sipsewanainstitute.hibernate.dao.custom.ProgramDAO;
import lk.sipsewanainstitute.hibernate.dao.custom.RegisterDAO;
import lk.sipsewanainstitute.hibernate.dao.custom.StudentDAO;
import lk.sipsewanainstitute.hibernate.dto.ProgramDTO;
import lk.sipsewanainstitute.hibernate.dto.RegisterDTO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.entity.Program;
import lk.sipsewanainstitute.hibernate.entity.Register;
import lk.sipsewanainstitute.hibernate.entity.Student;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTER);
    private final StudentDAO studentDAO  = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);

    @Override
    public boolean purchaseOrder(RegisterDTO dto) throws SQLException, ClassNotFoundException {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            boolean registerAvailable = registerDAO.ifRegisterExist(dto.getRegisterID());
            if (registerAvailable) {
                return false;
            }

            Register register = new Register(dto.getRegisterID(),dto.getNic(), dto.getOrderDate(),dto.getOrderTime());
            boolean registerAdded = registerDAO.add(register);
            if (!registerAdded) {

                transaction.commit();

                session.close();
                return false;
            }

                Student search = studentDAO.find(dto.getRegisterID());
                boolean update = studentDAO.update(search);
                if (!update) {
                    transaction.commit();

                    session.close();
                    return false;
                }
            } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    @Override
    public List<RegisterDTO> findAll() throws Exception {
        List<Register> all = registerDAO.findAll();
        ArrayList<RegisterDTO> dtoList = new ArrayList<>();

        for (Register register : all) {
            dtoList.add(new RegisterDTO(
                    register.getRegisterID(),
                    register.getOrderDate(),
                    register.getOrderTime(),
                    register.getStudent()
            ));
        }
        return dtoList;
    }

    @Override
    public boolean add(RegisterDTO registerDTO) throws Exception {
                return registerDAO.add(new Register(
                registerDTO.getRegisterID(),
                registerDTO.getOrderDate(),
                registerDTO.getOrderTime(),
                registerDTO.getNic()
        ));
    }

    @Override
    public boolean update(RegisterDTO registerDTO) throws Exception {
                return registerDAO.update(new Register(
                registerDTO.getRegisterID(),
                registerDTO.getNic(),
                registerDTO.getOrderDate(),
                registerDTO.getOrderTime()
        ));
    }

    @Override
    public boolean ifRegisterExist(String id) throws SQLException, ClassNotFoundException {
        return registerDAO.ifRegisterExist(id);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return registerDAO.delete(id);
    }

    @Override
    public StudentDTO findStudent(String id) throws Exception {
        Student student= studentDAO.find(id);
        return new StudentDTO(student.getNic(), student.getName(), student.getBirthDay(),
                student.getAddress(), student.getAge(), student.getGender(),student.getMobileNumber());
    }

    @Override
    public ProgramDTO findProgram(String id) throws Exception {
        Program program= programDAO.find(id);
        return new ProgramDTO(program.getProgramID(), program.getProgramName(),program.getDuration(),
                program.getFee());
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return registerDAO.generateNewOrderId();
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        ArrayList<StudentDTO> allStudents = new ArrayList<>();
        List<Student> all = studentDAO.findAll();
        for (Student student : all) {
            allStudents.add(new StudentDTO(student.getNic(), student.getName(), student.getBirthDay(),
                    student.getAddress(), student.getAge(), student.getGender(),student.getMobileNumber()));
        }
        return allStudents;
    }

    @Override
    public ArrayList<ProgramDTO> getAllPrograms() throws Exception {
        ArrayList<ProgramDTO> allPrograms = new ArrayList<>();
        List<Program> all = programDAO.findAll();
        for (Program program : all) {
           allPrograms.add(new ProgramDTO(program.getProgramID(), program.getProgramName(),program.getDuration(),
                   program.getFee()));
        }
        return allPrograms;
    }
}
