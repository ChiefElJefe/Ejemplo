package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;

public class _12_QueryClasesNoAsociadas {
    public _12_QueryClasesNoAsociadas() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query q = sesion.createQuery("from Departamento d, Empleado e where d.dept_NO=e.departamento.dept_NO order by e.nombre");

        List<Object[]> lista = q.list();
        for (int i = 0; i < lista.size(); i++) {
            Departamento departamento = (Departamento) lista.get(i)[0];
            Empleado empleado = (Empleado) lista.get(i)[1];
            System.out.println(departamento.getDept_NO() + " / " + departamento.getDnombre() + " / " + empleado.getNombre());
        }

        q = sesion.createQuery("from Departamento d, Empleado e where d.dept_NO=e.departamento.dept_NO order by e.nombre");

        Iterator iter = q.iterate();
        while(iter.hasNext()){
            Object[] objeto = (Object[]) iter.next();
            Departamento departamento = (Departamento) objeto[0];
            Empleado empleado = (Empleado) objeto[1];
            System.out.println(departamento.getDept_NO() + " / " + departamento.getDnombre() + " / " + empleado.getNombre());
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}
