package example.second.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

   private static SessionFactory sessionFactory;
   public static SessionFactory getSessionFactory(){

       if(sessionFactory==null){
           try{
               sessionFactory=new Configuration().configure().buildSessionFactory();
           }catch(Throwable ex){
               System.err.println("Inital SessionFactory creation failed"+ex);
           }
       }
       return sessionFactory;
   }


}
