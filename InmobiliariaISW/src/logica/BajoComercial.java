package logica;
/**
 * Clase para representar a un inmueble de tipo Bajo comercial.
 */
public class BajoComercial extends Inmueble {
	/**
	 * Atributos de la clase
	 */
	private String numPuertas;

	/**
	 * Constructor de la clase
	 * @param unCodigo Código de identificación de un bajo comercial
	 * @param unaCalle Calle de un bajo comercial
	 * @param unaLocalidad Localidad de un bajo comercial
	 * @param unaFechaAlta Fecha de alta en la inmobiliaria de un bajo comercial
	 * @param unaSuperficieTot Superficie total de un bajo comericial
	 * @param unaVentaAlquiler Indica si es una venta o un alquiler en la inmobiliaria
	 * @param unNumPuertas Número de puertas que tiene el bajo comercial
	 * @param unAsesor Asesor asociado al bajo comercial
	 * @param unCliente Propietario del bajo comercial
	 */
	public BajoComercial(String unCodigo, String unaCalle, String unaLocalidad,
			String unaFechaAlta, String unaSuperficieTot,
			String unaVentaAlquiler, String unNumPuertas, Asesor unAsesor,
			Cliente unCliente) {
		super(unCodigo, unaCalle, unaLocalidad, unaFechaAlta, unaSuperficieTot,
				unaVentaAlquiler, unAsesor, unCliente);

		this.numPuertas = unNumPuertas;
	}//Fin del constructor

	/**
	 * Establece el número de puertas de un bajo comercial
	 * @param unNumPuertas Número de puertas que contiene el bajo comercial
	 */
	public void setNumPuertas(String unNumPuertas) {
		this.numPuertas = unNumPuertas;
	}

	/**
	 * @return Devuelve el número de puertas del bajo comercial
	 */
	public String getNumPuertas() {
		return this.numPuertas;
	}
}// Fin de la clase.
