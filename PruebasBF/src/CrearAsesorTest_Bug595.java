import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import logica.Controlador;
import persistencia.ConnectionManager;
import presentacion.CrearAsesor;



/**
 * @author Pau Alario
 * 
 * la ventana no se cierra automaticamente despues de dar de alta un asesor
 */

public class CrearAsesorTest_Bug595 {
	Controlador controlador;
    ConnectionManager conexion;
    String cod;
    String nombre;
    CrearAsesor asesor;
	

    @Before
    public void inicializar() {
    	controlador = Controlador.dameControlador();
        asesor = new CrearAsesor(controlador);
        cod="1111122222";
        nombre="aaaaabbbbb";
        asesor.setCampos(cod,nombre);
        asesor.getContentPane().setVisible(false);
    }
    
    @Test
    public void test() {
    	
        asesor.botonOk();  	
    	assertFalse("La ventana deberia estar cerrada(isVisible==false)",asesor.isVisible());
    	
    }
    
    @After
    public void after(){
    	try{
    		ConnectionManager connManager = new ConnectionManager("practicaFinal");
            connManager.connect();
            
            connManager.updateDB("delete from asesor where CODIGO_EMPLEADO='" + cod + "'");
            
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