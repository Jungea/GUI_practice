/*
 * 작성자: 정은애
 * 작성일: 2019.03.05.
 * 내용: 섭씨->화씨
 */

package lab8_1;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TempConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f1 = new MyFrame();
	}
}

class MyFrame extends JFrame implements ActionListener {
	JTextField field1;
	JTextField field2;
	JButton button;

	public void frameLocation() {
		Dimension screen1 = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension screen2 = getSize();
		int xpos = (int) (screen1.getWidth() / 2 - screen2.getWidth() / 2);
		int ypos = (int) (screen1.getHeight() / 2 - screen2.getHeight() / 2);
		setLocation(xpos, ypos);
	}

	public MyFrame() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("images//frame_icon.png");
		setIconImage(img); // 아이콘 넣기

		JPanel panel = new JPanel();
		add(panel); // panel 만들기, 추가

		JLabel label1 = new JLabel("화씨 온도");
		JLabel label2 = new JLabel("섭씨 온도");
		field1 = new JTextField(15);
		field2 = new JTextField(15);
		button = new JButton("변환"); // component 생성
		button.addActionListener(this);

		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button); // panel component 추가

		setTitle("온도변환기");
		setSize(310, 160);
		frameLocation();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // frame에 대한 설정

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == button) {
			// 섭씨 입력 후 변환버튼 클릭 시 화씨 출력
			double c = Integer.parseInt(field1.getText());
			double f = (c * 9 / 5) + 32;
			field1.setText(c + "°C");
			field2.setText(f + "°F");
		}

	}
}
