package lk.sipsewanainstitute.hibernate.dao.custom.impl;


import lk.sipsewanainstitute.hibernate.dao.custom.StudentDAO;
import lk.sipsewanainstitute.hibernate.entity.Student;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }


    @Override
    public Student find(String id) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        List<Student> list = null;

        String hql = "FROM Student S WHERE S.nic = :id";
        Query query = session.createQuery(hql).setString("id",id);
        list = query.getResultList();
        transaction.commit();

        session.close();
        return list.get(0);
    }

    @Override
    public List<Student> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> list = null;

        Query students = session.createQuery("from Student");
        list = students.getResultList();

        transaction.commit();

        session.close();
        return list;
    }

    @Override
    public boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
