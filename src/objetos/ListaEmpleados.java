package objetos;

import java.util.ArrayList;

public class ListaEmpleados {

	 private ArrayList<GestionEmpleados> lista;
	 
	 public ListaEmpleados() {
		 this.lista = new ArrayList<>();
	 }
		      // 1. Añadir un empleado
		      public boolean aniadirEmpleado(GestionEmpleados empleado) {
		          if (empleado == null) return false;
		          return lista.add(empleado);
		      }

		      // 2. Listar todos los empleados con formato
		      public void listarTodos() {
		          System.out.println("--- LISTADO DE EMPLEADOS ---");
		          for (GestionEmpleados e : lista) {
		              System.out.println(e.toString());
		          }
		      }

		      // 3. Buscar por DNI
		      public GestionEmpleados buscarPorDni(String dni) {
		          for (GestionEmpleados e : lista) {
		              if (e.getDni().equalsIgnoreCase(dni)) {
		                  return e;
		              }
		          }
		          return null;
		      }

		      // 4. Modificar horas extra
		      public boolean modificarHorasExtra(String dni, int horas) {
		          GestionEmpleados e = buscarPorDni(dni);
		          if (e != null) {
		              e.setHorasExtrasRealizadas(horas);
		              return true;
		          }
		          return false;
		      }

		      // 5. Modificar bonificación (porcentaje)
		      public boolean modificarBonificacion(String dni, double porcentajeBonificacion) {
		          GestionEmpleados e = buscarPorDni(dni);
		          if (e != null) {
		              e.setPorcentajeBonificacion((int) porcentajeBonificacion); 
		              return true;
		          }
		          return false;
		      }

		      // 6. Eliminar por DNI
		      public boolean eliminarPorDni(String dni) {
		          GestionEmpleados e = buscarPorDni(dni);
		          if (e != null) {
		              return lista.remove(e);
		          }
		          return false;
		      }

		      // 7. Calcular gasto total en bonificaciones
		      public double calcularGastoBonificaciones() {
		          double total = 0;
		          for (GestionEmpleados e : lista) {
		              total += e.getPorcentajeBonificacion(); 
		          }
		          return total;
		      }

		      // 8. Listar empleados con bonificación > 15%
		      public void listarEmpleadosAltoDesempenio() {
		          System.out.println("--- EMPLEADOS ALTO DESEMPEÑO (>15%) ---");
		          for (GestionEmpleados e : lista) {
		              if (e.getPorcentajeBonificacion() > 15.0) {
		                  System.out.println(e.getNombre() + " - DNI: " + e.getDni());
		              }
		          }
		      }
		  }