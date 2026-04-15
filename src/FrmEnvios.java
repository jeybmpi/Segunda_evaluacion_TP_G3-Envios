import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import modelos.*;
import servicios.EnviosServicio;

public class FrmEnvios extends JFrame {
    private JTable tblEnvio;
    private JPanel pnlEditarEnvio, pnlEditarCancelado;
    private JTextField txtNumero, txtCliente, txtPeso, txtDistanciaKm, txtCodigoRetirar;
    private JComboBox cmbTipoDeEnvio;    
    JTabbedPane tp;

    public FrmEnvios() {
        setSize(600, 400);
        setTitle("Envios");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //_______tamaño de la ventana______________________________________________________

        JToolBar tbEnvios = new JToolBar();
        //_______barra de los botones______________________________________________________

        JButton btnAgregarEnvio = new JButton();
        btnAgregarEnvio.setIcon(new ImageIcon(getClass().getResource("/iconos/agregar.png")));
        btnAgregarEnvio.setToolTipText("Agregar Envio");
        btnAgregarEnvio.addActionListener(evt -> { 
            btnAgregarEnvioClick(); 

        });
        tbEnvios.add(btnAgregarEnvio);

        JButton btnQuitarEnvio = new JButton();
        btnQuitarEnvio.setIcon(new ImageIcon(getClass().getResource("/iconos/quitar.png")));
        btnQuitarEnvio.setToolTipText("Quitar Envio");
        btnQuitarEnvio.addActionListener(evt -> { 
            btnIrACancelacionesClick(); 

        });
        tbEnvios.add(btnQuitarEnvio);
        //______________________botones de agregar y quitar___________________________________

        JPanel pnlEnvios = new JPanel();
        pnlEnvios.setLayout(new BoxLayout(pnlEnvios, BoxLayout.Y_AXIS));

        pnlEditarEnvio = new JPanel();
        pnlEditarEnvio.setPreferredSize(new Dimension(600, 150)); 
        pnlEditarEnvio.setLayout(null);
        pnlEditarEnvio.setVisible(false);

        // Campos de texto y etiquetas (Pestaña 1)
        JLabel lblNumero = new JLabel("Número");
        lblNumero.setBounds(10, 10, 100, 25);
        pnlEditarEnvio.add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(110, 10, 100, 25);
        pnlEditarEnvio.add(txtNumero);
        
        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(10, 50, 100, 25);
        pnlEditarEnvio.add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(110, 50, 100, 25);
        pnlEditarEnvio.add(txtCliente);

        JLabel lblPeso = new JLabel("Peso");
        lblPeso.setBounds(10, 90, 100, 25);
        pnlEditarEnvio.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(110, 90, 100, 25);
        pnlEditarEnvio.add(txtPeso);

        JLabel lblDistanciaKm = new JLabel("Distancia en KM");
        lblDistanciaKm.setBounds(250, 50, 100, 25);
        pnlEditarEnvio.add(lblDistanciaKm);

        txtDistanciaKm = new JTextField();
        txtDistanciaKm.setBounds(350, 50, 100, 25);
        pnlEditarEnvio.add(txtDistanciaKm);

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(250, 10, 100, 25);
        pnlEditarEnvio.add(lblTipo);

        cmbTipoDeEnvio = new JComboBox();
        cmbTipoDeEnvio.setBounds(350, 10, 100, 25);
        cmbTipoDeEnvio.setModel(new DefaultComboBoxModel(TipoEnvio.values()));
        pnlEditarEnvio.add(cmbTipoDeEnvio);

        // _____________Botones Guardar y Cancelar________________________________________________
        JButton btnGuardarEnvio = new JButton("Guardar");
        btnGuardarEnvio.setBounds(250, 90, 100, 25);
        btnGuardarEnvio.addActionListener(evt -> { 
            btnGuardarEnvioClick(); 

        });
        pnlEditarEnvio.add(btnGuardarEnvio); 

        JButton btnCancelarEnvio = new JButton("Cancelar");
        btnCancelarEnvio.setBounds(350, 90, 100, 25);
        btnCancelarEnvio.addActionListener(evt -> { 
            limpiar(); 

        });
        pnlEditarEnvio.add(btnCancelarEnvio); 

        // Tabla
        tblEnvio = new JTable();
        JScrollPane spListaEnvios = new JScrollPane(tblEnvio);
        pnlEnvios.add(pnlEditarEnvio);
        pnlEnvios.add(spListaEnvios);

        //______________Pestaña 2 (Cancelaciones)______________________________
        pnlEditarCancelado = new JPanel();
        pnlEditarCancelado.setPreferredSize(new Dimension(600, 150));
        pnlEditarCancelado.setLayout(null);

        JLabel lblCodigoRetirar = new JLabel("Código a Quitar:");
        lblCodigoRetirar.setBounds(10, 20, 120, 25);
        pnlEditarCancelado.add(lblCodigoRetirar);

        txtCodigoRetirar = new JTextField();
        txtCodigoRetirar.setBounds(130, 20, 100, 25);
        pnlEditarCancelado.add(txtCodigoRetirar);

        JButton btnQuitar = new JButton("Quitar");
        btnQuitar.setBounds(240, 20, 100, 25);
        btnQuitar.addActionListener(evt -> { 
            btnQuitarClick(); 

        });
        pnlEditarCancelado.add(btnQuitar);

        // Tabs
        JScrollPane spEnvios = new JScrollPane(pnlEnvios);
        JPanel pnlCancelacionesFull = new JPanel();
        pnlCancelacionesFull.setLayout(new BoxLayout(pnlCancelacionesFull, BoxLayout.Y_AXIS));
        pnlCancelacionesFull.add(pnlEditarCancelado);
        JScrollPane spEnviosCancelados = new JScrollPane(pnlCancelacionesFull);

        tp = new JTabbedPane();
        tp.addTab("Envios", spEnvios);
        tp.addTab("Cancelaciones", spEnviosCancelados);

        add(tbEnvios, BorderLayout.NORTH);
        add(tp, BorderLayout.CENTER);

        EnviosServicio.mostrar(tblEnvio);
    }

    private void btnAgregarEnvioClick() {
        pnlEditarEnvio.setVisible(true);
        tp.setSelectedIndex(0);
    }

    private void btnIrACancelacionesClick() {
        tp.setSelectedIndex(1);
    }

    private void btnGuardarEnvioClick() {
        try {
            int codigo = Integer.parseInt(txtNumero.getText());

            // Validación de código único
            if (EnviosServicio.existeCodigo(codigo)) {
                JOptionPane.showMessageDialog(this, 
                    "El código " + codigo + " ya existe. Intente con uno diferente.", 
                    "Código Duplicado", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            String cliente = txtCliente.getText();
            double peso = Double.parseDouble(txtPeso.getText());
            double distancia = Double.parseDouble(txtDistanciaKm.getText());
            TipoEnvio tipo = (TipoEnvio) cmbTipoDeEnvio.getSelectedItem();

            Envio nuevo = null;
            if (tipo == TipoEnvio.TERRESTRE) nuevo = new Terrestre(cliente, codigo, peso, distancia);
            else if (tipo == TipoEnvio.AEREO) nuevo = new Aereo(cliente, codigo, peso, distancia);
            else if (tipo == TipoEnvio.FLUVIAL) nuevo = new Fluvial(cliente, codigo, peso, distancia);

            if (nuevo != null) {
                EnviosServicio.agregar(nuevo);
                EnviosServicio.mostrar(tblEnvio);
                limpiar();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Verifique que el código, peso y distancia sean números.");
        }
    }

    private void btnQuitarClick() {
        try {
            int codigo = Integer.parseInt(txtCodigoRetirar.getText());
            if (EnviosServicio.retirar(codigo)) {
                EnviosServicio.mostrar(tblEnvio);
                txtCodigoRetirar.setText("");
                JOptionPane.showMessageDialog(this, "Envío eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un envío con ese código.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código numérico válido.");
        }
    }

    private void limpiar() {
        txtNumero.setText("");
        txtCliente.setText("");
        txtPeso.setText("");
        txtDistanciaKm.setText("");
        cmbTipoDeEnvio.setSelectedIndex(0);
        pnlEditarEnvio.setVisible(false);
    }
}