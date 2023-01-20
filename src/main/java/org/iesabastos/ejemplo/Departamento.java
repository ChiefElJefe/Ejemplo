package org.iesabastos.ejemplo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    private byte dept_NO;
    @Column
    private String dnombre;
    @Column
    private String loc;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.DETACH)
    List<Empleado> empleado;

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }

    public Departamento() {
    }

    public byte getDept_NO() {
        return dept_NO;
    }

    public void setDept_NO(byte dept_NO) {
        this.dept_NO = dept_NO;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
