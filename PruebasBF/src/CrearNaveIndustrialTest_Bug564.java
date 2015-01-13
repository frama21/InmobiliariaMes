import static org.junit.Assert.*;

import java.util.List;

import logica.Asesor;
import logica.Cliente;
import logica.Controlador;
import logica.NaveIndustrial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistencia.ConnectionManager;
import presentacion.CrearNaveIndustrial;
import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;


/**
 * @author Fran Martí
 * 
 * Campo de número de puertas
 */

public class CrearNaveIndustrialTest_Bug564 {
	
    String numPuertas;
    Controlador controlador;
    Cliente cli;
    Asesor ase;
    NaveIndustrial nv;
    CrearNaveIndustrial nave;
    List <NaveIndustrial> navesIndustriales;
    
    
    @Before
    public void inicializar() {
    	
    	numPuertas = "qwe";
    	    	
    	controlador = Controlador.dameControlador();
    	nave = new CrearNaveIndustrial(controlador);
    	
    	cli = new Cliente("125", "Juan","ape");
    	ase = new Asesor("12356", "Asesor 12");
    	nv = new NaveIndustrial("111","calle","localidad", "10/01/2013", "200", "venta", numPuertas, "20", ase, cli);
		
    	
    	nave.crearAsesorCliente(ase, cli);
    	nave.setCampos(nv);
    	nave.getContentPane().setVisible(false);
    	
    	
    }

	@Test
	public void testCrearNaveIndustrial() {
		
		//Es necesario insertar el cliente y el asesor en la BBDD para poder crear la NV
		
		nave.botonOk();
		try {
			navesIndustriales = controlador.encontrarNaveIndustrial();
			for (int i = 0; i < navesIndustriales.size(); i++){
				assertFalse("La nave industrial no debería de haberse creado", 
						navesIndustriales.get(i).getCodId().equals(nv.getCodId()));
			}
		} catch (LogicaExcepcion e) {
			// TODO Auto-generated catch block
			fail("Fallo al recoger las naves industriales");
		}
	}
	
	@After
    public void after(){
    	try{
    		ConnectionManager connManager = new ConnectionManager("practicaFinal");
            connManager.connect();
            
            connManager.updateDB("delete from NAVEINDUSTRIAL where num_puertas='" + nv.getNumPuertas() + "'");
            connManager.updateDB("delete from INMUEBLE where COD_ID='" + nv.getCodId() + "'");
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
