package reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import Login.MainF;
import main.pay.data.db;

public class selectCancelRe extends JPanel{
//	JPanel panel = new JPanel();
	JPanel panel;
	JPanel re;
	private String font = "티웨이_항공";

	// db 접근
	db d = new db();

	// 조건> 데이터의 Id 정보와 로그인한 Id 정보가 같아야 하고,
	// StartTime의 정보가 현재 시간보다 늦어야 하고,
	// Menu의 정보가 'reserv'여야 함
	// 조건에 맞는 데이터 arr로 반환하는 함수
	public ArrayList<String> dataChk() {
		String form = "yyyy/MM/dd/HH:mm";
		SimpleDateFormat s = new SimpleDateFormat(form);
		Date now = new Date();
		return d.selectAll("paydata where Id='" + MainF.user + "' AND StartTime>='" + s.format(now.getTime())
				+ "' AND Menu='reserv'", 2);
	}

	// dataChk()에서 받아온 arr의 안의 값을
	// '10번 좌석, 2021/05/30/23:00~2021/05/31/02:00' 식으로 변경하는 함수
	public String dataModify(String str) {
		String data = "";
		String[] splitStr = str.split("_");
		data = splitStr[0] + "번 좌석, " + splitStr[1] + "~" + splitStr[2];
		return data;
	}

	// 로그인한 사용자의 조건에 맞는 예약 데이터의 사이즈 반환 함수
	public int dataSize() {
		ArrayList<String> arr = dataChk();
		return arr.size();
	}

	// 체크박스 생성 함수
	public JCheckBox chkBox(int i) {
		JCheckBox box = new JCheckBox("");
		box.setFont(new Font(font, Font.BOLD, 25));
		box.setBounds(50, 110 + 120 * (i + 1), 30, 30);
		box.setOpaque(false);
		panel.add(box);
		return box;
	}

	// 예약한 내용에 관한 라벨 생성 함수
	public JLabel selectReLabel(int i, String str) {
		JLabel label = new JLabel((i + 1) + ". " + str);
		label.setFont(new Font(font, Font.BOLD, 23));
		label.setBounds(90, 110 + 120 * (i + 1), 650, 30);
		panel.add(label);
		return label;
	}


	public selectCancelRe(JPanel panel) {
		this.panel = panel;
	}
}
