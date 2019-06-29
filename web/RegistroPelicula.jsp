<%-- 
    Document   : RegistroPelicula
    Created on : 28/06/2019, 06:08:29 PM
    Author     : Propietario
--%>


<%@page import="Modelo.genero"%>
<%@page import="Modelo.pelicula"%>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
       
            
        <h1>Registrar Pelicula</h1><br>
            <form action=pelicula?a=create" method="post" name="formPelicula">

                   Nombre:
                   <input name="txtNombre" type="text" id="Nombre"/><br/>
                    
                   Duracion:
                   <input name="txtDuracion" type="text" id="Duracion"/><br/>
                    
                   Hora:
                   <input name="txtHora"  type="text" id="Hora"/><br/>
                    
                   Costo:
                   <input name="txtCosto" type="text" id="Costo"/><br/>
        


                   Genero:
                   <select name="txtGenero" id="Genero">
                
                   <% ArrayList<genero>Genero=(ArrayList)request.getAttribute("Genero");%>
                   <%for(genero genero : Genero){%>
                   <option value="<%=genero.getId_Genero() %>"><%=genero.getId_Genero()%></option>
                   <% } %>
                   </select><br/>
            
           
           
            <input type="submit"  id="enviar" value="Registrar"/>
            
            </form>
    </body>
</html>
