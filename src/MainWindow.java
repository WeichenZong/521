
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.GeneralPath;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainWindow.setLocation(dim.width/2-mainWindow.getSize().width/2, dim.height/2-mainWindow.getSize().height/2);
	}

	public MainWindow() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(260, 280);
		getContentPane().setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		Graphics2D graphics = (Graphics2D) arg0;
		graphics.setColor(Color.RED);
		graphics.fill(getShape(0, 0));
		graphics.setFont(new Font("华文行楷", Font.PLAIN, 18));
		graphics.setColor(Color.WHITE);

		Decoder decoder = Base64.getDecoder();
		String string = null,str = null;
		try {
			string = new String(decoder.decode("U1NCc2IzWmxJRTFoZEdnTkNnPT0="),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			str = new String(decoder.decode(string),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		graphics.drawString(str, 85, 140);


	}

	private static Shape getShape(int x, int y) {
		GeneralPath path = new GeneralPath();
		path.moveTo(hX(0), hY(0));
		for (float theta = 0.0f; theta < 6.28f; theta += 0.02) {
			path.lineTo(hX(theta), hY(theta));
		}
		path.closePath();
		return path;
	}

	private static double hX(double theta) {
		return 130 - 5 * (22 * Math.pow(Math.sin(theta), 3));
	}

	private static double hY(double theta) {
		return 140 - 5 * (20 * Math.cos(theta) - 6 * Math.cos(2 * theta) - 3 * Math.cos(3 * theta) - Math.cos(4 * theta));
	}
}