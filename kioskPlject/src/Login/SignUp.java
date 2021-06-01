package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class SignUp {
	
	JPanel SignUp = new JPanel();
	JLabel signUp = new JLabel("회원이 아닌가요?");
	RoundButton signUpButton = new RoundButton("회원가입");
	JLabel signUpID = new JLabel("User ID");
	JLabel signUpPassword = new JLabel("Password");
	JLabel signUpName = new JLabel("이름");
	JLabel signUpGender = new JLabel("성별");
	JLabel signUpIDNum = new JLabel("주민등록번호(생년월일)");
	JLabel signUpPhoneNum = new JLabel("전화번호(- 제외)");
	JLabel signUpWord = new JLabel("소망(꿈) (기재시 꼭 이루어집니다!)");
	JRadioButton GenderM = new JRadioButton("남");
	JRadioButton GenderW = new JRadioButton("여");
	RoundButton completeBtn = new RoundButton("가입하기");
	RoundButton cancelBtn = new RoundButton("취소하기");
	
	//폰트 설정
	String font = "twayair";
	
	JTextField signUpIDField;
	JPasswordField signUpPasswordField;
	JTextField signUpNameField;
	JTextField signUpIDNumField;
	JTextField signUpPhoneNumField;
	JTextPane signUpWordTxt;
	
	public SignUp() {
		
		SignUp = new JPanel();
		SignUp.setLayout(null);
		SignUp.setToolTipText("");
		SignUp.setBackground(new Color(220, 220, 220));
		SignUp.setBounds(132, 72, 470, 733);
		
		// 회원가입 권유 
		signUp.setBackground(new Color(204, 204, 204));
		signUp.setForeground(new Color(51, 102, 204));
		signUp.setFont(new Font(font, Font.PLAIN, 13));
		signUp.setBounds(8, 230, 143, 34);
		
		// 회원가입 
		signUpButton.setFont(new Font(font, Font.PLAIN, 13));
		signUpButton.setBounds(110, 234, 55, 25);
		
		// Id
		signUpID.setFont(new Font(font, Font.PLAIN, 20));
		signUpID.setBounds(60, 45, 91, 25);
		SignUp.add(signUpID);
		
		signUpIDField = new JTextField();
		signUpIDField.setBounds(60, 72, 340, 34);
		SignUp.add(signUpIDField);
		
		// Pw
		signUpPassword.setFont(new Font(font, Font.PLAIN, 20));
		signUpPassword.setBounds(60, 118, 111, 42);
		SignUp.add(signUpPassword);
		
		signUpPasswordField = new JPasswordField();
		signUpPasswordField.setBounds(60, 153, 340, 34);
		SignUp.add(signUpPasswordField);
		
		// 이름 
		signUpName.setFont(new Font(font, Font.PLAIN, 19));
		signUpName.setBounds(60, 209, 91, 25);
		SignUp.add(signUpName);
		
		signUpNameField = new JTextField();
		signUpNameField.setBounds(60, 236, 340, 34);
		SignUp.add(signUpNameField);
		
		// 성별 
		signUpGender.setFont(new Font(font, Font.PLAIN, 19));
		signUpGender.setBounds(60, 292, 91, 25);
		SignUp.add(signUpGender);
		
		// 생년월일 
		signUpIDNum.setFont(new Font(font, Font.PLAIN, 19));
		signUpIDNum.setBounds(60, 375, 201, 25);
		SignUp.add(signUpIDNum);
		
		signUpIDNumField = new JTextField();
		signUpIDNumField.setBounds(60, 402, 340, 34);
		SignUp.add(signUpIDNumField);
		
		// 휴대폰 번호 
		signUpPhoneNum.setFont(new Font(font, Font.PLAIN, 19));
		signUpPhoneNum.setBounds(60, 455, 300, 25);
		SignUp.add(signUpPhoneNum);
		
		signUpPhoneNumField = new JTextField();
		signUpPhoneNumField.setBounds(60, 482, 340, 34);
		SignUp.add(signUpPhoneNumField);
		
		// 소망(꿈)
		signUpWord.setFont(new Font(font, Font.PLAIN, 19));
		signUpWord.setBounds(60, 534, 300, 25);
		SignUp.add(signUpWord);
		
		signUpWordTxt = new JTextPane();
		signUpWordTxt.setBounds(61, 565, 335, 97);
		SignUp.add(signUpWordTxt);
		
		// 성별 선택 버튼 그룹화
		ButtonGroup btnGender = new ButtonGroup();
		
		GenderM.setToolTipText("남");
		GenderM.setFont(new Font(font, Font.PLAIN, 16));
		GenderM.setBounds(70, 330, 54, 23);
		GenderM.setOpaque(false);
		SignUp.add(GenderM);
		
		GenderW.setToolTipText("여");
		GenderW.setFont(new Font(font, Font.PLAIN, 16));
		GenderW.setBounds(154, 330, 54, 23);
		GenderW.setOpaque(false);
		SignUp.add(GenderW);
		
		btnGender.add(GenderM);
		btnGender.add(GenderW);
		
		// 가입하기 
		completeBtn.setFont(new Font(font, Font.PLAIN, 15));
		completeBtn.setBounds(253, 688, 95, 35);
		SignUp.add(completeBtn);
		
		// 취소하기 
		cancelBtn.setFont(new Font(font, Font.PLAIN, 15));
		cancelBtn.setBounds(360, 688, 95, 35);
		SignUp.add(cancelBtn);
		
	}

}
