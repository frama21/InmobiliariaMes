package persistencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import logica.Asesor;
import logica.Cliente;
import logica.Inmueble;
import excepciones.DAOExcepcion;

public class InmuebleDAOImp implements IInmuebleDAO {
	protected ConnectionManager connManager;
	private Asesor ase =null;
	private Cliente cli =null;
	
	   public InmuebleDAOImp() throws DAOExcepcion {
			super();
			// TODO Auto-generated constructor stub
			try{
			connManager= new ConnectionManager("practicaFinal");
			}catch (ClassNotFoundException e){
				throw new DAOExcepcion(e);
			}
		}

	  public void crearInmueble(Inmueble i) throws DAOExcepcion {
			// TODO Auto-generated method stub
		
	  try{
		  
		connManager.connect();
		
		connManager.updateDB("insert into INMUEBLE (COD_ID, CALLE, LOCALIDAD, FECHA_ALTA, SUPERFICIE_TOTAL, VENTA_ALQUILER, CODIGO_EMPLEADO, NIF_CLIENTE) values ('"+i.getCodId()+"','"+i.getCalle()+"','"+i.getLocalidad()+"', '"+i.getFechaAlta()+"', '"+i.getSuperficieTotal()+"', '"+i.getVentaAlquiler()+"', '"+i.getAsesor().getCodigoEmp()+"', '"+i.getCliente().getNif()+"')");
		
		connManager.close();
		} catch (Exception e){
				throw new DAOExcepcion(e);
			}
		}

	 public Inmueble encontrarInmueblePorCod(String cod)throws DAOExcepcion{
			// TODO Auto-generated method stub
	  try{
		connManager.connect();


	ResultSet rs=connManager.queryDB("select CALLE, LOCALIDAD, FECHA_ALTA, SUPERFICIE_TOTAL, VENTA_ALQUILER, CODIGO_EMPLEADO, NIF_CLIENTE from INMUEBLE where COD_ID= '"+cod+"'");
		connManager.close();
	
		
		if (rs.next())
		  return new Inmueble(cod,rs.getString("CALLE"),rs.getString("LOCALIDAD"), rs.getString("FECHA_ALTA"),rs.getString("SUPERFICIE_TOTAL"),rs.getString("VENTA_ALQUILER"), ase = encontrarAsesorPorCodIn(rs.getString("CODIGO_EMPLEADO")), cli = encontrarClientePorCodIn(rs.getString("NIF_CLIENTE")) );
		 else
			return null;
				
		}catch (SQLException e){
					throw new DAOExcepcion(e);
				}
			
		}
	 
	 //Usamos este método dentro de Inmueble para encontrar un Asesor y poder crear un Inmueble al buscarlo en la base de datos.
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
	//Usamos este m¨¦todo dentro de Inmueble para encontrar un Cliente y poder crear un Inmueble al buscarlo en la base de datos.
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
	 
	 //Devuelve una lista de tipo Inmueble con todos los inmuebles en la base de datos.
	 @Override
		public List<Inmueble> encontrarInmuebles() throws DAOExcepcion{
			try{
				connManager.connect();
				ResultSet rs=connManager.queryDB("select * from INMUEBLE");						
				connManager.close();

				List<Inmueble> listaInmuebles=new ArrayList<Inmueble>();
				try{				
					while (rs.next()){
						Inmueble p = encontrarInmueblePorCod(rs.getString("COD_ID"));	 
						listaInmuebles.add(p);
					}
					return listaInmuebles;
				}catch (Exception e){
					throw new DAOExcepcion(e);
				}
			}catch (DAOExcepcion e){
				throw e;
			}	
		}


}
