package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import model.BuildingsModel;
import model.buildings.Building;


/**
 * ����ˢ�²�
 * 
 * @author ���������107
 *
 */
public class Buildings extends Layer{

	/**
	 * ���ط�����Ϣ
	 */
	private BuildingsModel informationBuilding;
	
	/**
	 * ��������
	 */
	private List<Building> building;
	
	/**
	 * house ͼƬ1-5����
	 * ���1�ķ���
	 */
	private Image HOUSE_01 = new ImageIcon("images/buliding/house01.png").getImage();
	
	/**
	 * house ͼƬ1-5����
	 * ���2�ķ���
	 */
	private Image HOUSE_02 = new ImageIcon("images/buliding/house02.png").getImage();
	
	/**
	 * α͸��ͼƬ
	 */
	public Image TRANSPARENT = new ImageIcon("images/window/transparent.png").getImage();
	
	//���캯��
	protected Buildings(int x, int y, int w, int h, BuildingsModel infor) {
		super(x, y, w, h);
		this.informationBuilding = infor;
	}
	
	public void paint(Graphics g) {
		//���ƽ�����
		paintBuildings(g);
	}
	
	//���ƽ�����ʵ�ַ���
	private void paintBuildings(Graphics g) {
		for(Building temp: this.building) {
			//���ݻ��� (ע�������������û��s)
			paintBuilding(temp, g);
		}
	}
	
	/**
	 * �����Ļ��ƽ�����ʵ�ַ���
	 */
	private void paintBuilding(Building building, Graphics g) {
		int x = 0;
		int y = 0;
		//getOwner �����־�֪���ǻ�ȡ����������
		if(building.getOwner() != null) {
			int level = building.getLevel(); //��ȡ��ǰ���ݵȼ�
			int i = building.getPosX(); //��ȡ����λ��
			int j = building.getPosY();
			//����������������˴�Ҳ��Ҫ��
			Image temp = building.getOwner().getNumber() == 1? this.HOUSE_01:HOUSE_02;
			//���ӵ�ͼƬҲ��60*60��
			if(level > 0) {
				//drawIamge�Ĳ������ui.layer��
				g.drawImage(temp, x+j*60, y+i*60-(temp.getHeight(null)-60),
						x+(j+1)*60, y+(i+1)*60, 60*(level-1), 0,
						60*level, temp.getHeight(null), null);
			}
			//����͸������
			g.drawImage(this.TRANSPARENT, x+j*60, y+i*60, x+(j+1)*60,
					y+(i+1)*60, 0, 0, 60, 60, null);
			
			// ����ӵ���ߵ�������ʾ
			g.drawString(""+building.getOwner().getName(), x+j*60+4, y+i*60+14);//ΪʲôҪ�Ӹ�14��
		}
	}

	@Override
	public void stratPanel() {
		this.building = this.informationBuilding.getBuilding();
	}
	
	//ȥ��̾���Զ���ӵ�
	private static final long serialVersionUID = 1L;
}
