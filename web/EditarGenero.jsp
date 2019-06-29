<%-- 
    Document   : EditarGenero
    Created on : 28/06/2019, 03:38:01 PM
    Author     : Propietario
--%>

<%@page import="Modelo.genero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
         <% genero genero = (genero) request.getAttribute("EditarGenero");%>
        
        <h1>Actualizar  Genero<%= genero.getId_Genero()%></h1>
        <form action="Genero?a=update&id=<%= genero.getId_Genero()%>"  method="post" >
            
                    <p>Nombre:</p>
                    <input name="txtNombre" class="field" type="text" id="Nombre" value="<%= genero.getNombre()%>"/><br/>

                    
                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>