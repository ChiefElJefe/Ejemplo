package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class _11_MasAntiguo {
    public _11_MasAntiguo() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query empleadosAntiguos = sesion.createQuery("from Empleado order by fecha_alta asc");

        Iterator iter = empleadosAntiguos.iterate();
        Empleado empleado;
        int i = 1, deptNO;
        if (iter.hasNext()){
            empleado = (Empleado) iter.next();
            System.out.println("\n" + i + ": " + empleado.getEmp_no() + " " + empleado.getNombre());
            i++;
            deptNO = empleado.getDepartamento().getDept_NO();

            Iterator iter2 = empleadosAntiguos.iterate();
            if (iter2.hasNext()){
                System.out.println("Compañeros del departamento " +deptNO);
                List<Empleado> listaCompanneros = empleado.getDepartamento().getEmpleado();

                for (int j = 0; j < listaCompanneros.size(); j++) {
                    System.out.println(listaCompanneros.get(i).getNombre());
                }

                sesion.getTransaction().commit();
                sesion.close();
            }
        }
    }
}
