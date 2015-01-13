package persistencia;

import java.util.List;
import logica.Transaccion;
import excepciones.DAOExcepcion;

public interface ITransaccionDAO {
	
	public Transaccion encontrarTransaccionPorCod(String cod)throws DAOExcepcion;
	public void crearTransaccion (Transaccion i)throws DAOExcepcion;
	public List<Transaccion> encontrarTransaccion() throws DAOExcepcion;

}
