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
import modelo.teatro;
import org.hibernate.Session;

/**
 *
 * @author Lizeth Nuñez
 */
public class controllerteatro extends HttpServlet {

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
        String nombre=request.getParameter("txtNombre");
        String direccion=request.getParameter("txtNombre");
        String ciudad=request.getParameter("txtNombre");
        String telefono=request.getParameter("txtNombre");
        String correo=request.getParameter("txtNombre");
        teatro teat=new teatro();
        teat.setNombre(nombre);
        teat.setDireccion(direccion);
        teat.setCiudad(ciudad);
        teat.setTelefono(telefono);
        teat.setCorreo(correo);
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.save(teat);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }else{
        try{
            request.getRequestDispatcher("RegistrarTeatro.jsp").include(request, response);
        }catch(ServletException|IOException ex){
            System.out.println("Error en registrar teatro "+ex.getMessage());
        }
    }
}
private void update(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
   int id=Integer.parseInt(request.getParameter("id"));
   teatro teat=(teatro) sesion.get(teatro.class,id);
            if(request.getMethod().equalsIgnoreCase("POST")){
                               
                teat.setNombre(request.getParameter("txtNombre"));
                teat.setDireccion(request.getParameter("txtDireccion"));
                teat.setCiudad(request.getParameter("txtCiudad"));
                teat.setTelefono(request.getParameter("txtTelefono"));
                teat.setCorreo(request.getParameter("txtCorreo"));
                
                sesion.beginTransaction();
                sesion.saveOrUpdate(teat);
                sesion.getTransaction().commit();
                sesion.close();
                admin(request,response);
            }else{
                 request.setAttribute("editarteatro", teat);
            try{
            request.getRequestDispatcher("EditarTeatro.jsp").forward(request, response);
            
                }catch(ServletException |IOException ex){
                System.out.println("Error al actualizar teatro"+ex.getMessage());
            
                }
            }
}
private void delete(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
        int id=Integer.parseInt(request.getParameter("id"));
        teatro teat=(teatro) sesion.get(teatro.class,id);
        sesion.beginTransaction();
        sesion.delete(teat);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request,response);
}
private void admin(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
        ArrayList datos=(ArrayList) sesion.createQuery("FROM teatro").list();
        ArrayList<teatro> lista=new ArrayList();
        for(Object obj:datos){
            lista.add((teatro)obj);
      }
         request.setAttribute("listateatro",lista);
         try{
            request.getRequestDispatcher("ListaTeatro.jsp").forward(request, response);
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
