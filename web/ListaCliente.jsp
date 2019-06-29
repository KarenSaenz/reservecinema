<%-- 
    Document   : ListaCliente
    Created on : 28/06/2019, 04:04:25 PM
    Author     : aleja9920
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <center><table border = "1" cellspacing = "9" bgcolor ="lightblue">
                    <caption><h1>Lista Cliente</h1></caption>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Telefono</th>
                        <th>Dirreci&oacute;n</th>
                        <th>Sexo</th>
                    </tr>
                    <%
                    ArrayList<cliente> clientes = (ArrayList) request.getAttribute("cliente");
            %>
            
            <% for(cliente clie : clientes){ %>
            
            <tr>
                <td> <%= clie.getNombre()%></td>
                <td> <%= clie.getApellido()%></td> 
                <td> <%= clie.getTelefono()%></td> 
                <td> <%= clie.getDireccion()%></td>
                <td> <%= clie.getSexo()%></td>
                
            <a href="ingreso?a=update&id=<%=clie.getId_Cliente()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=clie.getId_Cliente()%>"> 
                              
                </td>
        </table></center>
    </body>
</html>
