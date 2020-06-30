package main;

import javax.swing.UIManager;

import ui.JFrameGame;
import ui.WaitFrame;
import ui.config.FrameConfig;

public class Main {
	// ���������ʾ������ʽ�������ڴ���ʹ��֮ǰ��������
	static {//ȷ���Ƚ���Look&Feel����
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e1) {}//�����쳣
	}

	public static void main(String[] args) {
		// ����ui���ڻ�ӭ���洴��������ʼ��ӭ����
		WaitFrame wFrame = new WaitFrame();
		// ����ui�����������࣬������Ϸ������
		JFrameGame frame = new JFrameGame();
		// ʵ����������Ϸ���ô���
		new FrameConfig(wFrame,frame);
	}
}
