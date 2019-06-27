/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aleja9920
 */
public class boleta {
     private  int Id_Reserva;
     private int Nsillas;
     private int Valor_Unitario;
     private cliente Cliente_Id_Cliente;
     private usuario Usuario_Id_Usuario;
     private proyeccion Proyeccion_Id_Proyeccion;

    public boleta() {
    }

    public int getId_Reserva() {
        return Id_Reserva;
    }

    public void setId_Reserva(int Id_Reserva) {
        this.Id_Reserva = Id_Reserva;
    }

    public int getNsillas() {
        return Nsillas;
    }

    public void setNsillas(int Nsillas) {
        this.Nsillas = Nsillas;
    }

    public int getValor_Unitario() {
        return Valor_Unitario;
    }

    public void setValor_Unitario(int Valor_Unitario) {
        this.Valor_Unitario = Valor_Unitario;
    }

    public cliente getCliente_Id_Cliente() {
        return Cliente_Id_Cliente;
    }

    public void setCliente_Id_Cliente(cliente Cliente_Id_Cliente) {
        this.Cliente_Id_Cliente = Cliente_Id_Cliente;
    }

    public usuario getUsuario_Id_Usuario() {
        return Usuario_Id_Usuario;
    }

    public void setUsuario_Id_Usuario(usuario Usuario_Id_Usuario) {
        this.Usuario_Id_Usuario = Usuario_Id_Usuario;
    }

    public proyeccion getProyeccion_Id_Proyeccion() {
        return Proyeccion_Id_Proyeccion;
    }

    public void setProyeccion_Id_Proyeccion(proyeccion Proyeccion_Id_Proyeccion) {
        this.Proyeccion_Id_Proyeccion = Proyeccion_Id_Proyeccion;
    }

}
