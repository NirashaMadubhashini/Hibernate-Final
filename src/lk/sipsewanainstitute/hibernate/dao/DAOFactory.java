package lk.sipsewanainstitute.hibernate.dao;


import lk.sipsewanainstitute.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.sipsewanainstitute.hibernate.dao.custom.impl.RegisterDAOImpl;
import lk.sipsewanainstitute.hibernate.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAM:
                return new ProgramDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        STUDENT, PROGRAM,REGISTER
    }
}
