package lk.sipsewanainstitute.hibernate.dao.custom.impl;


import lk.sipsewanainstitute.hibernate.dao.custom.StudentDAO;
import lk.sipsewanainstitute.hibernate.entity.Program;
import lk.sipsewanainstitute.hibernate.entity.Register;
import lk.sipsewanainstitute.hibernate.entity.Student;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Student id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Student> findAll() throws Exception {
        return null;
    }

//    @Override
//    public boolean add(Student entity) throws Exception {
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
//    public boolean update(Student entity) throws Exception {
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
//        Student student= session.get(Student.class, s);
//
//        session.delete(student);
//
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    @Override
//    public Student find(String s) throws Exception {
//        return null;
//    }
//
//    @Override
//    public List<Student> findAll() throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<Student> list = null;
//
//        Query students = session.createQuery("from Student");
//        list = students.list();
//
//        transaction.commit();
//
//        session.close();
//        return list;
//    }
}
