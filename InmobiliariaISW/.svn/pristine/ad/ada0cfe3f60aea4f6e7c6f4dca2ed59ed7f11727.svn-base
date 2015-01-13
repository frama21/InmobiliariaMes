package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.Asesor;
import logica.Cliente;
import logica.Inmueble;
import logica.Oferta;
import logica.Visita;
import excepciones.DAOExcepcion;

public class OfertaDAOImp implements IOfertaDAO {
	
	protected ConnectionManager connManager;
	private Asesor ase =null;
	private Cliente cli =null;
	private Inmueble inmu = null;
	private Visita visi = null;
	
	//Constructor de Oferta.
	public OfertaDAOImp() throws DAOExcepcion {
		super();
		// TODO Auto-generated constructor stub
		try{
		connManager= new ConnectionManager("practicaFinal");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}

	@Override
	public Oferta encontrarOfertaPorCod(String cod) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();


		ResultSet rs=connManager.queryDB("select PRECIO, FECHA, COD_OFERTA, COD_VISITA from OFERTA where COD_OFERTA= '"+cod+"'");
		
			connManager.close();
		
			if (rs.next())
				  return new Oferta(rs.getString("COD_OFERTA"),rs.getString("PRECIO"), rs.getString("FECHA"), visi = encontrarVisitaPorCodIn(rs.getString("COD_VISITA")));
				 else
					return null;
						
				}catch (SQLException e){
							throw new DAOExcepcion(e);
						}
	}

	//Usamos este método dentro de Oferta para encontrar una Visita y poder crear la Visita al buscarlo en la base de datos.
	 public Visita encontrarVisitaPorCodIn(String cod)throws DAOExcepcion{
			// TODO Auto-generated method stub
	  try{
		
		connManager.connect();

	ResultSet rs=connManager.queryDB("select * from VISITA where COD_VISITA= '"+cod+"'");
		connManager.close();
		if (rs.next())
			return new Visita(rs.getString("COD_VISITA"), rs.getString("FECHA"), inmu = encontrarInmueblePorCodIn(rs.getString("COD_ID")), ase = encontrarAsesorPorCodIn(rs.getString("CODIGO_EMPLEADO")), cli = encontrarClientePorCodIn(rs.getString("NIF_CLIENTE")) );
		 else
			return null;
				
		}catch (SQLException e){
					throw new DAOExcepcion(e);
				}
			
		}
	
	//Usamos este método dentro de Oferta para encontrar un Asesor y poder crear una oferta al buscarlo en la base de datos.
	 public Asesor encontrarAsesorPorCodIn(String cod)throws DAOExcepcion{
			// TODO Auto-generated method stub
	  try{
		
		connManager.connect();

	ResultSet rs=connManager.queryDB("select * from ASESOR where CODIGO_EMPLEADO= '"+cod+"'");
		connManager.close();
		if (rs.next())
		  return new Asesor(cod, rs.getString("NOMBRE"));
		 else
			return null;
				
		}catch (SQLException e){
					throw new DAOExcepcion(e);
				}
			
		}
	 
	//Usamos este metodo dentro de Oferta para encontrar un Cliente y poder crear una oferta al buscarlo en la base de datos.
	 public Cliente encontrarClientePorCodIn(String cod)throws DAOExcepcion{
			// TODO Auto-generated method stub
	  try{
		connManager.connect();

	ResultSet rs=connManager.queryDB("select * from CLIENTE where NIF_CLIENTE= '"+cod+"'");
		connManager.close();
		if (rs.next())
		  return new Cliente(cod, rs.getString("NOMBRE"),rs.getString("APELLIDOS"));
		 else
			return null;
				
		}catch (SQLException e){
					throw new DAOExcepcion(e);
				}
			
		}
	 
	 //Usamos este metodo dentro de oferta para encontrar un Inmueble y poder crear la Oferta.
	 public Inmueble encontrarInmueblePorCodIn(String cod) throws DAOExcepcion{
		 try{
			 connManager.connect();
			 
			 ResultSet rs=connManager.queryDB("select * from INMUEBLE where COD_ID= '"+cod+"'");
			 connManager.close();
			 if(rs.next())
				 return new Inmueble(cod,rs.getString("CALLE"),rs.getString("LOCALIDAD"), rs.getString("FECHA_ALTA"),rs.getString("SUPERFICIE_TOTAL"),rs.getString("VENTA_ALQUILER"), ase = encontrarAsesorPorCodIn(rs.getString("CODIGO_EMPLEADO")), cli = encontrarClientePorCodIn(rs.getString("NIF_CLIENTE")) );
			 else
				 return null;
		 }catch (SQLException e){
			 throw new DAOExcepcion(e);
		 }
	 }
	
	@Override
	public void crearOferta(Oferta i) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try {
			connManager.connect();
			
			connManager.updateDB("insert into OFERTA (PRECIO, FECHA, COD_OFERTA, COD_VISITA) values ('"+i.getPrecio()+"','"+i.getFecha()+"','"+i.getCod()+"','"+i.getVisita().getCod()+"')");
			
			connManager.close();
		} catch (Exception e){
			throw new DAOExcepcion(e);
		}
	}

	@Override
	public List<Oferta> encontrarOfertas() throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from OFERTA");						
			connManager.close();

			List<Oferta> listaOfertas=new ArrayList<Oferta>();
			try{				
				while (rs.next()){
					Oferta p = encontrarOfertaPorCod(rs.getString("COD_OFERTA"));	 
					listaOfertas.add(p);
				}
				return listaOfertas;
			}catch (Exception e){
				throw new DAOExcepcion(e);
			}
		}catch (DAOExcepcion e){
			throw e;
		}	
	}


}//Fin de la clase.
