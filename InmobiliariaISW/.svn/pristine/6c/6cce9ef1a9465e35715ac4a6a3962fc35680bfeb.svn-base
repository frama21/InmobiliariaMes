package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import logica.Asesor;
import logica.Controlador;

import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class ConsultarTodosAsesores extends JDialog {


	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private static Controlador control;
	private JTable tableAsesor;
	int filas=0;

	/**
	 * Launch the application.
	 */
	public static void main(String... args) {
		try {
			ConsultarTodosAsesores dialog = new ConsultarTodosAsesores( control);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Inicialización de los objetos necesarios de la capa de negocio
	private void initDominio() {
		try{
			control = Controlador.dameControlador();
		}catch (Exception e){
			Logger log = Logger.getLogger(ConsultarTodosAsesores.class.getName());
        	if (log.isLoggable(Level.FINE))
        		log.fine(e.getMessage());
		}
	}


	/**
	 * Create the dialog.
	 */
	public ConsultarTodosAsesores(Controlador control1) {
		setBackground(new Color(255, 255, 255));

		//Método que inicializa el controlador.
		initDominio();

		setBounds(100, 100, 500, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Consultar Asesores");
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setLocation(10, 11);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


			scrollPane.setSize(464,507);


			contentPanel.add(scrollPane);
			{
				tableAsesor = new JTable(new DefaultTableModel());
				tableAsesor.setFont(new Font("Tahoma", Font.BOLD, 11));
				scrollPane.setViewportView(tableAsesor);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Volver");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Cierra la ventana de muestra Asesores.
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	//Se invoca desde fuera de ésta clase.
	public void cargaTodosAsesores() {
		try{


			ArrayList<Asesor> listaAsesor = (ArrayList<Asesor>) control.encontrarAsesores();

			//Modelo por defecto que añadiremos a nuestra tabla.
			DefaultTableModel model = (DefaultTableModel) tableAsesor.getModel();

			//Añadimos las columnas a la tabla.
			model.addColumn("Codigo");
			model.addColumn("Nombre");


			//Incluye solo los inmuebles que tienen un piso asociado.
				
				for(int j = 0; j<listaAsesor.size(); j++) {

					

						Object nuevo[]= {listaAsesor.get(j).getCodigoEmp(), listaAsesor.get(j).getNombre()
						};

						model.addRow(nuevo);

					  	
			}
			
			



		}catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR AL MOSTRAR",JOptionPane.ERROR_MESSAGE);
		}
	}
}//Fin de la clase ConsultarAsesores.

