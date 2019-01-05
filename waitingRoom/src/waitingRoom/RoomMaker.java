package waitingRoom;

/*
 * 작성자: 정은애
 * 작성일: 2019.01.05.
 * 방만들기 버튼 클릭 시 방 추가/ 제거 버튼 클릭 시 방 마지막 방 제거 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RoomMaker extends JFrame {

	int i = 0;
	List<JButton> list = new ArrayList<>();

	public RoomMaker() {
		setSize(700, 500);
		setTitle("시작");

		JPanel waiting = new JPanel();
		waiting.setLayout(null);

		JPanel total = new JPanel();
		total.setLayout(new BorderLayout());

		JPanel roomPanel = new JPanel();
		roomPanel.setLayout(new GridLayout(2, 2));
		roomPanel.setBackground(Color.cyan);

		JPanel movePanel = new JPanel();
		movePanel.setLayout(new GridLayout(2, 2));
		JButton up = new JButton("∧");
		up.setBorderPainted(false);
		up.setContentAreaFilled(false);
		JButton down = new JButton("∨");
		down.setBorderPainted(false);
		down.setContentAreaFilled(false);
		movePanel.add(up);
		movePanel.add(down);

		total.add(roomPanel, "Center");
		total.add(movePanel, "East");

		total.setBounds(30, 30, 330, 200);
		waiting.add(total);

		JPanel a = new JPanel();
		a.setBackground(Color.cyan);
		a.setBounds(400, 30, 250, 200);
		waiting.add(a);

		JPanel b = new JPanel();
		b.setBackground(Color.cyan);
		b.setBounds(30, 250, 330, 180);
		waiting.add(b);

		JPanel c = new JPanel();
		c.setBackground(Color.cyan);
		c.setBounds(400, 320, 250, 110);

		waiting.add(c);

		JPanel rButtonPanel = new JPanel();
		rButtonPanel.setLayout(new GridLayout(1, 2));

		JButton createButton = new JButton("방만들기");
		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				list.add(new JButton("<html><body><p align=\"center\">" + (i++)
						+ "번방</p><p>들어올래면 들어와라</p> <p align=\"right\">2/4</p></body></html>"));
//				roomPanel.removeAll();
//				for (int j = 0; j < 4; j++) {
//					if (j < list.size())
//						roomPanel.add(list.get(j));
//					else
//						roomPanel.add(new JLabel("hi"));
//				}

				roomPanel.add(list.get(i - 1));
				roomPanel.revalidate();
				roomPanel.repaint();
				setTitle("방");
			}
		});
		rButtonPanel.add(createButton);

		JButton resetButton = new JButton("방제거");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				roomPanel.remove(list.get(--i));
				list.remove(i);
				roomPanel.revalidate();
				roomPanel.repaint();
				setTitle("제거");
			}
		});
		rButtonPanel.add(resetButton);
		rButtonPanel.setBounds(400, 250, 250, 40);
		waiting.add(rButtonPanel);

		add(waiting);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RoomMaker();
	}

}

class room {
	int roomNum;
	String roomName;
	int roomSize;
	JButton button;

}