package excepciones;

	/**
	 * Clase para recoger y lanzar las excepciones que tengan que ver con la
	 * base de datos.
	 * 
	 */
public class DAOExcepcion extends Exception {

	/**
	 * Lanza una expceci�n mostrando el mensaje que le indiquemos por par�metro.
	 * 
	 * @param message Mensaje que se mostrar� cuando salte la excepci�n.
	 */
	public DAOExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Lanza una expceci�n mostrando el mensaje de error de la excepci�n que le
	 * pasamos por par�metro.
	 * 
	 * @param e Excepci�n que le pasamos al m�todo para que muestre el mensaje
	 * de error.
	 */
	public DAOExcepcion(Exception e) {
		super(e.getMessage());
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;

}
