package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
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

import logica.Controlador;
import logica.Inmueble;
import logica.NaveIndustrial;

import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class ConsultarNaveIndustrial extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Controlador control;
	private JTable tableInmueble;
	int filas=0;

	/**
	 * Launch the application.
	 */
	public static void main(String... args) {
		try {
			ConsultarNaveIndustrial dialog = new ConsultarNaveIndustrial(control);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Inicializaci�n de los objetos necesarios de la capa de negocio
	private void initDominio() {
		try{
			control = Controlador.dameControlador();
		}catch (Exception e){
			Logger log = Logger.getLogger(ConsultarNaveIndustrial.class.getName());
        	if (log.isLoggable(Level.FINE))
        		log.fine(e.getMessage());
		}
	}


	/**
	 * Create the dialog.
	 */
	public ConsultarNaveIndustrial(Controlador control1) {
		setBackground(new Color(255, 255, 255));

		//M�todo que inicializa el controlador.
		initDominio();

		setBounds(100, 100, 900, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Consultar NavesIndustriales");
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setLocation(10, 11);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


			scrollPane.setSize(864,396);


			contentPanel.add(scrollPane);
			{
				tableInmueble = new JTable(new DefaultTableModel());
				tableInmueble.setFont(new Font("Tahoma", Font.BOLD, 11));
				scrollPane.setViewportView(tableInmueble);
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
						//Cierra la ventana de crear NaveIndustrial.
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	//Se invoca desde fuera de �sta clase.
	public void cargaNaves() {
		try{
			ArrayList<Inmueble> listaInmuebles = (ArrayList<Inmueble>) control.encontrarInmuebles();


			ArrayList<NaveIndustrial> listaNaves = (ArrayList<NaveIndustrial>) control.encontrarNaveIndustrial();
			Iterator<NaveIndustrial> it1 = listaNaves.iterator();


			//Objeto Piso que utilizaremos para a�adir el numero de habitaciones de cada uno.
			NaveIndustrial in1;

			//Modelo por defecto que a�adiremos a nuestra tabla.
			DefaultTableModel model = (DefaultTableModel) tableInmueble.getModel();

			//A�adimos las columnas a la tabla.
			model.addColumn("Codigo");
			model.addColumn("Num.Puertas");
			model.addColumn("Puntuacion");
			model.addColumn("Direccion");
			model.addColumn("Localidad");
			model.addColumn("Fecha de Alta");
			model.addColumn("Superficie");
			model.addColumn("Venta/Alquiler");
			model.addColumn("Propietario");
			model.addColumn("Asesor");


			//Incluye solo los inmuebles que tienen un piso asociado.
			for(int i=0; i<listaInmuebles.size(); i++) {
				for(int j = 0; j<listaNaves.size(); j++) {

					//El trim() lo uso para eliminar espacios y que se puedan comparar los strings.
					if(listaInmuebles.get(i).getCodId().trim().equals(listaNaves.get(j).getCodId().trim())) {

						Object nuevo[]= {listaInmuebles.get(i).getCodId(), "","", listaInmuebles.get(i).getCalle(), listaInmuebles.get(i).getLocalidad(), listaInmuebles.get(i).getFechaAlta(),
								listaInmuebles.get(i).getSuperficieTotal(), listaInmuebles.get(i).getVentaAlquiler(),
								listaInmuebles.get(i).getCliente(), listaInmuebles.get(i).getAsesor()};

						model.addRow(nuevo);

					}
				}
			}



			//Para incluir la fila de las Naves.
			int fila = 0;
			while(it1.hasNext()) {
				in1 = it1.next();

				//Pone el valor de la NaveIndustrial en la fila n y columna 1.
				model.setValueAt(in1.getNumPuertas(), fila, 1);
				model.setValueAt(in1.getCalificacion(),fila,2);
				
				fila++;
			}


		}catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR AL MOSTRAR",JOptionPane.ERROR_MESSAGE);
		}
	}
}//Fin de la clase ConsultaInmueblesJDialog.

