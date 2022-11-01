package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;

public class HelloWorldClient {
    public static void main(String[] args) {
        Session session =  HibernateUtil.SessionFactory().openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

           

            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){transaction.rollback();}
            e.printStackTrace();
        }finally {
            if(session!=null){session.close();}
        }
        System.exit(0);
    }
}
