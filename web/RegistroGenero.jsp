<%-- 
    Document   : RegistroGenero
    Created on : 28/06/2019, 06:07:34 PM
    Author     : Propietario
--%>
<%@page import="Modelo.genero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
        <body>
          
               
            <h1>Registrar Genero</h1><br>       
        <form action="Genero?a=create"  method="post">
                    Nombre:
                    <input name="txtNombre" type="text" id="Nombre"/><br/>   
                   
                    
                    
                <input type="submit"  id="enviar" value="Registrar"/>
        </form>
    </body>
</html>
