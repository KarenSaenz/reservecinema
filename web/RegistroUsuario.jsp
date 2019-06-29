<%-- 
    Document   : RegistroUsuario
    Created on : 28/06/2019, 06:10:39 PM
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
       
            
            <h1>Registrar Usuario</h1>
            <form action="usuario?a=create" method="post" name="formUsuario">

                    Nombre:
                    <input name="txtNombre"  type="text" id="Nombre"/><br/>
                    
                    Apellido:
                    <input name="txtApellido"  type="text" id="Apellido"/><br/>
                    
                    Contrasena:
                    <input name="txtContrasena"  type="text" id="Contrasena"/><br/>
                    
                    Perfil:
                    <input name="txtPerfil"  type="text" id="Perfil"/><br/>
                    </select><br/><br/>
                   
           
           
            <input type="submit"  id="enviar" value="Registrar"/>
            
            </form>   
    </body>
</html>