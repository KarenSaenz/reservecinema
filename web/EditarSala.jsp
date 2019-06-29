<%-- 
    Document   : EditarSala
    Created on : 28/06/2019, 03:39:04 PM
    Author     : Propietario
--%>

<%@page import="Modelo.sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
         <% sala sala = (sala) request.getAttribute("EditarSala");%>
        
        <h1>Actualizar Sala <%= sala.getId_Sala()%></h1>
        <form action="Sala?a=update&id=<%= sala.getId_Sala()%>"  method="post" >
            
                    <p>Capacidad:</p>
                    <input name="txtCapacidad" class="field" type="text" id="Capacidad" value="<%= sala.getCapacidad()%>"/><br/>

                    <p>Teatro:</p>
                    <input name="txtTeatro" class="field" type="text" id="Teatro" value="<%= sala.getTeatro_Id_Teatro()%>"/><br/>

                   

                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>