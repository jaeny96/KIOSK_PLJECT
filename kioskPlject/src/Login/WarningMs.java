package Login;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WarningMs {
	
	JFrame frame = new JFrame();
	JLabel warning = new JLabel("");
	
	//폰트 설정
	String font = "twayair";
	
	WarningMs() {
		
		warning.setBounds(150, 0, 300, 150);
		warning.setFont(new Font(font, Font.PLAIN, 20));
		frame.add(warning);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(540, 30, 350, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

}