package main.pay.panel;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.pay.component.showDetail;
import main.pay.data.modiData;

public class detailPanel {
	JPanel container;
	JPanel panel;
	String font = "";

	public detailPanel() {
	}

	public detailPanel(JPanel container, JPanel panel, String font) {
		this.container = container;
		this.panel = panel;
		this.font = font;
	}

	public void makeTitle() {
		showDetail sd = new showDetail(panel, 0, font);
		sd.createTitle("Confirm Product");
	}

	public void makeComponent(String seat, String product, String price) {
		modiData md = new modiData();

		String[] listArr = { "Seat Info : ", "product Info : ", "usage time : ", "price Info : " };
		String[] detailArr = { seat + "번", product, md.start() + "-" + md.end(md.start(),product), price };

		for (int i = 0; i < listArr.length; i++) {
			showDetail showPanel = new showDetail(panel, 90, font);
			showPanel.createList(listArr[i], i);
			if (i != 2) {
				showPanel.createDetail(detailArr[i], i);
			} else {
				showPanel.createDetail2(detailArr[i], i);
			}
		}
	}

	public void makeComponent(String seat, String product, String start,String end, String price) {
		modiData md = new modiData();

		String[] listArr = { "Seat Info : ", "product Info : ", "usage time : ", "price Info : " };
		String[] detailArr = { seat + "번", product, start+"-"+end, price };

		for (int i = 0; i < listArr.length; i++) {
			showDetail showPanel = new showDetail(panel, 90, font);
			showPanel.createList(listArr[i], i);
			if (i != 2) {
				showPanel.createDetail(detailArr[i], i);
			} else {
				showPanel.createDetail2(detailArr[i], i);
			}
		}
	}

}
