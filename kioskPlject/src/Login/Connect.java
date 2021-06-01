package Login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.pay.component.fighting;
import main.pay.data.db;
import main.pay.data.modiData;
import reservation.RoundButton;
import reservation.resrvationMain;
import seatingTable.Exit_query;
import seatingTable.Main;

public class Connect {
	JFrame frame;
	JPanel panel;
	JPanel Connect = new JPanel();
	Rbtn_direct Today = new Rbtn_direct("바로 이용하기");
	Rbtn_reserve Reservation = new Rbtn_reserve("예약");
	Rbtn_chk_in In = new Rbtn_chk_in("입실");
	Rbtn_chk_out Out = new Rbtn_chk_out("퇴실");
	Rbtn_seatChange SeatChange = new Rbtn_seatChange("자리바꾸기");
	Rbtn_timeChk TimeConfirm = new Rbtn_timeChk("시간 확인 하기");

	String font = "twayair";
	Component[] first;
	JTextField loginId;
	JTextField loginPwd;
	String now = "";

	public Connect() {

	}

	public Connect(JFrame frame, JPanel panel, Component[] first, JTextField loginId, JTextField loginPwd, String now) {
		this.frame = frame;
		this.panel = panel;
		this.first = first;
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.now = now;

		Connect.setBounds(0, 0, 720, 1080);
		Connect.setLayout(null);
		Connect.setToolTipText("");
		Connect.setBackground(new Color(255, 255, 255));
		Connect.setVisible(false);

		// 바로 이용하기
		Today.setBounds(170, 170, 180, 180);
		Today.setFont(new Font("twayair", Font.PLAIN, 22));

		// 예약
		Reservation.setBounds(370, 170, 180, 180);
		Reservation.setFont(new Font("twayair", Font.PLAIN, 22));

		// 입실
		In.setBounds(170, 360, 180, 180);
		In.setFont(new Font("twayair", Font.PLAIN, 22));

		// 퇴실
		Out.setBounds(370, 360, 180, 180);
		Out.setFont(new Font("twayair", Font.PLAIN, 22));

		// 자리바꾸기
		SeatChange.setBounds(170, 550, 180, 180);
		SeatChange.setFont(new Font("twayair", Font.PLAIN, 22));

		// 시간확인하기
		TimeConfirm.setBounds(370, 550, 180, 180);
		TimeConfirm.setFont(new Font("twayair", Font.PLAIN, 22));

		seatEvent(Today);
		seatChangeEvt(SeatChange);
		outEvt(Out);
		timeEvt(TimeConfirm);
		inEvent(In);
		reservEvent(Reservation);
	}

	// 좌석 관련 이벤트 구현
	public void seatEvent(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("번호 들어간다");
				String str = "";
				// 바로이용하기 클릭한 경우
				str = "바로 사용하시겠습니까?";

				int result = JOptionPane.showConfirmDialog(null, str, "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					MainF mf = new MainF();
					db d = new db();
					ArrayList<String> seat = d.select("SeatNum", "paydata where id = +'" + mf.user + "';");
					if (seat.get(0) != null) {
						JOptionPane.showMessageDialog(null, "<html><font face='티웨이_항공'>이미 좌석이 있습니다.</font></html>",
								"confirm", JOptionPane.INFORMATION_MESSAGE);
					} else {
						panel.setVisible(false);
						if (Main.t.equals("now")) {
							System.out.println("다시 돌아가");
							for (int i = 0; i < Main.Main_p.length; i++) {
								Main.main_panel.add(Main.Main_p[i]);
							}
							frame.add(Main.main_panel);
						} else {
							Main m = new Main("now", frame, panel);
						}
					}
				}
			}
		});
	}

	public void reservEvent(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("예약 들어간다");
				MainF mf = new MainF();
				db d = new db();
				ArrayList<String> menu = d.select("Menu", "paydata where id = '" + mf.user + "';");
				int result = JOptionPane.showConfirmDialog(null,
						"<html><center><font face = '티웨이_항공'> 예약 하시겠습니까? </font></center></html>", "confirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
//					if (menu.size() >=5) {
//						JOptionPane.showMessageDialog(null,
//								"<html><center><font face = '티웨이_항공'> 예약 할 수 없습니다. </font></center></html>", "confirm",
//								JOptionPane.INFORMATION_MESSAGE);
//						panel.setVisible(false);
//
//						// 변경후 메인페이지로 이동.!
//						for (int i = 0; i < mf.main_con.length; i++) {
//							frame.add(mf.main_con[i]);
//						}
//					} else {
					panel.setVisible(false);
					resrvationMain rm = new resrvationMain("re", frame, panel);
//					}
				}
			}
		});
	}

	// 입실 이벤트 구현
	public void inEvent(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> data = new ArrayList<String>();
				System.out.println("입실 들어간다");
				int result = JOptionPane.showConfirmDialog(null, "<html><font face='티웨이_항공'>입실하시겠습니까?</font></html>",
						"confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					db d = new db();
					// 조건에 맞는 데이터 검색하여 저장
					data = d.selectAll("paydata WHERE Id='" + MainF.user
							+ "' AND StartTime IS NOT NULL AND StartTime>='" + now + "'", 1);
					// 조건에 맞는 데이터가 있으면 메인으로 돌아감
					if (data.size() == 1) {
						JOptionPane.showMessageDialog(null, "<html><font face='티웨이_항공'>입실되었습니다.</font></html>",
								"Message", JOptionPane.INFORMATION_MESSAGE);
						for (int i = 0; i < panel.getComponentCount(); i++) {
							panel.getComponent(i).setVisible(false);
						}
						for (int i = 0; i < first.length; i++) {
							panel.add(first[i]);
						}
						for (int i = 0; i < panel.getComponentCount(); i++) {
							if (panel.getComponent(i).toString().contains("Button")) {
								panel.getComponent(i).setVisible(true);
							} else {
								panel.getComponent(i).setVisible(false);
							}
						}
						MainF.user = "";
					} else { // 조건에 맞는 데이터가 없으면 message
						JOptionPane.showMessageDialog(null, "<html><font face='티웨이_항공'>입실할 수 없는 사용자입니다.</font></html>",
								"Message", result, null);
					}
					// login 시 입력했던 field 초기화
					loginId.setText("");
					loginPwd.setText("");
				}
			}
		});
	}

	// ++ wonho modify
	// 퇴실
	public void outEvt(JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("퇴실");
				int result = JOptionPane.showConfirmDialog(null, "<html><font face='티웨이_항공'>퇴실하시겠습니까?</font></html>",
						"confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {

					// ++ wh modify
					// timecheck 함수 Exit_query에 존재
					// 시작시간과 종료시간이 같은 경우 데이터 삭제.! 테스트 해봐야함!
					Exit_query ex = new Exit_query();
					ex.exit_dml();

					panel.setVisible(false);

					// 변경후 메인페이지로 이동.!
					MainF mf = new MainF();
					for (int i = 0; i < mf.main_con.length; i++) {
						frame.add(mf.main_con[i]);
					}
				}

			}

		});
	}

	// ++ wonho modify
	// 좌석변경
	public void seatChangeEvt(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "<html><font face='티웨이_항공'>바로 사용하시겠습니까?</font></html>",
						"confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					MainF mf = new MainF();
					db d = new db();
					d.dml("update paydata set seatNum = null where id ='" + mf.user + "';");
					d.dml("update paydata set StartTime = '"+now+"' where id ='" + mf.user + "' AND StartTime IS NULL;");
					System.out.println("좌석이 초기화 되었습니다.!");
					panel.setVisible(false);

				}
				if (Main.t.equals("now")) {
					System.out.println("다시 돌아가");
					for (int i = 0; i < Main.Main_p.length; i++) {
						Main.main_panel.add(Main.Main_p[i]);
					}
					frame.add(Main.main_panel);
				} else {
					Main m = new Main("now", frame, panel);
				}
			}
		});
	}

	// ++ wh modify
	// 남은 시간 확인 하기
	public void timeEvt(JButton btn) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null,
						"<html><font face='티웨이_항공'>시간을 확인하시겠습니까.?</font></html>", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					MainF mf = new MainF();
					db d = new db();

					ArrayList<String> startTime = d.select("StartTime",
							"paydata where id = '" + mf.user + "' order by StartTime;");
					ArrayList<String> endTime = d.select("EndTime",
							"paydata where id = '" + mf.user + "' order by StartTime;");
					ArrayList<String> seat = d.select("SeatNum",
							"paydata where id = '" + mf.user + "' order by StartTime;");

					System.out.println("시작시간과 끝시간은:" + startTime.get(0) + "," + endTime.get(0));
					if (startTime.get(0) != null & endTime.get(0) != null)
						JOptionPane.showMessageDialog(null, "<html><left>"
								+ "<font face='티웨이_항공'> 좌석번호는</font> <font color='red', size = 15, face = '티웨이_항공'>"
								+ seat.get(0) + "</font>번" + "<br>"
								+ "<font color = 'blue', size = 16, face = '티웨이_항공'>" + startTime.get(0)
								+ "</font> ~ <font color = 'blue', size = 16, face = '티웨이_항공'>" + endTime.get(0)
								+ "</font>까지", "confirm", JOptionPane.INFORMATION_MESSAGE);
					else {
						JOptionPane.showMessageDialog(null, "<html><font face='티웨이_항공'>결제 부탁 드립니다.</font><html>",
								"confirm", JOptionPane.INFORMATION_MESSAGE);
					}

				}

			}

		});
	}

}