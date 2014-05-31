/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webempleados.daos;

import com.webempleados.entidades.Cargo;
import com.webempleados.entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class EmpleadoDAO extends BaseDAO {

    public EmpleadoDAO(Conexion connectionManager) {
        super(connectionManager);
    }

    public void crearEmpleado(Empleado empleado) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO EMPLEADOS(identificacion_emp,nombres_emp,apellido1_emp,apellido2_emp,direccion_emp,telefono_emp,cargo_emp) "
                    + "VALUES(?,?,?,?,?,?,?)");
            ps.setLong(1, empleado.getNro_identificacion());
            ps.setString(2, empleado.getNombres());
            ps.setString(3, empleado.getApellido1());
            ps.setString(4, empleado.getApellido2());
            ps.setString(5, empleado.getDireccion());
            ps.setLong(6, empleado.getTelefono());
            ps.setLong(7, empleado.getCargo());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear empleado", e);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }

    public Empleado buscarEmpleado(long identificacion) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("SELECT * FROM EMPLEADOS WHERE identificacion_emp=?");
            ps.setLong(1, identificacion);
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new Empleado(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getInt(7));
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al buscar empleado", e);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    
    public void modificarEmpleado(Empleado empleado)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("UPDATE EMPLEADOS SET nombres_emp=?,apellido1_emp=?,apellido2_emp=?,direccion_emp=?,telefono_emp=?,cargo_emp=? WHERE identificacion_emp=?");
            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setString(4, empleado.getDireccion());
            ps.setLong(5, empleado.getTelefono());
            ps.setInt(6, empleado.getCargo());
            ps.setLong(7, empleado.getNro_identificacion());
            ps.execute();
          
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al modificar empleado", e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    public void eliminarEmpleado(long identificacion)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("DELETE FROM EMPLEADOS WHERE identificacion_emp=?");
            ps.setLong(1, identificacion);
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al eliminar empleado", e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
   

}
