package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;


import model.EffectModel;

/**
 * ���ֽ����ʾ��Ϣ�Ķ���Ч��
 * 
 * @author ���������107
 *
 */
public class Effect extends Layer{
	
	private EffectModel effect = null;
	
	/**
	 * panel�е�
	 */
	private Point middle = new Point((x+width)/2,(y+height)/2);
	private JPanelGame panel;
	
	protected Effect(int x, int y, int width, int height, EffectModel effect, JPanelGame panel) {
		super(x, y, width, height);
		this.effect = effect;
		this.panel = panel;
	}
	
	/**
	 * ����������
	 */
	public void moveToBack() {
		this.panel.getLayeredPane().moveToBack(this);
	}
	
	/**
	 * ����������
	 */
	public void moveToFront() {
		this.panel.getLayeredPane().moveToFront(this);
	}
	
	@Override
	public void paint(Graphics g) {
		if(effect.getStartTick()<effect.getNowTick()
				&& effect.getNextTick() >= effect.getNowTick()) {
			int pos = (int) ((effect.getNowTick()- effect.getStartTick())
					/ effect.getImageShowGap());
			if(pos<effect.getImg().length) {
				Image tempIMG = effect.getImg()[pos];
				//ͼƬ�е�
				Point imgGiddle = new Point(tempIMG.getWidth(null)/2, 
						tempIMG.getHeight(null)/2);
				Point position = new Point(middle.x - imgGiddle.x, 
						middle.y - imgGiddle.y);
				
				//������ʾͼƬ
				g.drawImage(tempIMG, position.x, position.y, 
						position.x+tempIMG.getWidth(null),
						position.y+tempIMG.getHeight(null),0,0,
						tempIMG.getWidth(null),tempIMG.getHeight(null),null);
			}
		}
	}

	@Override
	public void startPanel() {
		// TODO �Զ����ɵķ������
	}
	
	private static final long serialVersionUID = 1L;
}
