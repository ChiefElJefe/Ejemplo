package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _09_QueryDep {
    public _09_QueryDep() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("FROM Departamento");
        List<Departamento> departamento = query.list();
        for (int i = 0; i < departamento.size(); i++) {
            System.out.println(departamento.get(i).getDnombre());
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _09_QueryDep(int a) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("FROM Departamento");
        Iterator iter = query.iterate();
        while (iter.hasNext()){
            Departamento departamento = (Departamento) iter.next();
            System.out.println(departamento.getDnombre());
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}
