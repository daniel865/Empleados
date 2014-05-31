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
public class Cargo {

    private int cargo;
    private String descripcion;

    public Cargo(int cargo, String descripcion) {
        this.cargo = cargo;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    
    
    
}
