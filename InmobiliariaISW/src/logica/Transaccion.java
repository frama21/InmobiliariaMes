package logica;

public class Transaccion {

	private String codigo;
	private String precioFinal;
	private String fecha;
	private String compraAlquiler;
	private Oferta oferta;

	public Transaccion(String unCodigo, String unPrecioFinal, String unaFecha,
			String unaCompraAlquiler, Oferta unaOferta) {
		codigo = unCodigo;
		precioFinal = unPrecioFinal;
		fecha = unaFecha;
		compraAlquiler = unaCompraAlquiler;
		oferta = unaOferta;
	}

	public void setPrecioFinal(String p) {
		precioFinal = p;
	}

	public String getPrecioFinal() {
		return precioFinal;
	}

	public void setFecha(String f) {
		fecha = f;
	}

	public String getFecha() {
		return fecha;
	}

	public void setCompraAlquiler(String ca) {
		compraAlquiler = ca;
	}

	public String getCompraAlquiler() {
		return compraAlquiler;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta o) {
		oferta = o;
	}

	public String getCod() {
		return codigo;
	}

	public void setCod(String c) {
		codigo = c;
	}

	// Método toString sobreescrito.
	public String toString() {
		return "Transacción de código: " + getCod();
	}

}// Fin de Transacción.
