package modelos;

public class Fluvial extends Envio {
    private final double TARIFA_BASE_KM_FLUVIAL = 800;
    private final double RECARGO_KG_FLUVIAL = 1000;

    public Fluvial(String cliente, int codigoDeEnvio, double pesoDelEnvio, double distanciaDelEnvio) {
        super(cliente, codigoDeEnvio, pesoDelEnvio, distanciaDelEnvio);
    }

    @Override
    public double calcularTarifa() {
        return (getDistanciaARecorrer() * TARIFA_BASE_KM_FLUVIAL) + (getPeso() * RECARGO_KG_FLUVIAL);
    }
}