
package Datos;

public class VCliente extends VPersona
{
    private String codigoCliente;

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public VCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public VCliente() {
    }
}
