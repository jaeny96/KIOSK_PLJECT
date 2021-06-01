package seatingTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Login.MainF;
import main.pay.data.db;

//++ wh modify 추가 클래스.! 퇴실시 실행하는 쿼리문
public class Exit_query {
	db d = new db();
	ArrayList<String> prodname;
	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
	MainF mf = new MainF();
	String id = mf.user;
	Date nowTime = new Date();
	String startT = format.format(nowTime);
	ArrayList<String> endTime;

//	@SuppressWarnings("unlikely-arg-type")
	public Exit_query() {
		// 퇴실시 필요한 데이터들을 반영합니다.
		/*
		 * 삭제할 데이터.! menuType이 seat 일 경우 id를 제외한 모든 데이터 삭제 menuType이 reserv일 경우 사용시간,
		 * endTime 남기고 삭제하지말고 null값으로만 반환 한다면..?! 다음 로그인해서 정기권으로 사용할경우.. reserv 그냥 좌석선택이
		 * 되게 만들어야 하는거 아닌가!? 다음에 또 로그인 할 때 그들은 뭘 사용하지..?! 그거 좌석 선택에서 추가해주자!! 여기서 들어가야할것
		 * startTime 만 계속 업데이트 해주면 되겠지?!
		 */
	}

	public void exit_dml() {
		prodname = d.select("ProdName", "paydata where id ='" + id + "';");
		endTime = d.select("EndTime", "paydata where id ='" + id + "';");
		boolean after = false;
		endTime = d.select("EndTime", "paydata where id ='" + id + "';");

//		System.out.println(prodname.get(0));
		if(prodname.get(0)==null){
			System.out.println("prod name null");
			JOptionPane.showMessageDialog(null, "<html><font face='티웨이_항공'>퇴실할 수 없는 사용자입니다.</font><html>", "confirm", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (prodname.get(0).contains("hours")) {
			System.out.println("hours로 들어옴");
			d.dml("update paydata set seatNum =" + null + " where id = '" + id + "';");
			d.dml("update paydata set payTime =" + null + " where id = '" + id + "';");
			d.dml("update paydata set startTime =" + null + " where id = '" + id + "';");
			d.dml("update paydata set endTime =" + null + " where id = '" + id + "';");
			d.dml("update paydata set ProdName =" + null + " where id = '" + id + "';");
			d.dml("update paydata set Price =" + null + " where id = '" + id + "';");
			d.dml("update paydata set Menu =" + null + " where id = '" + id + "';");
			JOptionPane.showMessageDialog(null, "<html><font='티웨이_항공'>퇴실 확인 되었습니다.</font></html>", "confirm", JOptionPane.INFORMATION_MESSAGE);
		}	
		/*
		 * 시간이 지낫을 경우에 대해서 로그인시 자동으로 삭제 하기 위한 쿼리문을 작성하였다. before 를 사용하여 현재시간이 기준시간을 지났을
		 * 경우 true를 반환하였고, true일시 쿼리문을 실행하도록 작성하였다.
		 */ 
		else if (prodname.get(0).contains("days")) {

			System.out.println("days로 들어옴");
			// 시작시간과 종료시간이 같지 않으면 이 쿼리를 실행한다.
			try {
				// 기준시간
				Date endT = format.parse(endTime.get(0));
				// 비교할 시간이 기준시간을 지났을 경우 true를 반환한다.
				after = nowTime.after(endT);
		
				if (after) {
					d.dml("update paydata set seatNum =" + null + " where id = '" + id + "';");
					d.dml("update paydata set payTime =" + null + " where id = '" + id + "';");
					d.dml("update paydata set startTime =" + null + " where id = '" + id + "';");
//					d.dml("update paydata set endTime =" + null + " where id = '" + id + "';");
					d.dml("update paydata set ProdName =" + null + " where id = '" + id + "';");
					d.dml("update paydata set Price =" + null + " where id = '" + id + "';");
					d.dml("update paydata set Menu =" + null + " where id = '" + id + "';");
					JOptionPane.showMessageDialog(null, "<html><font='티웨이_항공'>퇴실 확인 되었습니다.</font></html>", "confirm", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					d.dml("update paydata set SeatNum =" + null + " where id = '" + id + "';");
					d.dml("update paydata set StartTime =" + null + " where id = '" + id + "';");
					JOptionPane.showMessageDialog(null, "<html><font='티웨이_항공'>퇴실 확인 되었습니다.</font></html>", "confirm", JOptionPane.INFORMATION_MESSAGE);
				}
				
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// 시작시간과 종료시간이 같으면 이 쿼리를 실행한다.
			// 예약시간이 가까워오면 알림해주는 것도 너무 좋을 거 같은데..!! 이건 일단 보류
		}else {
				
			}

	}
//	public void timecheck() {
//
//		boolean after = false;
//		endTime = d.select("EndTime", "paydata where id ='" + id + "';");
//		try {
//			// 기준시간
//			Date endT = format.parse(endTime.get(0));
//			// 비교할 시간이 기준시간을 지났을 경우 true를 반환한다.
//			after = nowTime.before(endT);
//			if (after) {
//				d.dml("update paydata set seatNum =" + null + "where id = '" + id + "';");
//				d.dml("update paydata set payTime =" + null + "where id = '" + id + "';");
//				d.dml("update paydata set startTime =" + null + "where id = '" + id + "';");
//				d.dml("update paydata set endTime =" + null + "where id = '" + id + "';");
//				d.dml("update paydata set ProdName =" + null + "where id = '" + id + "';");
//				d.dml("update paydata set Price =" + null + "where id = '" + id + "';");
//				d.dml("update paydata set Menu =" + null + "where id = '" + id + "';");
//			}
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
}
