package logica;

public class NaveIndustrial extends Inmueble {

	private String numPuertas;
	private String calificacion;

	public NaveIndustrial(String unCodigo, String unaCalle,
			String unaLocalidad, String unaFechaAlta, String unaSuperficieTot,
			String unaVentaAlquiler, String unNumPuertas,
			String unaCalificacion, Asesor unAsesor, Cliente unCliente) {

		super(unCodigo, unaCalle, unaLocalidad, unaFechaAlta, unaSuperficieTot,
				unaVentaAlquiler, unAsesor, unCliente);

		// TODO Auto-generated constructor stub
		numPuertas = unNumPuertas;
		calificacion = unaCalificacion;
	}

	public void setNumPuertas(String np) {
		numPuertas = np;
	}

	public String getNumPuertas() {
		return numPuertas;
	}

	public void setCalificacion(String c) {
		calificacion = c;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public String toString() {
		return getNumPuertas();

	}

}
