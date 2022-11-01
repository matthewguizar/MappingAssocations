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

            // Guide guide = new Guide("2000IM10901", "Ian Lamb", 2000);
            // Student student = new Student("2014AL50456", "Amy Gill", guide);

            //getting student with ID of 2
            Student student = (Student) session.get(Student.class, 2L);
            // session.save(guide);
            // session.save(student);
            
            session.delete(student);

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
