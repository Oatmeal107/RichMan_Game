package ui;

import java.awt.Graphics;
import java.awt.Image;

import model.LandModel;

/**
 * ����ˢ�²�
 * �ڿհ׵�ͼ�ϻ�������������ͼƬ
 * 
 * @author ���������107
 *
 */
public class Lands extends Layer{

	/**
	 * ����ģ��
	 * Model���ڵ�LandModel�Զ�����
	 */
	private LandModel land = null;
	
	/**
	 * ����ͼƬ
	 */
	private Image landsIMG = null;

	/**
	 * ���캯��
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param land
	 */
	protected Lands(int x, int y, int w, int h, LandModel land) {
		super(x, y, w, h);
		this.land = land;
		this.landsIMG = this.land.getLandsIMG();
	}
	
	/**
	 * ����ʵ�ֵļ̳з���
	 * ���ػ���
	 */
	@Override
	public void paint(Graphics g) {
		this.paintLands(g);
		
	}
	
	/**
	 * ����ͼ�궼��������һ��660*60�ĳ�����ͼƬ�У������ص�ͼƬΪ60*60
	 * �����ͼƬ��LandModel���޸�
	 * 
	 */
	private void paintLands(Graphics g) {
		int x = 0;
		int y = 0;
		for(int i = 0; i < land.getLand().length; i++) {
			for(int j = 0; j < land.getLand()[i].length; j++) {
				if(land.getLand()[i][j] != 0) {
					//ͼƬ������ʾ
					g.drawImage(landsIMG, x + j*60, y + i*60, x +(j+1)*60,
							y +(i+1)*60, (land.getLand()[i][j]-1)*60, 0 ,
							land.getLand()[i][j]*60, 60, null);
				}
			}
		}
	}
		
	@Override
	public void stratPanel() {
		// TODO �Զ����ɵķ������	
	}
	
	//ȥ��̾���Զ��ӵ�
	private static final long serialVersionUID = 1L;	
}
