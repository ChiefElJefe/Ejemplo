package org.iesabastos.ejemplo;

import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class _02_InsertaEmpleadoNuevoDep {
    private Departamento departamento;
    private List<Empleado> empleados;

    public _02_InsertaEmpleadoNuevoDep(Departamento departamento, List<Empleado> empleados) {
        this.departamento = departamento;
        this.empleados = empleados;

        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        departamento.setDept_NO((byte)70);
        departamento.setDnombre("GEOLOGIA");
        departamento.setLoc("DESPA17");
        empleados.add(new Empleado());
        empleados.get(0).setEmp_no((short)15);
        empleados.get(0).setDepartamento(departamento);
        empleados.get(0).setComision(200f);
        empleados.get(0).setNombre("Ivan");
        empleados.get(0).setFecha_alta(new Date());
        empleados.get(0).setSalario(400f);
        empleados.get(0).setOficio("Geologo");
        departamento.setEmpleado(empleados);
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(departamento);
        sesion.save(empleados.get(0));
        sesion.getTransaction().commit();
        sesion.close();
    }
}
