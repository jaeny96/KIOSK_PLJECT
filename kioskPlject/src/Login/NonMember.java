package Login;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class NonMember extends JPanel{
	
	JPanel NonMember = new JPanel();
	RoundButton nonMemberButton = new RoundButton("비회원");
	JLabel cellPhoneNum = new JLabel("휴대폰 번호");
	JLabel verifiedNum = new JLabel("인증번호");
	RoundButton loginButtonNon = new RoundButton("로그인");
	RoundButton returnButton = new RoundButton("돌아가기");
	
	//폰트 설정
	String font = "twayair";
	
	JTextField cellPhoneNumField;
	JTextField verifiedNumField;
	
	public NonMember() {
		
		NonMember.setLayout(null);
		NonMember.setToolTipText("");
		NonMember.setBackground(new Color(220, 220, 220));
		NonMember.setBounds(132, 214, 470, 266);
		
		// 비회원 버튼 
		nonMemberButton.setFont(new Font(font, Font.PLAIN, 14));
		nonMemberButton.setBounds(380, 211, 80, 30);
		
		// 휴대폰 번호 
		cellPhoneNum.setFont(new Font(font, Font.PLAIN, 19));
		cellPhoneNum.setBounds(60, 63, 151, 25);
		NonMember.add(cellPhoneNum);
		
		cellPhoneNumField = new JTextField();
		cellPhoneNumField.setBounds(60, 90, 340, 34);
		NonMember.add(cellPhoneNumField);
		
		// 인증번호 
		verifiedNum.setFont(new Font(font, Font.PLAIN, 19));
		verifiedNum.setBounds(60, 127, 168, 42);
		NonMember.add(verifiedNum);
		
		verifiedNumField = new JTextField();
		verifiedNumField.setBounds(60, 162, 340, 34);
		NonMember.add(verifiedNumField);
		
		// 비회원 로그인 버튼 
		loginButtonNon.setFont(new Font(font, Font.PLAIN, 15));
		loginButtonNon.setBounds(310, 211, 90, 30);
		NonMember.add(loginButtonNon);
		
		// 돌아가기 
		returnButton.setFont(new Font(font, Font.PLAIN, 14));
		returnButton.setBounds(378, 8, 80, 30);
		NonMember.add(returnButton);
		
	}
	
}