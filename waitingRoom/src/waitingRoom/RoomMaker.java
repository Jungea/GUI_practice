package waitingRoom;

/*
 * 작성자: 정은애
 * 작성일: 2019.01.05.
 * 상하 버튼 구현/ Room 클래스 생성
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RoomMaker extends JFrame {

	int i = 0; // 임의 방번호
	List<Room> list = new ArrayList<>(); // 방 리스트

	int page = 0; // 사용자가 보고있는 방 페이지 번호
	String inputName; // 방제목
	JPanel roomPanel;

	public RoomMaker() {
		setSize(700, 500);
		setTitle("시작");

		JPanel waiting = new JPanel();
		waiting.setLayout(null);

		JPanel total = new JPanel();
		total.setLayout(new BorderLayout());

		roomPanel = new JPanel();
		roomPanel.setLayout(new GridLayout(2, 2));
		roomPanel.setBackground(Color.cyan);

		JPanel movePanel = new JPanel();
		movePanel.setLayout(new GridLayout(2, 2));
		JButton up = new JButton("∧");
		up.addActionListener(e -> {
			if (page != 0)
				page--;
			roomRepaint();
		});
		up.setBorderPainted(false);
		up.setContentAreaFilled(false);
		JButton down = new JButton("∨");
		down.addActionListener(e -> {
			if ((list.size() - 1) / 4 != page)
				page++;
			roomRepaint();
		});
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
				inputName = JOptionPane.showInputDialog("방 제목을 입력하세요.");
				list.add(new Room(i++, inputName));

				roomRepaint();
				setTitle("방");
			}
		});
		rButtonPanel.add(createButton);

		JButton resetButton = new JButton("방제거");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				removeRoom(2);
				roomRepaint();
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

	public void roomRepaint() {
		roomPanel.removeAll();
		for (int j = 0; j < 4; j++) {
			if (j + (4 * page) < list.size())
				roomPanel.add(list.get(j + (4 * page)).getButton());
			else
				roomPanel.add(new JLabel(""));
		}

		roomPanel.revalidate();
		roomPanel.repaint();
	}

	public void removeRoom(int roomNum) {
		for (int k = 0; k < list.size(); k++) {
			if (list.get(k).roomNum == roomNum) {
				roomPanel.remove(list.get(k).getButton());
				list.remove(k);
				return;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RoomMaker();
	}

}

class roomEnterAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("잘 작동");
	}
}

//class Room {
//	int roomNum; // 방번호
//	String roomName; // 방 제목
//	int enterNum; // 들어온 인원
//	JButton button; // 버튼
//
//	public Room(int roomNum, String roomName) {
//		this.roomNum = roomNum;
//		this.roomName = roomName;
//		enterNum = 1;
//		button = new JButton("<html><body><p align=\"center\">" + roomNum + "번방</p><p>" + roomName
//				+ "</p> <p align=\"right\">" + enterNum + "/4</p></body></html>");
//		button.addActionListener(new roomEnterAction());
//	}
//
//	public void enterPlayer() { // 플레이어 입장
//		button.setText("<html><body><p align=\"center\">" + roomNum + "번방</p><p>" + roomName
//				+ "</p> <p align=\"right\">" + (++enterNum) + "/4</p></body></html>");
//	}
//
//	public JButton getButton() {
//		return button;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj instanceof Room == false)
//			return false;
//		Room r = (Room) obj;
//		return this.roomNum == r.roomNum && Objects.equals(this.roomName, r.roomName) && this.enterNum == r.enterNum
//				&& Objects.equals(this.button.getText(), r.button.getText());
//	}
//
//	@Override
//	public String toString() {
//		return "Room [roomNum=" + roomNum + ", roomName=" + roomName + ", enterNum=" + enterNum + ", button="
//				+ button.getText() + "]";
//	}
//
//}
