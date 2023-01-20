package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class _07_ModificaEmpleado {
    private List<Empleado> empleados;

    public _07_ModificaEmpleado() {
        this.empleados = empleados;

        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Empleado");
        this.empleados = (ArrayList<Empleado>) query.list();
        this.empleados.get(1).setNombre("El yoyas");

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(empleados.get(1));
        sesion.getTransaction().commit();
        sesion.close();
    }
}
