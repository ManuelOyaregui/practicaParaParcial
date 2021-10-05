package interfaz;

import java.util.Scanner;

import dominio.*;

public class adminCallcenter {

	static Scanner teclado = new Scanner(System.in);
	// Crear Callcenter
	static Callcenter callcenter = new Callcenter(5);

	public static void main(String[] args) {
		Integer opcion = 0;
		do {
			menuPrincipal();
			opcion = teclado.nextInt();
			evaluarOpcion(opcion);
		} while (opcion != 0);

	}

	public static void menuPrincipal() {
		System.out.println(
				"---CALLCENTER OESTE CABLE COLOR---" + "\n" + "¿Qué desea hacer?" + "\n" + "1. Realizar nueva llamada."
						+ "\n" + "2. Agregar Contacto." + "\n" + "0. Salir." + "\n" + "Ingrese su opción aquí -->");
	}

	public static void evaluarOpcion(Integer opcion) {
		switch (opcion) {
		case 0: {
			System.out.println("Ok... Saliendo");
		}
			break;
		case 1: {
			System.out.println("opcion elegida --> 1. Realizar nueva llamada.");
			Contacto contactoRandom = callcenter.buscarAlCandidato();
			if (contactoRandom != null) {
				System.out.println();
				System.out.println("¿Cómo fue en la llamada?" + "\n 1. Nuevo cliente."
						+ "\n 2. El contacto no desea ser llamado nuevamente"
						+ "\n 3. El contacto no quiso ser cliente");
				Integer subOpcion = teclado.nextInt();

				switch (subOpcion) {
				case 1: {
					contactoRandom.setEsCliente(true);
					contactoRandom.setDeseaSerLlamado(false);
				}
					break;
				case 2: {
					contactoRandom.setDeseaSerLlamado(false);
				}
				break;
				default:
					System.out.println("Opción Incorrecta");
				}
			}
			else {
				System.out.println("No hay contactos por llamar");
			}
		}
		break;
		case 2:{
			String nombre, apellido, direccion, localidad, provincia, celular = "+54 9 11 51653508"; 
			Integer codPostal;
			
			System.out.print("Ingrese Código Postal: ");
			codPostal = teclado.nextInt();
			System.out.print("Ingrese Nombre: ");
			nombre = teclado.nextLine();
			teclado.next();
			System.out.print("Ingrese Apellido: ");
			apellido = teclado.nextLine();
			teclado.next();
			System.out.print("Ingrese Direccion: ");
			direccion = teclado.nextLine();
			teclado.next();
			System.out.print("Ingrese Localidad: ");
			localidad = teclado.nextLine();
			teclado.next();
			System.out.print("Ingrese Provincia: ");
			provincia = teclado.nextLine();
			teclado.next();
			System.out.print("Ingrese Celular: ");
			celular = teclado.nextLine();
			teclado.next();
			
			Contacto contacto = new Contacto(nombre, apellido, celular, direccion, codPostal, localidad, provincia);
			callcenter.agregarContactoAListaDeContactos(contacto);
		
		}
		break;
		default:
			System.out.println("Opcion incorrecta.");
		}
	}
}
