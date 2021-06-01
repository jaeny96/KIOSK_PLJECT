package reservation;

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

public class Rbtn_back extends JButton{
	
	ImageIcon icon;
	public Rbtn_back() { super(); decorate();} 
	public Rbtn_back(String text) { super(text);decorate();} 
	public Rbtn_back(Action action) { super(action); decorate();} 
	public Rbtn_back(Icon icon) { super(icon); decorate();} 
	public Rbtn_back(String text, Icon icon) { super(text, icon); decorate();}

	public void decorate() {
	setBorderPainted(true);  //��ư �׵θ� ����
	//��ư ���� ���� ǥ�� ����
	setOpaque(true);} // �����ϰ� 
	@Override
	public void paintComponent(Graphics g) {
		
		Color c = new Color(255,255,255,50); // ������ ����
		Color o = new Color(247,99,12); //���ڻ� ����
		icon = new ImageIcon("./src/image/back_btn.png");
		
		g.drawImage(icon.getImage(),0,0,null);
		int width = getWidth(); 
		int height = getHeight(); 
		
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
	