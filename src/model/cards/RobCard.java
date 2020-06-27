package Model.cards;


import javax.swing.JOptionPane;

import context.GameState;

import Model.PlayerModel;

/**
 * 
 * 
 * ���Ῠ,�ӶԷ�ѡ�ִ��������ῨƬ����ֻ�ܸ����������������Է���Ƭ��
 * 
 * 
 */
public class RobCard extends Card {

	public RobCard(PlayerModel owner) {
		super(owner);
		this.name = "RobCard";
		this.cName = "���Ῠ";
		this.price = 50;
	}

	@Override
	public int useCard() {
		return GameState.CARD_ROB;
	}

}
