package lk.sipsewanainstitute.hibernate.dao.custom.impl;

import lk.sipsewanainstitute.hibernate.dao.custom.RegisterDAO;
import lk.sipsewanainstitute.hibernate.entity.Register;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean add(Register register) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(register);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Register register) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(register);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Register register = session.get(Register.class, id);

        session.delete(register);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Register find(String id) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        List<Register>list=null;

        String hql="FROM Register R WHERE R.registerID=:id";
        Query query=session.createQuery(hql);
        list=query.getResultList();
        transaction.commit();

        session.close();
        return list.get(0);
    }

    @Override
    public List<Register> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Register> list = null;

        Query registers = session.createQuery("from Register");
        list = registers.getResultList();

        transaction.commit();

        session.close();
        return list;
    }

    @Override
    public boolean ifRegisterExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
//        ResultSet rst = CrudUtil.executeQuery("SELECT orderId FROM `Order` ORDER BY orderId DESC LIMIT 1");
//        if (rst.next()) {
//
//            int tempId = Integer.
//                    parseInt(rst.getString(1).split("-")[1]);
//            tempId = tempId + 1;
//            if (tempId <= 9) {
//                return "O-00" + tempId;
//            } else if (tempId <= 99) {
//                return "O-0" + tempId;
//            } else {
//                return "O-" + tempId;
//            }
//
//        } else {
//            return "O-001";
//        }
        return null;
    }
}
