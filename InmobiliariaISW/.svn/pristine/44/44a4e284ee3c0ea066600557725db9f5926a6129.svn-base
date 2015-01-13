package logica;

import java.util.ArrayList;

/**
 * Clase que representa a la inmobiliaria de la aplicación
 */
public class Inmobiliaria {

	/**
	 * Atributos de la clase
	 */
	private String nombre;
	private ArrayList<Asesor> listaAsesores;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Inmueble> listaInmuebles;

	/**
	 * Construtor de la clase
	 * @param nombre Nombre que recibe la inmobiliaria
	 */
	public Inmobiliaria(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Establece el nombre de la inmobiliaria
	 * @param nombre Nombre elegido para la inmobiliaria
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Devuelve el nombre de la inmobiliaria
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Añade un asesor a la inmobiliaria
	 * @param unAsesor Asesor que añadimos a la inmobiliaria
	 */
	public void añadirAsesor(Asesor unAsesor) {
		this.listaAsesores.add(unAsesor);
	}

	/**
	 * Elimina un asesor de la inmobiliaria
	 * @param codAsesor Código del asesor que eliminamos
	 */
	public void eliminarAsesor(String codAsesor) {
		this.listaAsesores.remove(obetenerAsesor(codAsesor));
	}

	/**
	 * Obtiene un asesor asociado a la inmobiliaria
	 * @param codAsesor Código del asesor que queremos recuperar
	 * @return Devuelve la posición en la lista del asesor y 0 si no está
	 */
	public int obetenerAsesor(String codAsesor) {
		int res = 0;
		for (int i = 0; i < this.listaAsesores.size(); i++) {
			if (this.listaAsesores.get(i).getCodigoEmp().equals(codAsesor))
				res = i;
		}
		return res;
	}

	/**
	 * Añade un cliente a la inmobiliaria
	 * @param codCliente cliente que añadimos a la inmobiliaria
	 */
	public void añadirCliente(Cliente codCliente) {
		this.listaClientes.add(codCliente);
	}

	/**
	 * Elimina un cliente de la inmobiliaria
	 * @param codCliente Código del cliente que eliminamos
	 */
	public void eliminarCliente(int codCliente) {
		this.listaClientes.remove(obetenerCliente(codCliente));
	}

	/**
	 * Obtiene un Cliente asociado a la inmobiliaria
	 * @param codCliente Código del Cliente que queremos recuperar
	 * @return Devuelve la posición en la lista del Cliente y 0 si no está
	 */
	public int obetenerCliente(int codCliente) {
		int res = 0;
		for (int i = 0; i < this.listaClientes.size(); i++) {
			if (this.listaClientes.get(i).getTelefono().equals(codCliente))
				res = i;
		}
		return res;
	}

	/**
	 * Añade un inmueble a la inmobiliaria
	 * @param inmueble que añadimos a la inmobiliaria
	 */
	public void añadirInmueble(Inmueble inmueble) {
		this.listaInmuebles.add(inmueble);
	}

	/**
	 * Elimina un inmueble de la inmobiliaria
	 * @param codInmueble Código del inmueble que eliminamos
	 */
	public void eliminarInmueble(String codInmueble) {
		this.listaInmuebles.remove(obetenerInmueble(codInmueble));
	}

	/**
	 * Obtiene un inmueble asociado a la inmobiliaria
	 * @param codInmueble Código del inmueble que queremos recuperar
	 * @return Devuelve la posición en la lista del inmueble y 0 si no está
	 */
	public int obetenerInmueble(String codInmueble) {
		int res = 0;
		for (int i = 0; i < this.listaInmuebles.size(); i++) {
			if (this.listaInmuebles.get(i).getCodId().equals(codInmueble))
				res = i;
		}
		return res;
	}

}// Fin de la clase