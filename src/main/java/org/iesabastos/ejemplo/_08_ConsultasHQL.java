package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class _08_ConsultasHQL {
    public _08_ConsultasHQL() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("FROM Departamento");
        Iterator iter = query.iterate();
        while (iter.hasNext()) {
            Departamento departamento = (Departamento) iter.next();
            System.out.println(departamento.getDnombre() + " " + departamento.getDept_NO() + " " + departamento.getLoc());
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _08_ConsultasHQL(int a) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("select d.dnombre FROM Departamento as d");
        List<String[]> dnombres = query.list();
        for (int i = 0; i < dnombres.size(); i++) {
            System.out.println("" + dnombres.get(i));
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _08_ConsultasHQL(long a) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("select d.dnombre, d.loc FROM Departamento as d");
        List<Object[]> dnombres = query.list();
        for (int i = 0; i < dnombres.size(); i++) {
            System.out.println("" + dnombres.get(i)[0] + " " +dnombres.get(i)[1]);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _08_ConsultasHQL(short a) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("select d.dnombre, d.loc FROM Empleado as e");
        List<Object[]> dnombres = query.list();
        for (int i = 0; i < dnombres.size(); i++) {
            System.out.println("" + dnombres.get(i)[0] + " " +dnombres.get(i)[1]);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}
