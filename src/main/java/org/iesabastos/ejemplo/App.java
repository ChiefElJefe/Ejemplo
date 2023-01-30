package org.iesabastos.ejemplo;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //List<Empleado> empleado = new ArrayList<Empleado>();
        //Departamento departamento = new Departamento();
        //_01_InsertaDepartamento a = new _01_InsertaDepartamento(departamento);
        //_02_InsertaEmpleadoNuevoDep a = new _02_InsertaEmpleadoNuevoDep(departamento, empleado);
        //_03_InsertaEmpleado a = new _03_InsertaEmpleado(empleado);
        //_04_ListadoDep a = new _04_ListadoDep();
        //_05_ListadoDep a = new _05_ListadoDep();
        //_06_BorraEmpleado a = new _06_BorraEmpleado();
        //_07_ModificaEmpleado a = new _07_ModificaEmpleado();
        /*HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        Query q = sesion.createQuery("from Departamento d, Empleado e "
                + "where d.dept_NO=e.departamento.dept_NO order by e.nombre");
        List <Object[]> lista = q.list();
        Departamento dep;
        Empleado emp;
        for (Object[] resultado: lista){
            dep = (Departamento) resultado [0];
            emp = (Empleado) resultado [1];

            System.out.println(dep.getDept_NO() + " * " +
                    dep.getDnombre()+ " * " + emp.getNombre());
        }
        sesion.getTransaction().commit();
        sesion.close();*/
        //_09_QueryDep a = new _09_QueryDep();
        //_09_QueryDep a = new _09_QueryDep(1);
        //_08_ConsultasHQL a = new _08_ConsultasHQL();
        //_08_ConsultasHQL a = new _08_ConsultasHQL(1);
        _08_ConsultasHQL a = new _08_ConsultasHQL((long)1);

    }
}
