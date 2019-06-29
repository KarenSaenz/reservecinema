<%-- 
    Document   : EditarUsuario
    Created on : 28/06/2019, 03:39:38 PM
    Author     : Propietario
--%>

<%@page import="Modelo.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
         <% usuario usuario = (usuario) request.getAttribute("EditarUsuario");%>
        
        <h1>Actualizar  Usuario<%= usuario.getId_Usuario()%></h1>
        <form action="Usuario?a=update&id=<%= usuario.getId_Usuario()%>"  method="post" >
            
                    <p>Nombre:</p>
                    <input name="txtNombre" class="field" type="text" id="Nombre" value="<%= usuario.getNombre()%>"/><br/>

                    <p>Apellido:</p>
                    <input name="txtApellido" class="field" type="text" id="Apellido" value="<%= usuario.getApellido()%>"/><br/>

                    <p>Contrasena:</p>
                    <input name="txtContrasena" class="field" type="text" id="contrasena" value="<%= usuario.getId_Usuario()%>"/><br/>
                    
                    <p>Perfil:</p>
                    <input name="txtPerfil" class="field" type="text" id="Perfil" value="<%= usuario.getId_Usuario()%>"/><br/>
                    
                    

                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>