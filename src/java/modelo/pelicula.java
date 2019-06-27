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
public class pelicula {
    private int Id_Pelicula;
    private String Nombre;
    private Date Duracion;
    private Date Hora;
    private genero Genero_Id_Genero;
    private int Costo;

    public pelicula() {
    }

    public int getId_Pelicula() {
        return Id_Pelicula;
    }

    public void setId_Pelicula(int Id_Pelicula) {
        this.Id_Pelicula = Id_Pelicula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getDuracion() {
        return Duracion;
    }

    public void setDuracion(Date Duracion) {
        this.Duracion = Duracion;
    }

    public Date getHora() {
        return Hora;
    }

    public void setHora(Date Hora) {
        this.Hora = Hora;
    }

    public genero getGenero_Id_Genero() {
        return Genero_Id_Genero;
    }

    public void setGenero_Id_Genero(genero Genero_Id_Genero) {
        this.Genero_Id_Genero = Genero_Id_Genero;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
    
}

