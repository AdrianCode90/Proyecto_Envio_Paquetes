
package envio_paquetes;


public class Sucursal {
    
    private String numero_sucursal;
    private String provincia;
    private int cantidad_paquetes;

    public Sucursal(String numero_sucursal, String provincia, int cantidad_paquetes) {
        
        this.numero_sucursal = numero_sucursal;
        this.provincia = provincia;
        this.cantidad_paquetes = cantidad_paquetes;
    }

    
    public String getNumero_sucursal() {
        return numero_sucursal;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getCantidad_paquetes() {
        return cantidad_paquetes;
    }

   
    public String mostrarDatosSucursal(){
        
        return "Numero sucursal: " + numero_sucursal + "\nProvincia: " + provincia + "\nCantidad de paquetes: " + cantidad_paquetes;
    }
    
    
}

