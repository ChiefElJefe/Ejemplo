package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class _03_InsertaEmpleado {
    private ArrayList<Departamento> departamento;
    private List<Empleado> empleados;

    public _03_InsertaEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;

        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();

        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Departamento");
        this.departamento = (ArrayList<Departamento>) query.list();
        empleados.add(new Empleado());
        empleados.get(0).setDepartamento(departamento.get(3));
        empleados.get(0).setEmp_no((short)20);
        empleados.get(0).setComision(300f);
        empleados.get(0).setNombre("Raúl");
        empleados.get(0).setFecha_alta(new Date());
        empleados.get(0).setSalario(600f);
        empleados.get(0).setOficio("Bedel");

        sesion.beginTransaction();
        sesion.save(empleados.get(0));
        sesion.getTransaction().commit();
        sesion.close();
    }
}
