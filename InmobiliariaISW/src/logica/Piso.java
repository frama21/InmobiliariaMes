package logica;

public class Piso extends Inmueble { // NOPMD by joseph on 8/01/15 21:32

	private String numHabitaciones;
	private PlazaGaraje plazaGaraje;
	private CasaPueblo casaPueblo;

	public Piso(String unCodigo, String unaCalle, String unaLocalidad,
			String unaFechaAlta, String unaSuperficieTot,
			String unaVentaAlquiler, String unNumHabitaciones, Asesor unAsesor,
			Cliente unCliente) {
		super(unCodigo, unaCalle, unaLocalidad, unaFechaAlta, unaSuperficieTot,
				unaVentaAlquiler, unAsesor, unCliente);

		numHabitaciones = unNumHabitaciones;
		// TODO Auto-generated constructor stub
	}

	public void setNumHabitaciones(String nh) {
		numHabitaciones = nh;
	}

	public String getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setGaraje(PlazaGaraje pg) {
		plazaGaraje = pg;
	}

	public PlazaGaraje getGaraje() {
		return plazaGaraje;
	}

	public CasaPueblo getCasapueblo() {
		return casaPueblo;
	}

	public void setCasapueblo(CasaPueblo cp) {
		casaPueblo = cp;
	}

}// Fin de la clase
