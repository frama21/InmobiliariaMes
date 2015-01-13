package excepciones;

	/**
	 * Clase para recoger y lanzar las excepciones que tengan que ver con la
	 * base de datos.
	 * 
	 */
public class DAOExcepcion extends Exception {

	/**
	 * Lanza una expceción mostrando el mensaje que le indiquemos por parámetro.
	 * 
	 * @param message Mensaje que se mostrará cuando salte la excepción.
	 */
	public DAOExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Lanza una expceción mostrando el mensaje de error de la excepción que le
	 * pasamos por parámetro.
	 * 
	 * @param e Excepción que le pasamos al método para que muestre el mensaje
	 * de error.
	 */
	public DAOExcepcion(Exception e) {
		super(e.getMessage());
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;

}
