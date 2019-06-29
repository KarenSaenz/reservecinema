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
import modelo.cliente;
import modelo.proyeccion;
import modelo.usuario;
import org.hibernate.Session;

/**
 *
 * @author Lizeth Nuñez
 */
public class controllerboleta extends HttpServlet {

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
        String nsillas=request.getParameter("txtNsillas");
        String valorunitario=request.getParameter("txtValorunitario");
        String cliente=request.getParameter("txtCliente");
        String usuario=request.getParameter("txtUsuario");
        String proyeccion=request.getParameter("txtProyeccion");
        
        boleta bol=new boleta();
        bol.setNsillas(Integer.parseInt(nsillas));
        bol.setValor_Unitario(Integer.parseInt(valorunitario));
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        cliente cli=(cliente)sesion.get(cliente.class, Integer.parseInt(request.getParameter("txtCliente")));
        bol.setCliente_Id_Cliente(cli);
        usuario us=(usuario)sesion.get(usuario.class, Integer.parseInt(request.getParameter("txtUsuario")));
        bol.setUsuario_Id_Usuario(us);
        proyeccion proy=(proyeccion)sesion.get(proyeccion.class, Integer.parseInt(request.getParameter("txtProyeccion")));
        bol.setProyeccion_Id_Proyeccion(proy);
        sesion.beginTransaction();
        sesion.save(bol);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }else{
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        ArrayList datoscli=(ArrayList) sesion.createQuery("FROM cliente").list();
        ArrayList <cliente> cli=new ArrayList();
        for(Object obj:datoscli){
            cli.add((cliente)obj);
        }ArrayList datosus=(ArrayList) sesion.createQuery("FROM usuario").list();
        ArrayList <usuario> usu=new ArrayList();
        for(Object obj:datosus){
            usu.add((usuario)obj);
        }ArrayList datosproy=(ArrayList) sesion.createQuery("FROM proyeccion").list();
        ArrayList <proyeccion> proy=new ArrayList();
        for(Object obj:datosproy){
            proy.add((proyeccion)obj);
        }request.setAttribute("cliente", cli);
        request.setAttribute("usuario", usu);
        request.setAttribute("proyeccion", proy);
    }try{
        request.getRequestDispatcher("RegistrarBoleta.jsp").forward(request, response);
    }catch(ServletException|IOException ex){
        System.out.println("Error en registrar "+ ex.getMessage());
    }
}
private void update(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    int id =Integer.parseInt(request.getParameter("id"));
    boleta bol=(boleta) sesion.get(boleta.class, id);
    if(request.getMethod().equalsIgnoreCase("POST")){
        String nsillas=request.getParameter("txtNsillas");
        String valorunitario=request.getParameter("txtValorunitario");
        String cliente=request.getParameter("txtCliente");
        String usuario=request.getParameter("txtUsuario");
        String proyeccion= request.getParameter("txtProyeccion");
        bol.setNsillas(Integer.parseInt(nsillas));
        bol.setValor_Unitario(Integer.parseInt(valorunitario));
        cliente cli=(cliente) sesion.get(cliente.class, Integer.parseInt(cliente));
        bol.setCliente_Id_Cliente(cli);
        usuario usu=(usuario)sesion.get(usuario.class, Integer.parseInt(usuario));
        bol.setUsuario_Id_Usuario(usu);
        proyeccion proy=(proyeccion)sesion.get(proyeccion.class, Integer.parseInt(proyeccion));
        bol.setProyeccion_Id_Proyeccion(proy);
        sesion.beginTransaction();
        sesion.saveOrUpdate(bol);
        sesion.getTransaction().commit();
        sesion.close();
        admin(request, response);
    }else{
        ArrayList datoscli=(ArrayList)sesion.createQuery("FROM cliente").list();
        ArrayList<cliente> listacli=new ArrayList();
        for(Object obj:datoscli){
            listacli.add((cliente)obj);
        }ArrayList datosusu=(ArrayList)sesion.createQuery("FROM usuario").list();
        ArrayList<usuario> listausu=new ArrayList();
        for(Object obj:datosusu){
            listausu.add((usuario)obj);
        }ArrayList datosproy=(ArrayList)sesion.createQuery("FROM proyeccion").list();
        ArrayList<proyeccion> listaproy=new ArrayList();
        for(Object obj:datosproy){
            listaproy.add((proyeccion)obj);
        }
        request.setAttribute("editarcliente", listacli);
        request.setAttribute("editarusuario", listausu);
        request.setAttribute("editarproyeccion", listaproy);
        request.setAttribute("edtarboleta", bol);
        try{
            request.getRequestDispatcher("EditarBoleta.jsp").forward(request, response);
        }catch(ServletException |IOException ex ){
            System.out.println("Error en actualizar" + ex.getMessage());
        }
    }
}

private void delete(HttpServletRequest request, HttpServletResponse response){
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    int id=Integer.parseInt(request.getParameter("id"));
    boleta bol=(boleta)sesion.get(boleta.class, id);
    sesion.beginTransaction();
    sesion.delete(bol);
    sesion.getTransaction().commit();
    sesion.close();
    admin(request, response);
}
private void admin(HttpServletRequest request, HttpServletResponse response){
    Session sesion=HibernateUtil.getSessionFactory().openSession();
    ArrayList datos=(ArrayList)sesion.createQuery("FROM boleta").list();
    ArrayList <boleta> lista=new ArrayList();
    for(Object obj: datos){
        lista.add((boleta)obj);
    }request.setAttribute("listaboleta", lista);
    try{
        request.getRequestDispatcher("ListaBoleta.jsp").include(request, response);
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
