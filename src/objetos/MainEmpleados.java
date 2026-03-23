package objetos;

import java.util.Scanner;

public class MainEmpleados {
    private static Scanner sc = new Scanner(System.in);
    private static GestionEmpleados lista = new GestionEmpleados();

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de Gestión de Empleados");
        int opcion;

        do {
            System.out.println("\n1. Añadir empleado\n2. Listar empleados\n3. Buscar por DNI\n4. Modificar horas extra\n5. Modificar bonificación\n6. Modificar precio hora extra\n7. Eliminar empleado\n8. Ver estadísticas\n9. Salir");
            System.out.print("Seleccione: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    if (lista.buscarPorDni(dni) != null) {
                        System.out.println("Error: El DNI ya existe.");
                    } else {
                        System.out.print("Nombre: ");
                        String nom = sc.nextLine();
                        System.out.print("Salario Base: ");
                        double sal = Double.parseDouble(sc.nextLine());
                        System.out.print("Bonificación (0-30%): ");
                        double bon = Double.parseDouble(sc.nextLine());
                        
                        
                        if (bon >= 0 && bon <= 30) {
                            lista.aniadirEmpleado(new  (dni, nom, sal, bon));
                            System.out.println("Empleado añadido.");
                        } else {
                            System.out.println("Error: Bonificación fuera de rango (0-30%).");
                        }
                    }
                    break;
                case 6:
                    System.out.print("Nuevo precio hora extra global: ");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.print("¿Confirmar cambio para TODOS? (S/N): "); // 
                    if (sc.nextLine().equalsIgnoreCase("S")) {
                        Empleado.setPrecioHoraExtra(precio);
                        System.out.println("Precio actualizado.");
                    }
                    break;
                case 7:
                    System.out.print("DNI a eliminar: ");
                    String dniE = sc.nextLine();
                    System.out.print("¿Seguro que desea eliminarlo? (S/N): "); // 
                    if (sc.nextLine().equalsIgnoreCase("S")) {
                        if (lista.eliminarPorDni(dniE)) System.out.println("Eliminado.");
                        else System.out.println("No encontrado.");
                    }
                    break;
                case 8:
                    System.out.println("Gasto Total Bonificaciones: " + lista.calcularGastoBonificaciones());
                    System.out.println("Empleados Alto Desempeño:");
                    lista.listarEmpleadosAltoDesempenio();
                    break;
                case 9:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!"); // 
                    break;
            }
        } while (opcion != 9);
    }
}


