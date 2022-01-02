package lk.sipsewanainstitute.hibernate.dao.custom.impl;


import lk.sipsewanainstitute.hibernate.dao.custom.ProgramDAO;
import lk.sipsewanainstitute.hibernate.entity.Program;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {
    @Override
    public boolean add(Program program) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(program);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Program program) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(program);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Program program = session.get(Program.class, id);

        session.delete(program);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Program find(String id) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        List<Program>list=null;

        String hql="FROM Program P WHERE P.programID=:id";
        Query query=session.createQuery(hql).setString("id",id);
        list = query.getResultList();
        transaction.commit();

        session.close();
        return list.get(0);
    }

    @Override
    public List<Program> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Program> list = null;

        Query programs = session.createQuery("from Program");
        list = programs.getResultList();

        transaction.commit();

        session.close();
        return list;
    }

    @Override
    public boolean ifProgramExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
