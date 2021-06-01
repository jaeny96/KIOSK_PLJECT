package main.pay;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class done {
	private JFrame frame;
	private int payCash;
	private int mustCash;
	private String font = "티웨이_항공";
	
	public done() {
		initialize();
	}

	public done(int mustCash,int payCash) {
		this.mustCash=mustCash;
		this.payCash=payCash;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		System.out.println("p "+payCash);
//		System.out.println("m "+mustCash);
		
		if(payCash!=0 && mustCash!=payCash) {
			JLabel payPhrase = new JLabel("거스름돈 : "+ (payCash-mustCash)+"원 입니다.");
			payPhrase.setBounds(50, 88, 370, 72);
			payPhrase.setFont(new Font(font, Font.PLAIN, 25));
			frame.getContentPane().add(payPhrase);			
		}else{
			JLabel payPhrase = new JLabel("결제 중 입니다.");
			payPhrase.setBounds(50, 88, 370, 72);
			payPhrase.setFont(new Font(font, Font.PLAIN, 25));
			frame.getContentPane().add(payPhrase);	
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
