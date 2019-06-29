<%-- 
    Document   : EditarProyeccion
    Created on : 28/06/2019, 03:38:50 PM
    Author     : Propietario
--%>

<%@page import="Modelo.proyeccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <% proyeccion proyeccion = (proyeccion) request.getAttribute("EditarProyeccion");%>
        
       <h1>Actualizar  Proyeccion<%= proyeccion.getId_Proyeccion()%></h1>
        <form action="Proyeccion?a=update&id=<%= proyeccion.getId_Proyeccion()%>"  method="post" >
            
                    <p>Fecha:</p>
                    <input name="txtFecha" class="field" type="text" id="Fecha" value="<%= proyeccion.getFecha()%>"/><br/>

                    <p>Pelicula:</p>
                    <input name="txtPelicula" class="field" type="time" id="Pelicula" value="<%= proyeccion.getPelicula_Id_Pelicula()%>"/><br/>

                    <p>Sala:</p>
                    <input name="txtSala" class="field" type="time" id="Sala" value="<%= proyeccion.getSala_Id_Sala()%>"/><br/>
                    
                   

                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>
