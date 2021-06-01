package reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import Login.MainF;
import main.pay.data.db;

public class selectRe extends JPanel{
//	JPanel panel = new JPanel();
	JPanel panel;

	private String font = "티웨이_항공";
//	JRadioButton check[] = new JRadioButton[3];
//	String check_name[] = { "1.", "2.", "3." };
//	JRadioButton rdbtnNewRadioButton = new JRadioButton();
//	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton();
//	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton();
	
	//db 접근
	db d = new db();

	// 조건> 데이터의 Id 정보와 로그인한 Id 정보가 같아야 하고,
	// StartTime의 정보가 현재 시간보다 늦어야 하고,
	// Menu의 정보가 'reserv'여야 함
	// 조건에 맞는 데이터 arr로 반환하는 함수
	public ArrayList<String> dataChk(){		
		String form = "yyyy/MM/dd/HH:mm";
		SimpleDateFormat s = new SimpleDateFormat(form);
		Date now = new Date();
		return d.selectAll("paydata where Id='"+MainF.user +"' AND StartTime>='"+s.format(now.getTime())+"' AND Menu='reserv'",2);
	}

	public String dataModify(String str) {
		String data="";
		String[] splitStr = str.split("_");
		data = splitStr[0]+"번 좌석, " + splitStr[1]+"~"+splitStr[2];
		return data;
	}
	
	// 로그인한 사용자의 조건에 맞는 예약 데이터의 사이즈 반환 함수
	public int dataSize() {
		ArrayList<String> arr = dataChk();
		System.out.println("arr.size()"+arr.size());
		return arr.size();
	}
	
	// 예약한 내용에 관한 라벨 생성 함수
	public void selectReLabel(int i,String str) {
		JLabel label = new JLabel((i+1)+". "+str);
		label.setFont(new Font(font, Font.BOLD, 23));
		label.setBounds(50,110+120*(i+1),650,30);
		panel.add(label);
	}
	
	public selectRe(JPanel panel) {
		this.panel = panel;

//		setLayout(null);
//		
//		ButtonGroup group = new ButtonGroup();
//        for(int i=0; i<3; i++){
//        	check[i] = new JRadioButton(check_name[i]);
//        	if(check_name[i] == null)
//        		continue;
//             group.add(check[i]);
//             check[i].addActionListener(this);
//             check[i].setBounds(57, 55, 166, 41);
//             check[i].setFocusPainted(false);
//             check[i].setBorderPainted(false);
//             check[i].setContentAreaFilled(false);
//             check[i].setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//             if(check[i] == check[0]) { 
//            	 check[i].setBounds(57, 55, 166, 41);
//             }else if(check[i] == check[1]) { 
//            	 check[i].setBounds(57, 225, 166, 41);
//             }else if(check[i] == check[2]) {
//            	 check[i].setBounds(57, 410, 166, 41);
//             }
//        	
//
//           add(check[i]);
//             
//        }
//        
//        check[0].setSelected(false);
//        check[1].setSelected(true);
//        
//        
//        setSize(252, 496);
//        

		// DB ���� Ŭ���� �ҷ���
//        dbconnect();

//        JRadioButton selectRe = new JRadioButton();
//        for (int i = 1; i < 4; i++) {
//            rdbtnNewRadioButton.setBounds(57, 55, 166, 41);
//            rdbtnNewRadioButton.setFocusPainted(false);
//            rdbtnNewRadioButton.setBorderPainted(false);
//            rdbtnNewRadioButton.setContentAreaFilled(false);
//            rdbtnNewRadioButton.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//            add(rdbtnNewRadioButton);
//			
//		}
//        
//        
//        // 1������ �κп� �����ҷ����� �ʿ�
//        JRadioButton rdbtnNewRadioButton = new JRadioButton("1�� ����");
//        rdbtnNewRadioButton.setBounds(57, 55, 166, 41);
//        rdbtnNewRadioButton.setFocusPainted(false);
//        rdbtnNewRadioButton.setBorderPainted(false);
//        rdbtnNewRadioButton.setContentAreaFilled(false);
//        rdbtnNewRadioButton.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton);
//        
//        // 2������ �κп� �����ҷ����� �ʿ�
//        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2�� ����");
//        rdbtnNewRadioButton_1.setBounds(57, 224, 166, 41);
//        rdbtnNewRadioButton_1.setFocusPainted(false);
//        rdbtnNewRadioButton_1.setBorderPainted(false);
//        rdbtnNewRadioButton_1.setContentAreaFilled(false);
//        rdbtnNewRadioButton_1.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton_1);
//        
//        // 3������ �κп� �����ҷ����� �ʿ�
//        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3�� ����");
//        rdbtnNewRadioButton_2.setBounds(57, 407, 166, 41);
//        rdbtnNewRadioButton_2.setFocusPainted(false);
//        rdbtnNewRadioButton_2.setBorderPainted(false);
//        rdbtnNewRadioButton_2.setContentAreaFilled(false);
//        rdbtnNewRadioButton_2.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton_2);
//        
//
//        
//        rdbtnNewRadioButton.setSelected(false);
//        rdbtnNewRadioButton_1.setSelected(false);
//        rdbtnNewRadioButton_2.setSelected(false);
//
//        panel.setLayout(null);
//        panel.setBackground(new Color(255,0,0));
//        panel.setOpaque(false);
//        
//	
//		
//	}	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		   String s = e.getActionCommand();
//           
//           if(s.equals(rdbtnNewRadioButton.getText())){
//               JOptionPane.showMessageDialog(null,"���� ���� : "+rdbtnNewRadioButton.getText());
//           }
//           else if(s.equals(rdbtnNewRadioButton_1.getText())){
//               JOptionPane.showMessageDialog(null,"���� ���� : "+rdbtnNewRadioButton_1.getText());
//           }
//           else if(s.equals(rdbtnNewRadioButton_2.getText())){
//               JOptionPane.showMessageDialog(null,"���� ���� : "+rdbtnNewRadioButton_2.getText());
//           }	

	}

}
