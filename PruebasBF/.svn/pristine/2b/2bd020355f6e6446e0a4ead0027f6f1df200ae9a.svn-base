import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import logica.Asesor;
import logica.Cliente;
import logica.Controlador;
import logica.Piso;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistencia.ConnectionManager;
import presentacion.CrearPisoJDialog;
import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;

/**
 * @author Pau Alario
 * 
 * Crear Piso campo habitaciones negativo
 */

public class CrearPisoJDialogTest_Bug530 {
	String numHab;
	Controlador controlador;
	CrearPisoJDialog piso;
	Cliente cli;
	Asesor ase;
	Piso pi;
    List <Piso> pisos;
	
	 @Before
	    public void inicializar() {
		 	controlador = Controlador.dameControlador();
		 	numHab = "-1";
		 	
		 	cli = new Cliente("125", "Juan","ape");
	    	ase = new Asesor("12356", "Asesor 12");
            
            pi = new Piso("12","calle","localidaddd", "01/01/2013", "100", "V", numHab, ase,cli);
            try{
    			controlador.crearAsesor(ase);
    			controlador.crearCliente(cli);
            }
        	catch(LogicaExcepcion e){}
            
    		 	piso = new CrearPisoJDialog(controlador);
    			piso.setCampos("12","calle","localidaddd", "01/01/2013", "100", "V", numHab);
    			piso.setOpVenta(true);
    			piso.getContentPane().setVisible(false);
	    }

	@Test
	public void testCrearPisoJDialog() {
			piso.botonOk();
			try {
				pisos = controlador.encontrarPisos();
				for (int i = 0; i < pisos.size(); i++){
					assertFalse("El piso no debería de haberse creado con campo habitaciones negativo", 
							pisos.get(i).getCodId().equals(""));
				}
			} catch (LogicaExcepcion e) {
				// TODO Auto-generated catch block
				fail("Fallo al recoger los Pisos");
			}
    	
		/*try{
			superficie = Integer.parseInt(piso.getSuperficie_total());
			assertTrue("El número no es positivo", superficie>=0);
		}
		catch(NumberFormatException e){
			fail("Debes de introducir un valor numérico");
		}*/
		
	}
	
	@After
    public void after(){
    	try{
    		ConnectionManager connManager = new ConnectionManager("practicaFinal");
            connManager.connect();
            
            connManager.updateDB("delete from PISO where COD_ID='" + pi.getCodId() + "'");
            connManager.updateDB("delete from INMUEBLE where COD_ID='" + pi.getCodId() + "'");
            connManager.updateDB("delete from ASESOR where CODIGO_EMPLEADO='" + ase.getCodigoEmp()+ "'");
            connManager.updateDB("delete from CLIENTE where NIF_CLIENTE='" + cli.getNif() + "'");
            
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
