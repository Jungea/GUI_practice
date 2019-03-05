/*
 * 작성자: 정은애
 * 작성일: 2019.03.05.
 * 내용: 화씨->섭씨/ 칸 클릭시 공백/ 엔터로 변환가능
 */

package lab8_1;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

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

class MyFrame extends JFrame implements ActionListener, MouseListener, KeyListener {
	JTextField field1;
	JTextField field2;
	JButton button;

	// 프레임을 화면 가운데로 위치
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
		field1.addMouseListener(this);
		field1.addKeyListener(this);

		field2 = new JTextField(15);
		field2.addMouseListener(this);
		field2.addKeyListener(this);

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

	// 섭씨, 화씨 변환 메소드
	public void conversion() {
		try {
			if (field1.getText().length() > 0) {
				// 섭씨 입력 후 변환버튼 클릭 시 화씨 출력
				double c = Integer.parseInt(field1.getText());
				double f = (c * 9 / 5) + 32;
				field1.setText(formatD(c) + "°C");
				field2.setText(formatD(f) + "°F");
			} else {
				// 화씨 입력 후 변환버튼 클릭 시 섭씨 출력
				double f = Integer.parseInt(field2.getText());
				double c = (f - 32) * 5 / 9;
				field1.setText(formatD(c) + "°C");
				field2.setText(formatD(f) + "°F");
			}
		} catch (NumberFormatException ex) { // 필드에 문자가 입력된 경우
			// TODO: handle exception
			field1.setText("");
			field2.setText("");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button)
			conversion();

	}

	// 소수점이 불필요할 경우(0) 없애주는
	DecimalFormat df = new DecimalFormat("#.##");

	public String formatD(double number) {
		return df.format(number);
	}

	@Override
	public void mouseClicked(MouseEvent e) { // 필드 클릭시 공백
		// TODO Auto-generated method stub
		field1.setText("");
		field2.setText("");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) // 엔터로 변환 가능
			conversion();

	}

}
