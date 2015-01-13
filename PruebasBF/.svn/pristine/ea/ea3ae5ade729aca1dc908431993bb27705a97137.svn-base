/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;
import logica.Asesor;
import logica.Cliente;
import logica.Controlador;
import logica.Inmueble;
import logica.Visita;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import persistencia.ConnectionManager;
import presentacion.NuevaVisita;

/**
 *
 * @author joseph
 */
public class NuevaVisitaTest_Bug516 {    
    Controlador controlador; 
    Inmueble inmueble;
    Asesor asesor;
    Cliente cliente;
    NuevaVisita nv;  
    Visita visita;
    
    @Before
    public void inicializar() {
        try{
        	controlador = Controlador.dameControlador();
        
	        nv = new NuevaVisita(controlador);
	        
	        cliente = new Cliente("12345678A", "Antonio", "Manostijeras");
	        controlador.crearCliente(cliente);
	        asesor = new Asesor("0001", "Paquito");
	        controlador.crearAsesor(asesor);
	        inmueble = new Inmueble("1111", "Calle falsa", "localidad falsa", "1/1/1980", "80m2", "venta", asesor, cliente);
	        controlador.crearInmueble(inmueble);
	        
	        // Formato de fecha incorrecto
	        visita = new Visita("prueba516", "uno de enero de 2015", inmueble, asesor, cliente);
	
	        // Rellenamos los campos de la interfaz
	        nv.setCampos(visita);
	        nv.clickBtnOk();
	        
	        //nv.setFecha("uno de enero de 2015"); 
	        nv.getContentPane().setVisible(false);
        } catch(LogicaExcepcion e){
        	e.printStackTrace();
        }
    }

    @Test
    public void test() {  
    	try{
        	nv.clickBtnCrear();
        	// Si la visita no se ha creado, el método funciona correctamentes
            if(controlador.encontrarVisitaPorCod(visita.getCod()) != null) 
            	fail("El método debería haber fallado!");
    	} catch(LogicaExcepcion e){
    		e.printStackTrace();
    	}
    }
    
    @After
    public void eliminar(){
        try{
            ConnectionManager connManager = new ConnectionManager("practicaFinal");
            connManager.connect();
            
            connManager.updateDB("delete from visita where cod_visita='" + visita.getCod() + "'");
            connManager.updateDB("delete from inmueble where cod_id='" + inmueble.getCodId() + "'");
            connManager.updateDB("delete from asesor where codigo_empleado='" + asesor.getCodigoEmp() + "'");
            connManager.updateDB("delete from cliente where nif_cliente='" + cliente.getNif() + "'");
            
            connManager.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(DAOExcepcion ex2){
            ex2.printStackTrace();
        }
    }
}
