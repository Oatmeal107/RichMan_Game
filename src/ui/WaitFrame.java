package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import util.FrameUtil;

/**
 * ��ʼѡ��ǰ�ĵȴ�����
 * @author ���������107
 *
 */
public class WaitFrame extends JFrame{

	public WaitFrame() {
		//��������
		this.setTitle("RichMan_Game����by��Java");
		
		//����Ĭ�϶���������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * ���ô��ڴ�С
		 * ��ѡ�˽���һ����
		 */
		this.setSize(380, 370);
		
		//�������û��ı䴰�ڴ�С
		this.setResizable(false);
		
		/**
		 * ����
		 * UTIL���е��Զ����෽��
		 */
		FrameUtil.setFrameCenter(this);
		
		add(new JLabel("�����У����Ժ�...", JLabel.CENTER));
		
		//ʹ֮����
		setVisible(true);
	}
	
	//Ϊ��ȥ��̾���Զ��ӵ�
	private static final long serialVersionUID = 1L;
}
