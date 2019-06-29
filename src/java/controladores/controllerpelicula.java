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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.HibernateUtil;
import modelo.genero;
import modelo.pelicula;
import org.hibernate.Session;
import java.util.Date;
/**
 *
 * @author Lizeth Nuñez
 */
public class controllerpelicula extends HttpServlet {

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
        String nombre= request.getParameter("txtNombre");
        String duracion=request.getParameter("txtDuracion");
        String hora=request.getParameter("txtHora");
        String genero=request.getParameter("txtGenero");
        String costo=request.getParameter("txtCosto");
        
        pelicula peli=new pelicula();
        peli.setNombre(nombre);
        Date hr;
            try{
                hr=new SimpleDateFormat("HH-mm-ss").parse(hora);
                peli.setHora(hr);
            }catch(ParseException ex){
            }
       
        peli.setDuracion(duracion);
        peli.setCosto(Integer.parseInt(costo));
        
       Session sesion= HibernateUtil.getSessionFactory().openSession();
       genero gen=(genero)sesion.get(genero.class,Integer.parseInt(request.getParameter("txtGenero")));
       peli.setGenero_Id_Genero(gen);
       
       sesion.beginTransaction();
       sesion.save(gen);
       sesion.getTransaction().commit();
       sesion.close();
        admin(request, response);
    }else{
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        ArrayList datosgen= (ArrayList)sesion.createQuery("FROM genero").list();
        ArrayList <genero> gene=new ArrayList();
        for(Object obj: datosgen){
            gene.add((genero)obj);
        }request.setAttribute("genero", gene);
        try{
            request.getRequestDispatcher("RegistrarPelicula.jsp").forward(request, response);
        }catch(ServletException|IOException ex){
            System.out.println("Error en registrar "+ex.getMessage());
        }
    }
}
private void update(HttpServletRequest request, HttpServletResponse response){
    Session sesion= HibernateUtil.getSessionFactory().openSession();
    int id= Integer.parseInt(request.getParameter("id"));
    pelicula peli=(pelicula) sesion.get(pelicula.class, id);
    if(request.getMethod().equalsIgnoreCase("POST")){
        String nombre=request.getParameter("txtNombre");
        String duracion=request.getParameter("txtDuracion");
        String hora=request.getParameter("txtHora");
        String genero= request.getParameter("txtGenero");
        String costo= request.getParameter("txtCosto");
        
        peli.setNombre(nombre);
        Date hor;
            try{
                hor=new SimpleDateFormat("HH-mm-ss").parse(hora);
                peli.setHora(hor);
            }catch(ParseException ex){
               }
        peli.setDuracion(duracion);
        
        
        peli.setCosto(Integer.parseInt(costo));
        genero  gen= (genero) sesion.get(genero.class, Integer.parseInt(genero));
        peli.setGenero_Id_Genero(gen);
        
        sesion.beginTransaction();
        sesion.saveOrUpdate(peli);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }else{
        ArrayList datosgen=(ArrayList) sesion.createQuery("FROM genero").list();
        ArrayList <genero> listagen= new ArrayList();
        for(Object obj: datosgen){
            listagen.add((genero)obj);
        }request.setAttribute("editargenero",listagen);
        }request.setAttribute("editarpelicula",peli);
        try{
            request.getRequestDispatcher("EditarPelicula.jsp").forward(request, response);
    }catch(ServletException|IOException ex){
            System.out.println("Error en actualizar "+ ex.getMessage());
    }sesion.close();
}
private void delete(HttpServletRequest request, HttpServletResponse response){
    Session sesion= HibernateUtil.getSessionFactory().openSession();
    int id= Integer.parseInt(request.getParameter("id"));
    pelicula peli=(pelicula) sesion.get(genero.class, id);
    sesion.beginTransaction();
    sesion.delete(peli);
    sesion.getTransaction().commit();
    sesion.close();
    admin(request, response);
}
private void admin(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    ArrayList datos=(ArrayList) sesion.createQuery("FROM pelicula").list();
    ArrayList <pelicula> lista= new ArrayList();
    for(Object obj: datos){
        lista.add((pelicula)obj);
    }request.setAttribute("listapelicula", lista);
    try{
        request.getRequestDispatcher("ListaVenta.jsp").include(request, response);
    }catch(ServletException|IOException ex){
        System.out.println("Error en listar "+ex.getMessage());
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
