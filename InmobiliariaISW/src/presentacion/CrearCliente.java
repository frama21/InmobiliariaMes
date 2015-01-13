package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JTextField;

import logica.Cliente;
import logica.Controlador;

public class CrearCliente extends JDialog {

	
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textNif;
	private JTextField textNombreCli;
	private JTextField textApellidosCli;
	private static Controlador control;
	private JButton okButton;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String... args) {
		try {
			CrearCliente dialog = new CrearCliente(control);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//M�todo para asignar valores a los campos de la interfaz
	public void setCampos(Cliente cliente){
		textNif.setText(cliente.getNif());
		textNombreCli.setText(cliente.getNombre());
		textApellidosCli.setText(cliente.getApellidos());
	}
	
	
	//C�digo que se ejecuta cuando se pulsa el bot�n ok
	public void botonOk(){
		okButton.doClick();
	}
		
	
	
	
	//Inicializaci�n de los objetos necesarios de la capa de negocio
			private void initDominio() {
				try{
					control = Controlador.dameControlador();
				}catch (Exception e){
					Logger log = Logger.getLogger(CrearCliente.class.getName());
		        	if (log.isLoggable(Level.FINE))
		        		log.fine(e.getMessage());
				}
			}

	/**
	 * Create the dialog.
	 */
	public CrearCliente(Controlador control2) {
		
		//Inicializamos el controlador
		initDominio();
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nif_Cliente:");
			lblNewLabel.setBounds(50, 44, 70, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textNif = new JTextField();
			textNif.setBounds(144, 41, 135, 20);
			contentPanel.add(textNif);
			textNif.setColumns(10);
		}
		{
			JLabel nombreLabel = new JLabel("Nombre:");
			nombreLabel.setBounds(50, 91, 70, 14);
			contentPanel.add(nombreLabel);
		}
		{
			JLabel apellidosLabel = new JLabel("Apellidos:");
			apellidosLabel.setBounds(50, 143, 70, 14);
			contentPanel.add(apellidosLabel);
		}
		{
			textNombreCli = new JTextField();
			textNombreCli.setBounds(144, 88, 135, 20);
			contentPanel.add(textNombreCli);
			textNombreCli.setColumns(10);
		}
		{
			textApellidosCli = new JTextField();
			textApellidosCli.setBounds(144, 140, 135, 20);
			contentPanel.add(textApellidosCli);
			textApellidosCli.setColumns(10);
		}
		//Titulo del JDialog.
				setTitle("Crear un Cliente"); 
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					//Action para crear un Cliente en la base de datos.
					public void actionPerformed(ActionEvent e) {
						
						Cliente pi = new Cliente(textNif.getText(),
									textNombreCli.getText(),
									textApellidosCli.getText());
							
							try{
								
								//Antes de crearse el Cliente pregunta si estamos seguros o no.
								Object[] textoOpciones = {"Si Quiero", "Ahora no"};
								
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
								control.crearCliente(pi);
								if(getContentPane().isVisible())
									JOptionPane.showMessageDialog(null, "Cliente Creado Correctamente","CLIENTE",
										JOptionPane.DEFAULT_OPTION);
								}
								
							} catch(Exception es){
								if(getContentPane().isVisible())
									JOptionPane.showMessageDialog(null, es.getMessage(),"ERROR AL CREAR",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Cierra la ventana de crear cliente.
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}//Fin de la clase.
