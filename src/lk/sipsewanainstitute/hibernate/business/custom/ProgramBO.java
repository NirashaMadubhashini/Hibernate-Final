package lk.sipsewanainstitute.hibernate.business.custom;


import lk.sipsewanainstitute.hibernate.business.SuperBO;
import lk.sipsewanainstitute.hibernate.dto.ProgramDTO;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBO extends SuperBO {
    List<ProgramDTO> findAll() throws Exception;

    boolean add(ProgramDTO programDTO) throws Exception;

    boolean update(ProgramDTO programDTO) throws Exception;

    boolean ifProgramExist(String id) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws Exception;

    ProgramDTO find(String value) throws Exception;

}
