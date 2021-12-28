package lk.sipsewanainstitute.hibernate.business.custom.impl;


import lk.sipsewanainstitute.hibernate.business.custom.ProgramBO;
import lk.sipsewanainstitute.hibernate.dao.DAOFactory;
import lk.sipsewanainstitute.hibernate.dao.custom.ProgramDAO;
import lk.sipsewanainstitute.hibernate.dto.ProgramDTO;
import lk.sipsewanainstitute.hibernate.entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramBOImpl implements ProgramBO {
    private final ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAM);

    @Override
    public ArrayList<ProgramDTO> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(ProgramDTO programDTO) throws Exception {
        return programDAO.add(new Program(
                programDTO.getProgramID(),
                programDTO.getProgramName(),
                programDTO.getDuration(),
                programDTO.getFee(),
                programDTO.getDate(),
                programDTO.getTime()));
    }

    @Override
    public boolean update(ProgramDTO programDTO) throws Exception {
                return programDAO.update(new Program(
                programDTO.getProgramID(),
                programDTO.getProgramName(),
                programDTO.getDuration(),
                programDTO.getFee(),
                programDTO.getDate(),
                programDTO.getTime()
        ));
    }

    @Override
    public boolean ifProgramExist(String id) throws SQLException, ClassNotFoundException {
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
//    public void add(ProgramDTO programDTO) throws Exception {
//         programDAO.add(new Program(
//                programDTO.getProgramID(),
//                programDTO.getProgramName(),
//                programDTO.getDuration(),
//                programDTO.getFee(),
//                programDTO.getDate(),
//                programDTO.getTime()
//        ));
//    }
//
//    @Override
//    public List<ProgramDTO> findAll() throws Exception {
//        List<Program> all = programDAO.findAll();
//        ArrayList<ProgramDTO> dtoList = new ArrayList<>();
//
//        ProgramDTO programDTO = null;
//
//        for (Program program : all) {
//            dtoList.add(new ProgramDTO(
//                    program.getProgramID(),
//                    program.getProgramName(),
//                    program.getDuration(),
//                    program.getFee(),
//                    program.getDate(),
//                    program.getTime()
//            ));
//        }
//        return dtoList;
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return programDAO.delete(id);
//    }
//
//    @Override
//    public boolean update(ProgramDTO programDTO) throws Exception {
//        return programDAO.update(new Program(
//                programDTO.getProgramID(),
//                programDTO.getProgramName(),
//                programDTO.getDuration(),
//                programDTO.getFee(),
//                programDTO.getDate(),
//                programDTO.getTime()
//        ));
//    }
}
