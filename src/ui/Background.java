package ui;

import java.awt.Graphics;
import java.awt.Image;

import model.BackgroundModel;

/**
 * �������²�
 * 
 * @author ���������107
 *
 */
public class Background extends Layer{
	
	/**
	 * ����ͼƬ
	 */
	private Image bg = null;
	
	/**
	 * ����ģ��
	 * BackgroundModel�Զ�����λ��model����
	 */
	private BackgroundModel background = null;
	
	//ΪʲôJPaneGame�лṹ��Background��BackGround�������ȹ���JPaneGame��
	private JPanelGame panel;
	
	protected Background(int x, int y, int w, int h, BackgroundModel background, JPanelGame panel) {
		super(x, y, w, h);
		
		this.background = background;
		this.panel = panel;
	}
	
	//���Ʊ���
	public void paint(Graphics g) {
		this.paintBg(g);
	}
	
	/**
	 * �������Ʒ���
	 */
	public void paintBg(Graphics g) {
		g.drawImage(this.bg, 0, 0, this.bg.getWidth(null),
				this.bg.getHeight(null), 0, 0, this.bg.getWidth(null),
			    this.bg.getHeight(null), null);
	}

	@Override
	public void startPanel() {
		//�Զ����ɵı���ʵ�ֵķ���
		//getBg��model��BackgroundModel��ķ���
		this.bg = background.getBg();
	}
	
	/**
	 * ����������
	 * 
	 * JLayeredPaneͬһ���ڵ��������ͨ�������������������ڲ��ڵ�λ��
	 * �ƶ�����������ڲ����ײ�λ��
	 */
	public void moveToBack() {
		this.panel.getLayeredPane().moveToBack(this);
	}
	
	/**
	 * ����������
	 * 
	 * ͬ��
	 * �ƶ�����������ڲ�����λ��
	 */
	public void moveToFront() {
		this.panel.getLayeredPane().moveToFront(this);
	}
	
	// Ϊ��ȥ��̾���Զ���ӵ�
	private static final long serialVersionUID = 1L;
}
