package seatingTable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class mainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public mainPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0, 0, 700, 1080);
		

		
	}

	public void back_img() {
		seatingImage home_img = new seatingImage(new ImageIcon("./src/image/CODERIUM_Background.jpg").getImage());
		this.add(home_img);
	}
	

}
