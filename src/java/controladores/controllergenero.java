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
import modelo.genero;
import org.hibernate.Session;

/**
 *
 * @author Lizeth Nuñez
 */
public class controllergenero extends HttpServlet {

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
private  void create(HttpServletRequest request, HttpServletResponse response){
    if(request.getMethod().equalsIgnoreCase("POST")){
        String nombre=request.getParameter("txtNombre");
        genero gen=new genero();
        gen.setNombre(nombre);
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        sesion.save(gen);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }else{
        try{
            request.getRequestDispatcher("RegistrarGenero.jsp").include(request, response);
        }catch(ServletException|IOException ex){
            System.out.println("Error en registrar "+ex.getMessage());
        }
    }
}
private void update(HttpServletRequest request, HttpServletResponse response){
    Session sesion= HibernateUtil.getSessionFactory().openSession();
    int id=Integer.parseInt(request.getParameter("id"));
    genero gen=(genero) sesion.get(genero.class, id);
    if(request.getMethod().equalsIgnoreCase("POST")){
        gen.setNombre(request.getParameter("txtNombre"));
        sesion.beginTransaction();
        sesion.saveOrUpdate(gen);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request,response);
    }else{
        request.setAttribute("Editargenero", gen);
        try{
            request.getRequestDispatcher("EditarGenero.jsp").forward(request, response);
        }catch(ServletException|IOException ex){
            System.out.println("Error en actualizar "+ex.getMessage());
        }
    }
}
private void delete(HttpServletRequest request, HttpServletResponse response){
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    int id=Integer.parseInt(request.getParameter("id"));
    genero gen= (genero) sesion.get(genero.class, id);
    sesion.beginTransaction();
    sesion.delete(gen);
    sesion.getTransaction().commit();
    sesion.close();
    admin(request, response);
}
private void admin(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    ArrayList datos=(ArrayList) sesion.createQuery("FROM genero").list();
    ArrayList <genero> lista=new ArrayList(); 
    for(Object obj: datos){
        lista.add((genero)obj);
    }request.setAttribute("genero", lista);
    try{
       request.getRequestDispatcher("ListaGenero.jsp").forward(request, response);
                }catch(ServletException |IOException ex){
                System.out.println("Error en admin Genero"+ex.getMessage());
            
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
