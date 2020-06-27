package Model.cards;

import javax.swing.JOptionPane;

import context.GameState;

import Model.PlayerModel;
import Model.buildings.Building;

/**
 * 
 * ���ؿ�,���˵�Ŀǰ�������Լ�ʱ��������ͬ����ǿ���չ���
 * 
 * 
 */
public class HaveCard extends Card {

	public HaveCard(PlayerModel owner) {
		super(owner);
		this.name = "HaveCard";
		this.cName = "���ؿ�";
		this.price = 50;
	}

	@Override
	public int useCard() {
		return GameState.CARD_HAVE;
	}

}
