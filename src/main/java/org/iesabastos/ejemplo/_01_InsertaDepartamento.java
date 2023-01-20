package org.iesabastos.ejemplo;

import org.hibernate.Session;

import java.util.List;

public class _01_InsertaDepartamento {
    private Departamento departamento;


    public _01_InsertaDepartamento(Departamento departamento) {
        this.departamento = departamento;
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        departamento.setDept_NO((byte) 60);
        departamento.setDnombre("MATEMATICAS");
        departamento.setLoc("DESPA9");
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(departamento);
        sesion.getTransaction().commit();
        sesion.close();
    }
}
