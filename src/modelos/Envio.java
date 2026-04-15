package modelos;

public abstract class Envio { 
    private String cliente;
    private int codigoDeEnvio;
    private double pesoDelEnvio;
    private double distanciaDelEnvio;

    public Envio(String cliente, int codigoDeEnvio, double pesoDelEnvio, double distanciaDelEnvio){
        this.cliente = cliente;
        this.codigoDeEnvio = codigoDeEnvio;
        this.pesoDelEnvio = pesoDelEnvio;
        this.distanciaDelEnvio = distanciaDelEnvio;
    }

    public String getCliente() {
        return cliente;
    } 

    public int getCodigoEnvio() {
        return codigoDeEnvio;
    }
  
    public double getPeso() {
        return pesoDelEnvio;
    }
    
    public double getDistanciaARecorrer() {
        return distanciaDelEnvio;
    }    

    public abstract double calcularTarifa();

    public String[] getDatosParaTabla() {
        return new String[] {
            String.valueOf(codigoDeEnvio),
            cliente,
            String.valueOf(pesoDelEnvio),
            String.valueOf(distanciaDelEnvio),
            String.valueOf(calcularTarifa())
        };
    }

    public boolean CalculoDistancia(double distancia){
        return distancia > 0;
    }
}