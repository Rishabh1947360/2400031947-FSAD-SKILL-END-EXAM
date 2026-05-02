package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.query.Query;
import java.util.*;

public class ClientDemo {
    public static void main(String[] args) {

        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();

        Invoice i = new Invoice();
        i.setName("Rishabh");
        i.setStatus("PAID");
        i.setDate(new Date());

        s.save(i);
        t.commit();

        // Fetch all
        Query q1 = s.createQuery("from Invoice");
        List<Invoice> list = q1.list();
        list.forEach(x -> System.out.println(x.getName()+" "+x.getStatus()));

        // Filter
        Query q2 = s.createQuery("from Invoice where status=?1");
        q2.setParameter(1, "PAID");
        List<Invoice> list2 = q2.list();
        list2.forEach(x -> System.out.println("Filtered: "+x.getName()));

        s.close();
    }
}