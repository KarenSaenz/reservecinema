/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.HibernateUtil;
import modelo.cliente;
import org.hibernate.Session;


/**
 *
 * @author Lizeth Nuñez
 */
public class controllercliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action= request.getParameter("a");
        switch (action){
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "admin":
                admin(request, response);
                break;
        }
    }
private void create(HttpServletRequest request, HttpServletResponse response){
    if(request.getMethod().equalsIgnoreCase("POST")){
        String id=request.getParameter("txtIdusuario");
        String nombre=request.getParameter("txtNombre");
        String apellido=request.getParameter("txtApellido");
        String telefono=request.getParameter("txtApellido");
        String direccion=request.getParameter("txtApellido");
        String sexo=request.getParameter("txtApellido");
        
        cliente cli=new cliente();
        cli.setId_Cliente(Integer.parseInt(id));
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setTelefono(telefono);
        cli.setDireccion(direccion);
        cli.setSexo(sexo.charAt(0));
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.save(cli);
        admin(request, response);
    }else{
            try{
            request.getRequestDispatcher("RegistrarCliente.jsp").include(request, response);
                }catch(ServletException |IOException ex){
                System.out.println("Error en Registrar"+ex.getMessage());
            
                }
}
}
private void update(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    int id=Integer.parseInt(request.getParameter("id"));
    cliente cli= (cliente) sesion.get(cliente.class, id);
    if(request.getMethod().equalsIgnoreCase("POST")){
        int idUsuario=Integer.parseInt(request.getParameter("idusuario"));
        cli.setId_Cliente(idUsuario);
        cli.setNombre(request.getParameter("txtNombre"));
        cli.setApellido(request.getParameter("txtApellido"));
        cli.setTelefono(request.getParameter("txtTelefono"));
        cli.setDireccion(request.getParameter("txtDireccion"));
        String sexo=request.getParameter("txtSexo");
        cli.setSexo(sexo.charAt(0));
        sesion.beginTransaction();
        sesion.getTransaction().commit();
        sesion.saveOrUpdate(cli);
        sesion.close();
        admin(request, response);
    }else{
        request.setAttribute("EditarCliente", cli);
        try{
            request.getRequestDispatcher("EditarCliente.jsp").forward(request,response);
        }catch(ServletException|IOException ex){
            System.out.println("Error en actualizar "+ex.getMessage());
        }
    }
}
private void delete(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
        int id=Integer.parseInt(request.getParameter("id"));
        cliente cli=(cliente) sesion.get(cliente.class, id);
        sesion.beginTransaction();
        sesion.delete(cli);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
}
private void admin(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
        ArrayList datos=(ArrayList)sesion.createQuery("FROM cliente").list();
        ArrayList <cliente> lista=new ArrayList();
        for(Object obj: datos){
            lista.add((cliente)obj);
        }request.setAttribute("cliente", lista);
        try{
            request.getRequestDispatcher("ListaCliente.jsp").forward(request, response);
        }catch(ServletException| IOException ex){
            System.out.println("Error en admin cliente" +ex.getMessage());
        }
}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}