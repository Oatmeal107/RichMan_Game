package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import control.Control;
import model.PlayerModel;
import model.buildings.Shop_;
import model.card.Card;

/**
 * �̵�ui
 * 
 * @author ���������107
 *
 */
public class Shop extends JPanel{

	/**
	 * �̵걳��
	 */
	private Image bg = new ImageIcon("image/shop/bg_ui.png").getImage();
	
	/**
	 * �̵� ��Ƭ���ܱ��� ��ɫ
	 */
	private Image detialBg = new ImageIcon("image/shop/item_bg.png").getImage();

	/**
	 * �̵� ���п�Ƭչʾ��
	 */
	private Image sideBarBg = new ImageIcon("image/shop/sidebar.png").getImage();
	
	/**
	 * �������ڵ�
	 */
	private Point position = new Point(240,100);
	
	/**
	 * �Ӵ�������λ��(����ڴ���)
	 */
	private Point atWhere = new Point(282,244);
	
	private List<ShopButton> card = new ArrayList<ShopButton>();
	
	private ShopButton close;
	private ShopButton buy;
	private ShopButton cancel;
	
	private Shop_ shop;
	
	/**
	 * �Ƿ���ʾ����
	 */
	private boolean showDetial = true;
	
	/**
	 * ָ��ǰ���µĿ�Ƭ
	 */
	private int chooseCard = 1;
	
	private JPanelGame panel;
	
	private Control control;
	
	private int x,y,w,h;
	
	private Point origin = new Point(); //ȫ�ֵ�λ�ñ��������ڱ�ʾ����ڴ����ϱ�ʾ��λ��
	
	private Shop(int x, int y, int w, int h, Control control, JPanelGame panel) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		setBounds(x, y, w, h);
		this.control = control;
		this.panel = panel;
		setLayout(null);
		//��ʼ��UI��ť����
		inItUIButton();
		//��Ӽ���
		addListener();
	}
	
	private void inItUIButton() {
		this.close = new ShopButton(this, "close", position.x + 476,
				position.y + 42, control);
		add(close);
		this.buy = new ShopButton(this, "buy", position.x+atWhere.x+110,
				position.y+atWhere.y+97, control);
		add(buy);
		this.cancel = new ShopButton (this, "cancel", position.x +atWhere.x+159,
				position.y+atWhere.y+97, control);
		add(cancel);
	}
	
	/**
	 * ���ش���
	*/ 
	public void moveToBack() {
		for(ShopButton a: card) {
			remove(a);
		}
		card.clear();
		//�ƶ����ײ�
		this.panel.getLayeredPane().moveToBack(this);
	}
	
	/**
	 * ����������
	 */
	public void moveToFront() {
		//�ƶ�������
		this.panel.getLayeredPane().moveToFront(this);
	}
	
	public int getChooseCard() {
		return chooseCard;
	}
	
	public Shop_ getShop() {
		return shop;
	}
	
	/**
	 * ������ÿ�Ƭ
	 */
	public void setChooseCard(ShopButton button) {
		for(int i =0; i<card.size(); i++) {
			if(card.get(i).equals(button)) {
				chooseCard = i;
				return;
			}
		}
		chooseCard = -1;
	}
	
	/**
	 * ��ʼ����Ƭ��ʾ
	 * ����9�ſ�Ƭ
	 */
	public void addCards(Shop_ shop) {
		removeAll();
		inItUIButton();
		this.shop = shop;
		List<Card> card_temp = shop.getCards();
		card.add(new ShopButton(this,card_temp.get(0).getName(),
				position.x+38, position.y+252, control));
		card.add(new ShopButton(this,card_temp.get(1).getName(),
				position.x+38, position.y+252 + 21, control));
		card.add(new ShopButton(this,card_temp.get(2).getName(),
				position.x+38, position.y+252 + 21*2, control));
		card.add(new ShopButton(this,card_temp.get(3).getName(),
				position.x+38, position.y+252 + 21*3, control));
		card.add(new ShopButton(this,card_temp.get(4).getName(),
				position.x+38, position.y+252 + 21*4, control));

		card.add(new ShopButton(this,card_temp.get(5).getName(),
				position.x+151, position.y+252, control));
		card.add(new ShopButton(this,card_temp.get(6).getName(),
				position.x+151, position.y+252 + 21, control));
		card.add(new ShopButton(this,card_temp.get(7).getName(),
				position.x+151, position.y+252 + 21*2, control));
		card.add(new ShopButton(this,card_temp.get(8).getName(),
				position.x+151, position.y+252 + 21*3, control));
		for(ShopButton a : card) {
			add(a);
		}	
	}
	
	public void debug() {
		System.out.println("test!");
	}
	
	@Override
	public void paint(Graphics g) {
		//�����̵�
		drawShop(g);
		//����sideBar
		drawSideBar(g);
		//ˢ�¿�Ƭ���
		for(ShopButton a:card) {
			a.update(g);
		}
		//ˢ��ui���
		updateUI(g);
	}
	
	/**
	 * ����sidebar
	 */
	private void drawSideBar(Graphics g) {
		Point sideBar = new Point(position.x -125, position.y+32);
		//����
		g.drawImage(sideBarBg, sideBar.x, sideBar.y,
				sideBar.x+sideBarBg.getWidth(null),
				sideBar.y+sideBarBg.getHeight(null), 0, 0,
				sideBarBg.getWidth(null), sideBarBg.getHeight(null), null);
		
		//��Ҳ���
		PlayerModel player = control.getRunning().getNowPlayer();
		Image playerLogo = player.getIMG("logo");
		int posX = sideBar.x+10;
		int posY = sideBar.y;
		
		//ͷ��
		g.drawImage(playerLogo, posX, posY, posX+100, posY+100, 0, 0,
				playerLogo.getWidth(null), playerLogo.getHeight(null), null);
		
		//��Ƭ����
		List<Card> cardsTemp = player.getCards();
		for(int i = 0; i<cardsTemp.size(); i++) {
			FontMetrics fm = g.getFontMetrics();
			String str = cardsTemp.get(i).getcName();
			g.drawString(str, sideBar.x+10+49-fm.stringWidth(str)/2,
					sideBar.y + 125 +19*i);
		}
	}
	
	/**
	 * ˢ��ui���
	 */
	private void updateUI(Graphics g) {
		//�жϵ�ǰ�Ƿ���ʾ�Ӵ���
		if(chooseCard >= 0) {
			showDetial = true;
		} else {
			showDetial = false;
		}
		
		//�˳�����Զ����
		close.update(g);
		if(showDetial) {
			//������ʾ��ϸ����UI
			drawDetialUI(g);
		}
		buy.setEnabled(showDetial);
		buy.update(g);
		cancel.setEnabled(showDetial);
		cancel.update(g);
	}

	/**
	 * ������ʾ��ϸ����ui
	 */
	private void drawDetialUI(Graphics g) {
		g.drawImage(detialBg, position.x+atWhere.x, position.y+atWhere.y,
				position.x+atWhere.x+detialBg.getWidth(null),
				position.y+atWhere.y+detialBg.getHeight(null), 0, 0,
				detialBg.getWidth(null), detialBg.getHeight(null), null);
		
		//��ǰ��Ƭ
		Card tempCard = this.shop.getCards().get(chooseCard);
		Image tempIMG = this.createCardImg(tempCard.getName())[4];
		g.drawImage(tempIMG, position.x+atWhere.x, position.y+atWhere.y-30,
				position.x+atWhere.x+(int)(tempIMG.getWidth(null)),
				position.y+atWhere.y-30+(int)(tempIMG.getHeight(null)),
				0,0, tempIMG.getWidth(null), tempIMG.getHeight(null), null);
		
		//��Ƭ����
		Image tempIMG2 = this.createCardImg(tempCard.getName())[5];
		g.drawImage(tempIMG2, position.x+atWhere.x+115, position.y+atWhere.y,
				position.x+atWhere.x+(int)(tempIMG2.getWidth(null)+115),
				position.y+atWhere.y+(int)(tempIMG2.getHeight(null)),
				0,0, tempIMG2.getWidth(null), tempIMG2.getHeight(null), null);
		
		//��ǰ��Ƭ�۸�
		g.setColor(Color.WHITE);
		g.setFont(new Font(null, 0, 14));
		String str = tempCard.getPrice() + "���";
		FontMetrics fm = g.getFontMetrics();
		g.drawString(str, position.x + atWhere.x + 80 - fm.stringWidth(str),
				position.y + atWhere.y + 110);
	}

	/**
	 * ����
	 */
	private void addListener() {
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				//����
				origin.x = e.getX();//��갴��ʱ��ȡ���ڵ�ǰλ��
				origin.y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				//�϶�
				x += e.getX() - origin.x;
				y += e.getY() - origin.y;
				if(x<0)
					x = 0;
				if(x+w>950)
					x = 950 - w;
				if(y<0)
					y = 0;
				if(y+h>650) 
					y = 650 - h;
				setBounds(x, y, w, h);
			}
		});
	}
	
	/**
	 * �����̵�
	 */
	private void drawShop(Graphics g) {
		g.drawImage(bg, position.x, position.y,
				position.x + bg.getWidth(null),
				position.y + bg.getHeight(null), 0, 0,
				bg.getWidth(null), bg.getHeight(null), null);
		PlayerModel player = control.getRunning().getNowPlayer();
		FontMetrics fm = g.getFontMetrics();
		g.drawString(player.getNx()+"", 
				position.x+151+90-fm.stringWidth(null),
				position.y+252+21*4+14);
		g.drawString("   ���", position.x+151, position.y+252+21*4+14);
	}

	/**
	 * ����ĳ�ſ�Ƭ�Ķ�Ӧ״̬ͼƬ
	 * @param name ��Ƭ����
	 * @return 4����Ƭ��ʾ
	 * 		   5�� ��Ƭ����
	 */
	public Image[] createCardImg(String name) {
		return new Image[] {
				new ImageIcon("images/shop/card/" + name + "/normal.png")
						.getImage(),
				new ImageIcon("images/shop/card/" + name + "/mouseOver.png")
						.getImage(),
				new ImageIcon("images/shop/card/" + name + "/pressed.png")
						.getImage(),
				new ImageIcon("images/shop/card/" + name + "/disabled.png")
						.getImage(),
				new ImageIcon("images/shop/card/" + name + "/card.png")
						.getImage(),
				new ImageIcon("images/shop/card/" + name + "/info.png")
						.getImage() };
	}
	
	public List<ShopButton> getCard(){
		return card;
	}
	
	public void setChooseCard(int chooseCard) {
		this.chooseCard = chooseCard;
	}

	private static final long serialVersionUID = 1L;
}
