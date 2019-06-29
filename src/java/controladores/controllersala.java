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
import modelo.sala;
import modelo.teatro;
import org.hibernate.Session;

/**
 *
 * @author Lizeth Nuñez
 */
public class controllersala extends HttpServlet {

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
        String capacidad=request.getParameter("txtCpacidad");
        String teatro=request.getParameter("txtTeatro");
        sala sal=new sala();
        sal.setCapacidad(Integer.parseInt(capacidad));
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        teatro tea=(teatro)sesion.get(teatro.class, Integer.parseInt(request.getParameter("txTeatro")));
        sal.setTeatro_Id_Teatro(tea);
        sesion.beginTransaction();
        sesion.save(sal);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }else{
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        ArrayList datostatro=(ArrayList) sesion.createQuery("FROM teatro").list();
             ArrayList <teatro> teat=new ArrayList();
            for(Object obj: datostatro){
                teat.add((teatro)obj);
            }request.setAttribute("teatro",teat);
            try{
                request.getRequestDispatcher("RegstrarSala.jsp").forward(request, response);
            }catch(ServletException|IOException ex){
                System.out.println("Error en registrar sala "+ex.getMessage());
            }
    }
}
private void update(HttpServletRequest request, HttpServletResponse response){
     Session sesion= HibernateUtil.getSessionFactory().openSession();
        int id=Integer.parseInt(request.getParameter("id"));
        sala sal=(sala)sesion.get(sala.class,id);
        if(request.getMethod().equalsIgnoreCase("POST")){
            String capacidad=request.getParameter("txtCapacidad");
            String teatro=request.getParameter("txtTeatro");
            sal.setCapacidad(Integer.parseInt(capacidad));
            teatro te= (teatro)sesion.get(teatro.class, Integer.parseInt(teatro));
            sal.setTeatro_Id_Teatro(te);
            sesion.beginTransaction();
            sesion.saveOrUpdate(sal);
            sesion.getTransaction().commit();
            sesion.close();
            admin(request, response);
        }else{
            ArrayList datoste=(ArrayList)sesion.createQuery("FROM teatro").list();
            ArrayList <teatro> listate=new ArrayList();
            for(Object obj:datoste){
                listate.add((teatro)obj);
            }request.setAttribute("sala", listate);
            request.setAttribute("editarsala",sal);
            try{
                request.getRequestDispatcher("EditarSala.jsp").forward(request, response);
            }catch(ServletException|IOException ex){
                System.out.println("Error en actualizar sala "+ex.getMessage());
            }
        }
}
private void delete(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    int id =Integer.parseInt(request.getParameter("id"));
    sala sal=(sala)sesion.get(sala.class, id);
    sesion.beginTransaction();
    sesion.delete(sal);
    sesion.getTransaction().commit();
    sesion.close();
    admin(request, response);
}
private void admin(HttpServletRequest request, HttpServletResponse response){
    Session sesion= HibernateUtil.getSessionFactory().openSession();
        ArrayList datos= (ArrayList) sesion.createQuery("FROM sala").list();
        ArrayList<sala> lista= new ArrayList();
        for(Object obj:datos){
            lista.add((sala)obj);
        }request.setAttribute("listasala", lista);
        try{
            request.getRequestDispatcher("ListaSala.jsp").include(request, response);
        }catch(ServletException| IOException ex){
            System.out.println("Error en listar sala"+ ex.getMessage());
            
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
