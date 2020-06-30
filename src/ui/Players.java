package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import control.GameRunning;
import model.PlayerModel;

/**
 * ���λ�����ݸ��²�
 * 
 * @author ���������107
 *
 */
public class Players extends Layer{
	
	private GameRunning run = null;
	
	//�������
	private List<PlayerModel> players = null;
	
	//�������췽��
	protected Players(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	protected Players(int x, int y, int w, int h, GameRunning run, List<PlayerModel> players) {
		super(x, y, w, h);
		this.run = run;
		this.players = players;
	}
	
	/**
	 * ��������ڵ�ͼ�е����
	 * �˴��������Ҳ�����ֱ�����
	 */
	public void paint(Graphics g) {
		//ʹ��ѭ��һ��һ������
		for(PlayerModel temp : players) {
			paintPlayer(temp, g);
		}
	}
	
	/**
	 * ���Ƶ�����ҷ���
	 */
	private void paintPlayer(PlayerModel player, Graphics g) {
		//�ж��Ƿ�Ϊ��ǰ���
		boolean show = true;
		
		//����PlayerModel���еķ�������ͼƬ
		Image temp = player.getIMG("mini");
		
		//�����ʱ�ֵ�������ң�ʹ�����ϳ��������ͼƬ(mini_on)
		if(player.equals(this.run.getNowPlayer())) {
			temp = player.getIMG("mini_on");
		}
		else { 
			//�˴����ж��ڶ����ʱ������Ҫ���ģ����ܼ򵥵�getOtherPlayer
			if(this.x == player.getOtherPlayer().getX()
					&& this.y == player.getOtherPlayer().getY()) {
				//�غϲ���ʾ
				show = false;
			}
		}
		if (show) {
			g.drawImage(temp, player.getX()+28, player.getY()+28, player.getX()+60,
					player.getY()+60, 0, 0, 32, 32, null);
		}
	}

	@Override
	public void startPanel() {
		// TODO �Զ����ɵķ������
	}
	
	//ȥ��̾���Զ����ɵ�
	private static final long serialVersionUID = 1L;
}	
