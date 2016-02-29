
package Datos;

import java.sql.Date;


public class Vpago 
{
        private int IdPago;
        private int IdReserva;
        private String tipoComprobante;
        private String numeroComprobante;
        private double Igv;
        private double totalPago;
        private Date fechaEmision;
        private Date fechaPago;

    public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int IdPago) {
        this.IdPago = IdPago;
    }

    public int getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(int IdReserva) {
        this.IdReserva = IdReserva;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public double getIgv() {
        return Igv;
    }

    public void setIgv(double Igv) {
        this.Igv = Igv;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Vpago(int IdPago, int IdReserva, String tipoComprobante, String numeroComprobante, double Igv, double totalPago, Date fechaEmision, Date fechaPago) {
        this.IdPago = IdPago;
        this.IdReserva = IdReserva;
        this.tipoComprobante = tipoComprobante;
        this.numeroComprobante = numeroComprobante;
        this.Igv = Igv;
        this.totalPago = totalPago;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
    }


    public Vpago() {
    }
       
        
}
