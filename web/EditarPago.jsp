<%-- 
    Document   : EditarPago
    Created on : 28/06/2019, 03:38:15 PM
    Author     : Propietario
--%>

<%@page import="Modelo.pago"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
         <% pago pago = (pago) request.getAttribute("EditarPago");%>
        
        <h1>Actualizar  Pago<%= pago.getId_Pago()%></h1>
        <form action="Pago?a=update&id=<%= pago.getId_Pago()%>"  method="post" >
            
                    <p>Boleta:</p>
                    <input name="txtBoleta" class="field" type="text" id="Boleta" value="<%= pago.getBoleta_Id_Boleta()%>"/><br/>

                    <p>Total:</p>
                    <input name="txtTotal" class="field" type="text" id="Total" value="<%= pago.getTotal()%>"/><br/>

                   
                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>