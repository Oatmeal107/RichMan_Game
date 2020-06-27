package Model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.buildings.Building;
import model.card.Card;
import control.Control;
import control.GameRunning;

/**
 * �����Ϣ
 * 
 * @author Ruining
 * 
 */
public class PlayerModel extends Tick implements Port {

	/**
	 * ����
	 */
	private String name;
	/**
	 * ʹ������
	 */
	private int part=0;
	/**
	 * �ֽ�
	 */
	private int cash;
	/**
	 * ��ǰ����x �������½�
	 */
	private int x;
	/**
	 * ��ǰ����y �������½�
	 */
	private int y;
	/**
	 * ʣ��סԺ����
	 */
	private int inHospital;
	/**
	 * ʣ���������
	 */
	 private int inPrison;

		/**
		 * 
		 * ��ұ��,��ʾ����ͼƬʹ��
		 * 
		 */
		private int number = 0;

		/**
		 * 
		 * ���ӵ�з�������
		 * 
		 */
		private List<Building> buildings = new ArrayList<Building>();

		/**
		 * 
		 * ӵ�п�Ƭ
		 * 
		 */
		private List<Card> cards = new ArrayList<Card>();

		/**
		 * 
		 * ���ɳ��п�Ƭ
		 * 
		 */
		public static int MAX_CAN_HOLD_CARDS = 8;

		/**
		 * 
		 * �������ϵ�EFFECT ��Ƭ
		 * 
		 */
		private List<Card> effectCards = new ArrayList<Card>();

		private Image[] playerIMG = new Image[100];

		/**
		 * 
		 * �Է����
		 * 
		 */
		private PlayerModel otherPlayer = null;
		/**
		 * 
		 * ��Ϸ������
		 * 
		 */
		private Control control = null;

		public PlayerModel(int number, Control control) {
			this.name = "";
			this.number = number;
			this.control = control;
		}

		public List<Card> getCards() {
			return cards;
		}

		public void setCards(List<Card> cards) {
			this.cards = cards;
		}

		public List<Card> getEffectCards() {
			return effectCards;
		}

		public List<Building> getBuildings() {
			return buildings;
		}

		public int getInPrison() {
			return inPrison;
		}

		public void setInPrison(int inPrison) {
			this.inPrison = inPrison;
		}

		public PlayerModel getOtherPlayer() {
			return otherPlayer;
		}

		public void setOtherPlayer(PlayerModel otherPlayer) {
			this.otherPlayer = otherPlayer;
		}

		public int getNumber() {
			return number;
		}

		public int getInHospital() {
			return inHospital;
		}

		public void setInHospital(int inHospital) {
			this.inHospital = inHospital;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPart() {
			return part;
		}

		public void setPart(int part) {
			this.part = part;
		}

		public int getCash() {
			return cash;
		}

		public void setCash(int cash) {
			this.cash = cash;
		}
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void debug() {
			System.out.println("���:" + name + ",���꣺[" + x + "," + y + "].");
		}
        /**
         * ��ʼ�����ͼ��
         */
		  private void initPlayerIMG()
		  {
			  
		  }
		  /**
		   * ��ȡ���ͼ��
		   */
		  public Image getIMG(String str)
		  {
			  
		  }
		/**
		 * 
		 * ��ʼ��Ϸ����
		 * 
		 */
		public void startGameInit() {
			// ��ʼ�����ͼ��
			this.initPlayerIMG();
			// ���õ�λ����60px�����˶�ʱ��
			this.lastTime = Control.rate / 3;
			// ��ʼ����ҽ�Ǯ
			this.cash = GameRunning.PLAYER_CASH;
		}

		@Override
		public void updata(long tick) {
			this.nowTick = tick;
			// �ƶ����
			if (this.startTick < this.nowTick && this.nextTick >= this.nowTick) {
				this.control.movePlayer();
				// ·������
				if (this.nextTick != this.nowTick) {
					this.control.prassBuilding();
				}
				// ����ƶ���ϣ�ͣ�²���
				if (this.nextTick == this.nowTick) {
					this.control.playerStopJudge();
				}
			}
	 
}
