package logica;

import java.util.ArrayList;

public class ZonaGeografica {
	private String codigo;
	ArrayList<Cliente> clientes;
	ArrayList<Inmueble> inmuebles;
	
	public ZonaGeografica (String codigo) {
		this.codigo = codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	//CLIENTES
	//Añadir 
	public void añadirCliente(Cliente c){
		clientes.add(c);
	}
	//Eliminar
	public void eliminarCliente(String telf){	
		clientes.remove(obetenerCliente(telf));
	}

	//Obtener Inmueble
	public int obetenerCliente(String telf){
		int res = 0;
		for(int i = 0 ; i < clientes.size() ; i++){		
			if(clientes.get(i).getTelefono().equals(telf)) res = i;
		}
		return res;
	}

	//INMUEBLE
	//Añadir 
	public void añadirInmueble(Inmueble i){
		inmuebles.add(i);
	}

	//Eliminar Inmueble
	public void eliminarInmueble(String c){	
		inmuebles.remove(obetenerInmueble(c));
	}

	//Obtener Inmueble
	public int obetenerInmueble(String c){
		int res = 0;
		for(int i = 0 ; i < inmuebles.size() ; i++){		
			if(inmuebles.get(i).getCodId().equals(c)) res = i;
		}
		return res;
	}


}//Fin de la clase.
