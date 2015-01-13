package persistencia;



import java.util.List;

import excepciones.DAOExcepcion;
import logica.Asesor;
import logica.Cliente;
import logica.Inmueble;
import logica.NaveIndustrial;
import logica.Oferta;
import logica.Piso;
import logica.Transaccion;
import logica.Visita;
/**
 *Clase que será llamada a través del controlador y que será la encargada
 *de lanzar los métodos para hacer las peticiones a la base de datos.
 */
public final class DAL { // NOPMD by joseph on 8/01/15 21:37
	
	/**
	 * Atributos de la clase
	 */
	private static DAL dal;
	private IAsesorDAO asesorDAO;
	private IClienteDAO clienteDAO;
	private IPisoDAO pisoDAO;
	private IInmuebleDAO inmuebleDAO;
	private INaveIndustrialDAO naveindustrialDAO;
	private IVisitaDAO visitaDAO;
	private IOfertaDAO ofertaDAO;
	private ITransaccionDAO transaccionDAO;
	
	
	//Constructor privado
	/**
	 * Constructor de la clase.
	 * Es privado por usar el patrón Singleton
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	private DAL() throws DAOExcepcion {

		asesorDAO = new AsesorDAOImp();
		clienteDAO = new ClienteDAOImp();
		pisoDAO = new PisoDAOImp();
		inmuebleDAO = new InmuebleDAOImp();
		naveindustrialDAO = new NaveIndustrialDAOImp();
		visitaDAO = new VisitaDAOImp();
		ofertaDAO = new OfertaDAOImp();
		transaccionDAO = new TransaccionDAOImp();

	}

	//Patron Singleton
	/**
	 * Constructor publico de la clase DAL.
	 * Solo podrá haber una única instancia de esta clase
	 * @return Devuelve un DAL nuevo o uno ya existente si ya se había creado uno.
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public static DAL getDAL() throws DAOExcepcion {
		if(dal==null)
			dal = new DAL();
		return dal;
	}

	//Para el C.U. Consultar Clientes.
	/**
	 * Encuentra todos los clientes de la base de datos
	 * @return Devuelve una lista con los clientes y null si no hay ninguno
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public List<Cliente> encontrarClientes() throws DAOExcepcion{
		return clienteDAO.encontrarClientes();
	}

	//Para el C.U. Consultar Inmuebles
	/**
	 * Encuentra todos los inmuebles
	 * @return Devuelve una lista con los inmuebles y null si no hay ninguno
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public List<Inmueble> encontrarInmuebles() throws DAOExcepcion {
		return inmuebleDAO.encontrarInmuebles();
	}

	//Para el C.U. Consultar Asesores
	/**
	 * Encuentra todos los asesores
	 * @return Devuelve una lista con todos los asesores y null si no hay ninguno
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public List<Asesor> encontrarAsesores() throws DAOExcepcion {
		return asesorDAO.encontrarAsesores();
	}

	//Objeto DAL para encontrar un Asesor por Codigo.
	/**
	 * Encuentra a un asesor especifico
	 * @param cod Código específico del asesor que buscamos
	 * @return Devuelve el asesor que buscamos y null si existe
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public Asesor encontrarAsesorPorCod(String cod ) throws DAOExcepcion {
		return asesorDAO.encontrarAsesorPorCod(cod);
	}

	//Objeto DAL para encontrar un Cliente por cï¿½digo.
	/**
	 * Encuentra un cliente específico
	 * @param nif Nif del cliente que buscamos
	 * @return Devuelve el cliente especificado y null si no existe
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public Cliente encontrarClientePorCod(String nif) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return clienteDAO.encontrarClientePorCod(nif);
	}

	//Objeto DAL para encontrar un inmueble por cï¿½digo.
	/**
	 * Encuentra un inmueble específico
	 * @param cod Código del inmueble que buscamos
	 * @return Devuelve el inmueble especificado y null si no existe
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public Inmueble encontrarInmueblePorCod(String cod) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return inmuebleDAO.encontrarInmueblePorCod(cod);
	}
	
	//Objeto DAL para encontrar un piso por cï¿½digo.
	/**
	 * Encuentra un Piso específico
	 * @param cod Código del Piso que buscamos
	 * @return Devuelve el Piso especificado y null si no existe
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public Piso encontrarPisoPorCod(String cod) throws DAOExcepcion{
		return pisoDAO.encontrarPisoPorCod(cod);
	}

	//Objeto DAL para encontrar una NaveIndustrial por cï¿½digo.
	/**
	 * Encuentra una Nave industrial específica
	 * @param cod Código de la nave industrial que buscamos
	 * @return Devuelve la nave industrial especificada y null si no existe
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public NaveIndustrial encontrarNaveIndustrialPorCod(String cod) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return naveindustrialDAO.encontrarNaveIndustrialPorCod(cod);
	}
	
	//Objeto DAL para encontrar una Visita por cï¿½digo.
	/**
	 * Encuentra una Visita específica
	 * @param cod Código de la Visita que buscamos
	 * @return Devuelve la Visita especificada y null si no existe
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public Visita encontrarVisitaPorCod(String cod) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return visitaDAO.encontrarVisitaPorCod(cod);
	}
	
	//Objeto DAL para encontrar una Oferta por cï¿½digo.
	/**
	 * Encuentra una Oferta específica
	 * @param cod Código de la Oferta que buscamos
	 * @return Devuelve la Oferta especificada y null si no existe
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public Oferta encontrarOfertaPorCod(String cod) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return ofertaDAO.encontrarOfertaPorCod(cod);
	}
	
	//Objeto DAL para encontrar una Transaccion por cï¿½digo.
	/**
	 * Encuentra una Transaccion específica
	 * @param cod Código de la Transaccion que buscamos
	 * @return Devuelve la Transaccion especificada y null si no existe
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public Transaccion encontrarTransaccionPorCod(String cod) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return transaccionDAO.encontrarTransaccionPorCod(cod);
	}
	
	//Dal para crear un piso.
	/**
	 * Inserta un piso en la base de datos
	 * @param pi Piso que insertamos en la base de datos
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public void crearPiso(Piso pi) throws DAOExcepcion {
		pisoDAO.crearPiso(pi);
	}

	//Objeto DAL para crear un Asesor
	/**
	 * Inserta un Asesor en la base de datos
	 * @param unAsesor Asesor que insertamos en la base de datos
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public void crearAsesor(Asesor unAsesor) throws DAOExcepcion {
		// TODO Auto-generated method stub
		asesorDAO.crearAsesor(unAsesor);
	}

	//Objeto DAL para crear el cliente.
	/**
	 * Inserta un Cliente en la base de datos
	 * @param unCliente Cliente que insertamos en la base de datos
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public void crearCliente(Cliente unCliente) throws DAOExcepcion {
		// TODO Auto-generated method stub
		clienteDAO.crearCliente(unCliente);
	}
	
	//Objeto DAL para crear una Transacciï¿½n
	/**
	 * Inserta una Transaccion en la base de datos
	 * @param unaTransaccion Transaccion que insertamos en la base de datos
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public void crearTransaccion(Transaccion unaTransaccion) throws DAOExcepcion {
		// TODO Auto-generated method stub
		transaccionDAO.crearTransaccion(unaTransaccion);
	}
	
	//Objeto DAL para crear una Oferta.
	/**
	 * Inserta una Oferta en la base de datos
	 * @param unaOferta Oferta que insertamos en la base de datos
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public void crearOferta(Oferta unaOferta) throws DAOExcepcion {
		// TODO Auto-generated method stub
		ofertaDAO.crearOferta(unaOferta);
	}
	
	//Objeto DAL para crear un Inmueble.
	/**
	 * Inserta un Inmueble en la base de datos
	 * @param unInmueble Inmueble que insertamos en la base de datos
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public void crearInmueble(Inmueble unInmueble) throws DAOExcepcion {
		// TODO Auto-generated method stub
		inmuebleDAO.crearInmueble(unInmueble);
	}
	
	//Dal para crear una NaveIndustrial.
	/**
	 * Inserta una Nave industrial en la base de datos
	 * @param unaNaveIndustrial Nave industrial que insertamos en la base de datos
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public void crearNaveIndustrial(NaveIndustrial unaNaveIndustrial) throws DAOExcepcion {
		// TODO Auto-generated method stub
		naveindustrialDAO.crearNaveIndustrial(unaNaveIndustrial);
	}
	
	/**
	 * Encuentra todos los pisos
	 * @return Devuelve una lista con los pisos y null si no hay ninguno
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public List<Piso> encontrarPisos() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return pisoDAO.encontrarPisos();
	}
	
	/**
	 * Encuentra todos las naves industriales
	 * @return Devuelve una lista con las naves industriales y null si no hay ninguna
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public List<NaveIndustrial> encontrarNaveIndustrial() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return naveindustrialDAO.encontrarNavesIndustriales();
	}
	
	/**
	 * Inserta una Visita en la base de datos
	 * @param unaVisita Visita que insertamos en la base de datos
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public void crearVisita(Visita unaVisita) throws DAOExcepcion {
		visitaDAO.crearVisita(unaVisita);
	}
	
	/**
	 * Encuentra todos las Visitas
	 * @return Devuelve una lista con las Visitas y null si no hay ninguna
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public List<Visita> encontrarVisita() throws DAOExcepcion {
	return visitaDAO.encontrarVisitas();
	
	}
	
	/**
	 * Encuentra todos las Ofertas
	 * @return Devuelve una lista con las Ofertas y null si no hay ninguna
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public List<Oferta> encontrarOfertas() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return ofertaDAO.encontrarOfertas();
	}
	
	/**
	 * Encuentra todos las transacciones
	 * @return Devuelve una lista con las transacciones y null si no hay ninguna
	 * @throws DAOExcepcion Lanza una excepción relacionada con la BD
	 */
	public List<Transaccion> encontrarTransaccion() throws DAOExcepcion {
		// TODO Auto-generated method stub
		return transaccionDAO.encontrarTransaccion();
	}


}//Fin de la clase DAL.
