package ui.massage;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.JPanelGame;

/**
 * �����������û��
 * 
 * @author ���������107
 *
 */
public class Massage extends JPanel{
	
	/**
	 * ȥ��̾���Զ����ɵ�
	 */
	private static final long serialVersionUID = -7027645709576295249L;

	/*
	 * ����ͼƬ���󣬸���ʾ�����ϱ���ͼƬ
	 * ImageIcon������Ҫ��ת��ΪImage
	 */
	protected Image bg = new ImageIcon("images/massage/massage.png").getImage();
	
	//ȫ�ֵ�λ�ñ��������ڱ�ʾ����ڴ����ϵ�λ��
	protected Point origin = new Point();
	
	//���Ͻ�x��y���꣬ ����Ⱥ͸߶�
	protected int x, y, w, h;
	
	protected String titleStr = "������";
	
	protected JLabel title = null;  //�����ǩ
	
	//JPanelGameΪui�����Զ���
	protected JPanelGame panel = null;
	
	/**
	 * Massage��Ĺ��캯�� 
	 *
	 * ����һ����Ϣ�Ի���
	 */
	protected Massage(String title, JPanelGame panel) {
		this.titleStr = title;//����Ի������
		
		//��ʼ��λ��
		initBounds();
		
		/**
		 * ʹ�þ��Բ���(null)
		 * ʹ�þ��Բ��ֵĴ���ͨ�����ǹ̶���С��
		 * �����λ�ú���״�����洰��ı�������仯
		 */
		setLayout(null);
		
		//���ӱ���
		addTitle();
		
		//���Ӽ�����
		addListener();
		
		//���ñ���͸��
		setOpaque(false);
		this.panel = panel;
	}
	
	/**
	 * ��ʼ��λ��
	 */
	private void initBounds() {
		this.x = (950-bg.getWidth(null))/2;
		this.y = (650-bg.getHeight(null))/2;
		this.w = bg.getWidth(null);
		this.h = bg.getHeight(null);
		setBounds(x, y, w, h);
	}
	
	/**
	 * ���ӱ���
	 */
	private void addTitle() {
		title = new JLabel("<html><font color = 'white' >"+titleStr+"</font></html>");
		title.setBounds(18, 4, 230, 20);
		add(title);
	}
	
	/**
	 * ������������
	 */
	private void addListener() {
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){ //�������
				origin.x = e.getX();  //��갴��ʱ��ô��ڵ�ǰ��λ��
				origin.y = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { //�϶����
				x += e.getX() - origin.x;
				y += e.getY() - origin.y;
				if(x < 0) {
					x = 0;
				}
				if(x + w > 950) {
					x = 950 - w;
				}
				if(y < 0) {
					y = 0;
				}
				if(y + h > 650) {
					y = 650 - h;
				}
				setBounds(x, y, w, h);
			}
		});
	}
	
	//���ñ���
	public void setTitleStr(String titleStr){
		this.titleStr = titleStr;
		this.title.setText("<html><font color='white' >"+titleStr+"</font></html>");
	}
		
	/**
	 * ����������	
	 * 
	 * JLayeredPaneͬһ���ڵ��������ͨ�������������������ڲ��ڵ�λ��
	 * �ƶ�����������ڲ����ײ�λ��
	 */
	public void moveToBack() {
		//ui�����Զ���JPanelGame��gatLayeredPane()����
		this.panel.getLayeredPane().moveToBack(this);
	}
	
	/**
	 * ����������	
	 * 
	 * ͬ��
	 * �ƶ�����������ڲ�����λ��
	 */
	public void moveToFront() {
		//ui�����Զ���JPanelGame��gatLayeredPane()����
		this.panel.getLayeredPane().moveToFront(this);
	}
	
	/**
	 * ����OK��ť
	 */
	public void ok() {
		System.out.println("ok");  //��������ˣ�����
	}
	
	/**
	 * ����cancel��ť
	 */
	public void cancel() {
		System.out.println("cancel");
	}
}
