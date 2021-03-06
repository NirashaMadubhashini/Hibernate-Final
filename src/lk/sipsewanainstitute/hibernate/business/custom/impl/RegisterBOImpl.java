package lk.sipsewanainstitute.hibernate.business.custom.impl;

import lk.sipsewanainstitute.hibernate.business.custom.RegisterBO;
import lk.sipsewanainstitute.hibernate.dao.DAOFactory;
import lk.sipsewanainstitute.hibernate.dao.custom.ProgramDAO;
import lk.sipsewanainstitute.hibernate.dao.custom.RegisterDAO;
import lk.sipsewanainstitute.hibernate.dao.custom.RegisterDetailDAO;
import lk.sipsewanainstitute.hibernate.dao.custom.StudentDAO;
import lk.sipsewanainstitute.hibernate.dao.custom.impl.RegisterDAOImpl;
import lk.sipsewanainstitute.hibernate.dao.custom.impl.RegisterDetailDAOImpl;
import lk.sipsewanainstitute.hibernate.dto.*;
import lk.sipsewanainstitute.hibernate.entity.Program;
import lk.sipsewanainstitute.hibernate.entity.Register;
import lk.sipsewanainstitute.hibernate.entity.RegisterDetail;
import lk.sipsewanainstitute.hibernate.entity.Student;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTER);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);
    private final RegisterDetailDAO registerDetailDAO = (RegisterDetailDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTERDETAIL);



    @Override
    public boolean purchaseOrder(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            boolean registerAvailable = registerDAO.ifRegisterExist(dto.getRegisterID());
            if (registerAvailable) {
                return false;
            }

            Student student = studentDAO.find(dto.getNic());
            Register register = new Register(dto.getRegisterID(), dto.getOrderDate(), dto.getOrderTime(), student);
            boolean registerAdded = registerDAO.add(register);
            if (!registerAdded) {
                transaction.commit();
                session.close();
                return false;
            }


            Student student1 = studentDAO.find(dto.getNic());
            Program program = programDAO.find(dto.getPid());

            for (RegisterDetailDTO detailDTO : dto.getRegisterDetail()) {
                RegisterDetail registerDetail = new RegisterDetail(Long.parseLong("0"), program, student1);
                boolean registerDetailAdd = registerDetailDAO.add(registerDetail);
                if (!registerDetailAdd) {
                    transaction.commit();
                    session.close();
                    return false;
                }
            }


            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
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
        Student student = studentDAO.find(id);
        return new StudentDTO(student.getNic(), student.getName(), student.getBirthDay(),
                student.getAddress(), student.getAge(), student.getGender(), student.getMobileNumber());
    }

    @Override
    public ProgramDTO findProgram(String id) throws Exception {
        Program program = programDAO.find(id);
        return new ProgramDTO(program.getProgramID(), program.getProgramName(), program.getDuration(),
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
                    student.getAddress(), student.getAge(), student.getGender(), student.getMobileNumber()));
        }
        return allStudents;
    }

    @Override
    public ArrayList<ProgramDTO> getAllPrograms() throws Exception {
        ArrayList<ProgramDTO> allPrograms = new ArrayList<>();
        List<Program> all = programDAO.findAll();
        for (Program program : all) {
            allPrograms.add(new ProgramDTO(program.getProgramID(), program.getProgramName(), program.getDuration(),
                    program.getFee()));
        }
        return allPrograms;
    }

    @Override
    public RegisterDTO find(String rid) throws Exception {
        Register register= registerDAO.find(rid);
        return new RegisterDTO(register.getRegisterID(),register.getStudent(),register.getOrderDate(),register.getOrderTime());
    }

    @Override
    public RegistrationDTO getRegister(String registerID) throws Exception {
        List<RegistrationDTO> all = findAll();
        for (RegistrationDTO p:all) {
            if (p.getRegisterID().equals(registerID)){
                return new RegistrationDTO(
                        p.getRegisterID(),
                        p.getNic(),
                        p.getPid(),
                        p.getOrderDate(),
                        p.getOrderTime(),
                        p.getRegisterDetail()
                );
            }
        }
        return null;
    }

    @Override
    public List<RegistrationDTO> findAll() throws Exception {
        List<Register> all = registerDAO.findAll();
        ArrayList<RegistrationDTO> dtoList = new ArrayList<>();

        for (Register register : all) {
            dtoList.add(new RegistrationDTO(
                    register.getRegisterID(),
                    register.getStudent().getNic(),
                    getPid(register.getStudent().getNic()),
                    register.getOrderDate(),
                    register.getOrderTime()
            ));
        }
        return dtoList;
    }
    public String getPid(String NIC) throws Exception {
        List<RegisterDetail> all = registerDetailDAO.findAll();
        for (RegisterDetail registerDetail:all) {
            if (NIC.equals(registerDetail.getSid().getNic())){
                return registerDetail.getPid().getProgramID();
            }
        }
        return null;
    }
}
