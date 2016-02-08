package lekro.ecuaciones;

public class Ecuaciones {

	public static void main(String[] args) {
		
		// La programa empieza aquí.
		
		
		// Construyemos un interfaz con el código
		// en el archivo "EcuacionesGUI.java":
		
		new EcuacionesGUI();
		
		
	}
	
	public static double[] solucionar(double a, double b, double c) {
		
		// Primero, vamos a chequear si la ecuación sea cuadrática:
		
		if (a != 0) {
			
			// Aquí actualmente usamos la fórmula cuadrática.
			// 0 = ax^2 + bx + c
			// x = (-b +/- sqrt(b^2 - 4ac)) / 2a
			
			// Primero, calculamos la determinante
			// determinante = b^2 - 4ac
			// Así podemos saber el número de soluciones.
			// Ecuaciones cuadráticas pueden tener
			// 0, 1 o 2 soluciones.
	
			// "double" significa números decimales.
			
			double determinante = b * b - 4 * a * c;
			
			// Si la determinante sea negativo...
			
			if (determinante < 0) {
				
				// No podemos solucionar esta ecuación
				// porque tiene un número imaginario.
				// Por eso, no hay soluciones y vamos
				// a devolver 0 soluciones:
				
				return new double[0];
				
				// La declaración "return" significa que
				// terminamos este método. El código que
				// sigue no se va a ejecutar.
				
			}
			
			// Si la determinante sea cero, hay una solución:
			// No necesitamos incluir la determinante aquí
			// porque es cero!
			
			if (determinante == 0) {
				
				// Devolvemos una solución:
				
				return new double[] {-b / (2 * a)};
				
			}
			
			// Ahora sabemos que la determinante es positivo. 
			// Podemos calcular su raíz cuadrada:
			
			double sqrtDet = Math.sqrt(determinante);
			
			// Y calculamos los dos soluciones:
			
			double solucion1 = (-b + sqrtDet) / (2 * a);
			double solucion2 = (-b - sqrtDet) / (2 * a);
			
			// Los devolvemos:
			
			return new double[] {solucion1, solucion2};
		
		}
		
		// Ahora sabemos que la ecuación es linear o constante.
		
		// Si sea linear:
		
		if (b != 0) {
			
			// Hay una solución.
			
			return new double[] {-c / b};
			
		}
		
		// Si sea constante:
		
		// La ecuación es cierta si el constante c
		// es cero.
		
		if (c == 0) {
			
			// Vamos a devolver tres números para
			// decir "todos los números reales"
			
			return new double[3];
			
		} else {
			
			// Pero si "c" no sea cero, no hay soluciones.
			
			return new double[0];
			
		}
		
	}
	
}
