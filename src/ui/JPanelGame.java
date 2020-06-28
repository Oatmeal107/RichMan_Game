package ui;

import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class JPanelGame extends JPanel{
	
	private JFrameGame gameFrame = null;
	
	/**
	 * JLayeredPane���㼶���
	 * Ϊ������������ȣ������������Ҫʱ�໥�ص�
	 * �������������ʱ��Ҫָ��������ڵĲ㣬�Լ�������ڸò��ڵ�λ��
	 */
	private JLayeredPane layeredPane;
	
	private List<Layer> lays = null;
	private Background backgroundUI = null;
	private Lands landsUI = null;
	private Buildings buildingsUI = null;
	private Players playersUI = null;
	private TextTip textTip = null;
	private PlayersPanel layerPlayersPanel = null;
	private Dice dice = null;
	private Event event = null;
	private Shop shop = null;
	private Running running = null;
	
	
	
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}
	
	//ȥ��̾���Զ��ӵ�
	private static final long serialVersionUID = 1L;
}
