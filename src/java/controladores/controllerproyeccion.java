/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.HibernateUtil;
import modelo.pelicula;
import modelo.proyeccion;
import modelo.sala;
import org.hibernate.Session;

/**
 *
 * @author Lizeth Nuñez
 */
public class controllerproyeccion extends HttpServlet {

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
        String sala=request.getParameter("txtSala");
        String pelicula=request.getParameter("txtPelicula");
        String fecha=request.getParameter("txtFecha");
        proyeccion proy= new proyeccion();
        Date fc;
            try{
                fc=new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                proy.setFecha(fc);
            }catch(ParseException ex){
            }
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        pelicula peli=(pelicula)sesion.get(pelicula.class, Integer.parseInt(request.getParameter("txtPelicula")));
        proy.setPelicula_Id_Pelicula(peli);
        sala sal=(sala)sesion.get(sala.class,Integer.parseInt(request.getParameter("txtSala")));
        proy.setSala_Id_Sala(sal);
        sesion.beginTransaction();
        sesion.save(proy);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }else{
        Session sesion= HibernateUtil.getSessionFactory().openSession();
            ArrayList datospeli=(ArrayList) sesion.createQuery("FROM pelicula").list();
             ArrayList <pelicula> pelicu=new ArrayList();
            for(Object obj: datospeli){
                pelicu.add((pelicula)obj);
            }
            ArrayList datossala=(ArrayList) sesion.createQuery("FROM sala").list();
             ArrayList <sala> sal=new ArrayList();
            for(Object obj: datossala){
                sal.add((sala)obj);
            }request.setAttribute("pelicula", pelicu);
            request.setAttribute("sala", sal);
             try{
                request.getRequestDispatcher("RegistrarProyeccion.jsp").forward(request, response);
            }catch(ServletException |IOException ex){
                System.out.println("Error en registrar proyeccion"+ ex.getMessage());
            }
    }
}
private void update(HttpServletRequest request, HttpServletResponse response){
    Session sesion= HibernateUtil.getSessionFactory().openSession();
        int id=Integer.parseInt(request.getParameter("id"));
        proyeccion proy=(proyeccion)sesion.get(proyeccion.class, id);
        if(request.getMethod().equalsIgnoreCase("POST")){
            String pelicula=request.getParameter("txtPelicula");
            String sala=request.getParameter("txtSala");
            String fecha=request.getParameter("txtFecha");
             Date fc;
            try{
                fc=new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                proy.setFecha(fc);
            }catch(ParseException ex){
            }
            pelicula peli=(pelicula)sesion.get(pelicula.class, Integer.parseInt(pelicula));
            proy.setPelicula_Id_Pelicula(peli);
            sala sl=(sala)sesion.get(sala.class, Integer.parseInt(sala));
            proy.setSala_Id_Sala(sl);
            sesion.beginTransaction();
            sesion.saveOrUpdate(proy);
            sesion.getTransaction().commit();
            sesion.close();
            admin(request, response);
        }else{
            ArrayList datospel=(ArrayList)sesion.createQuery("FROM pelicula").list();
            ArrayList <pelicula> listapelic=new ArrayList();
            for(Object obj: datospel){
                listapelic.add((pelicula)obj);
            }
            ArrayList datossal=(ArrayList)sesion.createQuery("FROM sala").list();
            ArrayList <sala> listasal=new ArrayList();
            for(Object obj:datossal){
                listasal.add((sala)obj);
            }request.setAttribute("pelicula", listapelic);
            request.setAttribute("sala", listasal);
            request.setAttribute("editarproyeccion", proy);
            try{
                request.getRequestDispatcher("EditarProyeccion.jsp").forward(request, response);
            }catch(ServletException|IOException ex){
                System.out.println("Error en actualizar proyeccion");
            }sesion.close();
        }
}
private void delete(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    int id=Integer.parseInt(request.getParameter("id"));
    proyeccion proy=(proyeccion)sesion.get(proyeccion.class, id);
    sesion.beginTransaction();
    sesion.delete(proy);
    sesion.getTransaction().commit();
    sesion.close();
    admin(request, response);
}
private void admin(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    ArrayList datos=(ArrayList)sesion.createQuery("FROM proyeccion");
    ArrayList<proyeccion> lista=new ArrayList();
    for(Object obj:datos){
        lista.add((proyeccion)obj);
    }request.setAttribute("listaproyeccion", lista);
    try{
            request.getRequestDispatcher("ListaProyeccion.jsp").include(request, response);
        }catch(ServletException| IOException ex){
            System.out.println("Error en listar"+ ex.getMessage());
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
