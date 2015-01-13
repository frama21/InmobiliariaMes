package persistencia;

import java.util.*;
import java.sql.*;

import logica.NaveIndustrial;
import excepciones.DAOExcepcion;
import logica.Inmueble;

public class NaveIndustrialDAOImp extends InmuebleDAOImp implements
		INaveIndustrialDAO {

	public NaveIndustrial encontrarNaveIndustrialPorCod(String cod)
			throws DAOExcepcion {
		try {
			Inmueble inmueble = encontrarInmueblePorCod(cod);
			if (inmueble != null) {
				connManager.connect();
				ResultSet rs = connManager
						.queryDB("select * from NAVEINDUSTRIAL where COD_ID = '"
								+ cod + "'");
				connManager.close();

				if (rs.next())
					return new NaveIndustrial(cod, inmueble.getCalle(),
							inmueble.getLocalidad(), inmueble.getFechaAlta(),
							inmueble.getSuperficieTotal(),
							inmueble.getVentaAlquiler(),
							rs.getString("NUM_PUERTAS"),
							rs.getString("CALIFICACION"), inmueble.getAsesor(),
							inmueble.getCliente());
			}
			return null;

		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
	}

	@Override
	public void crearNaveIndustrial(NaveIndustrial p) throws DAOExcepcion {
		try {
			// Antes de crear la NaveIndustrial, creamos el inmueble
			crearInmueble(new Inmueble(p.getCodId(), p.getCalle(),
					p.getLocalidad(), p.getFechaAlta(), p.getSuperficieTotal(),
					p.getVentaAlquiler(), p.getAsesor(), p.getCliente()));

			// Ahora creamos la NaveIndustrial.
			connManager.connect();

			connManager
					.updateDB("insert into NAVEINDUSTRIAL (COD_ID, NUM_PUERTAS, CALIFICACION) "
							+ "values ('"
							+ p.getCodId()
							+ "', '"
							+ p.getNumPuertas()
							+ "', '"
							+ p.getCalificacion()
							+ "')");
			connManager.close();

		} catch (Exception e) {
			throw new DAOExcepcion(e);
		}
	}

	@Override
	public List<NaveIndustrial> encontrarNavesIndustriales()
			throws DAOExcepcion {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from NAVEINDUSTRIAL");
			connManager.close();

			List<NaveIndustrial> listaNave = new ArrayList<NaveIndustrial>();
			try {
				while (rs.next()) {
					NaveIndustrial p = encontrarNaveIndustrialPorCod(rs
							.getString("COD_ID"));
					listaNave.add(p);
				}
				return listaNave;
			} catch (Exception e) {
				throw new DAOExcepcion(e);
			}
		} catch (DAOExcepcion e) {
			throw e;
		}
	}

	public NaveIndustrialDAOImp() throws DAOExcepcion {
		super(); // inits and connects the connManager
	}

}
