package modelos;

public abstract class Envio { 
    private String cliente;
    private int codigoDeEnvio;
    private double pesoDelEnvio;
    private double distanciaDelEnvio;
    private TipoEnvio tipo; // Atributo agregado

    public Envio(String cliente, int codigoDeEnvio, double pesoDelEnvio, double distanciaDelEnvio, TipoEnvio tipo){
        this.cliente = cliente;
        this.codigoDeEnvio = codigoDeEnvio;
        this.pesoDelEnvio = pesoDelEnvio;
        this.distanciaDelEnvio = distanciaDelEnvio;
        this.tipo = tipo;
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

    public TipoEnvio getTipo() {
        return tipo;
    }

    public abstract double calcularTarifa();

    public String[] getDatosParaTabla() {
        return new String[] {
            String.valueOf(codigoDeEnvio),
            cliente,
            tipo.toString(),
            String.valueOf(pesoDelEnvio),
            String.valueOf(distanciaDelEnvio),
            String.valueOf(calcularTarifa())
        };
    }

    public boolean CalculoDistancia(double distancia){
        return distancia > 0;
    }
}