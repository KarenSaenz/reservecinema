<%@page import="java.util.ArrayList"%>
<%@page import="modelo.boleta"%>
<%@include file="header.jsp" %>
<%@include file="menu.jsp" %>
<div class="dashboard-ecommerce">
                <div class="container-fluid dashboard-content ">
                    
            <center><table  border = "1" cellspacing = "9" bgcolor ="lightblue">
                    <caption><h1>Lista Boleta</h1></caption>
                    <tr>
                        <th>Numero Sillas</th>
                        <th>Valor Unitario </th>
                        <th>Cliente</th>
                        <th>Usuario</th>
                        <th>Proyeccion</th>
                    </tr>
                    
                    <%
             ArrayList<boleta> boletas = (ArrayList) request.getAttribute("boleta");
            %>
            
            <% for(boleta bol : boletas){ %>
            <tr>
                <td> <%= bol.getNsillas()%></td>
                <td> <%= bol.getValor_Unitario()%></td>
                <td> <%= bol.getCliente_Id_Cliente().getNombre() %></td> 
                <td> <%= bol.getUsuario_Id_Usuario().getNombre() %></td> 
                <td> <%= bol.getProyeccion_Id_Proyeccion()%></td> 
                
            <a href="ingreso?a=update&id=<%=bol.getId_Boleta()%>"></a>
            </tr>
            <td>
                    <a href="ingreso?a=delete&id=<%=bol.getId_Boleta()%>"> 
                              
                </td>
            
        </table></center>
                    </div>
            </div>
<%@include file="footer.jsp" %>