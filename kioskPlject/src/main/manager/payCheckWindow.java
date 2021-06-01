package main.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class payCheckWindow {

	private JFrame frame;
	private JTable table;
	private JScrollPane scroll;
	private JLabel price;
	private String font = "티웨이_항공";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payCheckWindow window = new payCheckWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public payCheckWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//필요한 데이터만 불러옴
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 43, 680, 870);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		payCheck pc = new payCheck();
		String[] colTitle = {"아이디","결제시간","결제금액","결제타입"};
		String[] cols = {"id","paytime","price","payType"};

		int rowSize = pc.data.size();
		String[][] row = new String[rowSize][colTitle.length];

		for (int i = 0; i < colTitle.length; i++) {
			payCheck data = new payCheck(cols[i]);
			for (int k = 0; k < rowSize; k++) {
				System.out.print(data.data.get(k) + " ");
				row[k][i] = data.data.get(k);
				System.out.println();
			}
		}

		DefaultTableModel model = new DefaultTableModel(row, colTitle);

		table = new JTable(model);
		table.setAlignmentX(SwingConstants.CENTER);
		table.setBounds(30, 57, 615, 854);
		table.setFont(new Font(font, Font.PLAIN, 13));
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		table.setLayout(null);
		panel.add(table);

		scroll = new JScrollPane(table);
		scroll.setLocation(0, 10);
		scroll.setSize(680, 789);
		panel.add(scroll);

		price = new JLabel(sum(table,rowSize));
		price.setFont(new Font(font, Font.BOLD, 20));
		price.setBounds(400, 800, 300, 50);
		panel.add(price);

	}

	int total = 0;

	//결제 총금액 
	String sum(JTable t, int max) {
		for (int i = 0; i < max; i++) {
			String tmp = t.getValueAt(i, 2).toString();
			int temp = Integer.parseInt(tmp.substring(0,tmp.length()-3));
			total+=temp;
		}
		String res = "total price : " + format(total) + "원";
		return res;
	}
	String format(int a) {
		DecimalFormat fm = new DecimalFormat("###,###");
		return fm.format(a);
	}
}
