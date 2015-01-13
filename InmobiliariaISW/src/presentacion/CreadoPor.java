package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;


public class CreadoPor extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String... args) {
		try {
			CreadoPor dialog = new CreadoPor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreadoPor() {
		setTitle("Creado Por");
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnAplicacinCreadaPor = new JTextPane();
			txtpnAplicacinCreadaPor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
			txtpnAplicacinCreadaPor.setEditable(false);
			txtpnAplicacinCreadaPor.setBackground(Color.WHITE);
			txtpnAplicacinCreadaPor.setBounds(54, 22, 319, 115);
			txtpnAplicacinCreadaPor.setText("Aplicaci\u00F3n creada por:\n Samuel Villaescusa Vinader(savilvi@inf.upv.es)\n Borja Galiana Torr� (borgator@inf.upv.es)\n �lvaro Pardo Alcal�(lvaparal@ei.upv.es)\n Aitor Suarez Arambarri(Aisuar@inf.upv.es)");
			
			
			contentPanel.add(txtpnAplicacinCreadaPor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Volver");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Cierra la ventana de crear asesor.
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
