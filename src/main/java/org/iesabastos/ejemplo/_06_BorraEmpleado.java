package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class _06_BorraEmpleado {
    private List<Empleado> empleados;

    public _06_BorraEmpleado() {
        this.empleados = empleados;

        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Empleado");
        this.empleados = (ArrayList<Empleado>) query.list();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(empleados.get(0));
        sesion.getTransaction().commit();
        sesion.close();
    }
}
