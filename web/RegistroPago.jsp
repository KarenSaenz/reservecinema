<%-- 
    Document   : RegistroPago
    Created on : 28/06/2019, 06:07:56 PM
    Author     : Propietario
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.pago"%>
<%@page import="Modelo.boleta"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
        <body>
          
               
            <h1>Registrar pago</h1><br>       
        <form action="pago?a=create"  method="post">
                    Total:
                    <input name="txtTotal"  type="text" id="Total"/><br/>
                    
                    Boleta:
                    <select name="txtCliente" id="Cliente">
                
                    <% ArrayList<boleta>Boleta=(ArrayList)request.getAttribute("Boleta");%>
                    <%for(boleta boleta : Boleta){%>
                    <option value="<%=boleta.getId_Boleta() %>"><%=boleta.getId_Boleta()%></option>
                    <% } %>
                    </select><br/>
                    
                    
                    
                    
                    <input type="submit"  id="enviar" value="Registrar"/>
        </form>
    </body>
</html>
