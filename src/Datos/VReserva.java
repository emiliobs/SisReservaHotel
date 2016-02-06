
package Datos;
import java.sql.Date;


public class VReserva 
{
   private int IdReserva;
   private int IdHabitacion;
   private int IdCliente;
   private  int IdTrabajador;
   private String TipoRserva;
   private  Date FechaReserva;
   private Date FechaIngreso;
   private Date FechaSalida;
   private double CostoAlojamiento;
   private String Estado;

    public int getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(int IdReserva) {
        this.IdReserva = IdReserva;
    }

    public int getIdHabitacion() {
        return IdHabitacion;
    }

    public void setIdHabitacion(int IdHabitacion) {
        this.IdHabitacion = IdHabitacion;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdTrabajador() {
        return IdTrabajador;
    }

    public void setIdTrabajador(int IdTrabajador) {
        this.IdTrabajador = IdTrabajador;
    }

    public String getTipoRserva() {
        return TipoRserva;
    }

    public void setTipoRserva(String TipoRserva) {
        this.TipoRserva = TipoRserva;
    }

    public Date getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(Date FechaReserva) {
        this.FechaReserva = FechaReserva;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public Date getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(Date FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public double getCostoAlojamiento() {
        return CostoAlojamiento;
    }

    public void setCostoAlojamiento(double CostoAlojamiento) {
        this.CostoAlojamiento = CostoAlojamiento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public VReserva(int IdReserva, int IdHabitacion, int IdCliente, int IdTrabajador, String TipoRserva, Date FechaReserva, Date FechaIngreso, Date FechaSalida, double CostoAlojamiento, String Estado) {
        this.IdReserva = IdReserva;
        this.IdHabitacion = IdHabitacion;
        this.IdCliente = IdCliente;
        this.IdTrabajador = IdTrabajador;
        this.TipoRserva = TipoRserva;
        this.FechaReserva = FechaReserva;
        this.FechaIngreso = FechaIngreso;
        this.FechaSalida = FechaSalida;
        this.CostoAlojamiento = CostoAlojamiento;
        this.Estado = Estado;
    }

    public VReserva() {
    }
}
