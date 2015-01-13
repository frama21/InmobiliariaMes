package persistencia;

import java.util.*;
import java.sql.*;
import logica.Piso;
import excepciones.DAOExcepcion;
import logica.Inmueble;


public class PisoDAOImp extends InmuebleDAOImp implements IPisoDAO{

	public Piso encontrarPisoPorCod(String cod)throws DAOExcepcion{
		try{
			Inmueble in = encontrarInmueblePorCod(cod); 			
			if (in != null)
			{
				connManager.connect();
				ResultSet rs=connManager.queryDB("select * from PISO where COD_ID = '"+ cod +"'");
				connManager.close();
				
				if (rs.next())
					return new Piso(cod, in.getCalle(), in.getLocalidad(), in.getFechaAlta(), 
							in.getSuperficieTotal(), in.getVentaAlquiler(),
							rs.getString("NUM_HABITACIONES"),in.getAsesor(),in.getCliente());
			}
			return null;

		}catch (Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
	@Override
	public void crearPiso(Piso p)throws DAOExcepcion{
		try{	
			
			// Antes de crear el piso, creamos el inmueble
			crearInmueble(new Inmueble(p.getCodId(), p.getCalle(), p.getLocalidad(), p.getFechaAlta(), p.getSuperficieTotal(), 
					p.getVentaAlquiler(),p.getAsesor(),p.getCliente())); 
			
			
			// Ahora creamos el piso
			connManager.connect();			
			connManager.updateDB("insert into PISO (COD_ID, NUM_HABITACIONES) " +
					"values ('" + p.getCodId() + "', '" + p.getNumHabitaciones() +"')");  
			connManager.close();
			
		}catch (Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
	@Override
	public List<Piso> encontrarPisos() throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from PISO");						
			connManager.close();

			List<Piso> listaPisos=new ArrayList<Piso>();
			try{				
				while (rs.next()){
					Piso p = encontrarPisoPorCod(rs.getString("COD_ID"));	 
					listaPisos.add(p);
				}
				return listaPisos;
			}catch (Exception e){
				throw new DAOExcepcion(e);
			}
		}catch (DAOExcepcion e){
			throw e;
		}	
	}
	
	public PisoDAOImp() throws DAOExcepcion {
		super();  // inits and connects the connManager
	}

	
}
