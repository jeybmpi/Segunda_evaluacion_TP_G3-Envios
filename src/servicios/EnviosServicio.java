package servicios;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Envio;

public class EnviosServicio {

    private static List<Envio> envios = new ArrayList<>();
    public static String[] encabezados = new String[] { "Codigo", "Cliente", "Peso", "Distancia", "Costo" };


    public static boolean existeCodigo(int codigo) {
        for (Envio envios : envios) {
            if (envios.getCodigoEnvio() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static void agregar(Envio envio) {
        envios.add(envio);
    }

    public static boolean retirar(int codigo) {
        for (int i = 0; i < envios.size(); i++) {
            if (envios.get(i).getCodigoEnvio() == codigo) {
                envios.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void mostrar(JTable tbl) {
        String[][] datos = new String[envios.size()][encabezados.length];

        for (int fila = 0; fila < envios.size(); fila++) {
            datos[fila] = envios.get(fila).getDatosParaTabla();
        }
        
        DefaultTableModel dtm = new DefaultTableModel(datos, encabezados);
        tbl.setModel(dtm);
    }
}