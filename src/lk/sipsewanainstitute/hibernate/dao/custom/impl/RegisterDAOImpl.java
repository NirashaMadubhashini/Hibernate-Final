package lk.sipsewanainstitute.hibernate.dao.custom.impl;

import lk.sipsewanainstitute.hibernate.dao.custom.RegisterDAO;
import lk.sipsewanainstitute.hibernate.entity.Register;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public boolean delete(Register id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Register register = session.get(Register.class, id);

        session.delete(register);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Register find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Register> findAll() throws Exception {
        return null;
    }
//    @Override
//    public boolean add(Register entity) throws Exception {
//        Session session= FactoryConfiguration.getInstance().getSession();
//        Transaction transaction=session.beginTransaction();
//
//        session.save(entity);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    @Override
//    public boolean update(Register entity) throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        session.update(entity);
//
//        transaction.commit();
//        return true;
//    }
//
//    @Override
//    public boolean delete(String s) throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        Register register= session.get(Register.class, s);
//
//        session.delete(register);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    @Override
//    public Register find(String s) throws Exception {
//        return null;
//    }
//
//    @Override
//    public List<Register> findAll() throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<Register> list = null;
//
//        Query registers = session.createQuery("from Register");
//        list = registers.list();
//
//        transaction.commit();
//
//        session.close();
//        return list;
//    }
}
