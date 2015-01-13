package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Asesor;
import logica.Cliente;
import logica.Inmueble;
import logica.Oferta;
import logica.Transaccion;
import logica.Visita;
import excepciones.DAOExcepcion;

public class TransaccionDAOImp implements ITransaccionDAO {
	
	protected ConnectionManager connManager;
	private Asesor ase =null;
	private Cliente cli =null;
	private Inmueble inmu = null;
	private Visita visi = null;
	private Oferta ofe = null;
	
	//Constructor de Transaccion.
	public TransaccionDAOImp() throws DAOExcepcion {
		super();
		// TODO Auto-generated constructor stub
		try{
		connManager= new ConnectionManager("practicaFinal");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}
	

	@Override
	public Transaccion encontrarTransaccionPorCod(String cod) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();


		ResultSet rs=connManager.queryDB("select PRECIO_FINAL, FECHA, COMPRA_O_ALQUILER, COD_TRANSACCION, COD_OFERTA from TRANSACCION where COD_TRANSACCION= '"+cod+"'");
			connManager.close();
		
			
			if (rs.next())
			  return new Transaccion(rs.getString("COD_TRANSACCION"), rs.getString("PRECIO_FINAL"), rs.getString("FECHA"), rs.getString("COMPRA_O_ALQUILER"), ofe= encontrarOfertaPorCodIn(rs.getString("COD_OFERTA")) );
			 else
				return null;
					
			}catch (SQLException e){
						throw new DAOExcepcion(e);
					}
	}

	//Para encontrar Una Oferta y poder crear una Transacción.
	public Oferta encontrarOfertaPorCodIn(String cod) throws DAOExcepcion {
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
	
	//Encontrar una Visita y poder crear una Transacción.
	public Visita encontrarVisitaPorCodIn(String cod) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();


		ResultSet rs=connManager.queryDB("select FECHA, COD_ID, NIF_CLIENTE, CODIGO_EMPLEADO, COD_VISITA from VISITA where COD_VISITA= '"+cod+"'");
			connManager.close();
		
			
			if (rs.next())
			  return new Visita(rs.getString("COD_VISITA"), rs.getString("FECHA"), inmu = encontrarInmueblePorCodIn(rs.getString("COD_ID")), ase = encontrarAsesorPorCodIn(rs.getString("CODIGO_EMPLEADO")), cli = encontrarClientePorCodIn(rs.getString("NIF_CLIENTE")) );
			 else
				return null;
					
			}catch (SQLException e){
						throw new DAOExcepcion(e);
					}
	}
	
	//Usamos este método dentro de Transaccion para encontrar un Asesor y poder crear una Transacción al buscarlo en la base de datos.
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
		//Usamos este m¨etodo dentro de Transaccion para encontrar un Cliente y poder crear una Transaccion al buscarlo en la base de datos.
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
		 
		 //Usamo este metodo dentro de Transaccion para encontrar un Inmueble y poder crear la Transaccion.
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
			public void crearTransaccion(Transaccion i) throws DAOExcepcion {
				// TODO Auto-generated method stub
				try {
					connManager.connect();
					
					connManager.updateDB("insert into TRANSACCION (PRECIO_FINAL, FECHA, COMPRA_O_ALQUILER, COD_TRANSACCION, COD_OFERTA) values ('"+i.getPrecioFinal()+"','"+i.getFecha()+"','"+i.getCompraAlquiler()+"','"+i.getCod()+"','"+i.getOferta().getCod()+"')");
					
					connManager.close();
				} catch (Exception e){
					throw new DAOExcepcion(e);
				}
			}

	@Override
	public List<Transaccion> encontrarTransaccion() throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from TRANSACCION");						
			connManager.close();

			List<Transaccion> listaTransacciones=new ArrayList<Transaccion>();
			try{				
				while (rs.next()){
					Transaccion p = encontrarTransaccionPorCod(rs.getString("COD_TRANSACCION"));	 
					listaTransacciones.add(p);
				}
				return listaTransacciones;
			}catch (Exception e){
				throw new DAOExcepcion(e);
			}
		}catch (DAOExcepcion e){
			throw e;
		}	
	}


}//Fin de Transaccion.