package dominio;

import java.util.Iterator;

public class Callcenter {
	Contacto[] listaContactos;

	public Callcenter(Integer cantidadDeContactos) {
		this.listaContactos = new Contacto[cantidadDeContactos];
	}

	public Boolean agregarContactoAListaDeContactos(Contacto contacto) {
		Boolean sePudoAgregar = false;
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] == null) {
				listaContactos[i] = contacto;
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}

	public Contacto buscarAlCandidato() {
		Contacto contacto = null;
		Integer limiteContactos = listaContactos.length;
		Integer nroAleatorio;
		for(int i = 0; contacto == null && i <= limiteContactos*2; i++) {
			nroAleatorio = (int)(Math.random()*limiteContactos);
			Contacto contactoEncontrado = listaContactos[nroAleatorio];
			
			if(contactoEncontrado != null && 
					contactoEncontrado.getEsCliente() == "No es cliente" &&
					contactoEncontrado.getDeseaSerLlamado() == "Desea ser llamado nuevamente") {
				contacto = contactoEncontrado;
				break;
			}
			
		}

		return contacto;
	}

}
