package objetos;

public class GestionEmpleados {
	
	// VARIABLES
	private String dni;
	private String nombre;
	private double salarioBase;
	private int porcentajeBonificacion;
	private static double precioHoraExtra;
	private double horasExtrasRealizadas;
	
	// CONSTRUCTOR
	
	public GestionEmpleados(String dni, String nombre, double salarioBase, int porcentajeBonificacion,
			double horasExtrasRealizas) {
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.porcentajeBonificacion = porcentajeBonificacion;
		this.horasExtrasRealizadas = horasExtrasRealizas;
	}
	
	public GestionEmpleados(String dni, String nombre, double salarioBase, int porcentajeBonificacion) {
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.porcentajeBonificacion = porcentajeBonificacion;
	}

	public GestionEmpleados() {
		
	}

	// GETTERS Y SETTERS
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getSalarioBase() {
		return salarioBase;
	}
	
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public int getPorcentajeBonificacion() {
		return porcentajeBonificacion;
	}
	
	public void setPorcentajeBonificacion(int porcentajeBonificacion) {
		if (porcentajeBonificacion >= 0 && porcentajeBonificacion <= 25) {
            this.porcentajeBonificacion = porcentajeBonificacion;
		}
	}
		
	public static double getPrecioHoraExtra() {
		return precioHoraExtra;
	}
	
	public static void setPrecioHoraExtra(double precioHoraExtra) {
		GestionEmpleados.precioHoraExtra = precioHoraExtra;
	}
	
	public double getHorasExtrasRealizadas() {
		return horasExtrasRealizadas;
	}
	
	public void setHorasExtrasRealizadas(double horasExtrasRealizas) {
		this.horasExtrasRealizadas = horasExtrasRealizas;
	}
	
	/**
	 * Metodo que devuelve el imoporte de bonifación.
	 * @return Devuelve un valor double que representa el importe de la bonificación.
	 */
	public double devuelveImporteBonificacion () {
		return (salarioBase*porcentajeBonificacion/100);
	}
	
	/**
	 * Metodo que calcula y devuelve el dinero que gana en horas extras.
	 * @return Devuelve un valor double que representa el importe ganado por horas extras.
	 */
	public double precioHoraExtra() {
		return (horasExtrasRealizadas*precioHoraExtra);
	}

	 @Override
	 public String toString() {
	  return String.format(
	     "%s - %s\n" +
	     "Salario Base: %.1f | Bonificacion: %.1f (%.0f%%)\n" +
	      "Horas Extra: %d | Total Bruto: %.1f",
	       dni, nombre, salarioBase, porcentajeBonificacion,
	       horasExtrasRealizadas
	        );
	    }
	 	
	 public boolean equals(String dni1, String dni2) {
	       boolean iguales = false;
	       if (dni1.equalsIgnoreCase(dni2)) {
	           iguales = true;
	       }
	       return iguales;
	   }
	    
	    public boolean bonificacionTrue () {
	    	boolean bonificacion = false;
	    	if (porcentajeBonificacion > 15) {
	    		return bonificacion = true;
	    	}
			return bonificacion;
	    }
	}

