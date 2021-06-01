package reservation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class selectDate extends JPanel implements ActionListener{
	
	JComboBox<Integer> yearBox = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
    JComboBox<Integer> monthBox = new JComboBox<Integer>();
    JComboBox<Integer> dayBox = new JComboBox<Integer>();
    JComboBox<Integer> timelist = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> timeModel = new DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24});

    
    Calendar now;
    
    int year, month, date;
    private String font = "티웨이_항공";
    
    public selectDate(JPanel panel) {
    	
    	
    	now = Calendar.getInstance();	//���� ��¥

    	year = now.get(Calendar.YEAR);

    	month = now.get(Calendar.MONTH)+1;

    	date = now.get(Calendar.DATE);
    	
    	JLabel yearT = new JLabel("년");
    	yearT.setBounds(148, 10, 24, 25);
    	JLabel monthT = new JLabel("월");
    	monthT.setBounds(243, 10, 24, 25);
    	JLabel dayT = new JLabel("일");
    	dayT.setBounds(339, 9, 24, 27);
    	JLabel timeT = new JLabel("시");
    	timeT.setBounds(440,10,24,27);
    	
    	yearT.setFont(new Font("티웨이_항공", Font.BOLD, 25));
    	monthT.setFont(new Font("티웨이_항공", Font.BOLD, 25));
    	dayT.setFont(new Font("티웨이_항공", Font.BOLD, 25));
    	timeT.setFont(new Font("티웨이_항공", Font.BOLD, 25));

//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        getContentPane().setLayout(new FlowLayout());
        yearBox = new JComboBox<>();
        yearBox.setFont(new Font("티웨이_항공", Font.BOLD, 20));
        yearBox.setBounds(58, 12, 84, 23);
        for(int i=year-100; i<=year+50; i++){

    		yearModel.addElement(i);

    	}
//        for (int i = 1940; i <= LocalDateTime.now().getYear(); i++) {
//            yearBox.addItem(i);
//        }
        yearBox.setModel(yearModel);
        yearBox.addActionListener(this);
        monthBox = new JComboBox<>();
        monthBox.setFont(new Font("티웨이_항공", Font.BOLD, 20));
        monthBox.setBounds(184, 12, 53, 23);
        for (int i = 1; i <= 12; i++) {
            monthBox.addItem(i);
        }
        monthBox.addActionListener(this);
        dayBox = new JComboBox<>();
        dayBox.setFont(new Font("티웨이_항공", Font.BOLD, 20));
        dayBox.setBounds(279,12,53,23);
        
        timelist = new JComboBox();
        timelist.setModel(timeModel);
//        timelist.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5","6","7","8","9","10","11","12"
//        		,"13", "14", "15", "16","17","18","19","20","21","22","23","24",}));
        timelist.setFont(new Font("티웨이_항공", Font.BOLD, 20));
        timelist.setBounds(364, 12, 53, 23);
        
        
        add(yearBox);
        add(yearT);
        
        add(monthBox);
        add(monthT);
       
        add(dayBox);
        add(dayT);
        
        add(timelist);
        add(timeT);
        
        //Start with current year selected
        yearBox.setSelectedItem(year);
        
        monthBox.setSelectedItem(month);
        
        dayBox.setSelectedItem(date);
        setSize(400, 400);
//        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int year = (int) yearBox.getSelectedItem();
        int month = (int) monthBox.getSelectedItem();
        int daysInThisMonth = LocalDate.of(year, month, 1).lengthOfMonth();
        int previousSelection = dayBox.getSelectedItem() != null ? (int) dayBox.getSelectedItem() : 1;
        dayBox.removeAllItems();
        for (int i = 1; i <= daysInThisMonth; i++) {
            dayBox.addItem(i);
        }
        if (previousSelection >= dayBox.getItemCount())
            //select last index of month
            dayBox.setSelectedIndex(dayBox.getItemCount() - 1);
        else
            dayBox.setSelectedItem(previousSelection);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 SwingUtilities.invokeLater(() -> new selectDate().setVisible(true));
	}


}
