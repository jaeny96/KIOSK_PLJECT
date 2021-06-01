package Login;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Rbtn_timeChk extends JButton{
	
	ImageIcon icon;
	public Rbtn_timeChk() { super(); decorate();} 
	public Rbtn_timeChk(String text) { super(text);decorate();} 
	public Rbtn_timeChk(Action action) { super(action); decorate();} 
	public Rbtn_timeChk(Icon icon) { super(icon); decorate();} 
	public Rbtn_timeChk(String text, Icon icon) { super(text, icon); decorate();}

	public void decorate() {
	setBorderPainted(true);  //버튼 테두리 설정
	//버튼 영역 배경 표시 설정
	setOpaque(true);} // 투명하게 
	@Override
	public void paintComponent(Graphics g) {
		
		Color c = new Color(255,255,255,50); // 배경색 결정
		Color o = new Color(247,99,12); //글자색 결정
		icon = new ImageIcon("./image/seatTime.png");
		
		g.drawImage(icon.getImage(),0,0,null);
		int width = getWidth(); 
		int height = getHeight(); 
		int x = getX();
		int y = getY();
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
//		if (getModel().isArmed()) { graphics.setColor(getBackground().darker()); } 
		if(getModel().isRollover()) {graphics.setColor(c.darker());}
//		else if (getModel().isRollover()) { graphics.setColor(getBackground().brighter()); } 
		else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
//		else { graphics.setColor(getBackground()); } graphics.fillRoundRect(0, 0, width, height, 10, 10); 
		else { graphics.setColor(c); } 
		graphics.fillRoundRect(0 , 0, width, height, 20, 20);
		FontMetrics fontMetrics = graphics.getFontMetrics(); 
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		int textX = (width - stringBounds.width) / 2; 
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		graphics.setColor(getForeground());
		graphics.setFont(getFont()); graphics.drawString(getText(), textX, textY); 
		graphics.dispose();
		setOpaque(false);
		
		super.paintComponent(g);

	}
	
}
	