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

public class pago {
    private int Id_Pago;
    private double Total;
    private boleta Boleta_Id_Boleta;

    public pago() {
    }

    public int getId_Pago() {
        return Id_Pago;
    }

    public void setId_Pago(int Id_Pago) {
        this.Id_Pago = Id_Pago;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public boleta getBoleta_Id_Boleta() {
        return Boleta_Id_Boleta;
    }

    public void setBoleta_Id_Boleta(boleta Boleta_Id_Boleta) {
        this.Boleta_Id_Boleta = Boleta_Id_Boleta;
    }
}