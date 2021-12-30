package lk.sipsewanainstitute.hibernate.dao.custom;

import lk.sipsewanainstitute.hibernate.dao.SuperDAO;
import lk.sipsewanainstitute.hibernate.entity.Register;

import java.sql.SQLException;

public interface RegisterDAO extends SuperDAO<Register,String> {
    boolean ifRegisterExist(String id) throws SQLException, ClassNotFoundException;

    String generateNewOrderId() throws SQLException, ClassNotFoundException;
}
