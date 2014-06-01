/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webempleados.servlets;

import com.webempleados.daos.CargoDAO;
import com.webempleados.daos.Conexion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.webempleados.daos.EmpleadoDAO;
import com.webempleados.entidades.Cargo;
import com.webempleados.entidades.Empleado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "ServletEmpleado", urlPatterns = {"/ServletEmpleado"})
public class ServletEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        if (("Guardar").equals(accion)) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(new Conexion("dba_empleados", "polijic", "jdbc:oracle:thin:@localhost:1521:XE"));
            String nro_identificacion = request.getParameter("nro_identificacion");
            String nombres = request.getParameter("nombres");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String cargo = request.getParameter("cargo");
            try {
                empleadoDAO.crearEmpleado(new Empleado(Long.parseLong(nro_identificacion), nombres, apellido1, apellido2, direccion, Long.parseLong(telefono), Integer.parseInt(cargo)));
            } catch (Exception e) {
                Logger.getLogger(ServletEmpleado.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", e.getMessage());
                request.setAttribute("nro_identificacion", nro_identificacion);
                request.setAttribute("nombres", nombres);
                request.setAttribute("apellido1", apellido1);
                request.setAttribute("apellido2", apellido2);
                request.setAttribute("direccion", direccion);
                request.setAttribute("telefono", telefono);
                request.setAttribute("cargo", cargo);
            }
            request.getRequestDispatcher("FrmGestionar.jsp").forward(request, response);
        } else {
            if (("Consultar").equals(accion)) {
                EmpleadoDAO empleadoDAO = new EmpleadoDAO(new Conexion("dba_empleados", "polijic", "jdbc:oracle:thin:@localhost:1521:XE"));
                String id = request.getParameter("buscar_emp");
                Empleado empleado;
                try {
                    empleado = empleadoDAO.buscarEmpleado(Long.parseLong(id));
                    request.setAttribute("mensaje", "El Empleado fue encontrado");
                    request.setAttribute("nro_identificacion", Long.toString(empleado.getNro_identificacion()));
                    request.setAttribute("nombres", empleado.getNombres());
                    request.setAttribute("apellido1", empleado.getApellido1());
                    request.setAttribute("apellido2", empleado.getApellido2());
                    request.setAttribute("direccion", empleado.getDireccion());
                    request.setAttribute("telefono", Long.toString(empleado.getTelefono()));
                    request.setAttribute("cargo", Integer.toString(empleado.getCargo()));
                    request.getRequestDispatcher("FrmGestionar.jsp").forward(request, response);

                } catch (Exception e) {
                    Logger.getLogger(ServletEmpleado.class.getName()).log(Level.SEVERE, null, e);
                    request.setAttribute("mensaje", "Empleado no existe");
                    request.getRequestDispatcher("FrmGestionar.jsp").forward(request, response);
                }
            } else {
                if (("Modificar").equals(accion)) {
                    EmpleadoDAO empleadoDAO = new EmpleadoDAO(new Conexion("dba_empleados", "polijic", "jdbc:oracle:thin:@localhost:1521:XE"));
                    String nro_identificacion = request.getParameter("nro_identificacion");
                    String nombres = request.getParameter("nombres");
                    String apellido1 = request.getParameter("apellido1");
                    String apellido2 = request.getParameter("apellido2");
                    String direccion = request.getParameter("direccion");
                    String telefono = request.getParameter("telefono");
                    String cargo = request.getParameter("cargo");
                    try {
                        empleadoDAO.modificarEmpleado(new Empleado(Long.parseLong(nro_identificacion), nombres, apellido1, apellido2, direccion, Long.parseLong(telefono), Integer.parseInt(cargo)));
                        request.setAttribute("mensaje", "Empleado modificado correctamente");
                    } catch (Exception e) {
                        Logger.getLogger(ServletEmpleado.class.getName()).log(Level.SEVERE, null, e);
                        request.setAttribute("mensaje", e.getMessage());
                        request.setAttribute("nro_identificacion", nro_identificacion);
                        request.setAttribute("nombres", nombres);
                        request.setAttribute("apellido1", apellido1);
                        request.setAttribute("apellido2", apellido2);
                        request.setAttribute("direccion", direccion);
                        request.setAttribute("telefono", telefono);
                        request.setAttribute("cargo", cargo);
                    }
                    request.getRequestDispatcher("FrmGestionar.jsp").forward(request, response);
                } else {
                    if (("Eliminar").equals(accion)) {
                        EmpleadoDAO empleadoDAO = new EmpleadoDAO(new Conexion("dba_empleados", "polijic", "jdbc:oracle:thin:@localhost:1521:XE"));
                        String id = request.getParameter("eliminar_emp");
                        try {
                            empleadoDAO.eliminarEmpleado(Long.parseLong(id));
                            request.setAttribute("mensaje", "Empleado eliminado correctamente");
                        } catch (Exception e) {
                            Logger.getLogger(ServletEmpleado.class.getName()).log(Level.SEVERE, null, e);
                            request.setAttribute("mensaje", "Error al eliminar empleado");
                        }
                        request.getRequestDispatcher("FrmGestionar.jsp").forward(request, response);
                    }else{
                        if ( ("Inicio").equals(accion) ){
                            request.getRequestDispatcher("FrmGestionar.jsp").forward(request, response);
                        }
                    }
                    
                }
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
        
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void loadCargos(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Cargos");
        CargoDAO cargoDAO = new CargoDAO(new Conexion("dba_empleados", "polijic", "jdbc:oracle:thin:@localhost:1521:XE"));
        List<Cargo> listCargos;
        try {
            listCargos = cargoDAO.listarCargos();
            System.out.println(listCargos.toString());
            request.setAttribute("listCargos", listCargos);
            request.setAttribute("load", true);
        } catch (Exception e) {
            Logger.getLogger(ServletEmpleado.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    
}
