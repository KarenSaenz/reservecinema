<%-- 
    Document   : EditarPelicula
    Created on : 28/06/2019, 03:38:32 PM
    Author     : Propietario
--%>

<%@page import="Modelo.pelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
         <% pelicula pelicula = (pelicula) request.getAttribute("EditarPelicula");%>
        
        <h1>Actualizar  Pelicula<%= pelicula.getId_Pelicula()%></h1>
        <form action="Pelicula?a=update&id=<%= pelicula.getId_Pelicula()%>"  method="post" >
            
                    <p>Nombre:</p>
                    <input name="txtNombre" class="field" type="text" id="Nombre" value="<%= pelicula.getNombre()%>"/><br/>

                    <p>Duracion:</p>
                    <input name="txtDuracion" class="field" type="time" id="Duracion" value="<%= pelicula.getDuracion()%>"/><br/>

                    <p>Hora:</p>
                    <input name="txtHora" class="field" type="time" id="Hora" value="<%= pelicula.getHora()%>"/><br/>
                    
                    <p>Genero:</p>
                    <input name="txtGenero" class="field" type="text" id="Usuario" value="<%= pelicula.getGenero_Id_Genero()%>"/><br/>
                    
                    <p>Costo:</p>
                    <input name="txtCosto" class="field" type="text" id="Costo" value="<%= pelicula.getCosto()%>"/><br/>

                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>
