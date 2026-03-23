package objetos;

import java.util.Scanner;

/**
 * Clase Principal que contiene el menú interactivo para la gestión de empleados.
 * Cumple con los requisitos de la Unidad 4.
 */
public class MainEmpleados {
    private static Scanner sc = new Scanner(System.in);
    private static GestionEmpleados lista = new GestionEmpleados();

    public static void main(String[] args) {
        // Bienvenida al sistema [cite: 42]
        System.out.println("Bienvenido al sistema de Gestión de Empleados Avanzada");
        int opcion = 0;

        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine());
                ejecutarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduce un número válido.");
            }
        } while (opcion != 9);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE OPCIONES ---");
        System.out.println("1. Añadir empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Buscar empleado por DNI");
        System.out.println("4. Modificar horas extra");
        System.out.println("5. Modificar bonificación");
        System.out.println("6. Modificar precio hora extra");
        System.out.println("7. Eliminar empleado");
        System.out.println("8. Ver estadísticas");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Introduce DNI: ");
                String dni = sc.nextLine();
                if (lista.buscarPorDni(dni) != null) {
                    System.out.println("Error: El DNI ya existe en el sistema.");
                } else {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Salario Base: ");
                    double salario = Double.parseDouble(sc.nextLine());
                    System.out.print("Porcentaje Bonificación (0-30): ");
                    double bono = Double.parseDouble(sc.nextLine());
                    
                    if (bono >= 0 && bono <= 30) {
                        Empleado nuevo = new Empleado(dni, nombre, salario, bono);
                        if (lista.añadirEmpleado(nuevo)) System.out.println("Empleado añadido con éxito.");
                    } else {
                        System.out.println("Error: El porcentaje debe estar entre 0 y 30.");
                    }
                }
                break;

            case 2:
                gestion.listarTodos();
                break;

            case 3:
                System.out.print("DNI a buscar: ");
                Empleado emp = lista.buscarPorDni(sc.nextLine());
                System.out.println(emp != null ? emp : "Empleado no encontrado.");
                break;

            case 4:
                System.out.print("DNI: ");
                String dniH = sc.nextLine();
                System.out.print("Nuevas horas extra: ");
                int horas = Integer.parseInt(sc.nextLine());
                if (lista.modificarHorasExtra(dniH, horas)) {
                    System.out.println("Horas actualizadas correctamente.");
                } else {
                    System.out.println("Error: No se encontró el DNI.");
                }
                break;

            case 5:
                System.out.print("DNI: ");
                String dniB = sc.nextLine();
                System.out.print("Nuevo porcentaje (0-30): ");
                double nuevoBono = Double.parseDouble(sc.nextLine());
                if (nuevoBono < 0 || nuevoBono > 30) {
                    System.out.println("Error: Rango no válido.");
                } else if (GestionEmpleados.modificarBonificacion(dniB, nuevoBono)) {
                    System.out.println("Bonificación actualizada.");
                } else {
                    System.out.println("Error: No se encontró el DNI.");
                }
                break;

            case 6:
                System.out.print("Nuevo precio hora extra para todos: ");
                double precio = Double.parseDouble(sc.nextLine());
                System.out.print("¿Confirmar cambio global? (S/N): ");
                if (sc.nextLine().equalsIgnoreCase("S")) {
                    GestionEmpleados.setPrecioHoraExtra(precio);
                    System.out.println("Precio global actualizado.");
                }
                break;

            case 7: // Eliminar empleado 
                System.out.print("DNI a eliminar: ");
                String dniE = sc.nextLine();
                System.out.print("¿Está seguro de eliminar este registro? (S/N): ");
                if (sc.nextLine().equalsIgnoreCase("S")) {
                    if (ListaEmpleados.eliminarPorDni(dniE)) {
                        System.out.println("Empleado eliminado correctamente.");
                    } else {
                        System.out.println("Error: No se encontró el registro.");
                    }
                }
                break;

            case 8:
                System.out.println("Gasto total en bonificaciones: " + GestionEmpleados.calcularGastoBonificaciones());
                System.out.println("Empleados con alto desempeño (>15%):");
                lista.listarEmpleadosAltoDesempenio();
                break;

            case 9:
                System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }
}
