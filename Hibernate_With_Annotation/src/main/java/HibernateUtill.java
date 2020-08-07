import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtill {
    private static SessionFactory sessionFactory;

    static {
    try{
       /* AnnotationConfiguration acfg=new AnnotationConfiguration();
        acfg.addAnnotatedClass(Message2.class);
        sessionFactory = acfg.buildSessionFactory();*/
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
