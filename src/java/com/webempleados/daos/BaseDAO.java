/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webempleados.daos;

import java.sql.Connection;

/**
 *
 * @author Daniel
 */
public class BaseDAO {
    
    protected Conexion connectionManager;

    public BaseDAO(Conexion connectionManager) {
        this.connectionManager = connectionManager;
    }

    
    
    
    
}
