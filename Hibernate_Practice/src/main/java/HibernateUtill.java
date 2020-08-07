import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtill {
    private static SessionFactory sessionFactory;

    static {
    try{
        sessionFactory = new Configuration().configure("auction.cfg.xml").buildSessionFactory();
        }catch(Throwable ex){
            throw new ExceptionInInitializerError(ex);
            }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void shutdown(){
        getSessionFactory().close();
    }
}
