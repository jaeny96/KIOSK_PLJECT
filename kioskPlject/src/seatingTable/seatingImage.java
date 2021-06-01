package seatingTable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class seatingImage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// img 변수 설정
	private Image img;
	
	public seatingImage(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
}
