package lk.sipsewanainstitute.hibernate.business.custom.impl;

import lk.sipsewanainstitute.hibernate.business.custom.RegisterBO;
import lk.sipsewanainstitute.hibernate.dao.DAOFactory;
import lk.sipsewanainstitute.hibernate.dao.custom.ProgramDAO;
import lk.sipsewanainstitute.hibernate.dao.custom.RegisterDAO;
import lk.sipsewanainstitute.hibernate.dao.custom.impl.RegisterDAOImpl;
import lk.sipsewanainstitute.hibernate.dto.RegisterDTO;
import lk.sipsewanainstitute.hibernate.entity.Register;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {
    private final RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTER);

    @Override
    public List<RegisterDTO> findAll() throws SQLException, ClassNotFoundException {
        return null;
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
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean find(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

//    @Override
//    public boolean add(RegisterDTO registerDTO) throws Exception {
//        return registerDAO.add(new Register(
//                registerDTO.getRegisterID(),
//                registerDTO.getOrderDate(),
//                registerDTO.getOrderTime(),
//                registerDTO.getNic()
//        ));
//    }
//
//    @Override
//    public List<RegisterDTO> findAll() throws Exception {
//        List<Register>all=registerDAO.findAll();
//        ArrayList<RegisterDTO>dtoList=new ArrayList<>();
//
//        RegisterDTO registerDTO=null;
//
//        for (Register register:all){
//            dtoList.add(new RegisterDTO(
//                    register.getRegisterID(),
//                    register.getOrderDate(),
//                    register.getOrderTime(),
//                    register.getStudent()
//            ));
//        }
//        return dtoList;
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return registerDAO.delete(id);
//    }
//
//    @Override
//    public boolean update(RegisterDTO registerDTO) throws Exception {
//        return registerDAO.update(new Register(
//                registerDTO.getRegisterID(),
//                registerDTO.getNic(),
//                registerDTO.getOrderDate(),
//                registerDTO.getOrderTime()
//        ));
//    }
}
