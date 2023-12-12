package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.example.manyToMany.Employee;
import org.example.manyToMany.Task;
import org.example.oneToMany.Account;
import org.example.oneToMany.Person;
import org.example.oneToOne.Address;
import org.example.oneToOne.User;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("""
                        Enter operation:
                        1: one-to-one
                        2: one-to-many || many-to-one
                        3: many-to-many
                        """);
                int a = sc.nextInt();
                switch (a) {
                    case 1:
                        session.beginTransaction();

                        User user = new User();
                        user.setName("John");

                        Address address = new Address();
                        address.setCity("City");
                        address.setUser(user);

                        user.setAddress(address);

                        session.save(user);
                        session.save(address);

                        session.getTransaction().commit();
                        System.out.println("User and Address saved successfully!");
                        break;

                    case 2:
                        session.beginTransaction();

                        Person person = new Person();
                        person.setName("John Doe");

                        Person personKate = new Person();
                        personKate.setName("Kate");

                        Account account1 = new Account();
                        account1.setBalance(1000.0);
                        account1.setPerson(person);

                        Account account2 = new Account();
                        account2.setBalance(500.0);
                        account2.setPerson(person);

                        Account accountKate1 = new Account();
                        accountKate1.setBalance(1000.0);
                        accountKate1.setPerson(personKate);

                        Account accountKate2 = new Account();
                        accountKate2.setBalance(500.0);
                        accountKate2.setPerson(personKate);

                        Account accountKate3 = new Account();
                        accountKate3.setBalance(1000.0);
                        accountKate3.setPerson(personKate);

                        person.getAccounts().add(account1);
                        person.getAccounts().add(account2);

                        personKate.getAccounts().add(accountKate1);
                        personKate.getAccounts().add(accountKate2);
                        personKate.getAccounts().add(accountKate3);


                        session.save(person);
                        session.save(personKate);

                        session.getTransaction().commit();
                        break;

                    case 3:
                        session.beginTransaction();

                        Employee employee1 = new Employee("John");
                        Employee employee2 = new Employee("Alice");

                        Task task1 = new Task("Task A");
                        Task task2 = new Task("Task B");

                        session.save(task1);
                        session.save(task2);

                        Set<Task> tasksList1 = new HashSet<>();
                        tasksList1.add(task1);
                        tasksList1.add(task2);
                        employee1.setTasks(tasksList1);

                        Set<Task> tasksList2 = new HashSet<>();
                        tasksList2.add(task2);
                        employee2.setTasks(tasksList2);

                        session.save(employee1);
                        session.save(employee2);

                        session.getTransaction().commit();

                        System.out.println("Employees and Tasks saved successfully!");
                        break;

                }
            }
        }
    }
}
