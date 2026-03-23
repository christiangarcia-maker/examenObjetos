package objetos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainEmpleados {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcionMenu = 0;
		
		System.out.println("-------------------------------------");
		System.out.println("BIENVENIDO A LA GESTIÓN DE EMPLEADOS");
		System.out.println("-------------------------------------");
	
		do {
			try {
				imprimirMenu();
				opcionMenu = sc.nextInt();
				sc.nextLine();
				
				switch (opcionMenu) {
				case 1:
					aniadirEmpleado();
					break;
				case 2:
					listaEmpleado()
					break;
				case 3:
					buscarPorDni();
					break;
				case 4:
					modificarHorasExtras();
					break;
				case 5:
					modificarBonificacion();
					break;
				case 6:
					modificarPrecioHoraExtra();
					break;
				case 7:
					eliminarEmpleado();
					break;
				case 8:
					verEstadisticas();
				case 9:
					System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
					break;
				}
			}catch (InputMismatchException e) {
				System.out.println("Error: Introduce un número valido.");
				sc.nextLine();			}
		} while (opcionMenu != 9);

	}

	private static void imprimirMenu() {
		System.out.println(
		"\n1.Añadir | 2.Lista | 3.Buscar empleado por DNI | 4.Modificar horas extras | 5.Modificar bonificacion | 6.Modificar precio hora extra | 7.Eliminar empleado | 8.Ver estadísticas | 9.Salir");
		System.out.println("Seleccion");
	}

	    private static void aniadirEmpleado() {
	        System.out.print("Nombre del empleado: ");String nombre = sc.nextLine();
	        System.out.print("DNI: "); String dni = sc.nextLine();
	        System.out.println("Salario Base: "); double sb = sc.nextDouble();
	        System.out.println("Porcentaje Bonificacion: "); int pb = 
	       
	        GestionEmpleado nuevo = new GestionEmpleados(nombre, dni, sb, pb);
	        
	        if (empleado.aniaadirEmpleado(nuevo)) {
	            System.out.println("Empleado añadido con éxito.");
	        } else {
	            System.out.println("No se pudo añadir el empleado.");
	        }
	    }

	    private static void funcionBuscar() {
	        System.out.print("Introduce el DNI a buscar: ");
	        String dni = sc.nextLine();
	        GestionEmpleados e = empleado.buscarPorDni(dni);
	        if (e != null) {
	            System.out.println("Resultado: " + e.toString());
	        } else {
	            System.out.println("No existe ningún empleado con ese DNI.");
	        }
	    }

	    private static void funcionModificarHoras() {
	        System.out.print("DNI del empleado: ");
	        String dni = sc.nextLine();
	        System.out.print("Cantidad de horas extra realizadas: ");
	        int horas = sc.nextInt();
	        
	        if (sistema.modificarHorasExtra(dni, horas)) {
	            System.out.println("Horas actualizadas correctamente.");
	        } else {
	            System.out.println("Error: DNI no encontrado.");
	        }
	    }

	    private static void funcionModificarBoni() {
	        System.out.print("DNI del empleado: ");
	        String dni = sc.nextLine();
	        System.out.print("Nuevo porcentaje de bonificación: ");
	        double porcentaje = sc.nextDouble();
	        
	        if (sistema.modificarBonificacion(dni, porcentaje)) {
	            System.out.println("Bonificación actualizada.");
	        } else {
	            System.out.println("Error: DNI no encontrado.");
	        }
	    }

	    private static void funcionPrecioHoraGlobal() {
	        System.out.print("Nuevo precio para la hora extra: ");
	        double precio = sc.nextDouble();
	        // Asumiendo que existe un método estático en tu clase para esto
	        GestionEmpleados.setPrecioHoraExtra(precio);
	        System.out.println("Precio actualizado para todo el sistema.");
	    }

	    private static void funcionEliminar() {
	        System.out.print("Introduce el DNI del empleado a eliminar: ");
	        String dni = sc.nextLine();
	        if (sistema.eliminarPorDni(dni)) {
	            System.out.println("Registro eliminado satisfactoriamente.");
	        } else {
	            System.out.println("El DNI no existe en la base de datos.");
	        }
	    }

	    private static void funcionEstadisticas() {
	        System.out.println("\n--- ANÁLISIS DE DATOS ---");
	        double total = sistema.calcularGastoBonificaciones();
	        System.out.println("Gasto total en bonificaciones: " + total + "€");
	        sistema.listarEmpleadosAltoDesempenio();
	    }
	}



