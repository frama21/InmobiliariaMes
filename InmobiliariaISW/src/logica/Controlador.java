package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import persistencia.DAL;
import excepciones.DAOExcepcion;
import excepciones.LogicaExcepcion;

/**
 * Clase controlador que nos permitir� manejar todas las clases de la capa de l�gica 
 * y comunicarnos con la base de datos
 */
public final class Controlador {

	private DAL dal;

	// Creacion del controlador
	// Un unico controlador para todos los C.U.
	private Controlador() throws LogicaExcepcion {
		try {
			// Objeto para comunicarse con la capa de acceso a datos
			dal = DAL.getDAL();

		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}

	}//Fin controlador

	// ***Patron singleton para que unicamente exista una instancia del
	// controlador.***

	static private Controlador refControlador = null;
	/**
	 * Constructor de la clase controlador.
	 * Implementa el patr�n Singleton para que s�lo pueda haber una instancia
	 * de esta clase.
	 * @return Devuelve un nuevo controlador si no hay ninguno creado, o el 
	 * controlador existente en ese momento
	 */
	public static Controlador dameControlador() {
		if (refControlador == null) {
			try {
				refControlador = new Controlador();
			} catch (LogicaExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return refControlador;
	}//Fin dameControlador

	// Para el C.U. Crear Pisos
	/**
	 * Llama a la clase DAL para poder insertar el piso en la base de datos
	 * @param unPiso Piso que vamos a insertar en la base de datos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public void crearPiso(Piso unPiso) throws LogicaExcepcion {
		
		//Comprueba que la superficie del piso es un entero positivo
		try {
			int num = Integer.parseInt(unPiso.getSuperficieTotal());
			if (num <= 0)
				throw new LogicaExcepcion(
						"La superficie debe de ser un n�mero positivo.");
		} catch (NumberFormatException e) {
			throw new LogicaExcepcion(
					"La superficie debe de ser un n�mero positivo.");
		}
		
		//Comprueba que la fecha tenga el formato correco dd/MM/yyyy
		if (!fechaCorrecta(unPiso.getFechaAlta()))
			throw new LogicaExcepcion(
					"El campo fecha no tiene el formato correcto dd/MM/yyyy");
		
		//Comprueba que el n�mero de habitaciones es un entero positivo
		try {
			int num = Integer.parseInt(unPiso.getNumHabitaciones());
			if (num <= 0)
				throw new LogicaExcepcion(
						"Las habitaciones debe de ser un n�mero positivo.");
		} catch (NumberFormatException e) {
			throw new LogicaExcepcion(
					"La superficie debe de ser un n�mero positivo.");
		}
		
		//Comprueba que el piso no existe en la base de datos
		try {
			if (dal.encontrarPisoPorCod(unPiso.getCodId()) == null)
				dal.crearPiso(unPiso);
			else
				throw new LogicaExcepcion("El Piso ya existe\n Cree uno nuevo");
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin crearPiso

	/**
	 * Comprueba que el formato de la fecha es es correcto
	 * @param fecha Fecha que vamos a comprobar
	 * @return True si la fecha es correcta, False si es incorrecta
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	private boolean fechaCorrecta(String fecha) throws LogicaExcepcion {
		// Quita los posibles espacios
		fecha = fecha.trim();
		// Si la fecha coincide con el formato dd/MM/yyyy -> es correcta
		if (!fecha.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			return false;
		}
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		try {
			// Comprueba si se ha introducido una fecha v�lida (ejemplo: mes
			// [1-12])
			df.parse(fecha);
			return true;
		} catch (ParseException ex) {
			throw new LogicaExcepcion("La fecha introducida no es v�lida");
			// return false;
		}
	}//Fin fechaCorrecta

	// Para el C.U Crear Visita
	/**
	 * Crea una nueva visita en la base de datos a trav�s del DAL
	 * @param unaVisita Visita que vamos a insertar en la base de datos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public void crearVisita(Visita unaVisita) throws LogicaExcepcion {
		//Comprueba si la fecha tiene el formato correcto
		if (!fechaCorrecta(unaVisita.getFecha()))
			throw new LogicaExcepcion(
					"El campo fecha no tiene el formato correcto dd/MM/yyyy");
		//Comprueba si la visita tiene un c�digo de identificaci�n
		if (unaVisita.getCod().trim().equals(""))
			throw new LogicaExcepcion("El campo c�digo no puede estar vac�o");

		try {
			// Puede ser que un cliente visite el mismo inmueble dos veces el
			// mismo dia
			// y queramos registrarlo en la base de datos.
			if (dal.encontrarVisitaPorCod(unaVisita.getCod()) == null)
				dal.crearVisita(unaVisita);
			else
				throw new LogicaExcepcion(
						"Ya hay una Visita con ese c�digo\n Cree otra");
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin crearVisita

	// Para el C.U. Crear Inmuebles(EncontrarInmueblePorCod aun no funca).
	/**
	 * Crea un nuevo Inmueble en la base de datos a trav�s del DAL
	 * @param unInmueble Inmueble que vamos a insertar en la base de datos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public void crearInmueble(Inmueble unInmueble) throws LogicaExcepcion {
		//comprueba si no existe y lo inserta en la base de datos
		try {
			if (dal.encontrarInmueblePorCod(unInmueble.getCodId()) == null)
				dal.crearInmueble(unInmueble);
			else
				throw new LogicaExcepcion(
						"El Inmueble ya existe\n Cree uno nuevo");
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin crearInmueble

	// Para el C.U. Crear asesor.
	/**
	 * Crea un Asesor en la base de datos a trav�s del DAL
	 * @param unAsesor Asesor que vamos a insertar en la base de datos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public void crearAsesor(Asesor unAsesor) throws LogicaExcepcion {
		//Comprueba que los campos no estes vac�os
		if (unAsesor.getCodigoEmp().trim().equals("") || unAsesor.getNombre().trim().equals("")
				|| unAsesor.getCodigoEmp().length() > 15
				|| unAsesor.getNombre().length() > 15)
			throw new LogicaExcepcion("Los campos no pueden estar vac�os");
		//Comprueba que no exista el asesor y lo inserta en la base de datos
		try {
			if (dal.encontrarAsesorPorCod(unAsesor.getCodigoEmp()) == null)
				dal.crearAsesor(unAsesor);
			else
				throw new LogicaExcepcion(
						"El Asesor ya existe\n Cree uno nuevo");
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin crearAsesor

	// Para el C.U. Crear Clientes.
	/**
	 * Crea un cliente en la base de datos a trav�s del DAL
	 * @param unCliente Cliente que vamos a insertar en la base de datos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public void crearCliente(Cliente unCliente) throws LogicaExcepcion {
		
		//comprueba que los campos no esten vac�os
		if (unCliente.getApellidos().trim().equals("") || unCliente.getNif().trim().equals("")
				|| unCliente.getNombre().trim().equals(""))
			throw new LogicaExcepcion("Los campos no pueden estar vac�os");
		
		//Comprueba que no existe el cliente y lo inserta en la base de datos
		try {
			if (dal.encontrarClientePorCod(unCliente.getNif()) == null)
				dal.crearCliente(unCliente);
			else
				throw new LogicaExcepcion(
						"El Cliente ya existe\n Cree uno nuevo");
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin crearCliente

	// Para el C.U. Crear Oferta.
	/**
	 * Crea una oferta en la base de datos a trav�s del DAL
	 * @param unaOferta Oferta que vamos a insertar en la base de datos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public void crearOferta(Oferta unaOferta) throws LogicaExcepcion {
		// TODO Auto-generated method stub
		boolean crear = false;

		try {
			// Lista con las ofertas de la base de datos.
			List<Oferta> listaOfertas = encontrarOfertas();

			// Si no existe ninguna oferta con ese c�digo se creara si se cumple
			// lo siguiente.
			if (dal.encontrarOfertaPorCod(unaOferta.getCod()) == null) {
				// Si hay alguna oferta hay que comprobar m�s cosas, sinos se
				// crea.
				if (listaOfertas.size() > 0) {

					for (int i = 0; i < listaOfertas.size(); i++) {

						// Si hay alguna oferta en la base de datos con el mismo
						// c�digo de visita que la actual
						// no se crea, ya que solo puede existir una oferta por
						// visita.
						if (listaOfertas.get(i).getVisita().getCod().trim()
								.equals(unaOferta.getVisita().getCod().trim())) {
							throw new LogicaExcepcion(
									"Ya hay una oferta para esa visita\n No se pueden crear m�s");

						}

					}// Fin del for para comparar con todas las ofertas.
						// Fin del if que mira si hay alguna oferta en la base
						// de datos. (Si no hay ninguna se crea)
				} else {
					dal.crearOferta(unaOferta);
					crear = true;
				}

			}// Fin del if para comprobar ofertas con mismo c�digo.
			else {
				throw new LogicaExcepcion(
						"Ya hay una oferta con ese c�digo\n Cree otra");
			}

			if (crear == false) {
				dal.crearOferta(unaOferta);
			}

		} catch (DAOExcepcion e1) {
			throw new LogicaExcepcion(e1);
		}
	}// Fin de CrearOferta.

	// Para el C.U. Crear Transacci�n.
	/**
	 * Crea una transacci�n en la base de datos a trav�s de DAL
	 * @param unaTransaccion Transacci�n que vamos a insertar en la base de datos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public void crearTransaccion(Transaccion unaTransaccion) throws LogicaExcepcion {
		// TODO Auto-generated method stub
		boolean crear = false;
		try {
			// Lista con las transacciones de la base de datos.
			List<Transaccion> listaTransacciones = encontrarTransaccion();

			if (dal.encontrarTransaccionPorCod(unaTransaccion.getCod()) == null) {

				if (listaTransacciones.size() > 0) {

					for (int i = 0; i < listaTransacciones.size(); i++) {

						if (listaTransacciones.get(i).getOferta().getCod()
								.trim().equals(unaTransaccion.getOferta().getCod().trim())) {
							throw new LogicaExcepcion(
									"Ya hay una transaccion para esa oferta\n No se pueden crear m�s");
						}//Fin if

					}// Fin del for para comparar todas las transacciones.
						
				} // Fin del if que mira si hay alguna transaccion en la
				// base de datos(Si no hay se crea).
				else {
					dal.crearTransaccion(unaTransaccion);
					crear = true;
				}

			}// Fin del if para comprobar transacciones con el mismo c�digo.
			else
				throw new LogicaExcepcion(
						"Ese C�digo de Transacci�n ya existe\n Cree una nueva");

			if (crear == false) {
				dal.crearTransaccion(unaTransaccion);
			}

		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}

	}// Fin de Crear Transacci�n.

	// Para el C.U. CrearNaveIndustrial.
	/**
	 * Crea una nave industrial en la base de datos a trav�s del DAL
	 * @param unaNaveIndustrial Nave industrial que vamos a insertar en la base de datos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public void crearNaveIndustrial(NaveIndustrial unaNaveIndustrial) throws LogicaExcepcion {
		//Comprueba que el c�digo de identificaci�n en la base de datos no est� vac�o
		if (unaNaveIndustrial.getCodId().trim().equals(""))
			throw new LogicaExcepcion(
					"El c�digo de la nave no puede estar vac�o");
		
		//Comprueba que el formato de fecha sea correcto
		if (!fechaCorrecta(unaNaveIndustrial.getFechaAlta()))
			throw new LogicaExcepcion(
					"El campo fecha no tiene el formato correcto dd/MM/yyyy");
		
		//Comprueba que la calificaci�n de la nave industrial sea un entero positivo
		try {
			int num = Integer.parseInt(unaNaveIndustrial.getCalificacion());
			if (num <= 0)
				throw new LogicaExcepcion(
						"La calificaci�n debe de ser un n�mero positivo.");
		} catch (NumberFormatException e) {
			throw new LogicaExcepcion(
					"La calificaci�n debe de ser un n�mero positivo.");
		}
		
		//Comprueba que la superficie sea un entero positivo
		try {
			int num = Integer.parseInt(unaNaveIndustrial.getSuperficieTotal());
			if (num <= 0)
				throw new LogicaExcepcion(
						"La superficie debe de ser un n�mero positivo.");
		} catch (NumberFormatException e) {
			throw new LogicaExcepcion(
					"La superficie debe de ser un n�mero positivo.");
		}
		
		//Comprueba que el n�mero de puertas sea un entero positivo
		try {
			int num = Integer.parseInt(unaNaveIndustrial.getNumPuertas());
			if (num <= 0)
				throw new LogicaExcepcion(
						"El n�mero de puertas debe de ser un n�mero positivo.");
		} catch (NumberFormatException e) {
			throw new LogicaExcepcion(
					"El n�mero de puertas debe de ser un n�mero positivo.");
		}
		
		// Comprueba que la nave industrial no existe en la base de datos y la inserta
		try {
			if (dal.encontrarNaveIndustrialPorCod(unaNaveIndustrial.getCodId()) == null)
				dal.crearNaveIndustrial(unaNaveIndustrial);
			else
				throw new LogicaExcepcion(
						"Esa Nave Industrial ya existe\n Cree una nueva");
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fun crearNaveIndustial

	// Para el C.U. Consultar Inmuebles
	/**
	 * Devuelve todos los inmuebles de la base de datos
	 * @return Devuelve una lista de inmuebles de la base de datos y null si no hay ninguno insertado
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public List<Inmueble> encontrarInmuebles() throws LogicaExcepcion {
		try {
			return dal.encontrarInmuebles();

		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarInmuebles

	// Encontrar Asesores en controlador.
	/**
	 * Devuelve los asesores de la base de datos
	 * @return Devuelve una lista de asesores y null si no hay ninguno insertado
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public List<Asesor> encontrarAsesores() throws LogicaExcepcion {
		try {
			return dal.encontrarAsesores();

		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarAsesores

	// Encontrar Clientes en controlador.
	/**
	 * Devuelve todos los clientes de la base de datos
	 * @return Devuelve una Lista con los clientes y null si no hay ninguno insertado
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public List<Cliente> encontrarCliente() throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarClientes();
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarClientes

	// Encontrar Pisos en controlador.
	/**
	 * Devuelve todos los pisos de la base de datos
	 * @return Devuelve una lista con los pisos o null si no hay ninguno insertado
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public List<Piso> encontrarPisos() throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarPisos();
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarPisos

	// Encontrar NaveIndustrial en controlador.
	/**
	 * Devuelve todas las naves industriales de la  base de datos
	 * @return Devuelve una lista con las naves industriales y null si no hay ninguna insertada
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public List<NaveIndustrial> encontrarNaveIndustrial()
			throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarNaveIndustrial();
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}

	/**
	 * Devuelve todas las visitas de la base de datos
	 * @return Devuelve una lista con las visitas y null si no hay ninguna insertada
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public List<Visita> encontrarVisitas() throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarVisita();
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarVisitas

	/**
	 * Devuelve todas las transacciones de la base de datos
	 * @return Devuelve una lista con las transacciones y null si no hay ninguna insertada
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public List<Transaccion> encontrarTransaccion() throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarTransaccion();
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarTransaccion
	
	/**
	 * Devuelve todas las ofertas de la base de datos
	 * @return Devuelve una lista con las ofertas y null si no hay ninguna insertada
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public List<Oferta> encontrarOfertas() throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarOfertas();
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarOfertas

	/**
	 * Devuelve una visita
	 * @return Devuelve una visita que corresponda al c�digo indicado por par�metro y null si no existe
	 * @param unCodVisita C�digo de la visita que buscamos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public Visita encontrarVisitaPorCod(String unCodVisita) throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarVisitaPorCod(unCodVisita);
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarVisitasPorCod

	/**
	 * Devuelve un asesor
	 * @return Devuelve un asesor que corresponda con el c�digo indicado por par�metro y null si no existe
	 * @param codAsesor C�digo del asesor que buscamos
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public Asesor encontrarAsesorPorCod(String codAsesor) throws LogicaExcepcion {
		try {
			return dal.encontrarAsesorPorCod(codAsesor);
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarAsesorPorCod
	
	/**
	 * Devuelve un cliente
	 * @param codCliente C�digo del cliente que buscamos
	 * @return Devuelve un cliente que corresponda con el c�digo indicado por par�metro y null si no existe y null si no existe
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public Cliente encontrarClientePorCod(String codCliente) throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarClientePorCod(codCliente);
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarClientePorCod
	
	/**
	 * Devuelve una oferta
	 * @param codOferta C�digo de la oferta que queremos buscar
	 * @return Devuelve una oferta que corresponda con el c�digo indicado por par�metro y null si no existe
	 * @throws LogicaExcepcion Lanza una excepci�n de la capa l�gica
	 */
	public Oferta encontrarOfertaPorCod(String codOferta) throws LogicaExcepcion {
		// TODO Auto-generated method stub
		try {
			return dal.encontrarOfertaPorCod(codOferta);
		} catch (DAOExcepcion e) {
			throw new LogicaExcepcion(e);
		}
	}//Fin encontrarOfertaPorCod

}// Fin de controlador.
