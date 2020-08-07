
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

public class DisplayMessage {

    public static void main(String[] args) {
        Session session=HibernateUtill.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        Message message=new Message("Hello Nikhil");
        Long msgid =(Long)session.save(message);

        Statistics stats=  HibernateUtill.getSessionFactory().getStatistics();
        stats.setStatisticsEnabled(true);
        stats.getSessionOpenCount();
        stats.logSummary();

        tx.commit();
        System.out.println("Session check :: " + session.isOpen());
        session.flush();

        Session newSession1=HibernateUtill.getSessionFactory().openSession();
        Transaction tx2=session.beginTransaction();
        List messages=newSession1.createQuery("from Message m order by m.text asc").list();
        System.out.println(messages.size()+" message(s) found:");

        for(Iterator iter = messages.iterator();iter.hasNext();){
            Message loadmsg=(Message) iter.next();
            System.out.println(loadmsg.getText());
        }

       /*
       Need to study
       EntityStatistics ItemStats=stats.getEntityStatistics("auction.model.item");
        ItemStats.getFetchCount();*/
        tx2.commit();
        newSession1.flush();
        HibernateUtill.shutdown();
    }
}
