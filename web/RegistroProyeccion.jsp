<%-- 
    Document   : RegistroProyeccion
    Created on : 28/06/2019, 06:09:00 PM
    Author     : Propietario
--%>

<%@page import="Modelo.sala"%>
<%@page import="Modelo.pelicula"%>
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
       
            
        <h1>Registrar Proyeccion</h1><br>
            <form action="proyeccion?a=create" method="post" name="formProyeccion">

                    Fecha:
                    <input name="txtFecha" type="text" id="Fecha"/><br/>
                    
                    Pelicula:
             <select name="txtPeelicula" id="Pelicula">
                
                    <% ArrayList<pelicula>Pelicula=(ArrayList)request.getAttribute("Pelicula");%>
                    <%for(pelicula pelicula : Pelicula){%>
                    <option value="<%=pelicula.getId_Pelicula() %>"><%=pelicula.getId_Pelicula()%></option>
                    <% } %>
             </select><br/>  
       

                    Sala:
             <select name="txtSala" id="Sala">
                
                    <% ArrayList<sala>Sala=(ArrayList)request.getAttribute("Sala");%>
                    <%for(sala sala : Sala){%>
                    <option value="<%=sala.getId_Sala() %>"><%=sala.getId_Sala()%></option>
                    <% } %>
            </select><br/>
            
           
            
            <input type="submit"  id="enviar" value="Registrar"/>
            </form>
    </body>
</html>
