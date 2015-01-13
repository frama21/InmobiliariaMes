package logica;

import java.util.ArrayList;

/**
 * Clase para representar a un inmueble de tipo casa pueblo
 */
public class CasaPueblo extends Inmueble {

	/**
	 * Atributos de la clase
	 */
	private String superficiePatio;
	private String numeroPlantas;
	private String superficiePlantas;
	private PlazaGaraje plazaGaraje;
	private ArrayList<PlazaGaraje> listaGarajes;

	/**
	 * Constructor de la clase
	 * @param unCodigo Código de identificación de la casa de pueblo
	 * @param unaCalle Calle de la casa de pueblo
	 * @param unaLocalidad Localidad de la casa de pueblo
	 * @param unaFechaAlta Fecha de alta en la inmobiliaria de la casa de pueblo
	 * @param unaSuperficieTot Superficie total de la casa de pueblo
	 * @param unaVentaAlquiler Indica si es una venta o un alquiler
	 * @param unaSuperficiePatio Superficie del patio de la casa de pueblo
	 * @param unNumeroPlantas Número de plantas de las que dispone 
	 * @param unaSuperficiePlantas Superficie de las plantas
	 * @param unAsesor Asesor asociado a la casa de pueblo
	 * @param unCliente Propietario de la casa de pueblo
	 */
	public CasaPueblo(String unCodigo, String unaCalle, String unaLocalidad,
			String unaFechaAlta, String unaSuperficieTot,
			String unaVentaAlquiler, String unaSuperficiePatio,
			String unNumeroPlantas, String unaSuperficiePlantas,
			Asesor unAsesor, Cliente unCliente) {
		super(unCodigo, unaCalle, unaLocalidad, unaFechaAlta, unaSuperficieTot,
				unaVentaAlquiler, unAsesor, unCliente);

		this.superficiePatio = unaSuperficiePatio;
		this.numeroPlantas = unNumeroPlantas;
		this.superficiePlantas = unaSuperficiePlantas;
	}//Fin del constructor

	//Métodos getters and setters
	public String getSuperficiePatio() {
		return this.superficiePatio;
	}

	public String getSuperficiePlantas() {
		return this.superficiePlantas;
	}

	public String getNumeroPlantas() {
		return this.numeroPlantas;
	}

	public void setSuperficiePatio(String unaSupPatio) {
		this.superficiePatio = unaSupPatio;
	}

	public void setSuperficiePlantas(String unaSupPlantas) {
		this.superficiePlantas = unaSupPlantas;
	}

	public void setNumeroPlantas(String unNumPlantas) {
		this.numeroPlantas = unNumPlantas;
	}

	public void setPlazaGaraje(PlazaGaraje unaPlazaGarage) {
		this.plazaGaraje = unaPlazaGarage;
	}

	public PlazaGaraje getPlazaGaraje() {
		return this.plazaGaraje;
	}
	//Fin de métodos getters and setters

	/**
	 * Añade una plaza de garaje a la casa de pueblo
	 * @param unaPlazaGaraje Plaza de garaje que añadimos a la casa de pueblo
	 */
	public void añadirPlazaGaraje(PlazaGaraje unaPlazaGaraje) {
		this.listaGarajes.add(unaPlazaGaraje);
	}//Fin de añadir

	/**
	 * Elimina una plaza de garaje de la lista
	 * @param unaPlazaGaraje Plaza de garaje que vamos a eliminar de la lista
	 */
	public void eliminarPlazaGaraje(String unaPlazaGaraje) {
		this.listaGarajes.remove(obetenerPlazaGaraje(unaPlazaGaraje));
	}//Fin de elminar

	/**
	 * Devuelve la posición de la plaza de garaje en la lista
	 * @param unaPlazaGaraje Plaza de garaje que buscamos en la lista
	 * @return Devuelve la posición de la plaza de garaje o 0 si no la encuentra.
	 */
	public int obetenerPlazaGaraje(String unaPlazaGaraje) {
		int res = 0;
		for (int i = 0; i < this.listaGarajes.size(); i++) {
			if (this.listaGarajes.get(i).getCaracter().equals(unaPlazaGaraje))
				res = i;
		}//Fin for
		return res;
	}//Fin obtener
}// Fin de la clase.
