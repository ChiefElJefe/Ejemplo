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
            System.out.println("" + dnombres.get(i)[0] + " " + dnombres.get(i)[1]);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _08_ConsultasHQL(short a) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("select e.nombre FROM Empleado as e WHERE e.fecha_alta between '2016-01-01' and '2017-01-01'");
        List<String> nombres = query.list();
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("" + nombres.get(i));
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _08_ConsultasHQL(String a) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("select e.nombre FROM Departamento as d left outer join d.empleado as e WHERE d.dnombre = 'INFORMATICA'");
        List<String> nombres = query.list();
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("" + nombres.get(i));
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _08_ConsultasHQL(int a, int b) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("select count(e.nombre) from Departamento d left outer join d.empleado e group by (d.dnombre)");
        List<Long> nombres = query.list();
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("" + nombres.get(i));
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _08_ConsultasHQL(long a, long b) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("select d.dnombre from Departamento d left outer join d.empleado e where e.departamento is null");
        List<String> nombres = query.list();
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("" + nombres.get(i));
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    public _08_ConsultasHQL(short a, short b) {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query query = sesion.createQuery("select d.dnombre from Departamento d where d.dnombre not in (" +
                " select d.dnombre from Departamento d left outer join d.empleado e where e.nombre like 'Cristina%') ");
        List<String> nombres = query.list();
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("" + nombres.get(i));
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}
