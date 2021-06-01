package reservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Login.MainF;
import main.pay.payment;
import main.pay.data.db;
import main.pay.data.reservData;
import seatingTable.Main;
import seatingTable.mainPanel;

public class resrvationMain {

	JScrollPane scrollPane;
	ImageIcon icon;
	public static String seatnum = "";
	public static JButton btn_seat;
	public static JFrame frame;
	Component[] mainC;
	String rt = "";
	// ++js modify
	private JPanel mainReservation;
	public static JButton btn_pay;
	private Rbtn_home home;
	JPanel show;
	String StartT = "";
	String EndT = "";
	// ++

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					resrvationMain window = new resrvationMain();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public resrvationMain() {
		initialize();
	}

	public resrvationMain(String rt, JFrame frame, JPanel show) {
		this.rt = rt;
		this.frame = frame;
		this.show = show;
//		setFrame(frame);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if (!rt.equals("re")) {
			frame = new JFrame();
			frame.setBounds(100, 0, 720, 1080);
//			setFrame(frame);						
		}
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/Image/CODERIUM_Icon.png"));
		frame.getContentPane().setFont(new Font("티웨이_항공", Font.BOLD, 20));
		frame.setTitle("CODERIUM");
//		frame.setVisible(true);
		// exit 버튼 누를 시 현재 창만 종료됨
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
//		frame.setResizable(false);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);

		icon = new ImageIcon("./src/Image/CODERIUM_Background.jpg");

		mainReservation = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};

		mainReservation.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(mainReservation);
		mainReservation.setLayout(null);

		JLabel LavelmainRe = new JLabel("예약");
		LavelmainRe.setHorizontalAlignment(SwingConstants.CENTER);
		LavelmainRe.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelmainRe.setBounds(0, 0, 714, 110);
		mainReservation.add(LavelmainRe);

		// 새로운 예약 버튼
//		JButton btn_newReservation = new JButton("새로운 예약");
		RoundButton btn_newReservation = new RoundButton("새로운 예약");
		btn_newReservation.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_newReservation.setBounds(250, 190, 221, 54);
		btn_newReservation.setContentAreaFilled(false);
		btn_newReservation.setBorderPainted(false);
		btn_newReservation.setFocusPainted(false);
		btn_newReservation.setOpaque(false);
		mainReservation.add(btn_newReservation);
		btn_newReservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ++새로운 예약 버튼 구현
				// ++새로운 예약 버튼 클릭 시 현재 mainReservation 패널에 추가되어 있는 component들 지운 후
				// createNew 함수 내 구현되어 있는 component들 add시킴!
				mainReservation.removeAll();
				frame.remove(home);
				createNewRe(mainReservation);
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				mainReservation.repaint();

//				btn_pay.setvisible(false);  => 결제 버튼 비활성화 활성화 하고 싶은데 순서가 문제다 고민해보자,,,!

			}
		});

		// 예약 확인 버튼
		RoundButton btn_checkRe = new RoundButton("\uC608\uC57D \uD655\uC778");
		btn_checkRe.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_checkRe.setBounds(250, 470, 221, 54);
		btn_checkRe.setContentAreaFilled(false);
		btn_checkRe.setBorderPainted(false);
		btn_checkRe.setFocusPainted(false);
		mainReservation.add(btn_checkRe);
		btn_checkRe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ++새로운 예약 버튼 구현
				// ++새로운 예약 버튼 클릭 시 현재 mainReservation 패널에 추가되어 있는 component들 지운 후
				// createNew 함수 내 구현되어 있는 component들 add시킴!
				mainReservation.removeAll();
				checkRe(mainReservation);
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				mainReservation.repaint();

			}
		});

		// 예약 취소 버튼
		RoundButton btn_cancelRe = new RoundButton("\uC608\uC57D \uCDE8\uC18C");
		btn_cancelRe.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_cancelRe.setBounds(250, 775, 221, 54);
		btn_cancelRe.setContentAreaFilled(false);
		btn_cancelRe.setBorderPainted(false);
		btn_cancelRe.setFocusPainted(false);
		mainReservation.add(btn_cancelRe);
		// 현재 예약 취소 패널로 옮기는 창 구현됨 => 예약 취소로 기존의 예약 회원 DB 좌석 DB 삭제 actionlistener 필요
		btn_cancelRe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ++새로운 예약 버튼 구현
				// ++새로운 예약 버튼 클릭 시 현재 mainReservation 패널에 추가되어 있는 component들 지운 후
				// createNew 함수 내 구현되어 있는 component들 add시킴!
				mainReservation.removeAll();
				cancelRe(mainReservation);
//				System.out.println("cnt cotn " + mainReservation.getComponentCount());
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				mainReservation.repaint();
			}
		});
		btn_home(mainReservation);
		mainC = mainReservation.getComponents();
//		System.out.println("mainC count " + mainC.length);

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

	public void createNewRe(JPanel panel) {

		icon = new ImageIcon("./src/Image/CODERIUM_Background.jpg");

		JPanel createNewRe = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		createNewRe.setBounds(0, 0, 714, 1051);
//		frame.getContentPane().add(createNewRe);
		frame.add(createNewRe);
		createNewRe.setLayout(null);
		createNewRe.setVisible(false);

		JLabel LavelnewRe = new JLabel("새로운 예약");
		LavelnewRe.setHorizontalAlignment(SwingConstants.CENTER);
		LavelnewRe.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelnewRe.setBounds(0, 0, 714, 110);
		panel.add(LavelnewRe);

		JLabel date = new JLabel("날짜");
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		date.setBounds(10, 190, 200, 80);
		panel.add(date);

		selectDate selectDate = new selectDate(panel);
		selectDate.setBounds(150, 210, 500, 80);
		selectDate.setBackground(new Color(255, 0, 0, 0));
		panel.setVisible(true);
		panel.add(selectDate);

		JLabel time = new JLabel("시간");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		time.setBounds(10, 470, 200, 80);
		panel.add(time);

		selectMenu selectMenu = new selectMenu(panel);
		selectMenu.setBounds(160, 483, 400, 80);
		selectMenu.setBackground(new Color(255, 0, 0, 0));
		panel.setVisible(true);
		panel.add(selectMenu);

		JLabel seat = new JLabel("좌석");
		seat.setHorizontalAlignment(SwingConstants.CENTER);
		seat.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		seat.setBounds(10, 775, 200, 80);
		panel.add(seat);

		// 새로운 예약 => 좌석표 선택창 오픈 버튼
		btn_seat = new JButton("좌석 선택");
		btn_seat.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_seat.setBounds(250, 785, 221, 54);
//		btn_seat.setBounds(250, 600, 221, 54);
		btn_seat.setBackground(new Color(255, 0, 0, 0));
		btn_seat.setContentAreaFilled(false);
		btn_seat.setBorderPainted(false);
		btn_seat.setFocusPainted(false);
		btn_seat.setOpaque(false);
		panel.add(btn_seat);
		// 좌석표 창 오픈해야되는 actionlistener필요
		btn_seat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main seat = new Main("reserve");
				seat.getFrame().setVisible(true);

			}
		});

		// 새로운 예약 => 결제 창으로 이동 버튼
		btn_pay = new JButton("결제");
		btn_pay.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_pay.setBounds(558, 940, 158, 110);
		btn_pay.setContentAreaFilled(false);
		btn_pay.setBorderPainted(false);
//		btn_pay.setBorder(new LineBorder(Color.BLUE));
		btn_pay.setFocusPainted(false);
		btn_pay.setOpaque(false);
		btn_pay.setEnabled(false);
		panel.add(btn_pay);
		// 결제창으로 이동하는 actionlistener필요

		MainF mf = new MainF();
		db d = new db();
		ArrayList<String> menu = d.select("Menu", "paydata where id = '" + mf.user+"'");
//		System.out.println("menusize "+menu.size());

		btn_pay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (menu.size() >= 3) {
					JOptionPane.showMessageDialog(null,
							"<html><center><font face = '티웨이_항공'> 예약 할 수 없습니다. </font></center></html>", "confirm",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					selectDate.yearBox.getSelectedItem().toString();
					selectDate.monthBox.getSelectedItem().toString();
					selectDate.dayBox.getSelectedItem().toString();

					// ++js modify
					String yearB = selectDate.yearBox.getSelectedItem().toString();
					String year = Integer.parseInt(yearB) < 10 ? "0" + yearB : yearB;
					String month = selectDate.monthBox.getSelectedItem().toString();
					String day = selectDate.dayBox.getSelectedItem().toString();
					String hourTemp = selectDate.timelist.getSelectedItem().toString();
					String hour = Integer.parseInt(hourTemp) < 10 ? "0" + hourTemp : hourTemp;
//					System.out.println(hour);
					String stdDate = year + "/" + month + "/" + day + "/" + hour + ":00";
					reservData rd = new reservData();
					rd.modiProd(selectMenu.menuList.getSelectedItem().toString());
					String prodName = rd.getProd();
					String price = rd.getPrice();
					String seatN = btn_seat.getText();
					payment p = new payment(seatN.substring(0, seatN.length() - 4), getFrame(), "reserv", prodName,
							price, stdDate, show);
					p.getFrame().setVisible(true);
					// ++
				}
			}

		});

		btn_back(panel, home);
	}

	public void checkRe(JPanel panel) {
		JPanel checkRe = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		checkRe.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(checkRe);
		checkRe.setLayout(null);
		checkRe.setVisible(false);

		JLabel LabelcheckRe = new JLabel("예약 확인");
		LabelcheckRe.setHorizontalAlignment(SwingConstants.CENTER);
		LabelcheckRe.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LabelcheckRe.setBounds(0, 0, 700, 110);
		panel.add(LabelcheckRe);

		JPanel selectRe = new selectRe(panel);
		selectRe.setBounds(0, 105, 700, 855);
		selectRe.setBackground(new Color(255, 0, 0, 0));
		selectRe.setOpaque(false);
//		panel.setVisible(true);
		panel.add(selectRe);

		// ++js modify
		// selectRe 클래스 호출
		selectRe sr = new selectRe(panel);
		System.out.println(sr.dataSize());
		for (int i = 0; i < sr.dataSize(); i++) {
			// selectRe 클래스 내 함수를 통해 label 생성
			// sr.dataModify(sr.dataChk().get(i)) -> dataChk()함수를 통해 가져온 데이터값을 정제하여 label의
			// text 값으로 넣는 작업
			sr.selectReLabel(i, sr.dataModify(sr.dataChk().get(i)));
		}
		// ++

		// 예약 확인 => 입실 버튼 활성화
//		JButton btn_checkIn = new JButton("입실");
//		btn_checkIn.setFont(new Font("티웨이_항공", Font.BOLD, 25));
//		btn_checkIn.setBounds(558, 940, 158, 110);
//		btn_checkIn.setContentAreaFilled(false);
//		btn_checkIn.setBorderPainted(false);
//		btn_checkIn.setFocusPainted(false);
//		btn_checkIn.setOpaque(false);
//		panel.add(btn_checkIn);
//		// 입실하는 actionlistener필요 => 좌석표 시간 활성화 및 예약 데이터 삭제? => 실시간 좌석 데이터로 전환? 가능??
//		btn_checkIn.addActionListener(new ActionListener() {

//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			}
//		});

		btn_back(panel, home);
	}

	public void cancelRe(JPanel panel) {
		JPanel cancelRe = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		cancelRe.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(cancelRe);
		cancelRe.setLayout(null);
		cancelRe.setVisible(false);

		JLabel LabelcancelRe = new JLabel("예약 취소");
		LabelcancelRe.setHorizontalAlignment(SwingConstants.CENTER);
		LabelcancelRe.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LabelcancelRe.setBounds(0, 0, 714, 110);
		panel.add(LabelcancelRe);

		JPanel selectCancelRe = new selectCancelRe(panel);
		selectCancelRe.setBounds(230, 300, 500, 600);
		selectCancelRe.setBackground(new Color(255, 0, 0, 0));
		selectCancelRe.setOpaque(false);
//		panel.setVisible(true);
		panel.add(selectCancelRe);

		// 선택한 예약 데이터 예약 취소 버튼
		JButton btn_reCancel = new JButton("예약 취소");
		btn_reCancel.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_reCancel.setBounds(558, 940, 158, 110);
		btn_reCancel.setContentAreaFilled(false);
		btn_reCancel.setBorderPainted(false);
		btn_reCancel.setFocusPainted(false);
		btn_reCancel.setOpaque(false);
		panel.add(btn_reCancel);

		// ++js modify
		paintData(panel);

		// 선택한 예약 데이터 예약 취소
		btn_reCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예약 취소 버튼 눌렀을때 '취소하시겠습니까?' 팝업창 생성
				int result = JOptionPane.showConfirmDialog(null, "<html><font='티웨이_항공'>취소하시겠습니까?</font></html>",
						"confirm", JOptionPane.YES_NO_OPTION);
				// '취소하시겠습니까?' 팝업 창에 대해 'yes'옵션 선택한 경우
//				System.out.println("chkBoolggg " + chkBool);
				if (result == JOptionPane.YES_OPTION) {
					// 선택된 라디오 버튼이 없을 때 이벤트 처리
					if (!chkBool) {
						System.out.println("선택한 데이터 없음");
						JOptionPane.showMessageDialog(null, "<html><font='티웨이_항공'>선택한 버튼이 없습니다.</font></html>",
								"Message", JOptionPane.ERROR_MESSAGE);
					} else { // 선택된 라디오 버튼이 있을 때 이벤트 처리
						System.out.println("선택한 데이터 있음");
						// 데이터 베이스에 접근하여 데이터 삭제하는 코드 들어갈 부분
//						System.out.println("res" + result);
						db d = new db();
						d.delete("paydata", " WHERE Id='" + MainF.user + "' AND StartTime='" + getStart()
								+ "' AND EndTime<='" + getEnd() + "'");
						JOptionPane.showMessageDialog(null, "<html><font='티웨이_항공'>예약이 취소되었습니다.</font></html>");
						paintData(panel);

					}
				}
			}
		});
		btn_back(panel, home);
	}

	public String getStart() {
		return StartT;
	}

	public void setStart(String StartT) {
		this.StartT = StartT;
	}

	public String getEnd() {
		return EndT;
	}

	public void setEnd(String EndT) {
		this.EndT = EndT;
	}

//    public void delete(int id) {
//        StringBuilder sb = new StringBuilder();
//        String sql = sb.append("delete from " + table + " where id = ")
//                .append(id)
//                .append(";")
//                .toString();
//        try {
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

	// ++js modify
	// chkEvent에서 사용하기 위해 생성한 ArrayList
	ArrayList<JCheckBox> chkArr = new ArrayList<JCheckBox>();
	// 체크박스 선택되어 있는지 없는지 확인하는 chkBool 변수 생성
	boolean chkBool = false;
	// ++

	public void paintData(JPanel panel) {
		// selectCancelRe 클래스 호출
		selectCancelRe sr = new selectCancelRe(panel);
		for (int i = 0; i < sr.dataSize(); i++) {
			// chkBox event 적용하는 부분
			// selectCancelRe 클래스 내 함수를 통해 label 생성
			// sr.dataModify(sr.dataChk().get(i)) -> dataChk()함수를 통해 가져온 데이터값을 정제하여 label의
			// text 값으로 넣는 작업
			sr.selectReLabel(i, sr.dataModify(sr.dataChk().get(i)));
			// 데이터 delete 조건 위해 start~end 추출 후 chkEvent()에 전달
			String tempData = sr.dataModify(sr.dataChk().get(i));
			String[] tempDataArr = tempData.split(", ");
			String temp = tempDataArr[1];
			chkEvent(sr.chkBox(i), temp);
		}
	}


	public void chkEvent(JCheckBox box, String str) {
		box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (box.isSelected()) {
					String[] tmpTime = str.split("~");
					setStart(tmpTime[0]);
					setEnd(tmpTime[1]);
					chkBool = true;
					System.out.println("chkBool " + chkBool);
					chkDisabled(chkArr);
				} else {
					chkBool = false;
					System.out.println("chkBool " + chkBool);
					chkEnabled(chkArr);
				}
			}
		});
	}

	// 체크된 체크박스 이외 체크박스 비활성화하는 함수
	public void chkDisabled(ArrayList<JCheckBox> cb) {
		for (int i = 0; i < cb.size(); i++) {
			if (cb.get(i).isSelected()) {
				for (int j = 0; j < cb.size(); j++) {
					if (i != j) {
						cb.get(j).setEnabled(false);
					}
				}
			}
		}
	}

	// 모든 체크박스 활성화하는 함수
	public void chkEnabled(ArrayList<JCheckBox> cb) {
		for (int i = 0; i < cb.size(); i++) {
			cb.get(i).setEnabled(true);
		}
	}

	// 메뉴로 돌아가기 버튼 이벤트 구현
	public void btn_home(JPanel panel) {
		home = new Rbtn_home();
		home.setBounds(600, 50, 48, 48);
		designBtn(home);
		panel.add(home);

		// 홈버튼 클릭시
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainReservation);
				show.setVisible(true);
			}
		});
	}
	// ++

	// 뒤로 가기 이벤트 하나의 함수로 구현
	public void btn_back(JPanel panel, JButton btn) {
		Rbtn_back btn_back = new Rbtn_back();
		btn_back.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_back.setBounds(600, 50, 48, 48);
		btn_back.setContentAreaFilled(false);
		btn_back.setBorderPainted(false);
		btn_back.setFocusPainted(false);
		panel.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ++뒤로가기 버튼 구현
				// ++뒤로가기 클릭 시 현재 추가되어 있는 새로운 예약 구현 시 add했던 component들 지운 후
				// 저장해놓은 mainC add시킴!
				panel.removeAll();
				for (int i = 0; i < mainC.length; i++) {
					panel.add(mainC[i]);
				}
				btn_home(panel);
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				panel.repaint();
			}
		});
	}
}
