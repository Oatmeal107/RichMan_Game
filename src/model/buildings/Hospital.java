
package Model.buildings;


import Model.LandModel;
import Model.PlayerModel;
import context.GameState;
import control.Control;

/**
 * 
 * ҽԺ ��ɫ����˵ص㣬�����ò�����Ժ����ɫסԺ��Ϻ󣬻�����������Ϸ סԺʱ�䣺1 - 4��
 * 
 * 
 * @author Ruining
 * 
 */
public class Hospital extends Building {
	
	private String[] events = {
			"���С�",
			"���񲡡�",
			"���ˡ�",
			"����סԺ���ѡ�"
	};
	
	public Hospital(int posX, int posY) {
		super(posX, posY);
		this.name = "ҽԺ";
	}
	public String[] getEvents() {
		return events;
	}
	@Override
	public int getEvent() {
		this.player = player;
		int days = (int) (Math.random() * 4) + 2;
		player.setInHospital(days);
		int random = (int) (Math.random() * events.length);
		String text = events[random];
		player.showTextTip(player.getName() + text + "ͣ��" + (days - 1) + "��.", 3);
		new Thread(this).start();
		
		return GameState.HOSPITAL_EVENT;
	}
}
