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
import modelo.boleta;
import modelo.pago;
import org.hibernate.Session;

/**
 *
 * @author Lizeth Nuñez
 */
public class controllerpago extends HttpServlet {

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
        String total=request.getParameter("txtTotal");
        String boleta=request.getParameter("txtBoleta");
        pago pago= new pago();
        pago.setTotal(Integer.parseInt(total));
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        boleta bol=(boleta)sesion.get(boleta.class, Integer.parseInt(request.getParameter("txtBoleta")));
        pago.setBoleta_Id_Boleta(bol);
        sesion.beginTransaction();
        sesion.save(pago);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }else{
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        ArrayList datosbol=(ArrayList)sesion.createQuery("FROM boleta").list();
        ArrayList<boleta> bol=new ArrayList();
        for(Object obj:datosbol){
            bol.add((boleta)obj);
        }request.setAttribute("boleta", bol);
        try{
            request.getRequestDispatcher("RegistrarPago.jsp").forward(request, response);
        }catch(ServletException|IOException ex){
            System.out.println("Error en registrar "+ex.getMessage());
        }
    }
}
private void update(HttpServletRequest request, HttpServletResponse response){
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    int id= Integer.parseInt(request.getParameter("id"));
    pago pago=(pago)sesion.get(pago.class, id);
    if(request.getMethod().equalsIgnoreCase("POST")){
    String total=request.getParameter("txtTotal");
    String boleta=request.getParameter("txtBoleta");
    pago.setTotal(Integer.parseInt(total));
    boleta bol=(boleta)sesion.get(boleta.class,Integer.parseInt(boleta));
    pago.setBoleta_Id_Boleta(bol);
    sesion.beginTransaction();
    sesion.saveOrUpdate(pago);
    sesion.getTransaction().commit();
    sesion.close();
    admin(request, response);
    }else{
         ArrayList datosbol=(ArrayList) sesion.createQuery("FROM boleta").list();
                ArrayList<boleta> listabol= new ArrayList();
                for (Object obj: datosbol){
                    listabol.add((boleta) obj);
                }request.setAttribute("boleta", listabol);
                request.setAttribute("editarpago", pago);
                try{
                    request.getRequestDispatcher("EditarPago.jsp").forward(request, response);
                }catch(ServletException|IOException ex){
                    System.out.println("Error en actulizar pago "+ ex.getMessage());
                }sesion.close();
    } 
}
private void delete(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    int id =Integer.parseInt(request.getParameter("id"));
    pago pago=(pago)sesion.get(pago.class, id);
    sesion.beginTransaction();
    sesion.delete(pago);
    sesion.getTransaction().commit();
    sesion.close();
    admin(request, response);
}
private void admin(HttpServletRequest request, HttpServletResponse response){
  Session sesion= HibernateUtil.getSessionFactory().openSession();
        ArrayList datos= (ArrayList) sesion.createQuery("FROM pago").list();
        ArrayList<pago> lista= new ArrayList();
        for(Object obj:datos){
            lista.add((pago)obj);
        }request.setAttribute("listapago", lista);
        try{
            request.getRequestDispatcher("ListaPago.jsp").include(request, response);
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
