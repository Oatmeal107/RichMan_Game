package Model.cards;


import javax.swing.JOptionPane;

import context.GameState;

import Model.LandModel;
import Model.PlayerModel;

/**
 * 
 * �ݺ���,ʹ���ݺ������x��һ�����֣���������׌������z2�졣
 * 
 */
public class TrapCard extends Card {

	public TrapCard(PlayerModel owner) {
		super(owner);
		this.name = "TrapCard";
		this.cName = "�ݺ���";
		this.price = 120;
	}

	@Override
	public int useCard() {
		return GameState.CARD_TRAP;
	}

}
