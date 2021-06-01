package main.pay;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JCheckBox;

import Login.MainF;
import main.pay.done;
import main.pay.component.fighting;
import main.pay.component.nextBtn;
import main.pay.component.product;
import main.pay.component.showDetail;
import main.pay.data.modiData;
import main.pay.data.reservData;
import main.pay.data.storeData;
import main.pay.event.windowEvent;
import main.pay.panel.cashPanel;
import main.pay.panel.detailPanel;
import reservation.resrvationMain;
//import seatingTable.Main_swing;
import seatingTable.Main;

import java.awt.SystemColor;

public class payment {
	private JFrame frame;

	private JPanel containerPanel;
	private JPanel select;
	private JPanel content;
	private JPanel detailPanel;
	private JPanel cOc;
	private JPanel cash;

	private JButton category;
	private JButton firstNext;
	private JButton secondNext;
	private JButton backBtn;

	// 결제 창의 첫번째 창
	private static Component[] FirstC;
	// 결제 창의 두번째 창
	private static Component[] SecondC;
	// 결제 창의 세번째 창
	private static Component[] ThirdC;
	// font 지정
	private String font = "티웨이_항공";
	// seatButton에서 좌석번호 가져옴
	private String seatN = "1";
	private static JFrame prevF;
	private String menuType = "";

	// reserv에서 가져온 데이터
	private String reservStart = "";
	private JPanel show;

	Color background = new Color(255, 255, 255);
	Color btnC = new Color(206, 237, 222);
	Color btnC2 = new Color(245, 242, 205);

	public payment() {
		initialize();
	}

	public payment(String num, JFrame prevF, String type) {
		this.seatN = num;
		this.prevF = prevF;
		this.menuType = type;
		initialize();
	}

	public payment(String num, JFrame prevF, String type, String prod, String price, String start, JPanel show) {
		this.seatN = num;
//		this.prevF = Main.getFrame();
		this.prevF = prevF;
		this.menuType = type;
		reservStart = start;
		setProduct(prod);
		setPrice(price);
		this.show = show;
//		this.reservPanel = reservPanel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame bounds 설정
		int pointX = prevF.getX() + 10;
		int pointY = prevF.getY() + 340;
		int width = prevF.getWidth() - 20;
		int height = prevF.getHeight() - 680;

		setFrame(new JFrame());
		getFrame().setBounds(pointX, pointY, width, height);
		getFrame().setTitle("결제");
		getFrame().setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		// frame내 내용들을 모두 감싸는 container Panel 생성
		containerPanel = new JPanel();
		containerPanel.setBounds(0, 0, 684, 361);
		frame.getContentPane().add(containerPanel);
		containerPanel.setLayout(null);

		// 바로사용버튼을 이용해 좌석 패널로 전환 후 결제 창 열렸을때
		if (menuType.equals("seat")) {
			// 좌석 선택 시 처음으로 보이는 select panel 생성
			select = new JPanel();
			select.setBackground(background);
			select.setBounds(0, 0, 684, 361);
			containerPanel.add(select);
			select.setLayout(null);

			// select panel 제목 생성
			product tp = new product(select);
			tp.createTitle("Select Product");

			// 결제 팝업의 exit 버튼 누를 시 결제 팝업창만 종료됨
			getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			// 첫번째 nextBtn 구현
			// 상품 선택 후 다음 패널로 전환하는 next 버튼 생성
			// 상품 선택해야 nextBtn 활성화하는 기능 적용
			nextBtn n = new nextBtn(containerPanel, select, btnC, font);
			firstNext = n.createNext();
			firstNext.setEnabled(false);

			// next 버튼 클릭 시 select 패널 제거 후 detailPanel 생성
			firstNext.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					containerPanel.removeAll();
					detailPanel(seatN);
					containerPanel.repaint();
					SecondC = containerPanel.getComponents();
				}
			});

			content = new JPanel();
			content.setBounds(25, 90, 633, 195);
			content.setBackground(background);
			select.add(content);

			createCategory("시간권", 0);
			createCategory("기간권", 1);

			FirstC = containerPanel.getComponents();
		} else { // 예약하기를 통해 결제창이 열렸을 때
			detailPanel(seatN);
			SecondC = containerPanel.getComponents();
		}

		// windowEvent 설정
//		windowEvent we = new windowEvent(getFrame());
//		we.event();
	}

	public static void designBtn(JButton btn, Color c) {
		btn.setBackground(c);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
	}

	public void chkComponent(Component[] cc) {
		for (int i = 0; i < cc.length; i++) {
			System.out.println(cc[i]);
		}
		System.out.println();
		System.out.println();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setType(Type.UTILITY);
	}

	// 선택된 상품 내용
	String product = "";

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	// 선택된 상품의 가격 내용
	String price = "";

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	// createProduct() 함수에서 생성한 checkBox 배열
	ArrayList<JCheckBox> chkArr = new ArrayList<JCheckBox>();

	// 시간_기간 상품 카테고리 생성
	void createCategory(String str, int i) {
		category = new JButton(str);
		category.setBounds(25 + (i * 95), 65, 90, 30);
		category.setFont(new Font(font, Font.PLAIN, 15));
		designBtn(category, background);
		select.add(category);
		category.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				content.removeAll();
				chkArr.removeAll(chkArr);
				// 시간_기간 상품에 대한 내용 생성
				if (str.contains("시간")) {
					createProduct("timePro");
				} else {
					createProduct("termPro");
				}
				content.repaint();
			}
		});
	}

	// 시간_기간 상품 패널에 값 넣기
	void createProduct(String tableName) {
		product a = new product(tableName);
		int length = a.getNameArr().size();
		product ctnt = new product(content, font, tableName);
		for (int i = 0; i < length; i++) {
			ctnt.createName(i);
			ctnt.createPrice(i);
			chkArr.add(ctnt.chkBox(i));
			chkEvent(chkArr.get(i), ctnt.getNameArr().get(i), ctnt.getPriceArr().get(i));
		}
	}

	// checkBox 이벤트
	// 체크박스가 선택되어 있으면 nextBtn 활성화, 아니면 nextBtn 비활성화
	// 체크박스가 선택되어 있으면 선택된 체크박스 이외 비활성화, 아니면 모두 활성화
	public void chkEvent(JCheckBox chk, String name, String price) {
		chk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chk.isSelected()) {
					setProduct(name);
					setPrice(price);
					firstNext.setEnabled(true);
					chkDisabled(chkArr);
				} else {
					firstNext.setEnabled(false);
					chkEnabled(chkArr);
				}
			}
		});
	}

	// 체크된 체크박스 이외 체크박스 비활성화하는 함수
	public void chkDisabled(ArrayList<JCheckBox> cb) {
		for (int i = 0; i < cb.size(); i++) {
			if (cb.get(i).isSelected()) {
				for (int j = 0; j < cb.size(); j++) {
					if (i != j) {
						cb.get(j).setEnabled(false);
					}
				}
			}
		}
	}

	// 모든 체크박스 활성화하는 함수
	public void chkEnabled(ArrayList<JCheckBox> cb) {
		for (int i = 0; i < cb.size(); i++) {
			cb.get(i).setEnabled(true);
		}
	}

	// 선택한 상품에 대한 상세내용 다시 확인하는 detailPanel에 값 넣기
	// 좌석 정보, 상품 이름, 시작시간~끝시간, 가격
	public void detailPanel(String seat) {
		detailPanel = new JPanel();
		detailPanel.setBounds(0, 0, 700, 400);
		detailPanel.setBackground(background);
		containerPanel.add(detailPanel);
		detailPanel.setLayout(null);

		detailPanel dp = new detailPanel(containerPanel, detailPanel, font);
		dp.makeTitle();
		if (menuType.equals("seat")) {
			dp.makeComponent(seat, getProduct(), getPrice());
			createBack(FirstC, detailPanel);
		} else {
			modiData md = new modiData();
			dp.makeComponent(seat, getProduct(), reservStart, md.end(reservStart, getProduct()), getPrice());
		}

		// 두번째 next 버튼 구현
		nextBtn n = new nextBtn(containerPanel, detailPanel, btnC, font);
		secondNext = n.createNext();
		secondNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				containerPanel.removeAll();
				cashOrCard();
				containerPanel.repaint();
				ThirdC = containerPanel.getComponents();
			}
		});
	}

	// 뒤로가기 기본 정보 구현
	public JButton createBack(Component[] target, JPanel panel) {
		backBtn = new JButton("◀");
		backBtn.setFont(new Font(font, Font.PLAIN, 20));
		backBtn.setBounds(400, 295, 100, 45);
		designBtn(backBtn, btnC);
		panel.add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backEvent(target);
			}
		});
		return backBtn;
	}

	// backBtn event 구현
	public void backEvent(Component[] target) {
		containerPanel.removeAll();
		for (int i = 0; i < target.length; i++) {
			containerPanel.add(target[i]);
		}
		payCash = 0;
		containerPanel.repaint();
	}

	// 현금으로 결제할건지 카드로 결제할건지 선택하는 패널 생성
	public void cashOrCard() {
		cOc = new JPanel();
		cOc.setBounds(0, 0, 700, 400);
		cOc.setBackground(background);
		containerPanel.add(cOc);
		cOc.setLayout(null);

		JButton cashBtn = new JButton("Pay with cash");
		cashBtn.setBounds(65, 110, 221, 96);
		cashBtn.setFont(new Font(font, Font.PLAIN, 18));
		designBtn(cashBtn, btnC2);

		// 현금 결제 패널로 전환
		cashBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				containerPanel.removeAll();
				makeCashPanel();
				JButton thirdBack = new JButton("");
				thirdBack = createBack(ThirdC, cash);
				thirdBack.setLocation(500, 10);
				containerPanel.repaint();
			}
		});
		cOc.add(cashBtn);

		makeCardBtn(cOc);
		JButton secondBack = new JButton("");
		secondBack = createBack(SecondC, cOc);
		secondBack.setLocation(500, 295);
	}

	// cash 클래스 이용하여 cash panel 생성
	public static int payCash = 0;

	public void makeCashPanel() {
		cash = new JPanel();
		cash.setBounds(0, 0, 700, 400);
		cash.setBackground(background);
		containerPanel.add(cash);
		cash.setLayout(null);

		// cash 패널 list와 detail 생성
		cashPanel cp = new cashPanel(cash, font, getPrice(), btnC2);
		cp.create(fakeFrame);
		System.out.println("pay!!!" + payCash);
	}

	// cardBtn 생성
	public void makeCardBtn(JPanel panel) {
		JButton cardBtn = new JButton("Pay by card");
		cardBtn.setBounds(370, 110, 221, 96);
		cardBtn.setFont(new Font(font, Font.PLAIN, 18));
		designBtn(cardBtn, btnC2);

		// cardBtn 클릭 시 실제 결제되는 것 처럼 done 팝업창 호출
		// 3초 후 done팝업창과 payment 팝업 창 종료 후
		// main panel에 결제가 완료되었습니다. 감사합니다. + 응원문구 출력 패널 생성
		cardBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				fakeFrame("card");
				fakeFrame.accept("card");
			}
		});
		panel.add(cardBtn);
	}

	Consumer<String> fakeFrame = type -> {
		int mustCash = Integer.parseInt(getPrice().substring(0, getPrice().length() - 1));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					done d = new done(mustCash, payCash);
					d.getFrame().setVisible(true);
					doneTimerEvent(3000, d, type);
					payCash = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};

	// 결제 완료 시 timerEvent 함수 구현
	public void doneTimerEvent(int time, done d, String type) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				doneEvent(d, type);
			}
		};
		timer.schedule(task, time);
	}

	// 결제 완료 시 event
	public void doneEvent(done d, String type) {
		d.getFrame().dispose();
//		System.out.println("frame 1 " + d.getFrame().isDisplayable());
		getFrame().dispose();
		prevF.dispose();
		resrvationMain.getFrame().dispose();
		MainF.getFrame().dispose();
//		System.out.println("frame 2" + getFrame().isDisplayable());
//		System.out.println("frame 3" + prevF.isDisplayable());
//		System.out.println("frame 4" + resrvationMain.frame.isDisplayable());
//		System.out.println("frame 5" + MainF.getFrame().isDisplayable());

		// 응원문구 패널 생성
		reMain();
		modiData md = new modiData();
		String stSeat = seatN;
		String payTime = md.start();
		String stStart = menuType.equals("seat") ? md.start() : reservStart;
		String stEnd = md.end(stStart, getProduct());
		String stPro = md.modiPro(getProduct());
		String stPri = md.modiPri(getPrice());

		storeData sData = new storeData(MainF.user, stSeat, payTime, stStart, stEnd, stPro, stPri, type, menuType);
		sData.store();
	}

	public void reMain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainF window = new MainF();
					window.getFrame().setVisible(true);
					for (int i = 0; i < window.getShowUp().getComponentCount(); i++) {
						window.getShowUp().getComponent(i).setVisible(false);
					}
					fightingPan(window.getShowUp());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fightingPan(JPanel panel) {
		// Main 페이지 내 패널에 감사합니다 + 응원문구 라벨 부착
		JLabel donePhrase = new JLabel("");
		JLabel fightPhrase = new JLabel("");

		fighting ft = new fighting(panel, donePhrase, fightPhrase, font);
		ft.createDone("감사합니다.");
		ft.createFight();
		Component[] mainC = panel.getComponents();

		// 5초 후 메인 패널로 전환
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// 첫 화면인 JButton만 setVisible true로 변경
				for (int i = 0; i < mainC.length; i++) {
					if (mainC[i].toString().contains("JButton")) {
						mainC[i].setVisible(true);
					}
					// JLabel만 제거
					else if (mainC[i].toString().contains("JLabel")) {
						panel.remove(mainC[i]);
						panel.repaint();
					}
				}
			}
		};
		timer.schedule(task, 5000);
	}
}
