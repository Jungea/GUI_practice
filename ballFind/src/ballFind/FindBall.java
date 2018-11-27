package ballFind;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 공: 0.115 1.465 2.815   430
 * 컵: 0.50 1.400 2.750   250
 */
public class FindBall extends JFrame {
	JPanel ballPanel = new JPanel();

	Random random = new Random();
	JLabel ball = new JLabel("@");
	int ranBall;
	int[] ballXpos = new int[] { 125, 475, 825 };

	int ranCup;
	JPanel cupPanel = new JPanel();
	JButton[] cup = new JButton[3];

	JButton startButton = new JButton("시작");
	JButton resultButton = new JButton("결과");
	JLabel result = new JLabel("[정보 알림]");

	Timer timer;
	TimerTask task;
	int count = 0;

	Timer moveTimer;
	TimerTask moveTask;

	boolean endGame;
	int[] resultXpos = new int[] { 50, 400, 750 };

	int[] xpos = new int[] { 50, 400, 750 };
	int ypos = 170;

	void newGame() {
		xpos = new int[] { 50, 400, 750 };
		ypos = 170;
		cup[0].setBounds(xpos[0], ypos, 200, 250);
		cup[1].setBounds(xpos[1], ypos, 200, 250);
		cup[2].setBounds(xpos[2], ypos, 200, 250);
		count = 0;
	}

	public FindBall() {
		setSize(1015, 745);
		setLayout(null);

		ballPanel.setLayout(null);
		ballPanel.setBounds(0, 0, 1000, 700);
		ballPanel.setBackground(Color.white);

		cupPanel.setBounds(0, 0, 1000, 700);
		cupPanel.setOpaque(false);
		cupPanel.setLayout(null);

		startButton.setBounds(500, 30, 150, 50);
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newGame();
				result.setText("");
				ranBall = random.nextInt(3);
				ballPanel.add(ball);
				ball.setBounds(ballXpos[ranBall], 450, 70, 70);
				ball.setFont(new Font("Dialog", Font.BOLD, 30));
				System.out.println(ranBall);

				upDown(1);

				ranCup = random.nextInt(3);
				System.out.println(ranCup);
			}
		});
		cupPanel.add(startButton);

		resultButton.setBounds(700, 30, 150, 50);
		resultButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (endGame) {
					int bpos = Arrays.binarySearch(resultXpos, xpos[ranBall]);
					ballPanel.add(ball);
					ball.setBounds(ballXpos[bpos], 450, 70, 70);
					upDown(-1);
					result.setText(bpos + "번 컵");
				}
			}
		});
		cupPanel.add(resultButton);
		result.setBounds(745, 70, 200, 50);
		cupPanel.add(result);

		cup[0] = new JButton();
		cup[0].setBackground(Color.LIGHT_GRAY);
		cup[0].setBounds(xpos[0], ypos, 200, 250);
		cupPanel.add(cup[0]);

		cup[1] = new JButton();
		cup[1].setBackground(Color.LIGHT_GRAY);
		cup[1].setBounds(xpos[1], ypos, 200, 250);
		cupPanel.add(cup[1]);

		cup[2] = new JButton();
		cup[2].setBackground(Color.LIGHT_GRAY);
		cup[2].setBounds(xpos[2], ypos, 200, 250);
		cupPanel.add(cup[2]);

		ballPanel.add(cupPanel);
		add(ballPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void newTimer() {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (count == 15) {
					timer.cancel();
					endGame = true;

				} else {
					count++;
					ranCup = random.nextInt(3);
					move(Math.abs(xpos[ranCup] - xpos[(ranCup + 1) % 3]), ranCup, (ranCup + 1) % 3);
				}
			}
		};

		timer.schedule(task, 0);
	}

	public void move(int distance, int c1, int c2) {
		int one = xpos[c1];
		int two = xpos[c2];
		int i = xpos[c1] < xpos[c2] ? 1 : -1;

		moveTimer = new Timer();
		moveTask = new TimerTask() {

			@Override
			public void run() {
				xpos[c1] += (50 * i);
				cup[c1].setBounds(xpos[c1], ypos, 200, 250);
				xpos[c2] -= (50 * i);
				cup[c2].setBounds(xpos[c2], ypos, 200, 250);

				if (Math.abs(xpos[c1] - xpos[c2]) >= distance) {
					moveTimer.cancel();
					xpos[c1] = two;
					cup[c1].setBounds(xpos[c1], ypos, 200, 250);
					xpos[c2] = one;
					cup[c2].setBounds(xpos[c2], ypos, 200, 250);
					newTimer();
				}

			}
		};

		moveTimer.schedule(moveTask, 500, 20);
	}

	public void upDown(int d) {
		moveTimer = new Timer();
		moveTask = new TimerTask() {

			@Override
			public void run() {
				ypos += (10 * d);

				cup[0].setBounds(xpos[0], ypos, 200, 250);
				cup[1].setBounds(xpos[1], ypos, 200, 250);
				cup[2].setBounds(xpos[2], ypos, 200, 250);

				if (d == 1) {
					if (ypos >= 270) {
						moveTimer.cancel();
						ypos = 270;
						ballPanel.remove(ball);
						newTimer();
					}
				} else {
					if (ypos <= 170) {
						moveTimer.cancel();
						ypos = 170;
					}
				}

			}
		};

		moveTimer.schedule(moveTask, 1000, 50);
	}

	public static void main(String[] args) {
		FindBall f = new FindBall();
	}
}
