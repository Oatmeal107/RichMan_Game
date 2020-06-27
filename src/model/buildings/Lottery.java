
package Model.buildings;

import Model.PlayerModel;
import Model.TextTipModel;
import context.GameState;
import control.Control;

/**
 * 
 * ��͸
 * ��ɫ��������ʱ�����Խ�����ע��Ϸ��������Ӯ����.
 * 
 * 
 * 
 * @author MOVELIGHTS
 * 
 */
public class Lottery extends Building {

	private PlayerModel player;
	
	public Lottery(int posX, int posY) {
		super(posX, posY);
		this.name = "��͸";
	}
	
	@Override
	public int getEvent() {
		return GameState.LOTTERY_EVENT;
	}
}
