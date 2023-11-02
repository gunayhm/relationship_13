//package org.example;
//
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//import org.example.manyToMany.Employee;
//import org.example.manyToMany.Task;
//import org.example.oneToMany.Account;
//import org.example.oneToMany.Person;
//import org.example.oneToOne.Address;
//import org.example.oneToOne.User;
//import org.hibernate.Session;
//
//public class App {
//    public static void main(String[] args) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
//            Scanner sc = new Scanner(System.in);
//
//            while (true) {
//                System.out.println("""
//                        Enter operation:
//                        1: one-to-one
//                        2: one-to-many || many-to-one
//                        3: many-to-many
//                        """);
//                int a = sc.nextInt();
//                switch (a) {
//                    case 1:
//                        session.beginTransaction();
//                        Address address = new Address();
//                        address.setCity("City");
//
//                        User user = new User();
//                        user.setName("John");
//                        user.setAddress(address);
//
//                        session.save(user);
//
//                        session.getTransaction().commit();
//                        System.out.println("User and Address saved successfully!");
//                        break;
//
//                    case 2:
//                        session.beginTransaction();
//                        Person person = new Person();
//                        person.setName("John Doe");
//
//                        Account account1 = new Account();
//                        account1.setBalance(1000.0);
//                        account1.setPerson(person);
//
//                        Account account2 = new Account();
//                        account2.setBalance(500.0);
//                        account2.setPerson(person);
//
//                        person.getAccounts().add(account1);
//                        person.getAccounts().add(account2);
//
//                        session.save(person); // This will cascade the save to accounts as well
//                        session.getTransaction().commit();
//                        break;
//
//                    case 3:
//                        session.beginTransaction();
//
//                        Employee employee1 = new Employee("John");
//                        Employee employee2 = new Employee("Alice");
//
//                        Task task1 = new Task("Task A");
//                        Task task2 = new Task("Task B");
//
//                        session.save(task1);
//                        session.save(task2);
//
//                        Set<Task> tasks1 = new HashSet<>();
//                        tasks1.add(task1);
//                        tasks1.add(task2);
//                        employee1.setTasks(tasks1);
//
//                        Set<Task> tasks2 = new HashSet<>();
//                        tasks2.add(task2);
//                        employee2.setTasks(tasks2);
//
//                        session.save(employee1);
//                        session.save(employee2);
//
//                        session.getTransaction().commit();
//
//                        System.out.println("Employees and Tasks saved successfully!");
//                        break;
//
//                }
//            }
//        }
//    }
//}
