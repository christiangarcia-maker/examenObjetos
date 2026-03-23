import java.util.Scanner;

/**
 * Clase Principal que gestiona el menú interactivo del sistema.
 */
public class MainEmpleados {
    private static Scanner sc = new Scanner(System.in);
    private static GestionEmpleados lista = new GestionEmpleados();

    public static void main(String[] args) {
        System.out.println("--- Bienvenido al Sistema de Gestión de Empleados ---");
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: añadirEmpleado(); break; 
                case 2: lista.listarTodos(); break; 
                case 3: buscarEmpleado(); break; 
                case 4: modificarHoras(); break;
                case 5: modificarBonificacion(); break; 
                case 6: modificarPrecioHoraExtra(); break; 
                case 8: verEstadisticas(); break;
                case 9: System.out.println("Gracias por usar el sistema. ¡Hasta pronto!"); break; 
                default: System.out.println("Error: Opción no válida.");
            }
        } while (opcion != 9);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE GESTIÓN ---");
        System.out.println("1. Añadir empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Buscar empleado por DNI");
        System.out.println("4. Modificar horas extra");
        System.out.println("5. Modificar bonificación");
        System.out.println("6. Modificar precio hora extra");
        System.out.println("7. Eliminar empleado");
        System.out.println("8. Ver estadísticas");
        System.out.println("9. Salir");
    }

    private static void añadirEmpleado() {
        System.out.print("DNI: "); String dni = sc.nextLine();
        if (lista.buscarPorDni(dni) != null) {
            System.out.println("Error: El empleado con DNI " + dni + " ya existe.");
            return;
        }
        System.out.print("Nombre: ");
        String no = sc.nextLine();
        System.out.print("Salario Base: ");
        double salario = Double.parseDouble(sc.nextLine());
        System.out.print("Porcentaje Bonificación (0-30%): ");
        double bono = Double.parseDouble(sc.nextLine());

        GestionEmpleados nuevo = new GestionEmpleados(dni, no, sb, pb);
        if (lista.añadirEmpleado(nuevo)) {
            System.out.println("Empleado añadido con éxito.");
        }
    }

    private static void buscarEmpleado() {
        System.out.print("Ingrese DNI a buscar: ");
        String dni = sc.nextLine();
        GestionEmpleados e = lista.buscarPorDni(dni);
        if (e != null) {
            System.out.println(e.toString());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void modificarHoras() {
        System.out.print("DNI del empleado: ");
        String dni = sc.nextLine();
        System.out.print("Nuevas horas extra: ");
        int horas = Integer.parseInt(sc.nextLine());
        if (lista.modificarHorasExtra(dni, horas)) {
            System.out.println("Horas actualizadas correctamente.");
        } else {
            System.out.println("Error: No se encontró el empleado.");
        }
    }

    private static void modificarBonificacion() {
        System.out.print("DNI del empleado: ");
        String dni = sc.nextLine();
        System.out.print("Nuevo porcentaje (0-30%): ");
        double bono = Double.parseDouble(sc.nextLine());
        
        if (bono < 0 || bono > 30) {
            System.out.println("Error: El porcentaje debe estar entre 0 y 30.");
            return;
        }

        if (lista.modificarBonificacion(dni, bono)) {
            System.out.println("Bonificación actualizada.");
        } else {
            System.out.println("Error: No se encontró el empleado.");
        }
    }

    private static void modificarPrecioHoraExtra() {
        System.out.print("Nuevo precio para la hora extra (afecta a todos): ");
        double nuevoPrecio = Double.parseDouble(sc.nextLine());
        System.out.print("¿Está seguro? (S/N): ");
        if (sc.nextLine().equalsIgnoreCase("S")) {
            Empleado.setPrecioHoraExtra(nuevoPrecio);
            System.out.println("Precio actualizado globalmente.");
        }
    }

    private static void eliminarEmpleado() {
        System.out.print("DNI del empleado a eliminar: ");
        String dni = sc.nextLine();
        System.out.print("¿Confirmar eliminación? (S/N): ");
        if (sc.nextLine().equalsIgnoreCase("S")) {
            if (lista.eliminarPorDni(dni)) {
                System.out.println("Empleado eliminado.");
            } else {
                System.out.println("Error: No se pudo eliminar (DNI no encontrado).");
            }
        }
    }

    private static void verEstadisticas() {
        System.out.println("--- Estadísticas Generales ---");
        System.out.println("Gasto total en bonificaciones: " + lista.calcularGastoBonificaciones());
        System.out.println("Empleados de alto desempeño (>15%):");
        lista.listarEmpleadosAltoDesempenio();
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}


