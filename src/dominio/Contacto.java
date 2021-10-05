package dominio;

public class Contacto {
	
	private boolean esCliente;
	private boolean deseaSerLlamadoNuevamente;
	private String nombre;
	private String apellido;
	private String celular;
	private String direccion;
	private Integer codPostal;
	private String localidad;
	private String provincia;

	public Contacto (String nombre, String apellido, String celular, String direccion, Integer codPostal, String localidad, String provincia){
		this.esCliente = false;
		this.deseaSerLlamadoNuevamente = true;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	public void setEsCliente (Boolean valor) {
		this.esCliente = valor;
	}
	
	public String getEsCliente () {
		String cadena = "No es cliente";
		if(this.esCliente) {
			cadena = "Es cliente";
		}
		return cadena;
	}
	
	public void setDeseaSerLlamado(Boolean valor) {
		this.deseaSerLlamadoNuevamente = valor;
	}
	public String getDeseaSerLlamado() {
		String cadena = "Desea ser llamado nuevamente";
		if(!this.deseaSerLlamadoNuevamente) {
			cadena = "No desea ser llamado nuevamente";
		}
		return cadena;
	}

	@Override
	public String toString() {
		return "Contacto [esCliente=" + esCliente + ", deseaSerLlamadoNuevamente=" + deseaSerLlamadoNuevamente
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", celular=" + celular + ", direccion=" + direccion
				+ ", codPostal=" + codPostal + ", localidad=" + localidad + ", provincia=" + provincia + "]";
	}
	
}
