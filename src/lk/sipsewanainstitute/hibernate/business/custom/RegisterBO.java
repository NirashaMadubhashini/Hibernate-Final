package lk.sipsewanainstitute.hibernate.business.custom;

import lk.sipsewanainstitute.hibernate.business.SuperBO;
import lk.sipsewanainstitute.hibernate.dto.ProgramDTO;
import lk.sipsewanainstitute.hibernate.dto.RegisterDTO;

import java.sql.SQLException;
import java.util.List;

public interface RegisterBO extends SuperBO {
    List<RegisterDTO> findAll() throws Exception;

    boolean add(RegisterDTO registerDTO) throws Exception;

    boolean update(RegisterDTO registerDTO) throws Exception;

    boolean ifRegisterExist(String id) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws Exception;

    boolean find(String value) throws SQLException, ClassNotFoundException;
}
