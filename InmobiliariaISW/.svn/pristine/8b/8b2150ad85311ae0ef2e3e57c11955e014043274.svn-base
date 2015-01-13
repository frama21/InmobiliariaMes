package presentacion;


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

import logica.Asesor;
import logica.Controlador;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CrearAsesor extends JDialog {


	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private static Controlador control;
	private JTextField codigoEmpTextField;
	private JTextField textNombreEmp;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String... args) {
		try {
			CrearAsesor dialog = new CrearAsesor(control);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Método para asignar valores a los campos de la interfaz
	public void setCampos(String cod, String nombre){
		codigoEmpTextField.setText(cod);
		textNombreEmp.setText(nombre);
	}
	
	//Código que se ejecuta cuando se pulsa el botón crear
	public void botonOk(){
		okButton.doClick();
		
	}

	//Inicializacion de los objetos necesarios de la capa de negocio(en este caso es controlador).
	private void initDominio() {
		try{
			control = Controlador.dameControlador();
		}catch (Exception e){
			Logger log = Logger.getLogger(CrearAsesor.class.getName());
        	if (log.isLoggable(Level.FINE))
        		log.fine(e.getMessage());
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearAsesor(Controlador control1) {
		//Metodo que inicializa el controlador.
		initDominio();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		//Título del JDialog.
		setTitle("Crear un Asesor"); 
		{
			JLabel lblNewLabel = new JLabel("Cod_Empleado:");
			lblNewLabel.setBounds(49, 53, 107, 14);
			contentPanel.add(lblNewLabel);
		}

		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(49, 95, 75, 14);
		contentPanel.add(nombreLabel);

		codigoEmpTextField = new JTextField();
		codigoEmpTextField.setBounds(166, 50, 117, 20);
		contentPanel.add(codigoEmpTextField);
		codigoEmpTextField.setColumns(10);

		textNombreEmp = new JTextField();
		textNombreEmp.setBounds(166, 92, 117, 20);
		contentPanel.add(textNombreEmp);
		textNombreEmp.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					//Action para crear un Asesor en la base de datos.
					public void actionPerformed(ActionEvent actionListener) {

						Asesor pi = new Asesor(codigoEmpTextField.getText(),
								textNombreEmp.getText());

						try{

							//Antes de crearse el Asesor pregunta si estamos seguros o no.
							Object[] textoOpciones = {"Si Quiero", "Ahora no"};
							int opcion =0;
									if(getContentPane().isVisible()){
										opcion = JOptionPane.showOptionDialog(null,"¿ Desea realizar la operacion ahora ?",
									 
										"Mensaje de confirmacion",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE,
										null, //utilizar el icono predeterminado
										textoOpciones,
										textoOpciones[0]); //boton predeterminado
									 }
						
							//Si la opción elegida es "Si Quiero" se crea el asesor, sinos no.
							if(opcion == 0) {
							//Se crea el asesor en la case de datos.
							control.crearAsesor(pi);

							//Dice que se ha creado correctamente.
							if(getContentPane().isVisible())
							JOptionPane.showMessageDialog(null, "Asesor Creado Correctamente","ASESOR",
									JOptionPane.DEFAULT_OPTION);
							}
							
						} catch(Exception e){
							if(getContentPane().isVisible()){
								JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR AL CREAR",
									JOptionPane.ERROR_MESSAGE);
							}
						}
						setVisible(false);
						//dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						//Cierra la ventana de crear asesor.
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}//Fin de Crear Asesor.
