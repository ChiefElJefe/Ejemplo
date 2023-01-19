package org.iesabastos.ejemplo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int emp_no;
    @Column
    private String nombre;
    @Column
    private String oficio;
    @Column
    private Date fecha_alta;
    @Column
    private float salario;
    @Column
    private float comision;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_NO")
    private int dept_NO;

    public Empleado() {
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getDept_NO() {
        return dept_NO;
    }

    public void setDept_NO(int dept_NO) {
        this.dept_NO = dept_NO;
    }
}
