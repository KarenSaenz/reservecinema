<%-- 
    Document   : EditarTeatro
    Created on : 28/06/2019, 03:39:18 PM
    Author     : Propietario
--%>

<%@page import="Modelo.teatro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
         <% teatro teatro = (teatro) request.getAttribute("EditarTeatro");%>
        
        <h1>Actualizar  teatro<%= teatro.getId_Teatro()%></h1>
        <form action="teatro?a=update&id=<%= teatro.getId_Teatro()%>"  method="post" >
            
                    <p>Nombre:</p>
                    <input name="txtNombre" class="field" type="text" id="Nombre" value="<%= teatro.getNombre()%>"/><br/>

                    <p>Direccion:</p>
                    <input name="txtDireccion" class="field" type="text" id="Direccion" value="<%= teatro.getDireccion()%>"/><br/>

                    <p>Ciudad:</p>
                    <input name="txtCiudad" class="field" type="text" id="Ciudad" value="<%= teatro.getCiudad()%>"/><br/>
                    
                    <p>Telefono:</p>
                    <input name="txtTelefono" class="field" type="text" id="Telefono" value="<%= teatro.getTelefono()%>"/><br/>
                    
                    <p>Correo:</p>
                    <input name="txtCorreo" class="field" type="text" id="Correo" value="<%= teatro.getId_Teatro()%>"/><br/>

                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>