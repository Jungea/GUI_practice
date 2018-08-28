/*
 * 작성자: 정은애
 * 작성일: 2018.08.28.
 * 내용: 온도 변환기 형태 작성
 */

package lab8_1;

import java.awt.Image;
import java.awt.Toolkit;

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

class MyFrame extends JFrame {

	public MyFrame() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("images//frame_icon.png");
		setIconImage(img); // 아이콘 넣기

		JPanel panel = new JPanel();
		add(panel); // panel 만들기, 추가

		JLabel label1 = new JLabel("화씨 온도");
		JLabel label2 = new JLabel("섭씨 온도");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("변환"); // component 생성

		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button); // panel component 추가

		setTitle("온도변환기");
		setSize(310, 160);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // frame에 대한 설정

	}
}
