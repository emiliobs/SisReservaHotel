
package Datos;


public class VHabitacion
{
   private int IdHabitacion;
   private String Numero;
   private  String Piso;
   private String Descripcion;
   private String Caracteristicas;
   private double PrecioDiario;
   private String Estado;
   private String  TipoHabitacion; 

    public int getIdHabitacion() {
        return IdHabitacion;
    }

    public void setIdHabitacion(int IdHabitacion) {
        this.IdHabitacion = IdHabitacion;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getPiso() {
        return Piso;
    }

    public void setPiso(String Piso) {
        this.Piso = Piso;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String Caracteristicas) {
        this.Caracteristicas = Caracteristicas;
    }

    public double getPrecioDiario() {
        return PrecioDiario;
    }

    public void setPrecioDiario(double PrecioDiario) {
        this.PrecioDiario = PrecioDiario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTipoHabitacion() {
        return TipoHabitacion;
    }

    public void setTipoHabitacion(String TipoHabitacion) {
        this.TipoHabitacion = TipoHabitacion;
    }

    public VHabitacion() {
    }

    public VHabitacion(int IdHabitacion, String Numero, String Piso, String Descripcion, String Caracteristicas, double PrecioDiario, String Estado, String TipoHabitacion) {
        this.IdHabitacion = IdHabitacion;
        this.Numero = Numero;
        this.Piso = Piso;
        this.Descripcion = Descripcion;
        this.Caracteristicas = Caracteristicas;
        this.PrecioDiario = PrecioDiario;
        this.Estado = Estado;
        this.TipoHabitacion = TipoHabitacion;
    }
}
