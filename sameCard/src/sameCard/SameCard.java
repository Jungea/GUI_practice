package sameCard;

import java.awt.Color;

/*
 * 작성자: 정은애
 * 작성일: 2018.12.27.
 * 같은 그림 카드 맞추기(1인)
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

	int count = 0; // 카드 2개
	int pair; // 처음 뒤집은 카드 번호
	int backCount = 0; // 뒤집힌 카드 개수, 18개면 게임 종료

	Timer timer;
	TimerTask task;

	boolean startGame;

	public void init() {
		startGame = false;
		info.setText("게임 종료 다시 시작하려면 START 버튼을 누르시오.");
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
		setTitle("같은 그림 카드 맞추기");
		setResizable(false);

		JPanel totalPanel = new JPanel();
		totalPanel.setBackground(new Color(0Xfeeeed));
		totalPanel.setLayout(null);

		info = new JLabel("START 버튼을 누르시오.");
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

		card = new ArrayList<>(); // 카드 리스트
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

	public void check(int i) { // 2개의 카드가 같은 그림인지 확인
		if (startGame) {
			if (count == 0) { // 처음 뒤집는 카드
				pair = i;
				changeImg(i);
				count++;
				backCount++;

			} else if (count == 1) { // 두번째 뒤집는 카드
				if (pair != i) { // 첫번째 카드를 다시 눌렀을 경우 제외
					count++;
					backCount++;
					changeImg(i);

					timer = new Timer();
					task = new TimerTask() {

						@Override
						public void run() {
							// TODO Auto-generated method stub

							if (!Objects.equals(cardButton[pair].getIcon().toString(),
									cardButton[i].getIcon().toString())) { // 카드의 그림이 같지 않을 때
								info.setText("[실패] 짝이 맞지 않습니다.");
								changeImg(pair);
								changeImg(i);
								backCount -= 2;

							} else
								info.setText("[성공] 짝이 맞았습니다.");

							count = 0;

							if (backCount == 18) // 모두 뒤집었을 때
								init();

						}
					};

					timer.schedule(task, 1000);
				}
			}
		}
	}

	public void changeImg(int i) { // 카드 뒤집어주는 메소드
		if (cardButton[i].getIcon().toString().length() == 11) // 앞면일 때
			cardButton[i].setIcon(backImg);
		else
			cardButton[i].setIcon(cardImg[card.get(i)]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SameCard a = new SameCard();
	}

}
