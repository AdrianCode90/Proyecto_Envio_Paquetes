
package envio_paquetes;


public class Paquete {
    
    private String numero_paquete;
    private String dni;
    private String peso;
    private boolean estadoEnvio;

    public Paquete(String numero_paquete, String dni, String peso, boolean estadoEnvio) {
        
        this.numero_paquete = numero_paquete;
        this.dni = dni;
        this.peso = peso;
        this.estadoEnvio = estadoEnvio;
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

    public boolean getEstadoEnvio() {
        return estadoEnvio;
    }

    
    public String mostrarDatosPaquete(){
        
        return "Numero de paquete: " + numero_paquete + "\nDNI: " + dni + "\nPeso: " + peso;
    }
}
