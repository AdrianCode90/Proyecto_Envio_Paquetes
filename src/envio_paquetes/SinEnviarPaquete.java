
package envio_paquetes;


public class SinEnviarPaquete {
    
    private String numero_paquete;
    private String dni;
    private String peso;
    
    public SinEnviarPaquete(String numero_paquete, String dni, String peso) {
        
        this.numero_paquete = numero_paquete;
        this.dni = dni;
        this.peso = peso;
   
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

    
    public String mostrarDatosSinEnviarPaquete(){
        
        return "Numero de paquete: " + numero_paquete + "\nDNI: " + dni + "\nPeso: " + peso;
    }
    
}
