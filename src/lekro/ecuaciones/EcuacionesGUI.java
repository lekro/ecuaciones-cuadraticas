package lekro.ecuaciones;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EcuacionesGUI implements ActionListener {

	// Ponemos estos objetos aqu� para que se pueda accederlos
	// en todos los m�todos de esta clase.
	
	JTextField a, b, c;
	JLabel solucionesLabel;
	JFrame ventana;
	
	public EcuacionesGUI() {
		
		// Vamos a construir el interfaz.
		
		// Construyemos la ventana con el t�tulo "Ecuaciones cuadr�ticas":
		
		ventana = new JFrame("Ecuaciones cuadr�ticas");
		
		// Construyemos los "labels" que van a mostrar la ecuaci�n:
		
		JLabel uno = new JLabel("0 = ");
		JLabel dos = new JLabel("x� + ");
		JLabel tres = new JLabel("x + ");
		
		// Los usuarios pueden suplir los n�meros en los "JTextField"s
		
		a = new JTextField();
		b = new JTextField();
		c = new JTextField();
		
		// Con el c�digo siguiente, los JTextFields a, b y c ser�n
		// por lo menos 32 pixeles.
		
		a.setMinimumSize(new Dimension(32,0));
		a.setPreferredSize(new Dimension(32,0));
		b.setMinimumSize(new Dimension(32,0));
		b.setPreferredSize(new Dimension(32,0));
		c.setMinimumSize(new Dimension(32,0));
		c.setPreferredSize(new Dimension(32,0));
		
		// El usuario puede hacer clic en este boton para
		// mandar al computadora que necesite resolver la ecuaci�n.
		
		JButton resolver = new JButton("Resolver");
		
		// Necesitamos asignar un "ActionListener" para que podemos
		// "o�r" cuando el usuario haga clic en el boton.
		
		resolver.addActionListener(this);
		
		// Podemos a�adir el ActionListener a los JTextFields
		// tambi�n, para que el usuario pueda presionar "Enter"
		// para decir "Resu�lvalo!" a la computadora.
		
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		
		// Este JLabel va a mostrar las soluciones cuando la computadora
		// las calcula.
		
		solucionesLabel = new JLabel("Haz clic en \"Resolver\"");
		
		// Los soluciones se van a mostrar en letra negrita.
		
		solucionesLabel.setFont(solucionesLabel.getFont().deriveFont(Font.BOLD));
		
		// Usamos las "cajas" para ordenar todo en la ventana.
		
		Box vBox = Box.createVerticalBox();
		Box hBox = Box.createHorizontalBox();
		Box solBox = Box.createHorizontalBox();
		
		// A�adimos unos objetos a la primera l�nea.
		
		hBox.add(uno);
		hBox.add(a);
		hBox.add(dos);
		hBox.add(b);
		hBox.add(tres);
		hBox.add(c);
		hBox.add(resolver);
		
		// A�adimos unos objetos a la segunda l�nea.
		
		solBox.add(Box.createHorizontalGlue());
		solBox.add(solucionesLabel);
		solBox.add(Box.createHorizontalGlue());
		
		// A�adimos las l�neas a la "caja vertical"
		
		vBox.add(hBox);
		vBox.add(solBox);
		
		// A�adimos la "caja vertical" a la ventana
		
		ventana.add(vBox);
		
		// Este l�nea de c�digo automaticamente ajusta los dimensiones de la ventana
		
		ventana.pack();
		
		// Este l�nea dice que cuando el usuario presiona el X en la esquina de la ventana,
		// la programa va a terminar.
		
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// Ponemos la ventana en el centro de la pantalla:
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double altitud = screen.getHeight();
		double altura = screen.getWidth();
		
		// ...con un poco de las matem�ticas...
		
		ventana.setLocation(new Point((int) altura/2 - ventana.getWidth()/2, (int) altitud/2 - ventana.getHeight()/2));
		
		// Ahora podemos ver la ventana!
		
		ventana.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Se ejecuta este m�todo cuando el boton
		// "Resolver" est� presionado.
		
		// Tratamos de obtener los coeficientes a, b, c:
		// (en el bloque de "try")
		
		double a=0, b=0, c=0;
		
		try {
			
			a = Double.parseDouble(this.a.getText());
			
		} catch (NumberFormatException nfe) {
			
			// Pero si el usuario no provea un n�mero,
			// lo hacemos un n�mero.
			
			a = 0;
			this.a.setText("0");
		}
		try {
			
			b = Double.parseDouble(this.b.getText());
			
		} catch (NumberFormatException nfe) {
			
			a = 0;
			this.b.setText("0");
			
		}
		try {
			
			c = Double.parseDouble(this.c.getText());
			
		} catch (NumberFormatException nfe) {
			
			a = 0;
			this.c.setText("0");
			
		}
		
		// Ahora tenemos los n�meros a, b, c.
		// Vamos a usar el m�todo en el otro archivo:
		// solucionar(double, double, double)
		
		double[] soluciones = Ecuaciones.solucionar(a, b, c);
		
		// Si no haya soluciones...
		
		if (soluciones.length == 0) {
			
			// Mu�stralo en el JLabel:
			
			solucionesLabel.setText("No hay soluciones");
			
			// Pero si haya una soluci�n...
			
		} else if (soluciones.length == 1) {
			
			// Muestra la soluci�n.
			
			solucionesLabel.setText("x = "+soluciones[0]);
			
			// Si haya dos soluciones...
			
		} else if (soluciones.length == 2) {
			
			// Se necesita mostrar los dos.
			
			solucionesLabel.setText("x = {"+soluciones[0]+", "+soluciones[1]+"}");
			
			// Y finalmente, si haya los "tres soluciones" que definimos
			// en el m�todo solucionar(double, double, double)...
			
		} else {
			
			// Recordamos que "tres soluciones" significa 
			// "x puede ser cualquier n�mero"
			
			solucionesLabel.setText("x = todos los n�meros reales");
			
		}
		
		// Automaticamente ajustamos la ventana si haya n�meros m�s grandes
		// que la ventana.
		
		ventana.pack();
		
	}
	
}
