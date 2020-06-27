package Model.cards;


import javax.swing.JOptionPane;

import context.GameState;

import Model.PlayerModel;

/**
 * 
 * 
 * ͣ����,ʹ�Է���Ŀ��ԭ��ͣ��һ�غϡ�
 * 
 * 
 * 
 * 
 *
 */
public class StopCard extends Card{

	public StopCard(PlayerModel owner) {
		super(owner);
		this.name = "StopCard";
		this.cName ="ͣ����";
		this.price = 50;
	}

	@Override
	public int useCard() {
		return GameState.CARD_STOP;
	}
	/**
	 * 
	 *  ��Ƭ����Ч��
	 * 
	 */
	@Override
	public int cardBuff(){
		return GameState.CARD_BUFF_STOP;
	}
}
