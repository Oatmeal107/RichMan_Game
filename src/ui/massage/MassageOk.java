package ui.massage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextArea;

import ui.JPanelGame;

public class MassageOk extends Massage{
	
	/**
	 * Ϊ��ȥ��̾���Զ����ɵ�
	 */
	private static final long serialVersionUID = 7124891950603975799L;

	//����һ��Ĭ�ϵ��ı���
	private JTextArea textArea = null;
		
	private MassageButton ok;
	
	public MassageOk(String title, String information, JPanelGame panel) {
		// �̳к��Զ����ɵĹ��캯��
		super(title, panel);
		this.titleStr = title;
		
		//����OK��ť
		addButton();
		
		//�����ı���
		addTextArea();
		
		this.textArea.setText(information);
	}
	
	//���Ӱ�ť
	public void addButton() {
		ok = new MassageButton("ok", this, 18*6, 131);
		add(ok);
	}
	
	/**
	 * �����ı���
	 * ��֪����ɶ��
	 */
	public void addTextArea() {
		textArea = new JTextArea();
		textArea.setText("?????");//�ı�������ʾ������,�����ڹ��캯��������
		textArea.setBounds(18,39,230,50);//���λ��
		textArea.setSelectedTextColor(Color.BLUE);//ѡ�в����ı���ɫ
		textArea.setOpaque(false);//Ϊfalseʱ�������͸����
		textArea.setEditable(false);//�����Ƿ�ɱ༭
		textArea.setLineWrap(true);//�Ƿ��Զ�����
		add(textArea);
	}

	public void setInfo(String titleStr) {
		this.textArea.setText(titleStr);
		this.title.setText("<html><font color='white'>"+titleStr+"</font></html>");
	}
	
	@Override
	public void paint(Graphics g) {
		paints(g);
		
		ok.update(g);
		super.paint(g);
	}
	
	public void paints(Graphics g) {
		g.drawImage(bg, 0, 0, bg.getWidth(null), bg.getHeight(null), 0, 0, bg.getWidth(null), bg.getHeight(null), null);	
	}
}
