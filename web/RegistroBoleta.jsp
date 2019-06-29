<%-- 
    Document   : RegistroBoleta
    Created on : 28/06/2019, 06:06:30 PM
    Author     : Propietario
--%>

<%@page import="Modelo.boleta"%>
<%@page import="Modelo.cliente"%>
<%@page import="Modelo.usuario"%>
<%@page import="Modelo.proyeccion"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
       
            
        <h1>Registrar Boleta</h1><br> 
            <form action="boleta?a=create" method="post" name="formboleta">

                    NSillas:
                    <input name="txtNSillas" type="text" id="NSilllas"/><br/>
        
                    Valor Unitario:
                    <input name="txtValorUnitario"  type="text" id="ValorUnitario"/><br />


            Cliente:
            <select name="txtCliente" id="Cliente">
                
                <% ArrayList<cliente>Cliente=(ArrayList)request.getAttribute("Cliente");%>
                <%for(cliente cliente : Cliente){%>
                <option value="<%=cliente.getId_Cliente() %>"><%=cliente.getId_Cliente()%></option>
                <% } %>
            </select><br/>
            
            Usuario:
            <select name="txtUsuario"  id="Usuario">
                
                <% ArrayList<usuario>Usuario=(ArrayList)request.getAttribute("usuario");%>
                <%for(usuario usuario : Usuario){%>
                <option value="<%= usuario.getId_Usuario()%>"><%= usuario.getId_Usuario()%></option>
                <% } %>
                
                 Proyeccion:
            <select name="txtProyeccion"  id="Usuario">
                
                <% ArrayList<proyeccion>Proyeccion=(ArrayList)request.getAttribute("proyeccion");%>
                <%for(proyeccion proyeccion : Proyeccion){%>
                <option value="<%= proyeccion.getId_Proyeccion()%>"><%= proyeccion.getId_Proyeccion() %></option>
                <% } %>
                
            </select><br/><br/>
          <input type="submit"  id="enviar" value="Registrar"/>
          
            </form>
    </body>
</html>
