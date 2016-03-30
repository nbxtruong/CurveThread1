import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class CurveApplication {
	public static void createGUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.pack();
		Graphics2D g = (Graphics2D) frame.getContentPane().getGraphics();
		Curve c1 = new Curve(2, g, 400) {
			public double function(double x) {
				return 200. + 100. * Math.cos(x/20);
			}
		};
		Curve c2 = new Curve(1, g, 400) {
			public double function(double x) {
				return 200. + 100. * Math.sin(x/20);
			}
		};
		frame.setVisible(true);
		c1.start();
		c2.start();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		});
	}

}
