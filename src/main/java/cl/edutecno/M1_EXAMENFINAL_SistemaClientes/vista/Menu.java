package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.vista;

import java.util.List;
import java.util.Scanner;

import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.CategoriaEnum;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.Cliente;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ArchivoServicio;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ClienteServicio;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ExportadorCsv;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ExportadorTxt;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.utilidades.Utilidad;

public class Menu {

	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	ClienteServicio clienteServicio = new ClienteServicio(null);
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportarTxt = new ExportadorTxt();
	static Scanner scI = new Scanner(System.in);
	static Scanner scS = new Scanner(System.in);

	// Metodos
	public void iniciarMenu(Scanner scI) {
		
		List<Cliente> listaClientes = clienteServicio.getListaCliente();
		
		try {
			int opcion;
			do {
				System.out.println("1. Listar Clientes");
				System.out.println("2. Agregar Clientes");
				System.out.println("3. Editar Cliente");
				System.out.println("4. Cargar Datos");
				System.out.println("5. Exportar Datos");
				System.out.println("6. Salir");
				System.out.print("Seleccion: ");
				opcion = scI.nextInt();

				switch (opcion) {
				case 1:
					listarCliente();
					break;
				case 2:
					agregarCliente();
					break;
				case 3:
					editarCliente();
					break;
				case 4:
					importarDatos();
					break;
				case 5:
					exportarDatos();
					break;
				case 6:
					terminarPrograma();
					break;
				default:
					System.out.println("---------------OPCION NO VALIDA---------------");
					break;
				}

			} while (opcion != 6);

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Caracter no valido: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en ejecucion menu: " + e.getMessage());
		}

	}

	public void listarCliente() {
		
		clienteServicio.listarCliente();
		
		System.out.println("");
	}

	public void agregarCliente() {

		String dato = "";
		Cliente cliente = new Cliente();

		try {

			System.out.println("");
			System.out.println("---------------CREAR CLIENTE---------------");
			System.out.println("");
			System.out.print("Ingrese RUN del Cliente: ");
			dato = scS.nextLine();
			cliente.setRunCliente(dato);
			System.out.print("Ingrese Nombre del Cliente: ");
			dato = scS.nextLine();
			cliente.setNombreCliente(dato);
			System.out.print("Ingrese Apellido del Cliente: ");
			dato = scS.nextLine();
			cliente.setApellidoCliente(dato);
			System.out.print("Ingrese años como Cliente: ");
			dato = scS.nextLine();
			cliente.setAniosCliente(dato + " años");
			cliente.setNombreCategoria(CategoriaEnum.ACTIVO);// Por defecto al crear cliente
			
			clienteServicio.agregarCliente(cliente);
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en ejecucion Crear Cliente: " + e.getMessage());
		}
		
		System.out.println("-------------------------------------------");
		System.out.println("");
		//return listaClientes;
	}

	public void editarCliente() {
		int opcion;
		String rut;
		
		try {
			System.out.println("");
			System.out.println("---------------EDITAR CLIENTE---------------");
			System.out.println("");
			System.out.println("Seleccione qué desea hacer");
			System.out.println("1. Cambiar el estado del Cliente");
			System.out.println("2. Editar los datos ingresados del Cliente");
			System.out.println("3. Retornar al menu principal");
			System.out.println("");
			System.out.print("Ingrese opcion: ");
			opcion = scI.nextInt();
			if (opcion == 3) {
				System.out.println("-------------------------------------------");
				System.out.println("");
				iniciarMenu(scI);
			}else if (opcion == 1 || opcion == 2) {
				System.out.print("Ingrese RUN del cliente a editar: ");
				rut = scS.nextLine();
				clienteServicio.editarCliente(rut, opcion);
			}else {
				System.out.println("Opcion no valida");
			}
			System.out.println("-------------------------------------------");
			System.out.println("");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en ejecucion Editar Cliente: " + e.getMessage());
		}
		
	}

	public void importarDatos() {
		// Ejecuta la carga de datos del archivo "DBCLientes.csv"
		System.out.println("Metodo impotarDatos");
	}

	public void exportarDatos() {
		// Llama a metodo para exportar clientes en formato ".txt" O ".csv"
		System.out.println("Metodo exportarDatos");
	}

	public void terminarPrograma() {

		Utilidad utilidad = new Utilidad();

		utilidad.tiempoEspera();
		utilidad.limpiezaPantalla();

	}

}
