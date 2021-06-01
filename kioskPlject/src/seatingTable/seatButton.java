package seatingTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Login.MainF;
import main.pay.payment;
import main.pay.data.db;
import reservation.resrvationMain;

public class seatButton implements ActionListener {
	Dbfile db = new Dbfile();
	db d = new db();
	JButton btn = null;
	ArrayList<String> seat;
	ArrayList<String> payType;
	ArrayList<String> prod;
	Date start = new Date();
	Date end = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
	SimpleDateFormat fo = new SimpleDateFormat("HH:mm:ss");
	resrvationMain rm = new resrvationMain();
	MainF mf = new MainF();
	int i = 0;

	public seatButton(JButton btn) {
		this.btn = btn;
	}

	public seatButton(JButton btn, int i) {
		this.btn = btn;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// seatbutton을 db와 이곳에 저장되게 만드는 것이다.!

		// ++ wh modi 해당 아이디를 받아오기 위함
		seat = d.select("seatNum", "paydata where id = '" + mf.user + "'");
		// 정기권 이용자를 찾아내기 위해서 '주일'이라는 단어를 가져오기 위해 호출
		prod = d.select("ProdName", "paydata where id = '" + mf.user + "'");
		//
//		System.out.println(prod.get(0));
		// 현재사용자를 어떻게 하면 가져올 수 있을까?! 해결
		// 만약 id 가 userId 와 같고 seat이 null값이라면! 근데 이미 널값은 확실하지 않을까?! 왜냐면 자리변경을 누를 때 이미
		// null값으로 변경시켰으니가!
		// user id 와 id 가 같다면 아래의 쿼리문을 실행 시킬수 있는 것이겠지!

		//

		// ++wh modify
		// 버튼에 색이 지정되어있으면 아무 일도 안일어나게 바꿔 놓았다.

		if (btn.getBackground().getBlue() == 211 || btn.getBackground().getBlue() == 175) {
//			System.out.println("암것도 하지마!");
		} else {
//			System.out.println("들어오기 전이다아아아아");
//			System.out.println(Main.type);
			if (seat.get(0) == null || Main.type.equals("reserve") || seat.size()==0) {
//				System.out.println("들어왓다아아아");
				int result = JOptionPane.showConfirmDialog(null, btn.getText() + "를  선택하겠습니까?", "confirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					// 예약 패널에서 좌석 선택시 좌석번호를 보내주는 코드
					if (Main.type.equals("reserve")) {
						// 예약 패널에 번호 업데이트!
						resrvationMain.btn_seat.setText(btn.getText() + "번 좌석");
						Main.getFrame().dispose();
						resrvationMain.btn_pay.setEnabled(true);
						Main.type = "";
					}
					// ++ wh modi
					// 정기권 사용자가 로그아웃 후에 다시 이용할 때, 결제 페이지로 넘어가지 않고 바로 사용할 수 있게 하도록.!
					else if (prod.get(0) == null) {
						payment p = new payment(btn.getText(), Main.getFrame(), "seat");
						p.getFrame().setVisible(true);
					} else if (prod.get(0).contains("days") || Main.t.equals("reserv")) {
						int seatnum = Integer.parseInt(btn.getText());
						d.dml("update paydata set SeatNum = " + seatnum + " where id = '" + mf.user + "';");
						JOptionPane.showMessageDialog(null, mf.user + "님 좌석 선택 완료되었습니다!", "confirm",
								JOptionPane.INFORMATION_MESSAGE);
						// 새로고침 구현하고싶다.!

					}

					else if (prod.get(0).contains("hours")) {
						int seatnum = Integer.parseInt(btn.getText());
						d.dml("update paydata set SeatNum = " + seatnum + " where id = '" + mf.user + "';");
						JOptionPane.showMessageDialog(null, mf.user + "님 좌석 선택 완료되었습니다!", "confirm",
								JOptionPane.INFORMATION_MESSAGE);
						// 새로고침 구현하고싶다.!

					}

					// 바로 사용시 출력되는 코드.!
//				else {
//				payment p = new payment(btn.getText() ,Main.getFrame(), "seat");
//				p.getFrame().setVisible(true);
//
//				}

				} else {
//					JOptionPane.showMessageDialog(null, mf.id + "님 좌석 선택 완료되었습니다!", "confirm",
//							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		}
	}

}