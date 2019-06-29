<%-- 
    Document   : EditarCliente
    Created on : 28/06/2019, 03:37:29 PM
    Author     : Propietario
--%>

<%@page import="Modelo.cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
         <% cliente cliente = (cliente) request.getAttribute("EditarCliente");%>
        
        <h1>Actualizar  Cliente<%= cliente.getId_Cliente()%></h1>
        <form action="Cliente?a=update&id=<%= cliente.getId_Cliente()%>"  method="post" >
            
                    <p>Nombre:</p>
                    <input name="txtNombre" class="field" type="text" id="Nombre" value="<%= cliente.getNombre()%>"/><br/>

                    <p>Apellido:</p>
                    <input name="txtApellido" class="field" type="text" id="Apellido" value="<%= cliente.getApellido()%>"/><br/>

                    <p>Telefono:</p>
                    <input name="txtTelefono" class="field" type="text" id="Telefono" value="<%= cliente.getTelefono()%>"/><br/>
                    
                    <p>Direccion:</p>
                    <input name="txtDireccion" class="field" type="text" id="Direccion" value="<%= cliente.getDireccion()%>"/><br/>
                    
                    <p>Sexo:</p>
                    <input name="txtSexo" class="field" type="text" id="Sexo" value="<%= cliente.getSexo()%>"/><br/>

                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>
