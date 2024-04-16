package dao;

public abstract class DaoFactory {
    public abstract DaoTypeRepas getDaoTypeRepas();
    public abstract DaoRepas getDaoRepas();
    public abstract DaoSymptome getDaoSymptome();

//    public static Dao getDaoFactory(PersistenceType persistenceType) {
//        if (persistenceType == PersistenceType.JPA) {
//            return new JpaDaoFactory();
//        } else if (persistenceType == PersistenceType.JSON) {
//            return new JsonDaoFactory();
//        } else {
//            return null;
//        }
//    }
}
