<%-- 
    Document   : ListaUsuario
    Created on : 28/06/2019, 06:00:53 PM
    Author     : aleja9920
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center><table  border = "1" cellspacing = "9" bgcolor ="lightblue">
                    <caption><h1>Lista Usuario</h1></caption>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Contraseña</th>
                        <th>Perfil</th>
                    </tr>
                    
                    <%
             ArrayList<usuario> usuarios = (ArrayList) request.getAttribute("usuario");
            %>
            
            <% for(usuario usu : usuarios){ %>
            <tr>
                <td> <%= usu.getNombre()%></td>
                <td> <%= usu.getApellido()%></td>
                <td> <%= usu.getContrasena()%></td> 
                <td> <%= usu.getPerfil()%></td> 
                
                
            <a href="ingreso?a=update&id=<%=usu.getId_Usuario()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=usu.getId_Usuario()%>"> 
                              
                </td>
            
        </table></center>
    </body>
</html>
