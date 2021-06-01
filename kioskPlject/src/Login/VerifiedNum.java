package Login;

import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VerifiedNum {
	
	JFrame frame = new JFrame();
	JLabel randomNum = new JLabel(randomNum());
	JLabel verified = new JLabel("인증번호(5초)");
	
	//폰트 설정
	String font = "twayair";
	
	VerifiedNum() {
		
		verified.setBounds(45, 5, 330, 130);
		verified.setFont(new Font(font, Font.PLAIN, 20));
		frame.add(verified);
		
		randomNum.setBounds(80, 30, 330, 130);
		randomNum.setFont(new Font(font, Font.PLAIN, 20));
		frame.add(randomNum);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 30, 200, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	String randomNum() {
		
		Random rd = new Random();
		String Num = "";
		
		for(int i = 0; i < 4; i++) {
			Num += rd.nextInt(9);
		}
		return Num;
	}
	
}