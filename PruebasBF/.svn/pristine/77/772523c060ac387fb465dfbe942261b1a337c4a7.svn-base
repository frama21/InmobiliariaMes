import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import persistencia.ConnectionManager;
import presentacion.CrearCliente;
import logica.Cliente;
import logica.Controlador;



/**
 * @author Fran Martí
 * 
 * Crear cliente con los campos vacíos
 * 
 */

public class CrearClienteTest_Bug535 {

	Controlador controlador;
    ConnectionManager conexion;
    String nif;
    String nombre;
    String apellidos;
    CrearCliente cli;
    Cliente cliente, clienteCreado;
    
    
    @Before
    public void inicializar() {
    	nif="";
    	nombre="";
    	apellidos=""; 
    	
    	controlador = Controlador.dameControlador();
        cli = new CrearCliente(controlador);
        
        cliente = new Cliente(nif, nombre, apellidos);
        
        cli.setCampos(cliente);
        cli.getContentPane().setVisible(false);
        
    }
    
    @Test
    public void testCrearCliente() {
    	cli.botonOk();
		try {
			clienteCreado = controlador.encontrarClientePorCod(cliente.getNif());
			assertNull("El cliente no debería de haberse creado",clienteCreado);			
			
		} catch (LogicaExcepcion e) {
			// TODO Auto-generated catch block
			fail("Fallo al recoger el cliente");
		}
    }
    
    @After
    public void after(){
    	try{
    		ConnectionManager connManager = new ConnectionManager("practicaFinal");
            connManager.connect();
            
            connManager.updateDB("delete from cliente where nif_cliente='" + cliente.getNif() + "'");
            
            connManager.close();
    	}
    	catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    	
    	catch(DAOExcepcion ex){
    		ex.printStackTrace();    		
    	}
    }

}
