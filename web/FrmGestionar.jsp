<%-- 
    Document   : FrmGestionar
    Created on : 24/05/2014, 04:03:32 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String mensaje = request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
    String nro_identificacion = request.getAttribute("nro_identificacion") != null ? (String) request.getAttribute("nro_identificacion") : "";
    String nombres = request.getAttribute("nombres") != null ? (String) request.getAttribute("nombres") : "";
    String apellido1 = request.getAttribute("apellido1") != null ? (String) request.getAttribute("apellido1") : "";
    String apellido2 = request.getAttribute("apellido2") != null ? (String) request.getAttribute("apellido2") : "";
    String direccion = request.getAttribute("direccion") != null ? (String) request.getAttribute("direccion") : "";
    String telefono = request.getAttribute("telefono") != null ? (String) request.getAttribute("telefono") : "";
    String cargo = request.getAttribute("cargo") != null ? (String) request.getAttribute("cargo") : "";
%>


<%if (mensaje != null) {%>
<script>
    alert('<%=mensaje%>');
</script>
<%}%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Empleado</title>
        <link rel="stylesheet" href="css/bootstrap.css"/>
        <link rel="stylesheet" href="css/dashboard.css"/>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.js"></script>
    </head>
    <body>
        <script type="text/javascript">
   
        </script>



        <div id="wrapper">

            <!-- Menu Horizontal -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Agrupación de Elementos en navbar para dispositivos mobiles-->
                <div class="navbar-header"> 
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"> <!-- Organizar data-target -->
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Web Empleados</a>
                </div>

                <!-- Colección de Link del Nav para el dashboard  parte izquierda-->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                    </ul>

                </div> <!-- Fin Barra Colapsada -->
            </nav>

            <form class="form-horizontal" action="ServletEmpleado" method="POST" >
                <fieldset>

                    <!-- Form Name -->
                    <legend>Gestionar Empleado</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="nro_identificacion">Número de Identificación</label>  
                        <div class="col-md-5">
                            <input id="nro_identificacion" name="nro_identificacion" type="text" placeholder="" class="form-control input-sm" required="" value="<%=nro_identificacion%>">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="nombres">Nombres</label>  
                        <div class="col-md-5">
                            <input id="nombres" name="nombres" type="text" placeholder="" class="form-control input-sm" required="" value="<%=nombres%>">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="apellido1">Primer Apellido</label>  
                        <div class="col-md-5">
                            <input id="apellido1" name="apellido1" type="text" placeholder="" class="form-control input-sm" required="" value="<%=apellido1%>">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="apellido2">Segundo Apellido</label>  
                        <div class="col-md-5">
                            <input id="apellido2" name="apellido2" type="text" placeholder="" class="form-control input-sm" required="" value="<%=apellido2%>">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="direccion">Dirección</label>  
                        <div class="col-md-5">
                            <input id="direccion" name="direccion" type="text" placeholder="" class="form-control input-sm" required="" value="<%=direccion%>">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="telefono">Teléfono</label>  
                        <div class="col-md-5">
                            <input id="telefono" name="telefono" type="text" placeholder="" class="form-control input-sm" value="<%=telefono%>">

                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cargo">Cargo</label>
                        <div class="col-md-5">
                            <select id="cargo" name="cargo" class="form-control input-sm">

                            </select>
                        </div>
                    </div>

                    <div class="btn-group col-lg-offset-4 col-lg-4">
                        <!--<button type="button" class="btn btn-default" name="btnnuevo" id="btnnuevo">Nuevo</button>-->
                        <input type="submit" class="btn btn-default" name="accion" value="Guardar" id="btnguardar" />
                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#ModalBuscar" name="btnbuscar" id="btnbuscar">Consultar</button>
                        <input type="submit" class="btn btn-default" name="accion" value="Modificar" id="btnmodificar" /> 
                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#ModalEliminar" name="btneliminar" id="btneliminar" >Eliminar</button> 

                    </div>

                </fieldset>
            </form>

            <!-- Modal Buscar-->
            <form class="form-horizontal" action="ServletEmpleado" method="POST" >
                <div class="modal fade" id="ModalBuscar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">Buscar Empleado</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="buscar">Número de Identificación</label>  
                                    <div class="col-md-4">
                                        <input id="buscar_emp" name="buscar_emp" placeholder="" class="form-control input-md"  type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                <input type="submit" value="Consultar" class="btn btn-primary" name="accion" id="btnbuscarb">
                            </div>
                        </div>
                    </div>
                </div>
            </form>


            <!-- Modal Eliminar-->
            <form class="form-horizontal" action="ServletEmpleado" method="POST" >
                <div class="modal fade" id="ModalEliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">Eliminar Empleado</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="buscar">Número de Identificación</label>  
                                    <div class="col-md-4">
                                        <input id="eliminar_emp" name="eliminar_emp" placeholder="" class="form-control input-md"  type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                <input type="submit" value="Eliminar" class="btn btn-primary" name="accion" id="btnbuscare">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            
            
        </div>
    </body>
</html>
