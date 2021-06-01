package main.pay.component;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cash {
	JPanel panel;
	String font = "";
	int x = 85;
	int y;
	int width=120;
	int height = 60;

	public cash() {

	}

	public cash(JPanel panel, int y, String font) {
		this.panel = panel;
		this.y = y;
		this.font = font;
	}

	// cash 패널 list 생성 
	public void makeCashTF(String str,int i) {
		JLabel tf = new JLabel(str);
		tf.setFont(new Font(font, Font.PLAIN, 18));
		tf.setBounds(x, y+(60*i), width, height);
		panel.add(tf);
	}

	// cash 패널 list의 detail 생성
	public JLabel makeCashD(String str,int i) {
		JLabel tf = new JLabel(str);
		tf.setFont(new Font(font, Font.PLAIN, 18));
		tf.setBounds(x+110, y+(60*i), width+160, height);
		panel.add(tf);
		return tf;
	}
	
	// cash 패널 button 생성
	public JButton makeCashB(String str, int i, int j) {
		JButton cashBtn = new JButton(str);
		cashBtn.setFont(new Font(font, Font.PLAIN, 18));
		cashBtn.setBounds(88+(290*i), y+(90*j), 198, 57);
		panel.add(cashBtn);
		return cashBtn;
	}

}
