package main.pay.component;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.pay.data.readFile;


public class fighting {
	JPanel panel;
	JLabel done;
	JLabel fight;
	String font;

	ArrayList<String> arr = new ArrayList<String>();

	public fighting() {

	}

	public fighting(JPanel panel, JLabel done,String font) {
		this.panel = panel;
		this.done = done;
		this.font=font;
	}
	public fighting(JPanel panel, JLabel done, JLabel fight,String font) {
		this.panel = panel;
		this.done = done;
		this.fight = fight;
		this.font=font;
	}

	public void createDone(String str) {
		done.setText(str);
		done.setFont(new Font(font, Font.PLAIN, 30));
		done.setHorizontalAlignment(SwingConstants.CENTER);
		done.setBounds(110, 480, 520, 125);
		panel.add(done);
	}

	// 응원 문구는 데이터 파일 내에서 읽어와서 배열로 만든 후 랜덤으로 1개만 출력하도록 구현
	public void createFight() {
		readFile rf = new readFile("fighting");
		arr=rf.readFileFunc(arr);
		int random = (int)(Math.random()*arr.size());
		fight.setText(arr.get(random));
		fight.setForeground(new Color(102, 51, 255));
		fight.setHorizontalAlignment(SwingConstants.CENTER);
		fight.setFont(new Font(font, Font.PLAIN, 32));
		fight.setBounds(60, 480, 600, 400);
		panel.add(fight);
	}
}
