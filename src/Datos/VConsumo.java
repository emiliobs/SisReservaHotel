/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


public class VConsumo 
{
   private int idconsusmo;
   private  int idreserva;
   private  int idproducto;
   private  double cantidad;
   private double precio_venta;
   private String estado;

    public int getIdconsusmo() {
        return idconsusmo;
    }

    public void setIdconsusmo(int idconsusmo) {
        this.idconsusmo = idconsusmo;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public VConsumo(int idconsusmo, int idreserva, int idproducto, double cantidad, double precio_venta, String estado) {
        this.idconsusmo = idconsusmo;
        this.idreserva = idreserva;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
        this.estado = estado;
    }

    public VConsumo() {
    }
           
   
   
}
