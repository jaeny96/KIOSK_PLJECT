package seatingTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class subPanel extends JPanel {
	JButton back;
	JButton home;
	JButton btn;
	JButton btns[];
	srZone sr = new srZone();
	lbZone lb = new lbZone();
	cfZone cf = new cfZone();
	Component[] Main_ps;
	Component[] Sub_p;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public subPanel() {
		
		setBounds(20, 130, 660, 870);
		setBackground(Color.white);
		setLayout(null);

	}
	
	public subPanel(Component lb_z, Component cf_z, Component sr_z,Component[] Sub_p) {

		setBounds(20, 130, 660, 870);
		setBackground(Color.white);
		setLayout(null);

	}
	// subpanel 라이브러리 생성!
	public void lb_btn(JButton btn, JPanel subPanel, JPanel mainPanel, JButton btns[]) {


		
		btn.setText("스터디룸");
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(450, 220, 165, 65);
		btn.setVisible(true);
		btn.setIcon(new ImageIcon("./src/image/lbzone_btn.jpg"));

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//메인패널에 컴포넌트 저장
				Main_ps = mainPanel.getComponents();
				//서브패널에 컴포넌트 저장
				Sub_p = subPanel.getComponents();
				
				//버튼 생성 (위치바꾸면 문제 생김)
				lb.btn(btns, lb);
				
				//패널내용 모두 삭제
				mainPanel.removeAll();
				subPanel.removeAll();
				//라이브러리존 좌석표 생성
				lb.back_img();
				//메인패널에 필요 컴포넌트 붙임
				mainPanel.add(lb);
				mainPanel.add(Main_ps[1]);
				mainPanel.add(Main_ps[2]);
				mainPanel.add(Main_ps[3]);
				
				//다시 생성
				subPanel.repaint();
				mainPanel.repaint();
				
				
				
			}
		});
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
//
		subPanel.add(btn);
//		mainPanel.add(lb);
//		

	}

	// caffe zone 버튼!
	public void cf_btn(JButton btn, JPanel subPanel, JPanel mainPanel, JButton[] btns) {
//		btn.setBackground(new Color(0, 191, 255));
		btn.setText("카페존");
		btn.setFont(new Font("티웨이항공", Font.BOLD, 15));
		btn.setBounds(82, 650, 165, 65);
		btn.setVisible(true);
		btn.setIcon(new ImageIcon("./src/image/cfzone_btn.jpg"));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//메인패널에 컴포넌트 저장
				Main_ps = mainPanel.getComponents();
				Sub_p = subPanel.getComponents();
				//카페존 버튼 생성
				cf.btn(btns, cf);
				//메인,서브패널 모두삭제
				mainPanel.removeAll();
				subPanel.removeAll();
				//카페존 배경 생성
				cf.back_img();
				//필요 컴포넌트 패널에 붙이기
				mainPanel.add(cf);
				mainPanel.add(Main_ps[1]);
				mainPanel.add(Main_ps[2]);
				mainPanel.add(Main_ps[3]);
				//다시 생성
				subPanel.repaint();
				mainPanel.repaint();
			}
		});
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);

		subPanel.add(btn);
//		mainPanel.add(cf);
	}

// study room ��ư! 
	public void sr_btn(JButton btn, JPanel subPanel, JPanel mainPanel, JButton[] btns) {
//		btn.setBackground(new Color(0, 191, 255));
		btn.setText("스터디룸");
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(445, 650, 165, 65);
		btn.setVisible(true);
		btn.setIcon(new ImageIcon("./src/image/srzone_btn.jpg"));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////메인패널에 컴포넌트 저장
				Main_ps = mainPanel.getComponents();
				Sub_p = subPanel.getComponents();
				
				//스터디룸 번호 생성
				sr.btn(btns, sr);
				
				//메인,서브패널 모두 지우기
				mainPanel.removeAll();
				subPanel.removeAll();
				//스터디룸 배경 불러오기
				sr.back_img();
				//메인패널에 요소붙이기
				mainPanel.add(sr);
				mainPanel.add(Main_ps[1]);
				mainPanel.add(Main_ps[2]);
				mainPanel.add(Main_ps[3]);
				//리페인트
				subPanel.repaint();
				mainPanel.repaint();
			}
		});
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);

		subPanel.add(btn);
//		mainPanel.add(sr);

	}

//subPanel 배경!
	public void back_img() {
		seatingImage seatImg = new seatingImage(new ImageIcon("./src/image/seatting_table_1.jpg").getImage());
		this.add(seatImg);
	}


}
