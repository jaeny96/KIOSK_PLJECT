
package main.pay.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.pay.payment;
import main.pay.component.cash;

public class cashPanel {
	JPanel panel;
	String font;
	String price;
	Color cl;
	int payCash=0;

	public cashPanel() {

	}

	public cashPanel(JPanel panel, String font, String price, Color cl) {
		this.panel = panel;
		this.font = font;
		this.price = price;
		this.cl = cl;
	}
	public void create(Consumer<String> cs) {
		String[] list = { "결제 금액 : ", "투입 금액 : "};
		String[] detail = { price, "0원" };
		ArrayList<JLabel> detailArr = new ArrayList<JLabel>();
		for (int i = 0; i < list.length; i++) {
			cash c = new cash(panel, 30, font);
			c.makeCashTF(list[i], i);
			detailArr.add(c.makeCashD(detail[i], i));
		}

		// cash 패널 button 생성
		String[] btnDetail = { "1000", "5000", "10000", "50000" };
		ArrayList<JButton> btnArr = new ArrayList<JButton>();

		for (int i = 0; i < btnDetail.length; i++) {
			cash c = new cash(panel, 200, font);
			int chkW = i % 2 != 0 ? 1 : 0;
			int chkY = i > 1 ? 1 : 0;
			btnArr.add(c.makeCashB(btnDetail[i], chkW, chkY));
		}

		// cash 패널 button event 생성
		// button style 변경
		for (int i = 0; i < btnArr.size(); i++) {
			String a = btnArr.get(i).getText();
			payment.designBtn(btnArr.get(i), cl);
			btnArr.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					payCash += Integer.parseInt(a);
					detailArr.get(1).setText(payCash + "원");

					if (payCash >= Integer.parseInt(detailArr.get(0).getText().substring(0, price.length() - 1))) {
						cs.accept("cash");
						payment.payCash=payCash;
					}
					
				}
			});
		}
	}
}
