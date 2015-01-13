package logica;

/**
 * Clase para representar a un inmueble de tipo Adosado.
 */
public class Adosado extends CasaPueblo {
	
	/**
	 * Atributos de la clase
	 */
	private String gastosComunidad;
	
	/**
	 * Constructor de la clase Adosado
	 * @param unCodigo Código de identificación del Adosado
	 * @param unaCalle Calle de referencia al Adosado
	 * @param unaLocalidad Localidad del Adosado
	 * @param unaFechaAlta Fecha en la que se insertó el Adosado en la BD
	 * @param unaSuperficieTot Superficie total del Adosado
	 * @param unaVentaAlquiler Indicar si el Adosado corresponde a una venta o un alquiler
	 * @param unaSuperficiePatio Superficie del patio del Adosado
	 * @param unNumeroPlantas Número de plantas disponibles
	 * @param unaSuperficiePlantas Superficie de las plantas
	 * @param unosGastosComunidad Gastos de la comunidad del Adosado
	 * @param unAsesor Asesor encargado del Adosado
	 * @param unCliente Propietario del Adosado
	 */
	public Adosado(String unCodigo, String unaCalle, String unaLocalidad,
			String unaFechaAlta, String unaSuperficieTot,
			String unaVentaAlquiler, String unaSuperficiePatio,
			String unNumeroPlantas, String unaSuperficiePlantas,
			String unosGastosComunidad, Asesor unAsesor, Cliente unCliente) {

		super(unCodigo, unaCalle, unaLocalidad, unaFechaAlta, unaSuperficieTot,
				unaVentaAlquiler, unaSuperficiePatio, unNumeroPlantas,
				unaSuperficiePlantas, unAsesor, unCliente);

		this.gastosComunidad = unosGastosComunidad;
	}//Fin del constructor

	/**
	 * @param gc Establece el valor de la variable gastosComunidad.
	 */
	public void setGastosComunidad(String gc) {
		this.gastosComunidad = gc;
	}

	/**
	 * Devuelve el valor de la variable gastosComunidad
	 * 
	 * @return gastosComunidad Devuelve los gastos de la comunidad
	 */
	public String getGastosComunidad() {
		return gastosComunidad;
	}

}// Fin de la clase.
