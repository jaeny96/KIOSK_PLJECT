package main.pay.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class nextBtn {
	JPanel container;
	JPanel target;
	Color c;
	String font;
	Component[] cp;
	public nextBtn() {
		
	}
	public nextBtn(JPanel container,JPanel target,Color c,String font) {
		this.container=container;
		this.target=target;
		this.c=c;
		this.font=font;
	}
	
	public void designBtn(JButton btn, Color c) {
		btn.setBackground(c);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
	}
	
	public JButton createNext() {
		JButton nextBtn = new JButton("▶");
		nextBtn.setFont(new Font(font, Font.PLAIN, 20));
		nextBtn.setBounds(550, 295, 100, 45);
		designBtn(nextBtn, c);
		nextBtn.setVisible(true);
		target.add(nextBtn);

		return nextBtn;
	}
}
