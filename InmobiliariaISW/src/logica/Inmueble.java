package logica;

import java.util.List;


/**
 * Clase que representa a los inmuebles de la aplicación
 * De esta clase heredarán los direrentes tipos de inmuebles
 */
public class Inmueble {
	/**
	 * Atributos de la clase
	 */
	private String codID;
	private String ventaAlquiler;
	private String calle;
	private String localidad;
	private String fechaAlta;
	private String superficieTotal;
	private Hipoteca hipoteca;
	private List<Visita> listaVisitas = null;
	private ZonaGeografica zonaGeografica;
	private Asesor asesor;
	private Cliente cliente;
	
	/**
	 * Constructor de la clase
	 * @param unCodigo Código del inmueble
	 * @param unaCalle nombre de la calle
	 * @param unaLocalidad Localidad del inmueble
	 * @param unaFechaAlta Fecha en la que se introdujo el inmueble 
	 * @param unaSuperficieTot Superficie del inmueble
	 * @param unaVentaAlquiler Indicar si es una venta o un alquiler
	 * @param unAsesor Asesor asociado al inmueble
	 * @param unCliente Cliente asociado al inmueble
	 */
	public Inmueble(String unCodigo, String unaCalle, String unaLocalidad,
			String unaFechaAlta, String unaSuperficieTot,
			String unaVentaAlquiler, Asesor unAsesor, Cliente unCliente) {
		// TODO Auto-generated constructor stub
		this.codID = unCodigo;
		this.ventaAlquiler = unaVentaAlquiler;
		this.calle = unaCalle;
		this.localidad = unaLocalidad;
		this.fechaAlta = unaFechaAlta;
		this.superficieTotal = unaSuperficieTot;
		this.asesor = unAsesor;
		this.cliente = unCliente;
	}//Fin del constructor

	//Métodos getters and setters
	public void setVentaAlquiler(String va) {
		this.ventaAlquiler = va;
	}

	public String getVentaAlquiler() {
		return this.ventaAlquiler;
	}

	public void setCalle(String c) {
		this.calle = c;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setLocalidad(String l) {
		this.localidad = l;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setFechaAlta(String l) {
		this.fechaAlta = l;
	}

	public String getFechaAlta() {
		return this.fechaAlta;
	}

	public void setSuperficieTotal(String st) {
		this.superficieTotal = st;
	}

	public String getSuperficieTotal() {
		return this.superficieTotal;
	}

	public void setHipoteca(Hipoteca h) {
		this.hipoteca = h;
	}

	public Hipoteca getHipoteca() {
		return this.hipoteca;
	}

	public void setZonaGeografica(ZonaGeografica zg) {
		this.zonaGeografica = zg;
	}

	public ZonaGeografica getZonaGeografica() {
		return this.zonaGeografica;
	}

	public void setCodId(String c) {
		this.codID = c;
	}

	public String getCodId() {
		return this.codID;
	}

	public Asesor getAsesor() {
		return this.asesor;
	}

	public void setAsesor(Asesor a) {
		this.asesor = a;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente c) {
		this.cliente = c;
	}
	//Fin métodos getters and setters
	
	/**
	 * Añade una visita al inmueble
	 * @param v Visita que añadimos al inmueble
	 */
	public void añadirVisita(Visita v) {
		this.listaVisitas.add(v);
	}

	/**
	 * Elimina una visita del inmueble
	 * @param id Código de la visita que eliminamos
	 */
	public void eliminarVisita(String id) {
		this.listaVisitas.remove(obtenerVisitas(id));
	}

	/**
	 * Devuelve una visita específica
	 * @param id Código de la visita que buscamos
	 * @return Devuelve la visita que corresponda al código especificado
	 * y null si no existe
	 */
	public Visita obtenerVisitas(String id) {
		Visita vi = null;
		for (int i = 0; i < this.listaVisitas.size(); i++) {

			if (this.listaVisitas.get(i).getInm().getCodId().trim().equals(id))
				vi = this.listaVisitas.get(i);
		}
		return vi;
	}

	// Sobreescritura del método toString
	public String toString() {
		return "Código: " + getCodId();
	}// Fin de la sobreescritura del método toString.

}// Fin de inmueble.
