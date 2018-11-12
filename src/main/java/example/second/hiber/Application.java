package example.second.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class Application {

    private static SessionFactory factory;

    public static void main(String[] args) {

        factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=null;

        try{
            transaction=session.beginTransaction();

            League league1=new League();
            league1.setName("NFL");
            session.save(league1);

            League league2=new League();
            league2.setName("NBA");
            session.save(league2);

            League league3=new League();
            league3.setName("NHL");
            session.save(league3);

            City city1=new City();
            city1.setName("Boston");
            city1.setLeague(league2);
            city1.setLeague(league3);
            session.save(city1);

            City city2=new City();
            city2.setName("Pitsburgh");
            city2.setLeague(league1);
            session.save(city2);

            transaction.commit();
        }catch (Exception e)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            System.out.println("ERROR"+e.getMessage());

        }finally {
            session.close();
        }
        factory.close();
    }
}
