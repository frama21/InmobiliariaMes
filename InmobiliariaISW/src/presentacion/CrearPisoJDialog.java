package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import excepciones.LogicaExcepcion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Asesor;
import logica.Cliente;
import logica.Controlador;
import logica.Piso;

import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;


public class CrearPisoJDialog extends JDialog {


	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCodigo;
	private JTextField textFieldDireccion;
	private JTextField textFieldLocalidad;
	private JTextField textFieldFecha;
	private JTextField textFieldSuperficie;
	private JTextField textFieldNumHabit;
	private static Controlador control;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JComboBox<Asesor> comboBoxAsesor;
	private final JComboBox<Cliente> comboBoxPropietario;
	private final JRadioButton rdbtnVenta;
	private JButton okButtonCrear;
	private JRadioButton rdbtnAlquiler;


	/**
	 * Launch the application.
	 */
	public static void main(String... args) {
		try {
			CrearPisoJDialog dialog = new CrearPisoJDialog(control);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean selected(){
		if(rdbtnAlquiler.isSelected() || rdbtnVenta.isSelected()) return true;
		return false;
		
	}
	
	public void setCampos(String cod, String calle, String locali, String fecha, String superf, String vOa, String hab){
		
		textFieldCodigo.setText(cod);
		textFieldDireccion.setText(calle);
		textFieldLocalidad.setText(locali);
		textFieldFecha.setText(fecha);
		textFieldSuperficie.setText(superf);
		textFieldNumHabit.setText(hab);
		
		//comboBoxAsesor.setSelectedIndex(0);
		//comboBoxPropietario.setSelectedIndex(0);
	}
	
	public void setCampos(Piso piso){
		textFieldCodigo.setText(piso.getCodId());
		textFieldDireccion.setText(piso.getCalle());
		textFieldLocalidad.setText(piso.getLocalidad());
		textFieldFecha.setText(piso.getFechaAlta());
		textFieldSuperficie.setText(piso.getSuperficieTotal());
		textFieldNumHabit.setText(piso.getNumHabitaciones());
		
		setOpVenta(true);
		
	}
	
	public void crearAsesorCliente(Asesor asesor, Cliente cliente){
		try {
			control.crearAsesor(asesor);
			control.crearCliente(cliente);
		} catch (LogicaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comboBoxAsesor.addItem(asesor);
		comboBoxPropietario.addItem(cliente);
		
	}
	
	public void setOpVenta(boolean seleccion){
				rdbtnVenta.setSelected(seleccion);
	}
	
	//C�digo que se ejecuta cuando se pulsa el bot�n ok. PAU
	public void botonOk(){
		okButtonCrear.doClick();
	}
	
	//Inicializacion de los objetos necesarios de la capa de negocio
	private void initDominio() {
		try{
			control = Controlador.dameControlador();
		}catch (Exception e){
			Logger log = Logger.getLogger(CrearPisoJDialog.class.getName());
        	if (log.isLoggable(Level.FINE))
        		log.fine(e.getMessage());
		}
	}

	/**
	 * Create the dialog.
	 * @param control1 
	 */
	public CrearPisoJDialog(Controlador control1) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Crear Piso");
		//Inicializamos el controlador para poder trabajar entre presentacion,l�gica y persistencia.
		initDominio();

		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNewLabel);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(84, 9, 86, 17);
		contentPanel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		JLabel direccionLabel = new JLabel("Direcci\u00F3n:");
		direccionLabel.setBounds(10, 35, 65, 14);
		contentPanel.add(direccionLabel);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(84, 33, 340, 17);
		contentPanel.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);

		JLabel localidadLabel = new JLabel("Localidad:");
		localidadLabel.setBounds(10, 58, 65, 14);
		contentPanel.add(localidadLabel);

		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setBounds(84, 56, 340, 17);
		contentPanel.add(textFieldLocalidad);
		textFieldLocalidad.setColumns(10);

		JLabel fechaLabel = new JLabel("Fecha:");
		fechaLabel.setBounds(10, 86, 46, 14);
		contentPanel.add(fechaLabel);

		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(84, 84, 86, 17);
		contentPanel.add(textFieldFecha);
		textFieldFecha.setColumns(10);

		JLabel superficieLabel = new JLabel("Superficie:");
		superficieLabel.setBounds(10, 111, 65, 14);
		contentPanel.add(superficieLabel);

		JLabel lblNmero = new JLabel("N\u00FAm.Habit:");
		lblNmero.setBounds(10, 136, 65, 14);
		contentPanel.add(lblNmero);

		JLabel lblPropietario = new JLabel("Propietario:");
		lblPropietario.setBounds(10, 161, 75, 14);
		contentPanel.add(lblPropietario);

		JLabel lblAsesor = new JLabel("Asesor:");
		lblAsesor.setBounds(10, 182, 46, 14);
		contentPanel.add(lblAsesor);

		textFieldSuperficie = new JTextField();
		textFieldSuperficie.setBounds(84, 109, 86, 17);
		contentPanel.add(textFieldSuperficie);
		textFieldSuperficie.setColumns(10);

		textFieldNumHabit = new JTextField();
		textFieldNumHabit.setBounds(84, 134, 86, 17);
		contentPanel.add(textFieldNumHabit);
		textFieldNumHabit.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(281, 125, 131, 76);
		contentPanel.add(panel);
		panel.setLayout(null);
		
				rdbtnVenta = new JRadioButton("Venta");
				buttonGroup.add(rdbtnVenta);
				rdbtnVenta.setBounds(6, 20, 109, 23);
				panel.add(rdbtnVenta);
				
						rdbtnAlquiler = new JRadioButton("Alquiler");
						buttonGroup.add(rdbtnAlquiler);
						rdbtnAlquiler.setBounds(6, 46, 109, 23);
						panel.add(rdbtnAlquiler);

		//ComboBox que lista los clientes en la base de datos por su nombre.
		comboBoxPropietario = new JComboBox<Cliente>();
		comboBoxPropietario.setBounds(84, 160, 163, 17);

		try {
			java.util.List<Cliente> clientes= control.encontrarCliente();

			for(int i=0;i<clientes.size();i++){
				comboBoxPropietario.addItem(clientes.get(i));

			}
		} catch (LogicaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		



		contentPanel.add(comboBoxPropietario);

		//Combobox que lista los Asesores en la base de datos por su nombre.
		comboBoxAsesor = new JComboBox<Asesor>();
		comboBoxAsesor.setBounds(84, 181, 163, 17);
		try {
			java.util.List<Asesor> asesores= control.encontrarAsesores();

			for(int i=0;i<asesores.size();i++){
				comboBoxAsesor.addItem(asesores.get(i));

			}
		} catch (LogicaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//comboBoxAsesor.setModel(new DefaultComboBoxModel());

		contentPanel.add(comboBoxAsesor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButtonCrear = new JButton("Crear");  //Boton crear
				okButtonCrear.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent actionListener) { //Asociamos el ActionEvent al boton crear.

						//Creamos la instancia de la clase Piso.
						String va = "";
						if (rdbtnVenta.isSelected()) va = "V";
						else if (rdbtnAlquiler.isSelected()) va="A";
						else {
							if(getContentPane().isVisible())
								JOptionPane.showMessageDialog(null, "Debe seleccionar si es una venta o un alquiler","NAVEINDUSTRIAL",
										JOptionPane.DEFAULT_OPTION);
						}
						Piso pi = new Piso(textFieldCodigo.getText(),
								textFieldDireccion.getText(),
								textFieldLocalidad.getText(),
								textFieldFecha.getText(),
								textFieldSuperficie.getText(),
								va,
								textFieldNumHabit.getText(),
								(Asesor)comboBoxAsesor.getSelectedItem(),
								(Cliente)comboBoxPropietario.getSelectedItem());

						//	pi.setAsesor((Asesor)comboBoxAsesor.getSelectedItem());
						//	pi.setCliente((Cliente)comboBoxPropietario.getSelectedItem());
						try{
							
							//Antes de crearse el Piso pregunta si estamos seguros o no.
							Object[] textoOpciones = {"Si, Quiero Crearla", "Ahora no"};
							
							int opcion = 0;
							if(getContentPane().isVisible()){
								
								opcion = JOptionPane.showOptionDialog(null,"� Desea realizar la operacion ahora ?",
										"Mensaje de confirmacion",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE,
										null, //utilizar el icono predeterminado
										textoOpciones,
										textoOpciones[0]); //boton predeterminado
							}
							//Si el boton elegido es "Si quiero" (posicion 0 del array) lo crea.
							if(opcion == 0) {
								if(!pi.getCodId().equals("")) {
							control.crearPiso(pi);
							
							if(getContentPane().isVisible())
								JOptionPane.showMessageDialog(null, "Piso Creado Correctamente","PISO",
									JOptionPane.DEFAULT_OPTION);
								} else {
									if(getContentPane().isVisible())
										JOptionPane.showMessageDialog(null, "Necesario un c�digo de identificaci�n","PISO",
										JOptionPane.DEFAULT_OPTION);}
							}

						} catch(Exception e){
							if(getContentPane().isVisible())
								JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR AL CREAR",
									JOptionPane.ERROR_MESSAGE);
						}
						
					}

				});

				okButtonCrear.setActionCommand("OK");
				buttonPane.add(okButtonCrear);
				getRootPane().setDefaultButton(okButtonCrear);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Quita el jdialog.
						setVisible(false);

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}//Fin de la clase.
