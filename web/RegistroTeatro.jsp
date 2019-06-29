<%-- 
    Document   : RegistroTeatro
    Created on : 28/06/2019, 06:10:13 PM
    Author     : Propietario
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
       
            
            <h1>Registrar Teatro</h1>
            <form action="teatro?a=create" method="post" name="formTeatro">

                    Nombre:
                    <input name="txtNombre" type="text" id="Nombre"/><br/>
                    
                    Direccion:
                    <input name="txtDireccion" type="text" id="Direccion"/><br/>
                    
                    Ciudad
                    <input name="txtCiudad" type="text" id="Ciudad"/><br/>
                    
                    Telefono:
                    <input name="txtTelefono" type="text" id="Telefono"/><br/>
                    
                    Correo:
                    <input name="txtCorreo" type="text" id="Correo"/><br/>
                 </select><br/><br/>
           
            
                 <input type="submit"  id="enviar" value="Registrar"/>
                 
            </form> 
    </body>
</html>
