package logica;

import java.util.ArrayList;

/**
 * Clase para representar a los asesores de la inmobiliaria
 */
public class Asesor {

	/**
	 * Atributos de la clase
	 */
	private String codigoEmpleado;
	private String nombre;
	private Visita visita;
	private Inmobiliaria inmobiliaria;
	private ArrayList<Visita> visitas;

	/**
	 * Constructor de la clase Asesor
	 * 
	 * @param unCodigoEmpleado Código de identificación de la clase
	 * @param unNombre Nombre de un asesor
	 */
	public Asesor(String unCodigoEmpleado, String unNombre) {
		this.codigoEmpleado = unCodigoEmpleado;
		this.nombre = unNombre;
	}//Fin del constructor

	/**
	 * Establece el código de un asesor
	 * 
	 * @param unCodigoEmp Código de un asesor
	 */
	public void setCodigoEmp(String unCodigoEmp) {
		this.codigoEmpleado = unCodigoEmp;
	}

	/**
	 * @return Devuelve el código de un asesor
	 */
	public String getCodigoEmp() {
		return this.codigoEmpleado;
	}

	/**
	 * Establece una visita
	 * 
	 * @param unaVisita Visita relacionada con un asesor
	 */
	public void setVisita(Visita unaVisita) {
		this.visita = unaVisita;
	}

	/**
	 * @return Devuelve una visita asociada a un asesor
	 */
	public Visita getVisita() {
		return this.visita;
	}

	/**
	 * Establece una inmobiliaria a la que estará asociado un asesor
	 * 
	 * @param unaInmobiliaria Inmobiliaria asociada a un asesor
	 */
	public void setInmobiliaria(Inmobiliaria unaInmobiliaria) {
		this.inmobiliaria = unaInmobiliaria;
	}

	/**
	 * @return Devuelve la inmobiliaria asociada
	 */
	public Inmobiliaria getInmobiliaria() {
		return this.inmobiliaria;
	}

	/**
	 * Añade una visita a la lista de visitas asociadas a un asesor
	 * 
	 * @param unaVisita Visita que va a ser asociada al asesor
	 */
	public void añadirVisita(Visita unaVisita) {
		this.visitas.add(unaVisita);
	}

	/**
	 * Elimina una visita de la lista de visitas asociadas a un asesor
	 * 
	 * @param unaFecha Fecha de la visita que va a ser eliminada
	 */
	public void eliminarVisita(String unaFecha) {
		this.visitas.remove(obetenerVisita(unaFecha));
	}

	/**
	 * Devuelve la posición de la visita que coincida con la fecha especificada
	 * por parámetro
	 * 
	 * @param unaFecha Fecha de la visita que queremos obtener
	 * @return Devuelve la posición de la visita en la lista de visitas
	 *         asociadas al asesor
	 */
	public int obetenerVisita(String unaFecha) {
		int res = 0;
		for (int i = 0; i < this.visitas.size(); i++) {
			if (this.visitas.get(i).getFecha().equals(unaFecha))
				res = i;
		}
		return res;
	}

	/**
	 * @return Devuelve el nombre de un asesor
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Establece el nombre de un asesor
	 * 
	 * @param unNombre Nombre que corresponderá a un asesor
	 */
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}

	/**
	 * Devuelve un String con el nombre de un asesor
	 */
	public String toString() {
		return getNombre();
	}
}//Fin de la clase
