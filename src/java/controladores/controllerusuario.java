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
import modelo.usuario;
import org.hibernate.Session;

/**
 *
 * @author Lizeth Nuñez
 */
public class controllerusuario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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
            String nombre=request.getParameter("txtNombre");
            String apellido=request.getParameter("txtApellido");
            String contrasena=request.getParameter("txtContrasena");
            String perfil=request.getParameter("txtPerfil");
            
            usuario us= new usuario();
            us.setNombre(nombre);
            us.setApellido(apellido);
            us.setContrasena(contrasena);
            us.setPerfil(perfil);
            
            org.hibernate.Session sesion=HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(us);
            sesion.getTransaction().commit();
            sesion.close();
            admin(request, response);
            }else{
            try{
               request.getRequestDispatcher("RegistrarUsuario.jsp").include(request, response);
               }catch(ServletException| IOException ex){
                   System.out.println("Error en registrar" +ex.getMessage());
               }
        }
    }
    private void update(HttpServletRequest request, HttpServletResponse response){
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        int id= Integer.parseInt(request.getParameter("id"));
        usuario us= (usuario) sesion.get(usuario.class, id);
        if(request.getMethod().equalsIgnoreCase("POST")){
            us.setNombre(request.getParameter("txtNombre"));
            us.setApellido(request.getParameter("txtApellido"));
            us.setContrasena(request.getParameter("txtContrasena"));
            us.setPerfil(request.getParameter("txtPerfil"));
            sesion.beginTransaction();
            sesion.saveOrUpdate(us);
            sesion.getTransaction().commit();
            sesion.close();
            admin(request, response);
        }else{
            request.setAttribute("editarempresa:v", us);
            try{
                request.getRequestDispatcher("EditarUsuario.jsp");
            }catch(ServletException|IOException ex){
                System.out.println("Error al actualizar "+ex.getMessage());
            }
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response){
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        int id= Integer.parseInt(request.getParameter("id"));
        usuario us=(usuario) sesion.get(usuario.class, id);
        sesion.beginTransaction();
        sesion.delete(us);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }
    private void admin(HttpServletRequest request, HttpServletResponse response){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        ArrayList  datos= (ArrayList) sesion.createQuery("FROM Usuario").list();
        ArrayList <usuario> lista=new ArrayList();
        for(Object obj:datos){
            lista.add((usuario)obj);            
        } request.setAttribute("usuario",lista);
        try{
            request.getRequestDispatcher("ListaUsuario.jsp").forward(request, response);
                }catch(ServletException |IOException ex){
                System.out.println("Error en admin Usuario"+ex.getMessage());
            
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