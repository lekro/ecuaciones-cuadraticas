package lekro.ecuaciones;

public class Ecuaciones {

	public static void main(String[] args) {
		
		// La programa empieza aqu�.
		
		
		// Construyemos un interfaz con el c�digo
		// en el archivo "EcuacionesGUI.java":
		
		new EcuacionesGUI();
		
		
	}
	
	public static double[] solucionar(double a, double b, double c) {
		
		// Primero, vamos a chequear si la ecuaci�n sea cuadr�tica:
		
		if (a != 0) {
			
			// Aqu� actualmente usamos la f�rmula cuadr�tica.
			// 0 = ax^2 + bx + c
			// x = (-b +/- sqrt(b^2 - 4ac)) / 2a
			
			// Primero, calculamos la determinante
			// determinante = b^2 - 4ac
			// As� podemos saber el n�mero de soluciones.
			// Ecuaciones cuadr�ticas pueden tener
			// 0, 1 o 2 soluciones.
	
			// "double" significa n�meros decimales.
			
			double determinante = b * b - 4 * a * c;
			
			// Si la determinante sea negativo...
			
			if (determinante < 0) {
				
				// No podemos solucionar esta ecuaci�n
				// porque tiene un n�mero imaginario.
				// Por eso, no hay soluciones y vamos
				// a devolver 0 soluciones:
				
				return new double[0];
				
				// La declaraci�n "return" significa que
				// terminamos este m�todo. El c�digo que
				// sigue no se va a ejecutar.
				
			}
			
			// Si la determinante sea cero, hay una soluci�n:
			// No necesitamos incluir la determinante aqu�
			// porque es cero!
			
			if (determinante == 0) {
				
				// Devolvemos una soluci�n:
				
				return new double[] {-b / (2 * a)};
				
			}
			
			// Ahora sabemos que la determinante es positivo. 
			// Podemos calcular su ra�z cuadrada:
			
			double sqrtDet = Math.sqrt(determinante);
			
			// Y calculamos los dos soluciones:
			
			double solucion1 = (-b + sqrtDet) / (2 * a);
			double solucion2 = (-b - sqrtDet) / (2 * a);
			
			// Los devolvemos:
			
			return new double[] {solucion1, solucion2};
		
		}
		
		// Ahora sabemos que la ecuaci�n es linear o constante.
		
		// Si sea linear:
		
		if (b != 0) {
			
			// Hay una soluci�n.
			
			return new double[] {-c / b};
			
		}
		
		// Si sea constante:
		
		// La ecuaci�n es cierta si el constante c
		// es cero.
		
		if (c == 0) {
			
			// Vamos a devolver tres n�meros para
			// decir "todos los n�meros reales"
			
			return new double[3];
			
		} else {
			
			// Pero si "c" no sea cero, no hay soluciones.
			
			return new double[0];
			
		}
		
	}
	
}
