package logica;

import java.util.ArrayList;

/**
 * Clase para representar a los clientes de la inmobiliaria
 */
public class Cliente {

	/**
	 * Atributos de la clase
	 */
	private String nombre;
	private String apellidos;
	private String nif;
	private String telefono;
	private String zonaInteres;
	private String precioMax;
	private Interesado interesado;
	private ArrayList<Visita> listaVisitas;
	private ArrayList<ZonaGeografica> listaZonasGeograficas;
	private ArrayList<Inmueble> listaInmueble;

	/**
	 * Constructor de la clase
	 * 
	 * @param nif nif de identificación del cliente
	 * @param nombre Nombre del cliente
	 * @param apellidos Apellidos del cliente
	 */
	public Cliente(String nif, String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
	}//Fin del constructor

	//Médodos getters and setters
	public void setInteresado(Interesado interesado) {
		this.interesado = interesado;
	}

	public Interesado getInteresado() {
		return interesado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setZonaInteres(String zonaInteres) {
		this.zonaInteres = zonaInteres;
	}

	public String getZonaInteres() {
		return zonaInteres;
	}

	public void setPrecioMax(String precioMax) {
		this.precioMax = precioMax;
	}

	public String getPrecioMax() {
		return this.precioMax;
	}
	//Fin métodos getters and setters

	/**
	 * Añade una visita a la lista de visitas del cliente
	 * @param unaVisita Visita que añadimos a la lista
	 */
	public void añadirVisita(Visita unaVisita) {
		this.listaVisitas.add(unaVisita);
	}

	/**
	 * Elimina una visita de la lista
	 * @param fecha Fecha de la visita que vamos a borrar 
	 */
	public void eliminarVisita(String fecha) {
		this.listaVisitas.remove(obetenerVisita(fecha));
	}

	// Obtener Asesor
	public int obetenerVisita(String fecha) {
		int res = 0;
		for (int i = 0; i < this.listaVisitas.size(); i++) {
			if (this.listaVisitas.get(i).getFecha().equals(fecha))
				res = i;
		}
		return res;
	}

	// Zonas Geograficas
	// Añadir
	public void añadirZonaGeografica(ZonaGeografica z) {
		this.listaZonasGeograficas.add(z);
	}

	// Eliminar
	public void eliminarZonaGeografica(String cod) {
		this.listaZonasGeograficas.remove(obetenerzonaGeografica(cod));
	}

	// Obtener
	public int obetenerzonaGeografica(String cod) {
		int res = 0;
		for (int i = 0; i < this.listaZonasGeograficas.size(); i++) {
			if (this.listaZonasGeograficas.get(i).getCodigo().equals(cod))
				res = i;
		}
		return res;
	}

	// Inmuebles
	// Añadir
	public void añadirInmueble(Inmueble z) {
		this.listaInmueble.add(z);
	}

	// Eliminar
	public void eliminarInmueble(String cod) {
		this.listaInmueble.remove(obetenerzonaGeografica(cod));
	}

	// Obtener
	public int obetenerInmueble(String cod) {
		int res = 0;
		for (int i = 0; i < this.listaInmueble.size(); i++) {
			if (this.listaInmueble.get(i).getCodId().equals(cod))
				res = i;
		}
		return res;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String toString() {
		return getNombre();
	}

}// Fin de la clase.
