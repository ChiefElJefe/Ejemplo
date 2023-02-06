package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;

public class _10_QueryParam {

    public _10_QueryParam() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query q = sesion.createQuery("from Empleado where salario >= :sal");

        q.setInteger("sal", 800);
        //q.setFetchSize(5);
        Iterator iter = q.iterate();
        int i = 1;

        while (iter.hasNext()){
            Empleado empleado = (Empleado) iter.next();
            System.out.println("\n"+ i + ": " + empleado.getEmp_no() + " " + empleado.getNombre());
            i++;
        }

        sesion.getTransaction().commit();
        sesion.close();

    }
}
