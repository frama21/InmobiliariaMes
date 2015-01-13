package persistencia;

import java.util.List;
import logica.Visita;
import excepciones.DAOExcepcion;

public interface IVisitaDAO {

	public Visita encontrarVisitaPorCod(String cod)throws DAOExcepcion;
	public void crearVisita (Visita i)throws DAOExcepcion;
	List<Visita> encontrarVisitas() throws DAOExcepcion;
}
