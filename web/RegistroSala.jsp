<%-- 
    Document   : RegistroSala
    Created on : 28/06/2019, 06:09:22 PM
    Author     : Propietario
--%>
<%@page import="Modelo.teatro"%>
<%@page import="Modelo.sala"%>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
       
            
        <h1>Registrar Sala</h1><br>
            <form action="sala?a=create" method="post" name="formSala">

                    Capacidad:
                    <input name="txtCapacidad" type="text" id="Capacidad"/><br/>

                    Teatro:
            <select name="txtTeatro" id="Teatro">
                
                    <% ArrayList<teatro>Teatro=(ArrayList)request.getAttribute("Teatro");%>
                    <%for(teatro teatro : Teatro){%>
                    <option value="<%=teatro.getId_Teatro() %>"><%=teatro.getId_Teatro()%></option>
                    <% } %>
            </select><br/>
            

           <input type="submit"  id="enviar" value="Registrar"/>
           
            </form>
    </body>s
</html>
