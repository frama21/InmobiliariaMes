package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

import excepciones.LogicaExcepcion;
import logica.Asesor;
import logica.Cliente;
import logica.Controlador;
import logica.Inmueble;
import logica.Visita;

public class NuevaVisita extends JDialog {

    /**
     * Atributos de la clase y Variables.
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldAse;
    private JTextField textFieldFecha;
    private static Controlador control;
    private JComboBox<Cliente> comboBoxCliente;
    private JComboBox<Inmueble> comboBoxInmuebles;
    private JTextField textFieldCodigo;
    private JButton btnCrear;
    private JButton okButton;
    
    /**
     * Launch the application.
     */
    public static void main(String... args) {
        try {
            NuevaVisita dialog = new NuevaVisita(control);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFecha(String fecha) {
        textFieldFecha.setText(fecha);
    }
    
    public void setCodigoVisita(String codigo) {
        textFieldCodigo.setText(codigo);
    }

    public void setCampos(Visita v){
    	textFieldAse.setText(v.getAsesor().getCodigoEmp());
    	textFieldCodigo.setText(v.getCod());
    	textFieldFecha.setText(v.getFecha());
    }
    
    // Simula un clic sobre el bot�n [Ok]
    public void clickBtnOk() {
        okButton.doClick();
    }
    
    // Simula un clic sobre el bot�n [Crear]
    public void clickBtnCrear() {
        btnCrear.doClick();
    }

    //Inicializacion de los objetos necesarios de la capa de negocio
    private void initDominio() {
        try {
            control = Controlador.dameControlador();
        } catch (Exception e) {
        	Logger log = Logger.getLogger(NuevaVisita.class.getName());
        	if (log.isLoggable(Level.FINE))
        		log.fine(e.getMessage());
        }
    }

    /**
     * Create the dialog.
     */
    public NuevaVisita(Controlador control1) {
        setBounds(100, 100, 467, 300);
        getContentPane().setLayout(new BorderLayout());
        setTitle("Nueva Visita");
        //Inicializamos el controlador para poder trabajar entre presentacion,l�gica y persistencia.
        initDominio();

        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            okButton = new JButton("OK");
            okButton.setBounds(236, 37, 57, 23);
            contentPanel.add(okButton);
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    //Una vez se introduce el ID del Asesor, aparecen todos los datos.
                    String ase = textFieldAse.getText();

                    //Cada vez que pulsas ok se borrar�n todos los datos cargados en el combobox.
                    comboBoxInmuebles.removeAllItems();

                    //Se crea la lista de clientes.
                    try {
                        java.util.List<Cliente> clientes = control.encontrarCliente();

                        for (int i = 0; i < clientes.size(); i++) {
                            comboBoxCliente.addItem(clientes.get(i));

                        }
                    } catch (LogicaExcepcion e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }	//fin lista clientes.	

					//Se crea la lista de Inmuebles por Asesor.
                    try {

                        java.util.List<Inmueble> inmuebles = control.encontrarInmuebles();

                        //Incluye solo los inmuebles asociados a ese Asesor.
                        for (int i = 0; i < inmuebles.size(); i++) {

                            if (inmuebles.get(i).getAsesor().getCodigoEmp().trim().equals(ase)) {

                                comboBoxInmuebles.addItem(inmuebles.get(i));
                            }

                        }//Fin primer for.

                    } catch (LogicaExcepcion e2) {
                        e2.printStackTrace();
                    }

                }//Fin del action.

            });

            okButton.setActionCommand("OK");
            getRootPane().setDefaultButton(okButton);
        }

        textFieldAse = new JTextField();
        textFieldAse.setBounds(87, 38, 139, 20);
        contentPanel.add(textFieldAse);
        textFieldAse.setColumns(10);

        JLabel lblIntroduceElCdigo = new JLabel("Introduce el C\u00F3digo del Asesor:");
        lblIntroduceElCdigo.setBounds(87, 12, 176, 14);
        contentPanel.add(lblIntroduceElCdigo);

        JSeparator separator = new JSeparator();
        separator.setBounds(158, 124, 57, -5);
        contentPanel.add(separator);

        JSeparator separador = new JSeparator();
        separador.setBounds(0, 73, 434, 2);
        contentPanel.add(separador);

        textFieldFecha = new JTextField();
        textFieldFecha.setBounds(87, 98, 86, 20);
        contentPanel.add(textFieldFecha);
        textFieldFecha.setColumns(10);

        comboBoxCliente = new JComboBox<Cliente>();
        comboBoxCliente.setBounds(87, 164, 163, 17);
        contentPanel.add(comboBoxCliente);

        comboBoxInmuebles = new JComboBox<Inmueble>();
        comboBoxInmuebles.setBounds(87, 192, 163, 17);
        contentPanel.add(comboBoxInmuebles);

        JLabel lblNewLabel = new JLabel("Cliente:");
        lblNewLabel.setBounds(10, 168, 46, 14);
        contentPanel.add(lblNewLabel);

        JLabel lblInmuebles = new JLabel("Inmuebles:");
        lblInmuebles.setBounds(10, 193, 67, 14);
        contentPanel.add(lblInmuebles);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(10, 101, 46, 14);
        contentPanel.add(lblFecha);

        JLabel lblInmueblesAsociadosAl = new JLabel("Inmuebles asociados al asesor.");
        lblInmueblesAsociadosAl.setBounds(262, 193, 182, 14);
        contentPanel.add(lblInmueblesAsociadosAl);

        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(87, 124, 86, 20);
        contentPanel.add(textFieldCodigo);
        textFieldCodigo.setColumns(10);

        JLabel lblCdigo = new JLabel("C\u00F3digo:");
        lblCdigo.setBounds(10, 127, 46, 14);
        contentPanel.add(lblCdigo);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {

                        //Cierra la ventana de crear asesor.
                        setVisible(false);
                    }
                });
                {
                    //JButton btnCrear = new JButton("Crear");
                    btnCrear = new JButton("Crear");
                    btnCrear.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {

                            Asesor aseso = null;
                            try {
                                aseso = control.encontrarAsesorPorCod(textFieldAse.getText());
                            } catch (LogicaExcepcion e2) {
                                // TODO Auto-generated catch block
                                e2.printStackTrace();
                            }

                            //Se crear� la visita 
                            Visita vi = new Visita(textFieldCodigo.getText(),
                                    textFieldFecha.getText(),
                                    (Inmueble) comboBoxInmuebles.getSelectedItem(),
                                    aseso,
                                    (Cliente) comboBoxCliente.getSelectedItem());

                            try {

                                //Antes de crearse la Visita pregunta si estamos seguros o no.
                                Object[] textoOpciones = {"Si Quiero", "Ahora no"};

                                int opcion = 0;
                                if(getContentPane().isVisible()){
                                    opcion = JOptionPane.showOptionDialog(null, "� Desea realizar la operacion ahora ?",
                                            "Mensaje de confirmacion",
                                            JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null, //utilizar el icono predeterminado
                                            textoOpciones,
                                            textoOpciones[0]); //boton predeterminado
                                }
                                //Si el boton elegido es "Si quiero" (posicion 0 del array) lo crea.
                                if (opcion == 0) {
                                    //Creamos la Visita y la a�adimos al array de los Inmuebles y sus visitas.
                                    control.crearVisita(vi);

                                    if(getContentPane().isVisible()) JOptionPane.showMessageDialog(null, "Visita Creada Correctamente", "VISITA",
                                            JOptionPane.DEFAULT_OPTION);
                                }

                            } catch (Exception e1) {
                                if(getContentPane().isVisible()) JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR AL CREAR",
                                        JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    });
                    buttonPane.add(btnCrear);
                }
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }//Final de NuevaVisita

}//Final de la clase
