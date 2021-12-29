package lk.sipsewanainstitute.hibernate.dao.custom;


import lk.sipsewanainstitute.hibernate.dao.SuperDAO;
import lk.sipsewanainstitute.hibernate.entity.Program;

import java.sql.SQLException;

public interface ProgramDAO extends SuperDAO<Program,String> {
    boolean ifProgramExist(String id) throws SQLException, ClassNotFoundException;
}
