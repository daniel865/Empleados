/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webempleados.daos;

import com.webempleados.entidades.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class CargoDAO extends BaseDAO{

    public CargoDAO(Conexion connectionManager) {
        super(connectionManager);
    }

    public List<Cargo> listarCargos()throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            List<Cargo> cargos = new LinkedList<Cargo>();
            ps = connection.prepareStatement("SELECT * FROM CARGOS");
            rs = ps.executeQuery();
            while (rs.next()) {                
                cargos.add(new Cargo(rs.getInt(1), rs.getString(2)));
            }
            return cargos;
        } catch (Exception e) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al listas cargos",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    public Cargo obtenerCargo(String empleado)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM CARGOS WHERE codigo_car=?");
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new Cargo(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al obtener cargo",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    
    
}

