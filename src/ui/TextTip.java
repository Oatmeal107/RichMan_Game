package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import model.TextTipModel;

/**
 * ��Ϣ��ʾ��
 * �ɹ������ݡ���ĳ���޷��ж�����õ�����ʾ�򣬶��ݳ���һ��ʱ��
 * 
 * @author ���������1007
 * 
 */
public class TextTip extends Layer{

	//��ʾ��ģ��
	private TextTipModel textTip = null;
	
	//������ʾ��ͼƬ
	private Image bg = new ImageIcon("image/window/tip_01.png").getImage();
	
	/**
	 * Point:����
	 * ��Ա������:x,y
	 */
	private Point pointWindow = null;
	
	protected TextTip(int x, int y, int w, int h, TextTipModel textTip) {
		super(x, y, w, h);
		
		//����ȷ��λ�õ�
		this.pointWindow = new Point((x + w) /2, (y + h) / 2);
		this.textTip = textTip;
	}

	@Override
	public void paint(Graphics g) {
		//������Ϣ���
		paintTextTip(g, this);
		
	}
	
	/**
	 * ������Ϣ���
	 */
	private void paintTextTip(Graphics g, TextTip textTip2) {
		/**
		 * �����õ���tickֵ������model��Tick����
		 */
		if(textTip.getStartTick() < textTip.getNowTick()
			&& textTip.getNextTick() >= textTip.getNowTick()) {
			
			//���ݵ�ǰ��ɫ����λ�������崰��λ��
			this.pointWindow.x = textTip.getPlayer().getX() + 45;
			this.pointWindow.y = textTip.getPlayer().getY() + 10;
			
			g.drawImage(bg, pointWindow.x, pointWindow.y, pointWindow.x + bg.getWidth(null),
					pointWindow.y + bg.getHeight(null), 0, 0, bg.getWidth(null),
					bg.getHeight(null), null);
			
			//�������֣�ʵ��������
			drawString(g);
		}
	}
	
	/**
	 * �������ַ���
	 */
	private void drawString(Graphics g) {
		String str = this.textTip.getTipString();
		int maxSize = 13; //��ͼƬ��ÿ���������13���ַ�
		int posY = 32;
		int front = 0;
		int rear = maxSize;
		while (front < str.length() -1) {
			if(rear >= str.length()) {
				rear = str.length() -1;
			}
			char[] temp = new char[maxSize];
			
			/** 
			 * getChars() �������ַ����ַ������Ƶ�Ŀ���ַ����顣
			 * getChars(int srcBegin, int srcEnd, char[] dst,  int dstBegin)
			 * srcBegin ���� �ַ�����Ҫ���Ƶĵ�һ���ַ���������
			 * srcEnd ���� �ַ�����Ҫ���Ƶ����һ���ַ�֮���������
			 * dst ���� Ŀ�����顣
			 * dstBegin ���� Ŀ�������е���ʼƫ������
			 */
			str.getChars(front, rear, temp, 0);//����Ҫ������ַ�
			//char[] ת����String
			String s = new String(temp);
			g.drawString(s, pointWindow.x + 20, pointWindow.y + posY);
			front = rear;
			rear += maxSize;
			posY += 20;//����ÿ������ļ��
		}
	}

	@Override
	public void stratPanel() {
		// TODO �Զ����ɵķ������
	}
	
	//ȥ��̾���Զ���ӵ�
	private static final long serialVersionUID = 1L;
}
	

