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

	// Ponemos estos objetos aquí para que se pueda accederlos
	// en todos los métodos de esta clase.
	
	JTextField a, b, c;
	JLabel solucionesLabel;
	JFrame ventana;
	
	public EcuacionesGUI() {
		
		// Vamos a construir el interfaz.
		
		// Construyemos la ventana con el título "Ecuaciones cuadráticas":
		
		ventana = new JFrame("Ecuaciones cuadráticas");
		
		JLabel uno = new JLabel("0 = ");
		a = new JTextField();
		JLabel dos = new JLabel("x² + ");
		b = new JTextField();
		JLabel tres = new JLabel("x + ");
		c = new JTextField();
		
		a.setMinimumSize(new Dimension(32,0));
		a.setPreferredSize(new Dimension(32,0));
		b.setMinimumSize(new Dimension(32,0));
		b.setPreferredSize(new Dimension(32,0));
		c.setMinimumSize(new Dimension(32,0));
		c.setPreferredSize(new Dimension(32,0));
		
		JButton resolver = new JButton("Resolver");
		
		resolver.addActionListener(this);
		
		solucionesLabel = new JLabel("Haz clic en \"Resolver\"");
		solucionesLabel.setFont(solucionesLabel.getFont().deriveFont(Font.BOLD));
		
		Box vBox = Box.createVerticalBox();
		Box hBox = Box.createHorizontalBox();
		Box solBox = Box.createHorizontalBox();
		
		hBox.add(uno);
		hBox.add(a);
		hBox.add(dos);
		hBox.add(b);
		hBox.add(tres);
		hBox.add(c);
		hBox.add(resolver);
		
		solBox.add(Box.createHorizontalGlue());
		solBox.add(solucionesLabel);
		solBox.add(Box.createHorizontalGlue());
		
		vBox.add(hBox);
		vBox.add(solBox);
		
		ventana.add(vBox);
		ventana.pack();
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double altitud = screen.getHeight();
		double altura = screen.getWidth();
		
		ventana.setLocation(new Point((int) altura/2 - ventana.getWidth()/2, (int) altitud/2 - ventana.getHeight()/2));
		
		ventana.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Se ejecuta este método cuando el boton
		// "Resolver" está presionado.
		
		// Tratamos de obtener los coeficientes a, b, c:
		// (en el bloque de "try")
		
		double a=0, b=0, c=0;
		
		try {
			
			a = Double.parseDouble(this.a.getText());
			
		} catch (NumberFormatException nfe) {
			
			// Pero si el usuario no provea un número,
			// lo hacemos un número.
			
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
		
		// Ahora tenemos los números a, b, c.
		// Vamos a usar el método en el otro archivo:
		// solucionar(double, double, double)
		
		double[] soluciones = Ecuaciones.solucionar(a, b, c);
		
		if (soluciones.length == 0) {
			solucionesLabel.setText("No hay soluciones");
		} else if (soluciones.length == 1) {
			solucionesLabel.setText("x = "+soluciones[0]);
		} else if (soluciones.length == 2) {
			solucionesLabel.setText("x = {"+soluciones[0]+", "+soluciones[1]+"}");
		} else {
			solucionesLabel.setText("x = todos los números reales");
		}
		
		ventana.pack();
		
	}
	
}
