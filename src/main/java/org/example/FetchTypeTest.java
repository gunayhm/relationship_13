package org.example;

import java.util.List;
import java.util.Scanner;
import org.example.manyToMany.Employee;
import org.example.oneToMany.Account;
import org.example.oneToMany.Person;
import org.example.oneToOne.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class FetchTypeTest {
    public static void main(String[] args) {
//        SessionFactory factory=HibernateUtil.getSessionFactory();
//
//        Session session1=factory.openSession();  // GET
//        session1.beginTransaction();
//        User user1=session1.get(User.class,1L); // select
//        User user2=session1.get(User.class,1L); // cache
//        session1.close();
//
//        System.out.println("-----------------------------------------");
//
//        Session session2=factory.openSession();  // IGNORE
//        User user3=session2.get(User.class,1L); // cache
//        User user4=session2.get(User.class,1L); // cache
//
//        session2.close();


        int a=1;

        switch(a){
            case 1:
                System.out.println(a);
                break;
            case 2:
                System.out.println(a+10);
                break;
            case 3:
                System.out.println(a+20);
                break;
        }

    }

}
