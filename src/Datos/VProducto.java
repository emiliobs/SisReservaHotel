
package Datos;


public class VProducto 
{
    //SELECT `idproducto`, `nombre`, `descripcion`, `unidad_medida`, `precio_venta` FROM `producto` WHERE 1
    
    private int IdProducto;
    private String Nombre;
    private String Descripcion;
    private String UnidadMedida;
    private double  PrecioVenta;

    public VProducto(int IdProducto, String Nombre, String Descripcion, String UnidadMedida, double PrecioVenta) {
        this.IdProducto = IdProducto;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.UnidadMedida = UnidadMedida;
        this.PrecioVenta = PrecioVenta;
    }

    public VProducto() {
    }
    
    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    
    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }
    
    
    
}
