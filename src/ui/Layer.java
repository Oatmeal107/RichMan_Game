package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ���Ʋ��� �� ����ˢ���࣬���ء����ݡ����ˢ���࣬��Ϣ��ʾ��  �ĳ�����
 * 
 * �̳�Panel������
 * 
 * @author ���������107
 */

public abstract class Layer extends JPanel{

	/**
	 * �������Ͻ�x����
	 */
	protected int x;
	
	/**
	 * �������Ͻ�y����
	 */
	protected int y;
	
	/**
	 * ���ڿ��
	 */
	protected int width;
	
	/**
	 * ���ڸ߶�
	 */
	protected int height;
	
	protected static final int PADDING = 5;  //������
	protected static final int SIZE = 2;//���Ƽ��ģ�
	protected static Image WINDOW_IMG = new ImageIcon("images/window/window.png").getImage();
	protected static int WINDOW_W = WINDOW_IMG.getWidth(null);
	protected static int WINDOW_H = WINDOW_IMG.getHeight(null);
	
	/**
	 * Layer�๹�캯�� ����x��y����ʹ��ڿ�ȳ���
	 * @param x ���Ͻ�x����
	 * @param y	���Ͻ�y���� 
	 * @param width ���ڿ��
	 * @param height ���ڳ���
	 */
	protected Layer(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//��ȡ���Ͻ�x����
	public int getX() {
		return x;
	}
	
	//��ȡ���Ͻ�y����
	public int getY() {
		return y;
	}
	
	//��ȡ���ڿ��
	public int getW() {
		return width;
	}
	
	//��ȡ���ڸ߶�
	public int getH() {
		return height;
	}
	
	/**
	 * �߿����
	 * drawImage:
	 * IMG - Ҫ���Ƶ�ָ��ͼ����� IMG Ϊ null����˷�����ִ���κβ�����
	 * dx1 - Ŀ����ε�һ���ǵ� x ���ꡣ
	 * dy1 - Ŀ����ε�һ���ǵ� y ���ꡣ
	 * dx2 - Ŀ����εڶ����ǵ� x ���ꡣ
	 * dy2 - Ŀ����εڶ����ǵ� y ���ꡣ
	 * sx1 - Դ���ε�һ���ǵ� x ���ꡣ
	 * sy1 - Դ���ε�һ���ǵ� y ���ꡣ
	 * sx2 - Դ���εڶ����ǵ� x ���ꡣ
	 * sy2 - Դ���εڶ����ǵ� y ���ꡣ
	 * observer - �����Ų�ת���˸���ͼ��ʱҪ֪ͨ�Ķ���
	 * ���أ�
	 * ���ͼ���������ڸı䣬�򷵻� false�����򷵻� true��
	 */
	public void createWindow(Graphics g) {
		g.drawImage(WINDOW_IMG, 0, 0, 0 + SIZE, 0 + SIZE,
				0, 0, SIZE, SIZE, null);//���Ϲ̶�
		
		g.drawImage(WINDOW_IMG, 0 + SIZE, 0, 0 + width - SIZE, 0 + SIZE,
				SIZE, 0, WINDOW_W - SIZE, SIZE, null);//�м�
		
		g.drawImage(WINDOW_IMG, 0 + width - SIZE, 0, 0 + width, 0 + SIZE,
				WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);// ���Ϲ̶�
		
		g.drawImage(WINDOW_IMG, 0, 0+SIZE, 0+SIZE, 0+height-SIZE,
				0, SIZE, SIZE, WINDOW_H-SIZE, null);// ����
		
		g.drawImage(WINDOW_IMG, 0+SIZE, 0+SIZE, 0+width-SIZE, 0+height-SIZE,
				SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);// ����
		
		g.drawImage(WINDOW_IMG, 0+width-SIZE, 0+SIZE, 0+width, 0+height-SIZE,
				WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);// ����
		
		g.drawImage(WINDOW_IMG, 0, 0+height-SIZE, 0+SIZE, 0+height,
				0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);// ����
		
		g.drawImage(WINDOW_IMG, 0+SIZE, 0+height-SIZE, 0+width-SIZE, 0+height,
				SIZE, 50-SIZE, WINDOW_W-SIZE, WINDOW_H, null);// ����
		
		g.drawImage(WINDOW_IMG, 0+width-SIZE, 0+height-SIZE, 0+width, 0+height,
				WINDOW_W - SIZE, WINDOW_H - SIZE, WINDOW_W, WINDOW_H, null);// ����
	}
	
	/**
	 * ����ĳ��󷽷�
	 * ����ͼƬ
	 */
	abstract public void paint(Graphics g);
	
	/**
	 * ��ʼ��Ϸpanel����
	 */
	abstract public void stratPanel();
	
	//Ϊ��ȥ��̾���Զ��ӵ�
	private static final long serialVersionUID = 1L;
}
