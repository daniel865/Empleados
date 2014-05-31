/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webempleados.entidades;

/**
 *
 * @author Daniel
 */
public class Empleado {
    
    private long nro_identificacion;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private long telefono;
    private int cargo;

    public Empleado(long nro_identificacion, String nombres, String apellido1, String apellido2, String direccion, long telefono, int cargo) {
        this.nro_identificacion = nro_identificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public Empleado(long nro_identificacion, String nombres, String apellido1, String direccion, long telefono, int cargo) {
        this.nro_identificacion = nro_identificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public long getNro_identificacion() {
        return nro_identificacion;
    }

    public void setNro_identificacion(long nro_identificacion) {
        this.nro_identificacion = nro_identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nro_identificacion=" + nro_identificacion + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion=" + direccion + ", telefono=" + telefono + ", cargo=" + cargo + '}';
    }
    
    
    
}
