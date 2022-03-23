
package envio_paquetes;


public class EnvioPaquete {

    private String numero_paquete;
    private String dni;
    private String peso;
    private String numero_sucursal;
    
    public EnvioPaquete(String numero_paquete, String dni, String peso, String numero_sucursal) {
        
        this.numero_paquete = numero_paquete;
        this.dni = dni;
        this.peso = peso;
        this.numero_sucursal = numero_sucursal;
   
    }

    public String getNumero_paquete() {
        return numero_paquete;
    }

    public String getDni() {
        return dni;
    }

    public String getPeso() {
        return peso;
    }

    public String getNumero_sucursal() {
        return numero_sucursal;
    }
    
    
    
    public String mostrarDatosEnvioPaquete(){
        
        return "Numero de paquete: " + numero_paquete + "\nDNI: " + dni + "\nPeso: " + peso + "\nFue enviado a la sucursal: " + numero_sucursal;
    }
    
}
