package lk.sipsewanainstitute.hibernate.business;


import lk.sipsewanainstitute.hibernate.business.custom.impl.ProgramBOImpl;
import lk.sipsewanainstitute.hibernate.business.custom.impl.RegisterBOImpl;
import lk.sipsewanainstitute.hibernate.business.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBOImpl();
            case PROGRAM:
                return new ProgramBOImpl();
            case REGISTER:
                return new RegisterBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
        STUDENT, PROGRAM, REGISTER
    }
}
