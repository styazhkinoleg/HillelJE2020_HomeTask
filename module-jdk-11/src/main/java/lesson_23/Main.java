package lesson_23;

import org.hibernate.Session;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateSession.getSessionFactory().openSession();

        printStudent(session);
        System.out.println();

        printStudent(session, 2);
        System.out.println();

        printStudent(session, "Bogdan%");
        System.out.println();

        createStudent(session);
        printStudent(session);
        System.out.println();

        deleteStudent(session);
        printStudent(session);

        HibernateSession.close();
    }
    private static List getStudent(Session session) {
        return session.createQuery("from Student").list();
    }
    private static List getStudent(Session session, long id) {
        return session.createQuery("from Student as s where s.id = :id").setParameter("id", id).list();
    }
    private static List getStudent(Session session, String name) {
        return session.createQuery("from Student as s where s.name like :name").setParameter("name", name).list();
    }
    private static void printStudent(Session session) {
        getStudent(session).forEach(System.out :: println);
    }
    private static void printStudent(Session session, long id) {
        getStudent(session, id).forEach(System.out :: println);
    }
    private static void printStudent(Session session, String name) {
        getStudent(session, name).forEach(System.out :: println);
    }
    private static void createStudent(Session session)  {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter data like \"FirstName,GroupName,YaerOfEntry\": ");
        String result = scanner.nextLine();
        String [] param = result.split(",");
        if (param.length == 3) {
            Groups group = getGroup(session, param[1]);
            session.beginTransaction();
            session.save(new Student(param[0], group, param[2]));
            session.getTransaction().commit();
        } else {
            System.out.println("Wrong data");
        }
    }
    private static Groups getGroup(Session session, String name) {
        var scrollableResults = session.createQuery("From Groups as g where name like :name")
                .setParameter("name", name)
                .setMaxResults(1)
                .scroll();
        Groups group = null;
        if(scrollableResults.next())
            group = (Groups) scrollableResults.get()[0];
        else {
            session.beginTransaction();
            group = new Groups(name);
            session.save(group);
            session.getTransaction().commit();
        }
        scrollableResults.close();
        return group;
    }
    private static void deleteStudent(Session session){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID student to delete it: ");
        long id = -1;
        try {
            id = scanner.nextLong();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return;
        }
        var scrollableResults = session.createQuery("From Grades as g where student_id = :id")
                .setParameter("id", id)
                .setMaxResults(1)
                .scroll();
        if(scrollableResults.next()){
            System.out.println("Can not delete Student ID = " + id + ". Links found in table Grades.");
        } else {
            session.beginTransaction();
            getStudent(session, id).forEach(session ::delete);
            session.getTransaction().commit();
        }
        scrollableResults.close();
    }
}
