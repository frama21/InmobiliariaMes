import static org.junit.Assert.assertFalse;
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
 * @author Fran Martí
 * 
 * Crear Piso campo superficie total
 */

public class CrearPisoJDialogTest_Bug532 {
	String supTotal;
	Controlador controlador;
	CrearPisoJDialog piso;
	Cliente cli;
	Asesor ase;
	Piso pi;
	List <Piso> pisos;
	
	 @Before
	    public void inicializar() {
		 	controlador = Controlador.dameControlador();
		 	piso = new CrearPisoJDialog(controlador);
		 	
		 	supTotal = "asd";
		 	
		 	cli = new Cliente("125", "Juan","ape");
	    	ase = new Asesor("12356", "Asesor 12");            
            pi = new Piso("12","calle","localidaddd", "10/10/2311", supTotal, "V", "2", ase,cli);
            
            piso.crearAsesorCliente(ase, cli);
            piso.setCampos(pi);
            piso.getContentPane().setVisible(false);
		 	
	    }

	@Test
	public void testCrearPisoJDialog() {
		
		piso.botonOk();
		try {
			pisos = controlador.encontrarPisos();
			for (int i = 0; i < pisos.size(); i++){
				assertFalse("El piso no debería de haberse creado", 
						pisos.get(i).getCodId().equals(pi.getCodId()));
			}
		} catch (LogicaExcepcion e) {
			// TODO Auto-generated catch block
			fail("Fallo al recoger los pisos");
		}
		
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
