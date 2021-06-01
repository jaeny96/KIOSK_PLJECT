package seatingTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.pay.data.db;

public class srZone extends JPanel {

	db d = new db();
	ArrayList<String> seat = null;
	ArrayList<String> menuType = null;
	ArrayList<String> time = null;
	ArrayList<String> startTime = null;
	ArrayList<String> endTime = null;
	Date start = new Date();
	Date end = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
	SimpleDateFormat fo = new SimpleDateFormat("HH:mm");
	SimpleDateFormat ho = new SimpleDateFormat("HH");
	String type = "";
		
	//스터디룸 패널 생성
	srZone() {
		setBounds(20, 130, 660, 870);
		setLayout(null);
		this.setVisible(true);
	}
	

	// 좌석표 버튼 생성!
	void btn(JButton[] btn, JPanel srZone) {

		seat = d.select("seatNum", "paydata");
		startTime = d.select("StartTime", "paydata");
		endTime = d.select("EndTime", "paydata");
		menuType = d.select("Menu", "paydata");

		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton((i + 51) + "");
			btn[i].addActionListener(new seatButton(btn[i], i + 1));
			srZone.add(btn[i]);
			btn[i].setContentAreaFilled(false);
			btn[i].setBorderPainted(false);
			btn[i].setFocusPainted(false);
			// db 파일에 저장한 seat 버튼을 가져옵니다.
			for (int j = 0; j < seat.size(); j++) {
				// db 번호와 좌석표 db와 같은경우 코드 실행
				
				if (btn[i].getText().equals(seat.get(j))) { //이대로도 가능할 것 같긴 한데.. 퇴실 때 seatNum을 null처리 해버리면.!
					// 바로사용의 시간에 데이터가 있는 경우 색상지정!
					System.out.println("btn[i]:" + btn[i].getText());
					System.out.println("seat:"+seat.get(j));
					System.out.println("time:" + time.get(j));
					if (menuType.get(j).equals("seat")) {
						btn[i].setBackground(new Color(174,248,211));
						btn[i].setContentAreaFilled(true);
//						파란색 102번 가져오기!
						if (btn[i].getBackground().getBlue() == 211) {
							JButton J = btn[i];
							btn[i].addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									
									// TODO Auto-generated method stub
									for (int z = 0; z < seat.size(); z++) {
										if (J.getText().equals(seat.get(z))) {
											try {
												start = f.parse(startTime.get(z));
												end = f.parse(endTime.get(z));

											} catch (ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}

											String start_t = fo.format(start);
											String end_t = fo.format(end);

											JOptionPane.showMessageDialog(null, "<HTML>" + "<font face='티웨이_항공'>사용중인 자리입니다." + "<br>"
													+ start_t + "~" + end_t + "</font></HTML>");
										}
									}

								}
							});
						}
					}
					// 예약 시간에 데이터가 있는 경우 색상지정
					else if (startTime.get(j) != null) {
						System.out.println("예약시간:" + startTime.get(j));
						try {
							start = f.parse(startTime.get(j));
							end = f.parse(endTime.get(j));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						/// 예약 시간 한시간 전을 구하기 위한 calendar사용!
						Calendar cal = Calendar.getInstance();
						cal.setTime(start);
						cal.add(Calendar.HOUR, -1);
						System.out.println("cal:" + cal.getTime());
						String r_start = ho.format(cal.getTime());
						System.out.println("r_start:" + r_start);

						Date dt_now = new Date();
						String now = ho.format(dt_now);
						System.out.println("now:" + now);

						// 현재 시간과 db시간이 같으면 예약 색상으로 변경!
						if (r_start.equals(now)) {
							btn[i].setBackground(new Color(248,229,175));
							btn[i].setContentAreaFilled(true);
							if (btn[i].getBackground().getBlue() == 175) {
								JButton c = btn[i];
								btn[i].addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// for문으로 데이터 가지고오기!
										for (int k = 0; k < seat.size(); k++) {
											if (c.getText().equals(seat.get(k))) {
												try {
													start = f.parse(startTime.get(k));
													end = f.parse(endTime.get(k));
												} catch (ParseException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												String start_t = fo.format(start);
												String end_t = fo.format(end);

												JOptionPane.showMessageDialog(null, "<HTML>" + "<font face='티웨이_항공'>예약 중인 자리입니다.." + "<br>"
														+ start_t + "~" + end_t + "</font></HTML>");
											}
										}

									}

								});
							}
						}
					}

				}
			}

		}
		//버튼 위치
		btn[0].setBounds(115, 300, 111, 100);
		btn[1].setBounds(438, 300, 111, 100);
	}
	public void back_img() {
		seatingImage seatimg = new seatingImage(new ImageIcon("./src/image/sr_zone_1.jpg").getImage());
		this.add(seatimg);
	}
}
