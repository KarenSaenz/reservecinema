/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author aleja9920
 */
public class proyeccion {
    private int Id_Proyeccion;
    private Date Fecha;
    private pelicula Pelicula_Id_Pelicula;
    private sala Sala_Id_Sala;

    public proyeccion() {
    }

    public int getId_Proyeccion() {
        return Id_Proyeccion;
    }

    public void setId_Proyeccion(int Id_Proyeccion) {
        this.Id_Proyeccion = Id_Proyeccion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public pelicula getPelicula_Id_Pelicula() {
        return Pelicula_Id_Pelicula;
    }

    public void setPelicula_Id_Pelicula(pelicula Pelicula_Id_Pelicula) {
        this.Pelicula_Id_Pelicula = Pelicula_Id_Pelicula;
    }

    public sala getSala_Id_Sala() {
        return Sala_Id_Sala;
    }

    public void setSala_Id_Sala(sala Sala_Id_Sala) {
        this.Sala_Id_Sala = Sala_Id_Sala;
    }
    
    
}

