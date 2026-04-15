package modelos;

public class Aereo extends Envio {
    private final double TARIFA_BASE_KM_AEREO = 5000;
    private final double RECARGO_KG_AEREO = 4000;

    public Aereo(String cliente, int codigoDeEnvio, double pesoDelEnvio, double distanciaDelEnvio) {
        super(cliente, codigoDeEnvio, pesoDelEnvio, distanciaDelEnvio, TipoEnvio.AEREO);
    }

    @Override
    public double calcularTarifa() {
        return (getDistanciaARecorrer() * TARIFA_BASE_KM_AEREO) + (getPeso() * RECARGO_KG_AEREO);
    }
}