<%-- 
    Document   : ListaProyeccion
    Created on : 28/06/2019, 05:15:11 PM
    Author     : aleja9920
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.proyeccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <center><table border="1" cellspacing="9" bgcolor="lightblue">
                    <caption><h1>Lista Proyeccion</h1></caption>
                    <tr>
                        <th>Fecha</th>
                        <th>Sala</th>
                        <th>Pelicula</th>
                        
                    </tr>
                    
                    <%
                 ArrayList<proyeccion> proyeccion = (ArrayList) request.getAttribute("pelicula");
                        %>
                 <% for(proyeccion pel: proyeccion) {%>   
              
                 <tr>
                <td> <%= pel.getFecha()%></td>
                <td> <%= pel.getSala_Id_Sala()%></td>
                <td> <%= pel.getPelicula_Id_Pelicula()%></td> 
                
                
            <a href="ingreso?a=update&id=<%=pel.getId_Proyeccion()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=pel.getId_Proyeccion()%>"> 
                              
                </td>
        
        </table></center>
    </body>
</html>
