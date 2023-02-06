package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class _13_QueryFuncionesGrupo {
    public _13_QueryFuncionesGrupo() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();

        Double salario;
        salario = (Double) sesion.createQuery("select avg(salario) from Empleado").uniqueResult();

        System.out.println("Salario medio de profesores: " + salario);

        Query q = sesion.createQuery("from Empleado");
        List<Object> lista = q.list();
        Departamento departamento;

        int cont = 0;
        salario = Double.valueOf(0);

        for (int i = 0; i < lista.size(); i++) {
            Empleado empleado = (Empleado) lista.get(i);
            salario += empleado.getSalario();
            cont++;
        }
        System.out.println("Salario medio: " + salario/cont);
        System.out.println("Número de profesores: " + cont);
        sesion.getTransaction().commit();
        sesion.close();
    }
}
