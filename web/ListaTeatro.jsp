<%-- 
    Document   : ListaTeatro
    Created on : 28/06/2019, 05:54:41 PM
    Author     : aleja9920
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.teatro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center><table  border = "1" cellspacing = "9" bgcolor ="lightblue">
                    <caption><h1>Lista Teatro</h1></caption>
                    <tr>
                        <th>Nombre</th>
                        <th>Direccion</th>
                        <th>Ciudad</th>
                        <th>Telefono</th>
                        <th>Correo</th>
                    </tr>
                    
                    <%
             ArrayList<teatro> teatros = (ArrayList) request.getAttribute("teatro");
            %>
            
            <% for(teatro tea : teatros){ %>
            <tr>
                <td> <%= tea.getNombre()%></td>
                <td> <%= tea.getDireccion()%></td>
                <td> <%= tea.getCiudad()%></td> 
                <td> <%= tea.getTelefono() %></td> 
                <td> <%= tea.getCorreo()%></td> 
                
            <a href="ingreso?a=update&id=<%=tea.getId_Teatro()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=tea.getId_Teatro()%>"> 
                              
                </td>
            
        </table></center>
    </body>
</html>
