package org.iesabastos.ejemplo;

import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class _04_ListadoDep {
    private List<Empleado> empleados;

    public _04_ListadoDep() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Empleado");
        this.empleados = (ArrayList<Empleado>) query.list();

        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDepartamento().getDept_NO() == (byte)10){
                System.out.println(""+empleados.get(i).getNombre());
            }
        }

    }
}
