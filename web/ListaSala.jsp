<%-- 
    Document   : ListaSala
    Created on : 28/06/2019, 05:50:01 PM
    Author     : aleja9920
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center><table  border = "1" cellspacing = "9" bgcolor ="lightblue">
                    <caption><h1>Lista Sala</h1></caption>
                    <tr>
                        <th>Capacidad</th>
                        <th>Teatro</th>
                        
                    </tr>
                    
                    <%
             ArrayList<sala> salas = (ArrayList) request.getAttribute("sala");
            %>
            
            <% for(sala sal : salas){ %>
            <tr>
                <td> <%= sal.getCapacidad()%></td>
                <td> <%= sal.getTeatro_Id_Teatro()%></td>
               
                
            <a href="ingreso?a=update&id=<%=sal.getId_Sala()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=sal.getId_Sala()%>"> 
                              
                </td>
            
        </table></center>
    </body>
</html>
