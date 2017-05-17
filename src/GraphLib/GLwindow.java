package GraphLib;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/** Creates a Window*/
public class GLwindow  extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4449238369031840830L;

	public GLwindow(int width, int height, String title, GLgraphicLib game){
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}

}
