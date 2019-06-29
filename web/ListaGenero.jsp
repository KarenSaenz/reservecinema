<%-- 
    Document   : ListaGenero
    Created on : 28/06/2019, 04:38:36 PM
    Author     : aleja9920
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.genero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <center><table border = "1" cellspacing = "9" bgcolor ="lightblue">
                    <caption><h1>Lista Genero</h1></caption>
                    
                    <tr>
                        <th>Nombre</th>
                    </tr>
                    
                    <%
             ArrayList<genero> generos = (ArrayList) request.getAttribute("genero");
            %>
            
            <% for(genero gen : generos){ %>
             <tr>
                <td> <%= gen.getNombre()%></td>
                 
                
            <a href="ingreso?a=update&id=<%=gen.getId_Genero()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=gen.getId_Genero()%>"> 
                              
                </td>
        
        </table></center>
    </body>
</html>
