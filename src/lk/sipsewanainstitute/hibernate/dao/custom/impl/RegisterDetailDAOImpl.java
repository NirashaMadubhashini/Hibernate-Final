package lk.sipsewanainstitute.hibernate.dao.custom.impl;

import lk.sipsewanainstitute.hibernate.dao.custom.RegisterDetailDAO;
import lk.sipsewanainstitute.hibernate.entity.Register;
import lk.sipsewanainstitute.hibernate.entity.RegisterDetail;
import lk.sipsewanainstitute.hibernate.entity.Student;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class RegisterDetailDAOImpl implements RegisterDetailDAO {

    @Override
    public boolean add(RegisterDetail registerDetail) throws Exception {
        Session  session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.save(registerDetail);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(RegisterDetail registerDetail) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public RegisterDetail find(String s) throws Exception {
        return null;
    }

    @Override
    public List<RegisterDetail> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<RegisterDetail> list = null;

        Query registers = session.createQuery("from RegisterDetail");
        list = registers.getResultList();

        transaction.commit();

        session.close();
        return list;
    }

}
