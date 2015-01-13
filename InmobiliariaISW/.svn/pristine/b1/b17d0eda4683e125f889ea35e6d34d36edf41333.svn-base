package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import logica.Cliente;
import excepciones.DAOExcepcion;

//import logica.Piso;

public class ClienteDAOImp implements IClienteDAO{
	protected ConnectionManager connManager;
	
	public ClienteDAOImp() throws DAOExcepcion {
		super();
		// TODO Auto-generated constructor stub
		try{
		connManager= new ConnectionManager("practicaFinal");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}

	
	@Override
	public void crearCliente(Cliente p)throws DAOExcepcion{
		try{	
			

			//Creamos el piso
			connManager.connect();			
			connManager.updateDB("insert into CLIENTE (NIF_CLIENTE, NOMBRE, APELLIDOS) " +
					"values ('" + p.getNif() + "', '" + p.getNombre() + "', '" + p.getApellidos() + "')"); 
			connManager.close();
			
		}catch (Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
	
	
	 public Cliente encontrarClientePorCod(String cod)throws DAOExcepcion{
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
	
	@Override
	public List<Cliente> encontrarClientes() throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CLIENTE");						
			connManager.close();

			List<Cliente> listaCliente=new ArrayList<Cliente>();
			try{				
				while (rs.next()){
					Cliente p = encontrarClientePorCod(rs.getString("NIF_CLIENTE"));	 
					listaCliente.add(p);
				}
				return listaCliente;
			}catch (Exception e){
				throw new DAOExcepcion(e);
			}
		}catch (DAOExcepcion e){
			throw e;
		}	
	}
	

	
}
