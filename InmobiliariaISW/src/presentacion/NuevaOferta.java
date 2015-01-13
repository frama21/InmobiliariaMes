package presentacion;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import excepciones.LogicaExcepcion;
import logica.Controlador;
import logica.Oferta;
import logica.Visita;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NuevaOferta extends JDialog {

	/**
	 * Variables para la clase NuevaOferta
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAsesor;
	private JTextField textFieldPrecio;
	private JTextField textFieldFecha;
	private static Controlador control;
	private  JComboBox<Visita> comboBoxVisitas;
	private JTextField textFieldCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String... args) {
		try {
			NuevaOferta dialog = new NuevaOferta(control);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Inicializacion de los objetos necesarios de la capa de negocio
			private void initDominio() {
				try{
					control = Controlador.dameControlador();
				}catch (Exception e){
					Logger log = Logger.getLogger(NuevaOferta.class.getName());
		        	if (log.isLoggable(Level.FINE))
		        		log.fine(e.getMessage());
				}
			}

	/**
	 * Create the dialog.
	 */
	public NuevaOferta(Controlador control1) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setTitle("Nueva Oferta");
		//Inicializamos el controlador para poder trabajar entre presentacion,l�gica y persistencia.
		initDominio();
		
		setTitle("Nueva Oferta");
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(217, 10, 0, 2);
			contentPanel.add(separator);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 65, 434, 2);
		contentPanel.add(separator);
		
		textFieldAsesor = new JTextField();
		textFieldAsesor.setColumns(10);
		textFieldAsesor.setBounds(78, 34, 139, 20);
		contentPanel.add(textFieldAsesor);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Cuando pongamos la id del asesor apareceran sus visitas asociadas.
				String ase = textFieldAsesor.getText();
				
				//Cada vez que pulsas ok se borrar�n todos los datos cargados en el combobox.
				comboBoxVisitas.removeAllItems();
				
				try{
					
					java.util.List<Visita> visitas = control.encontrarVisitas();
						
					
					//Incluye solo las visitas asociadas a ese Asesor.
					for(int i=0; i<visitas.size(); i++) {
						
						if(visitas.get(i).getAsesor().getCodigoEmp().trim().equals(ase)) {
							
					
							comboBoxVisitas.addItem(visitas.get(i));
							}
					
						
					}//Fin primer for.
					
				} catch (LogicaExcepcion e2) {
					e2.printStackTrace();
				}
			}
		});
		button.setActionCommand("OK");
		button.setBounds(227, 33, 57, 23);
		contentPanel.add(button);
		
		JLabel label = new JLabel("Introduce el C\u00F3digo del Asesor:");
		label.setBounds(78, 9, 176, 14);
		contentPanel.add(label);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(78, 90, 139, 20);
		contentPanel.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(78, 121, 139, 20);
		contentPanel.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		comboBoxVisitas = new JComboBox<Visita>();
		comboBoxVisitas.setBounds(78, 189, 163, 17);
		contentPanel.add(comboBoxVisitas);
		
		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(10, 93, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel fechaLabel = new JLabel("Fecha:");
		fechaLabel.setBounds(10, 124, 46, 14);
		contentPanel.add(fechaLabel);
		
		JLabel visitasLabel = new JLabel("Visitas:");
		visitasLabel.setBounds(10, 190, 46, 14);
		contentPanel.add(visitasLabel);
		
		JLabel lblVisitasAsociadasAl = new JLabel("Visitas asociadas al Asesor.");
		lblVisitasAsociadasAl.setBounds(246, 190, 178, 14);
		contentPanel.add(lblVisitasAsociadasAl);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 152, 46, 14);
		contentPanel.add(lblCdigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(78, 152, 139, 20);
		contentPanel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						//Se crear� la Oferta en la base de datos
						Oferta vi = new Oferta (textFieldCodigo.getText(),
								textFieldPrecio.getText(), 
								textFieldFecha.getText(),
								(Visita)comboBoxVisitas.getSelectedItem());
						
						
						try{
							
							//Antes de crearse la Oferta pregunta si estamos seguros o no.
							Object[] textoOpciones = {"Si Quiero", "Ahora no"};

							int opcion = JOptionPane.showOptionDialog(null,"� Desea realizar la operacion ahora ?",
									"Mensaje de confirmacion",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null, //utilizar el icono predeterminado
									textoOpciones,
									textoOpciones[0]); //boton predeterminado
							
							//Si el boton elegido es "Si quiero" (posicion 0 del array) lo crea.
							if(opcion==0) {
							control.crearOferta(vi); //Se crea la Oferta en la base de datos.
							
							JOptionPane.showMessageDialog(null, "Oferta Creada Correctamente","OFERTA",
									JOptionPane.DEFAULT_OPTION);
							}

						} catch(Exception e1){
							JOptionPane.showMessageDialog(null, e1.getMessage(),"ERROR AL CREAR",
									JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//Cierra la ventana de crear Oferta.
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}//Fin de la clase CrearOferta.
