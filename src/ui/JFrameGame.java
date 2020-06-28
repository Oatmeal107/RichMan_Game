package ui;

import javax.swing.JFrame;

import util.FrameUtil;

public class JFrameGame extends JFrame{
	
	/**
	 * ��Ϸ���й����еĽ���
	 * Ĭ����panel(���)
	 */
	private JPanelGame panelGame = null;
	
	public JFrameGame() {
		/**
		 * ��������
		 * ����Ϸ���й����д����ϵ����� 
		 */
		this.setTitle("RichMan_Game����by��Java");
		
		//����Ĭ�ϴ��ڵĹ��ܣ���С����ȫ�����رգ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * ���ô��ڴ�С
		 * �˴�СΪ��Ϸ����ʱ�Ĵ�С,���ݱ�����С������
		 */
		this.setSize(750+200, 650);
		
		//�������û��ı䴰�ڴ�С
		this.setResizable(false);
		
		/**
		 * ����
		 * �Զ����util����FrameUtil��ķ���
		 */
		FrameUtil.setFrameCenter(this);
		
		//����Ĭ��Panel
		this.panelGame = new JPanelGame();
		add(this.panelGame);
		
		/**
		 * ���ñ߿���ʾ
		 * Ϊtrueʱ����ȫ��״̬��û�ж����ı߿��EXIT_ON_CLOSE����
		 */
		this.setUndecorated(false);		
	}
	
	public JPanelGame getPanelGame() {
		return panelGame;
	}
}
