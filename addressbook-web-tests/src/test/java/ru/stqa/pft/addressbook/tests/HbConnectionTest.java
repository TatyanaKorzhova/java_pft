package ru.stqa.pft.addressbook.tests;
//import org.hibernate.boot.registry.StandardServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.EntryData;

import java.util.List;

public class HbConnectionTest {

    private SessionFactory sessionFactory;

    @BeforeClass
    protected void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

//    @Test
//    public void testHbConnection() {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        List<GroupData> result = session.createQuery( "from GroupData" ).list();
//        for (GroupData group : result) {
//            System.out.println(group);
//        }
//        session.getTransaction().commit();
//        session.close();
//    }

    @Test
    public void testHbConnection() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<EntryData> result = session.createQuery( "from EntryData where deprecated = '0000-00-00'" ).list();
        for (EntryData entry : result) {
            System.out.println(entry);
        }
        session.getTransaction().commit();
        session.close();
    }
}
