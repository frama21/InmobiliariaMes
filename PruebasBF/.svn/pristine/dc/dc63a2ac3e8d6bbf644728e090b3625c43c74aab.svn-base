import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import logica.Asesor;
import logica.Controlador;
import persistencia.ConnectionManager;
import presentacion.CrearAsesor;



/**
 * @author Pau Alario
 * 
 * longitud de los campos mayor a 15
 */

public class CrearAsesorTest_Bug596 {
	Controlador controlador;
    ConnectionManager conexion;
    String cod;
    String nombre;
    CrearAsesor asesor;
    List <Asesor> asesores;
	

    @Before
    public void inicializar() {
    	controlador = Controlador.dameControlador();
        asesor = new CrearAsesor(controlador);
        cod="11111222223333344444";
        nombre="aaaaabbbbbcccccddddd";
        asesor.setCampos(cod,nombre);
        asesor.getContentPane().setVisible(false);
        
    }
    
    @Test
    public void test() {
            asesor.botonOk();
			try {
				asesores = controlador.encontrarAsesores();
				for (int i = 0; i < asesores.size(); i++){
					assertFalse("El piso no debería de haberse creado", 
							asesores.get(i).getCodigoEmp().equals(""));
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