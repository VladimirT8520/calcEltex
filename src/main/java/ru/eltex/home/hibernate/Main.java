package ru.eltex.home.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Collection<User> users = new ArrayList<User>();
        users.add(new User());
        User user = ((ArrayList<User>) users).get(0);
        Passport passport =new Passport();
        passport.setSeries("4878");
        passport.setNumber("179456");


        Collection<Address> addresses = new ArrayList<>();
        Collection<Doctor> doctor = new ArrayList<>();
        addresses.add(new Address());
        doctor.add(new Doctor());
        Address address = ((ArrayList<Address>) addresses).get(0);
        Doctor doctor1 = ((ArrayList<Doctor>) doctor).get(0);


        doctor1.setSpeciality("Stomatolog");
        doctor1.setPhone("222-15-09");
        doctor1.setFio("Olhovskiy Dmitri Ivanovich");
        doctor1.setCabinet(102);
        doctor1.setBirthday("10.06.1972");
        doctor1.setUser(users);

        address.setCity("Novosibirsk");
        address.setStreet("Lenina");
        address.setHome("15");
        address.setClients(users);

        user.setPassport(passport);
        user.setFio("Trescov Vladimir Nikolaevich");
        user.setSex("man");
        user.setRegday("19.05.1999");
        user.setBirthday("19.05.1963");
        user.setPhone("89529142806");
        user.setAddress(address);
        user.setDoctor(doctor);

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }

        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.save(passport);
        session.save(user);
        session.save(doctor1);
        session.save(address);
        session.getTransaction().commit();
        session.close();
    }
}

