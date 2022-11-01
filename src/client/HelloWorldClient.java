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

        //    Guide g1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        //    Guide g2 = new Guide("2000IM10901", "Ian Lamb", 2000);

        //    Student s1 = new Student("2014JT50123", "John Smith", g1);
        //    Student s2 = new Student("2014AL50456", "Amy Gill", g1);

        //    g1.getStudents().add(s1);
        //    g1.getStudents().add(s2);
        
        //    session.persist(g1);
        //    session.persist(g2);

        Guide guide = (Guide) session.get(Guide.class, 15L);
        Student student = (Student) session.get(Student.class, 13L);

        //guide.setSalary(2500);
        guide.addStudents(student);


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
