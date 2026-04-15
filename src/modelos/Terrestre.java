package modelos;

public class Terrestre extends Envio {
    private final double TARIFA_BASE_KM_TERRESTRE = 1500;
    private final double RECARGO_KG_TERRESTRE = 2000;

    public Terrestre(String cliente, int codigoDeEnvio, double pesoDelEnvio, double distanciaDelEnvio) {
        super(cliente, codigoDeEnvio, pesoDelEnvio, distanciaDelEnvio);
    }

    @Override
    public double calcularTarifa() {
        return (getDistanciaARecorrer() * TARIFA_BASE_KM_TERRESTRE) + (getPeso() * RECARGO_KG_TERRESTRE);
    }
}