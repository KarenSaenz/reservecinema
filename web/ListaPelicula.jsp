<%-- 
    Document   : ListaPelicula
    Created on : 28/06/2019, 04:56:41 PM}
    Author     : aleja9920
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.pelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <center><table border="1" cellspacing="9" bgcolor="lightblue">
                    <caption><h1>Lista Pelicula</h1></caption>
                    <tr>
                        <th>Nombre</th>
                        <th>Duraci&oacute;n</th>
                        <th>Hora</th>
                        <th>Costo</th>
                        <th>Genero</th>
                    </tr>
                    
                    <%
                 ArrayList<pelicula> peliculas = (ArrayList) request.getAttribute("pelicula");
                        %>
                 <% for(pelicula pel: peliculas) {%>   
                 
                 <tr>
                <td> <%= pel.getNombre()%></td>
                <td> <%= pel.getDuracion()%></td>
                <td> <%= pel.getHora()%></td> 
                <td> <%= pel.getCosto()%></td> 
                <td> <%= pel.getGenero_Id_Genero()%></td> 
                
            <a href="ingreso?a=update&id=<%=pel.getId_Pelicula()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=pel.getId_Pelicula()%>"> 
                              
                </td>
        
        </table></center>
        
    </body>
</html>
