package persistencia;
import java.util.List;

import excepciones.*;
import logica.Inmueble;

public interface IInmuebleDAO {

	public Inmueble encontrarInmueblePorCod(String cod)throws DAOExcepcion;
	public void crearInmueble (Inmueble i)throws DAOExcepcion;
	List<Inmueble> encontrarInmuebles() throws DAOExcepcion;


}
