package org.iesabastos.ejemplo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column
    private short emp_no;
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

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "dept_NO")
    private Departamento departamento;

    public Empleado() {
    }

    public short getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(short emp_no) {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
