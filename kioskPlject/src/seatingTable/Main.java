package seatingTable;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Login.MainF;
import reservation.Rbtn_back;
import reservation.Rbtn_home;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

public class Main {
	public static String type = "";
	public static String t = "";
	private static JFrame frame;
	public static mainPanel main_panel;
	public static Component[] Main_p;
	private static Component[] Sub_p;
	Rbtn_home home;
	JPanel show;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main window = new Main(null);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public Main() {
		initialize();
	}

	public Main(String type) {
		this.type = type;
		initialize();
	}

	public Main(String t, JFrame frame, JPanel show) {
		this.t = t;
		this.frame = frame;
		this.show = show;
//		setFrame(frame);
		initialize();
	}

	private void initialize() {
		// ++js modify
		if (!t.equals("now") || type.equals("reserve")) {
			frame = new JFrame();
//			setFrame(frame);
			frame.setBounds(100, 0, 720, 1080);
		}

		// ++
//		frame.setBounds(100, 0, 720, 1080);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 메인 판넬 설정
		main_panel = new mainPanel();
		frame.getContentPane().add(main_panel);
		subPanel sub_panel = new subPanel();

		// 버튼생성
		JButton lb_btn = new JButton();
		JButton cf_btn = new JButton();
		JButton sr_btn = new JButton();

		// 좌석번호 생성!
		JButton[] l_btn = new JButton[35];
		JButton[] c_btn = new JButton[16];
		JButton[] s_btn = new JButton[2];

		// 라이브러리룸, 카페룸, 스터디룸 버튼 생성
		sub_panel.lb_btn(lb_btn, sub_panel, main_panel, l_btn);
		sub_panel.cf_btn(cf_btn, sub_panel, main_panel, c_btn);
		sub_panel.sr_btn(sr_btn, sub_panel, main_panel, s_btn);

		// 메인판넬에 서브패널 배경 붙이기
		sub_panel.back_img();
		main_panel.add(sub_panel);

		// 백버튼 생성
		Rbtn_back back = new Rbtn_back();
		back.setBounds(600, 50, 48, 48);
		designBtn(back);
		main_panel.add(back);
//		main_panel.back_img();

		// 홈버튼 생성
		home = new Rbtn_home();
		home.setBounds(500, 50, 48, 48);
		designBtn(home);
		main_panel.add(home);
		main_panel.back_img();		
		if(t.equals("now")) {
			home.setEnabled(true);
		}else {
			home.setEnabled(false);
		}

		Main_p = main_panel.getComponents();
		Sub_p = sub_panel.getComponents();

//		System.out.println(Main_p.length);
//		System.out.println(Sub_p.length);
		// 백버튼 클릭시
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main_p = main_panel.getComponents();

				main_panel.removeAll();
				main_panel.add(sub_panel);
				for (int i = 0; i < Sub_p.length; i++) {
					sub_panel.add(Sub_p[i]);
				}
				main_panel.add(Main_p[1]);
				main_panel.add(Main_p[2]);
				main_panel.add(Main_p[3]);

				main_panel.repaint();

			}
		});

		// 홈버튼 클릭시
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main_p = main_panel.getComponents();
				frame.remove(main_panel);
				show.setVisible(true);

			}
		});
	}

	public static JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static void designBtn(JButton btn) {
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
	}

	public JPanel getMainPanel() {
		// TODO Auto-generated method stub
		return main_panel;
	}

}