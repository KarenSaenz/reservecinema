<%-- 
    Document   : RegistroCliente
    Created on : 28/06/2019, 06:07:08 PM
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
          
               
            <h1>Registrar Cliente</h1><br>    
        <form action="Cliente?a=create"  method="post">
                    Nombre:
                    <input name="txtNombre"  type="text" id="Nombre"/><br/>
                    
                    Apellido:
                    <input name="txtApellido"  type="text" id="Apellido"/><br>
                    
                    Telefono:
                    <input name="txtTelefono" type="text" id="Telefono"/><br>
                    
                     Direccion:
                    <input name="txtDireccion"  type="text" id="Direccion"/><br>
                    
                     Sexo:
                    <input name="txtSexo" type="text" id="Sexo"/><br>
                    
                    
                    <input type="submit"  id="enviar" value="Registrar"/>
     
        </form>
    </body>
</html>
