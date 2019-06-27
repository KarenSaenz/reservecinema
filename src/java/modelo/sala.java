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
public class sala {
    private int Id_Sala;
    private int Capacidad;
    private teatro Teatro_Id_Teatro;

    public sala() {
    }

    public int getId_Sala() {
        return Id_Sala;
    }

    public void setId_Sala(int Id_Sala) {
        this.Id_Sala = Id_Sala;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public teatro getTeatro_Id_Teatro() {
        return Teatro_Id_Teatro;
    }

    public void setTeatro_Id_Teatro(teatro Teatro_Id_Teatro) {
        this.Teatro_Id_Teatro = Teatro_Id_Teatro;
    }
    
}

