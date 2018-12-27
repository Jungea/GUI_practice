package sameCard;

import java.awt.Color;

/*
 * �ۼ���: ������
 * �ۼ���: 2018.12.27.
 * ���� �׸� ī�� ���߱�(1��)
 */

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SameCard extends JFrame {
	JLabel info;
	List<Integer> card;
	ImageIcon[] cardImg;
	ImageIcon backImg;
	JButton[] cardButton;

	int count = 0; // ī�� 2��
	int pair; // ó�� ������ ī�� ��ȣ
	int backCount = 0; // ������ ī�� ����, 18���� ���� ����

	Timer timer;
	TimerTask task;

	boolean startGame;

	public void init() {
		startGame = false;
		info.setText("���� ���� �ٽ� �����Ϸ��� START ��ư�� �����ÿ�.");
		Collections.shuffle(card);
		backCount = 0;
		System.out.println(card);

		for (int i = 0; i < card.size(); i++)
			cardButton[i].setIcon(backImg);
	}

	public void start() {
		for (int i = 0; i < card.size(); i++)
			changeImg(i);

		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < card.size(); i++)
					changeImg(i);
				startGame = true;
			}
		};

		timer.schedule(task, 4000);
	}

	public SameCard() {
		setSize(1000, 1030);
		setTitle("���� �׸� ī�� ���߱�");
		setResizable(false);

		JPanel totalPanel = new JPanel();
		totalPanel.setBackground(new Color(0Xfeeeed));
		totalPanel.setLayout(null);

		info = new JLabel("START ��ư�� �����ÿ�.");
		info.setFont(new Font("Dialog", Font.BOLD, 18));
		info.setBounds(80, 20, 500, 50);

		JButton startButton = new JButton("START");
		startButton.setFont(new Font("Dialog", Font.BOLD, 25));
		startButton.setBounds(700, 20, 200, 50);
		startButton.addActionListener(e -> start());

		JPanel cardPanel = new JPanel();
		cardPanel.setOpaque(false);
		cardPanel.setLayout(new GridLayout(3, 6));
		cardPanel.setBounds(60, 100, 850, 850);

		/////////////////////////////////////////////////////////////////

		card = new ArrayList<>(); // ī�� ����Ʈ
		for (int i = 0; i < 9; i++) {
			card.add(i);
			card.add(i);
		}

		Collections.shuffle(card);
		System.out.println(card);

		cardImg = new ImageIcon[9];
		for (int i = 0; i < cardImg.length; i++)
			cardImg[i] = new ImageIcon("image/" + i + ".png");
		backImg = new ImageIcon("image/back.png");

		cardButton = new JButton[18];
		for (int i = 0; i < card.size(); i++) {
			cardButton[i] = new JButton(backImg);
			cardButton[i].setBorderPainted(false);
			cardButton[i].setContentAreaFilled(false);
			// cardButton[i].setFocusPainted(false);
			cardPanel.add(cardButton[i]);

			final int ii = i;
			cardButton[i].addActionListener(e -> check(ii));
		}

		/////////////////////////////////////////////////////////////////

		totalPanel.add(info);
		totalPanel.add(startButton);
		totalPanel.add(cardPanel);
		add(totalPanel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void check(int i) { // 2���� ī�尡 ���� �׸����� Ȯ��
		if (startGame) {
			if (count == 0) { // ó�� ������ ī��
				pair = i;
				changeImg(i);
				count++;
				backCount++;

			} else if (count == 1) { // �ι�° ������ ī��
				if (pair != i) { // ù��° ī�带 �ٽ� ������ ��� ����
					count++;
					backCount++;
					changeImg(i);

					timer = new Timer();
					task = new TimerTask() {

						@Override
						public void run() {
							// TODO Auto-generated method stub

							if (!Objects.equals(cardButton[pair].getIcon().toString(),
									cardButton[i].getIcon().toString())) { // ī���� �׸��� ���� ���� ��
								info.setText("[����] ¦�� ���� �ʽ��ϴ�.");
								changeImg(pair);
								changeImg(i);
								backCount -= 2;

							} else
								info.setText("[����] ¦�� �¾ҽ��ϴ�.");

							count = 0;

							if (backCount == 18) // ��� �������� ��
								init();

						}
					};

					timer.schedule(task, 1000);
				}
			}
		}
	}

	public void changeImg(int i) { // ī�� �������ִ� �޼ҵ�
		if (cardButton[i].getIcon().toString().length() == 11) // �ո��� ��
			cardButton[i].setIcon(backImg);
		else
			cardButton[i].setIcon(cardImg[card.get(i)]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SameCard a = new SameCard();
	}

}
