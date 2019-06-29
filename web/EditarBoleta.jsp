<%-- 
    Document   : EditarBoleta
    Created on : 28/06/2019, 03:36:58 PM
    Author     : Propietario
--%>
<%@page import="Modelo.boleta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
         <% boleta boleta = (boleta) request.getAttribute("EditarBoleta");%>
        
        <h1>Actualizar  Boleta <%= boleta.getId_Boleta()%></h1>
        <form action="Boleta?a=update&id=<%= boleta.getId_Boleta()%>"  method="post" >
            
                    <p>Nsillas:</p>
                    <input name="txtNsillas" class="field" type="text" id="Nsillas" value="<%= boleta.getNsillas()%>"/><br/>

                    <p>Valor Unitario:</p>
                    <input name="txtValorUnitario" class="field" type="text" id="ValorUnitario" value="<%= boleta.getValor_Unitario()%>"/><br/>

                    <p>Cliente:</p>
                    <input name="txtCliente" class="field" type="text" id="Cliente" value="<%= boleta.getCliente_Id_Cliente()%>"/><br/>
                    
                    <p>Usuario:</p>
                    <input name="txtUsuario" class="field" type="text" id="Usuario" value="<%= boleta.getUsuario_Id_Usuario()%>"/><br/>
                    
                    <p>Proyeccion:</p>
                    <input name="txtProyeccion" class="field" type="text" id="Proyeccion" value="<%= boleta.getProyeccion_Id_Proyeccion()%>"/><br/>

                    <p><button  type="submit" onclick="Registra();">Guardar</button></p><br>    
        </form>
    </body>
</html>