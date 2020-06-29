package Model.cards;


import javax.swing.JOptionPane;

import context.GameState;

import Model.PlayerModel;

/**
 * 
 * ��˰��,��ȡ�����е�10%˰��
 *
 */
public class TallageCard extends Card{

	public TallageCard(PlayerModel owner) {
		super(owner);
		this.name = "TallageCard";
		this.cName = "��˰��";
		this.price = 100;
	}

	@Override
	public int useCard() {
		return GameState.CARD_TALLAGE;
	}

}