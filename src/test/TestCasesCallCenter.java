package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.*;

public class TestCasesCallCenter {
	
	@Test
	public void queSePuedaInstanciarUnContacto() {
		String nombre = "Manuel", apellido = "Oyaregui", direccion = "Rivadavia5000", localidad = "Villa Luro", provincia = "Buenos Aires"; 
		String celular = "+54 9 11 51653508"; 
		Integer codPostal = 1407;
	
		Contacto contacto = new Contacto(nombre, apellido, celular, direccion, codPostal, localidad, provincia);
		
		assertNotNull(contacto);
	}
	
	@Test
	public void queSePuedaSaberSiElContactoEsOnoCliente() {
		String nombre = "Manuel", apellido = "Oyaregui", direccion = "Rivadavia5000", localidad = "Villa Luro", provincia = "Buenos Aires"; 
		String celular = "+54 9 11 51653508"; 
		Integer codPostal = 1407;
	
		Contacto contacto = new Contacto(nombre, apellido, celular, direccion, codPostal, localidad, provincia);
		
		String valorEsperado = "No es cliente";
		String valorObtenido = contacto.getEsCliente();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaPuedaConvertirUnContactoEnCliente() {
		String nombre = "Manuel", apellido = "Oyaregui", direccion = "Rivadavia5000", localidad = "Villa Luro", provincia = "Buenos Aires"; 
		String celular = "+54 9 11 51653508"; 
		Integer codPostal = 1407;
	
		Contacto contacto = new Contacto(nombre, apellido, celular, direccion, codPostal, localidad, provincia);
		contacto.setEsCliente(true);
		String valorEsperado = "Es cliente";
		String valorObtenido = contacto.getEsCliente();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaSaberSiDeseaSerLlamadoNuevamente() {
		String nombre = "Manuel", apellido = "Oyaregui", direccion = "Rivadavia5000", localidad = "Villa Luro", provincia = "Buenos Aires"; 
		String celular = "+54 9 11 51653508"; 
		Integer codPostal = 1407;
	
		Contacto contacto = new Contacto(nombre, apellido, celular, direccion, codPostal, localidad, provincia);
		
		String valorEsperado = "Desea ser llamado nuevamente";
		String valorObtenido = contacto.getDeseaSerLlamado();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queUnClienteNoDeseeSerLlamadoNuevamente() {
		String nombre = "Manuel", apellido = "Oyaregui", direccion = "Rivadavia5000", localidad = "Villa Luro", provincia = "Buenos Aires"; 
		String celular = "+54 9 11 51653508"; 
		Integer codPostal = 1407;
	
		Contacto contacto = new Contacto(nombre, apellido, celular, direccion, codPostal, localidad, provincia);
		contacto.setDeseaSerLlamado(false);
		
		String valorEsperado = "No desea ser llamado nuevamente";
		String valorObtenido = contacto.getDeseaSerLlamado();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	//Tests Callcenter
	@Test
	public void queSePuedaInstanciarUnCallcenter() {
		Integer cantidadDeContactos = 20;
		Callcenter callcenter = new Callcenter(cantidadDeContactos);
		
		assertNotNull(callcenter);
	}
	
	@Test
	public void queSePuedaAgregarUnContactoAlaListaDeContactosDelCallcenter() {
		String nombre = "Manuel", apellido = "Oyaregui", direccion = "Rivadavia5000", localidad = "Villa Luro", provincia = "Buenos Aires"; 
		String celular = "+54 9 11 51653508"; 
		Integer codPostal = 1407;
		Integer cantidadMaximaDeContactosCallcenter = 20;
	
		Contacto contacto = new Contacto(nombre, apellido, celular, direccion, codPostal, localidad, provincia);
		Callcenter callcenter = new Callcenter(cantidadMaximaDeContactosCallcenter);
		
		Boolean valorObtenido = callcenter.agregarContactoAListaDeContactos(contacto);
		
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarVariosContactosALaLista() {
		String nombre = "Manuel", apellido = "Oyaregui", direccion = "Rivadavia5000", localidad = "Villa Luro", provincia = "Buenos Aires"; 
		String celular = "+54 9 11 51653508"; 
		Integer codPostal = 1407;
		Integer cantidadMaximaDeContactosCallcenter = 20;
	
		Contacto contacto = new Contacto("Manuel", "Oyaregui", "+54 9 11 51653508", "Rivadavia 5000", 1407, "Villa Luro", "Buenos Aires");
		Contacto contacto_1 = new Contacto("Pedro", "Picapiedra", "011 34596875", "De Tierra 208", 0000, "Por Ahí", "Por Alla");
		Contacto contacto_2 = new Contacto("Gallo", "Claudio", "15 42568795", "Del Gallinero 5", 0101, "El Campo", "La Pampa");
		
		
		Callcenter callcenter = new Callcenter(cantidadMaximaDeContactosCallcenter);
		callcenter.agregarContactoAListaDeContactos(contacto);
		callcenter.agregarContactoAListaDeContactos(contacto_1);
		callcenter.agregarContactoAListaDeContactos(contacto_2);
		
		assertNotNull(contacto);
		assertNotNull(contacto_1);
		assertNotNull(contacto_2);
	}
	
	
	@Test
	public void queSePuedaSeleccionarUnCandidatoASerLlamado() {
		Integer cantidadMaximaDeContactosCallcenter = 20;
	
		Contacto contacto = new Contacto("Manuel", "Oyaregui", "+54 9 11 51653508", "Rivadavia 5000", 1407, "Villa Luro", "Buenos Aires");
		Contacto contacto_1 = new Contacto("Pedro", "Picapiedra", "011 34596875", "De Tierra 208", 0000, "Por Ahí", "Por Alla");
		Contacto contacto_2 = new Contacto("Gallo", "Claudio", "15 42568795", "Del Gallinero 5", 0101, "El Campo", "La Pampa");
		
		
		Callcenter callcenter = new Callcenter(cantidadMaximaDeContactosCallcenter);
		callcenter.agregarContactoAListaDeContactos(contacto);
		callcenter.agregarContactoAListaDeContactos(contacto_1);
		callcenter.agregarContactoAListaDeContactos(contacto_2);
		
		Contacto valorObtenido = callcenter.buscarAlCandidato();
		
		assertNotNull(valorObtenido);
	}
	
	@Test
	public void queNoSePuedaSeleccionarUnCandidatoASerLlamado() {
		Integer cantidadMaximaDeContactosCallcenter = 20;
	
		Contacto contacto = new Contacto("Manuel", "Oyaregui", "+54 9 11 51653508", "Rivadavia 5000", 1407, "Villa Luro", "Buenos Aires");
		contacto.setEsCliente(true);
		Contacto contacto_1 = new Contacto("Pedro", "Picapiedra", "011 34596875", "De Tierra 208", 0000, "Por Ahí", "Por Alla");
		contacto_1.setDeseaSerLlamado(false);
		Contacto contacto_2 = new Contacto("Gallo", "Claudio", "15 42568795", "Del Gallinero 5", 0101, "El Campo", "La Pampa");
		contacto_2.setDeseaSerLlamado(false);
		
		
		Callcenter callcenter = new Callcenter(cantidadMaximaDeContactosCallcenter);
		callcenter.agregarContactoAListaDeContactos(contacto);
		callcenter.agregarContactoAListaDeContactos(contacto_1);
		callcenter.agregarContactoAListaDeContactos(contacto_2);
		
		Contacto valorObtenido = callcenter.buscarAlCandidato();
		
		assertNull(valorObtenido);
	}
	
	@Test
	public void queSePuedaSeleccionarUnCandidatoEspecificoASerLlamado() {
		Integer cantidadMaximaDeContactosCallcenter = 20;
	
		Contacto contacto = new Contacto("Manuel", "Oyaregui", "+54 9 11 51653508", "Rivadavia 5000", 1407, "Villa Luro", "Buenos Aires");
		contacto.setEsCliente(true);
		Contacto contacto_1 = new Contacto("Pedro", "Picapiedra", "011 34596875", "De Tierra 208", 0000, "Por Ahí", "Por Alla");
		Contacto contacto_2 = new Contacto("Gallo", "Claudio", "15 42568795", "Del Gallinero 5", 0101, "El Campo", "La Pampa");
		contacto_2.setDeseaSerLlamado(false);
		
		
		Callcenter callcenter = new Callcenter(cantidadMaximaDeContactosCallcenter);
		callcenter.agregarContactoAListaDeContactos(contacto);
		callcenter.agregarContactoAListaDeContactos(contacto_1);
		callcenter.agregarContactoAListaDeContactos(contacto_2);
		
		Contacto valorObtenido = callcenter.buscarAlCandidato();
		Contacto valorEsperado = contacto_1;
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	

}
