package main.pay.event;

import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class windowEvent {
	JFrame f;
	JFrame pf;
	public static Component[] com;
	public windowEvent(JFrame f,JFrame pf) {
		this.f=f;
		this.pf=pf;
	}
	
	public static void setComponent(Component[] c) {
		com=c;
	}
	
	public void event() {
//		System.out.println("c사이즈 "+c.length);
		f.addWindowListener(new WindowListener() {
			@Override
			// 윈도우 처음 생성되었을 때
			public void windowOpened(WindowEvent e) {
			}

			@Override
			// 윈도우 시스템 메뉴의 닫기 시도할 때
			public void windowClosing(WindowEvent e) {
			}

			@Override
			// 윈도우가 닫힐 때
			// 결제 창이 닫히면 main 패널에 있는 자식 component 활성화
			public void windowClosed(WindowEvent e) {
				System.out.println("꺼졌다");
				System.out.println(pf.getBounds());
				pf.dispose();
//				pf.setVisible(false);
				System.out.println("꺼졋당 ");
			}

			@Override
			// 윈도우가 최소화 되었을 때
			public void windowIconified(WindowEvent e) {
			}

			@Override
			// 윈도우가 최소화에서 최대화 되었을 때
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			// 윈도우가 활성화 되었을 때
			public void windowActivated(WindowEvent e) {
			}

			@Override
			// 윈도우가 비활성화 되었을 때
			public void windowDeactivated(WindowEvent e) {
			}
		});
	}
}