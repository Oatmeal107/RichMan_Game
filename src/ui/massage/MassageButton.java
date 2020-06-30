package ui.massage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MassageButton extends JPanel implements MouseListener{
	
	/**
	 * ȥ��̾���Զ����ɵ�
	 */
	private static final long serialVersionUID = 9118697608635979542L;

	private Image[] img;  //���շ��صİ�ť4��״̬��ͼƬ
	
	private Image normalImage;  //����״̬
	private Image rolloverImage;  //�뿪
	private Image pressedImage;  //����
	
	private Image currentImage;  //��ǰ
	
	private boolean enabled = true;  //???
	
	private String name = null;  //����OK��cancel
	
	private Massage massage = null;
	
	/**
	 * MassageButton�๹�췽��
	 */
	public MassageButton(String name, Massage massage, int x, int y) {
		this.name = name;  //����
		this.massage = massage;
		this.img = this.getImg(name);
		this.normalImage = this.img[0];
		this.rolloverImage = this.img[1];
		this.pressedImage = this.img[2];
		this.currentImage = normalImage;
		this.setBounds(x, y, this.img[0].getWidth(null), this.img[0].getHeight(null));
		this.addMouseListener(this);
	}
	
	/**
	 * (֮��������Icon��getImage������image��һ��ߴ���󣬲��ʺ���ͼ��)
	 * @param name(OK��cancel)
	 * @return ����OK��cancel�İ�ť��4��״̬��ͼƬ
	 */
	private Image[] getImg(String name) {
		return new Image[] {
			new ImageIcon("images/massage/"+name+"/normal.png").getImage(),
			new ImageIcon("images/massage/"+name+"/mouseOver.png").getImage(),
			new ImageIcon("images/massage/"+name+"/pressed.png").getImage(),
			new ImageIcon("images/massage/"+name+"/disabled.png").getImage()
		};
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * Graphics��ͼ��
	 */
	public void paint(Graphics g) {
		this.setOpaque(false);  //����͸��
		if(enabled) {
			//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ��
			g.drawImage(currentImage, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
		}
	}
	
	/**
	 * ���� MassageButton ����ʵ�ּ̳еĳ��󷽷� MouseListener.mouseExited��MouseEvent��
	 * ���¾�Ϊ�̳к����ʵ�ֵķ��� 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		//���������¼�ʱ����
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//��갴��ʱ����
		currentImage = pressedImage;
		if(enabled) {
			if(name.equals("ok")) {
				massage.ok();
			}
			else if(name.equals("cancel")) {
				massage.cancel();
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		//��갴�����ͷ�ʱ����
		currentImage = rolloverImage;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//����������
		currentImage = rolloverImage;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//����Ƴ����
		currentImage = normalImage;
	}
}
