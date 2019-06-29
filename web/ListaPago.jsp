<%-- 
    Document   : ListaPago
    Created on : 28/06/2019, 04:49:44 PM
    Author     : aleja9920
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.pago"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <center><table border = "1" cellspacing = "9" bgcolor ="lightblue">
                    <caption><h1>Lista Pago</h1></caption>
                    
                    <tr>
                        <th>Total</th>
                        <th>Boleta</th>
                    </tr>
                    <%
                     ArrayList<pago> pagos = (ArrayList) request.getAttribute("pago");
            %>
            
            <% for(pago pag : pagos){ %>
            <tr>
                <td> <%= pag.getTotal()%></td>
                <td> <%= pag.getBoleta_Id_Boleta()%></td>
                
                
            <a href="ingreso?a=update&id=<%=pag.getId_Pago()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=pag.getId_Pago()%>"> 
                              
                </td>
        
        </table></center>
    </body>
</html>
