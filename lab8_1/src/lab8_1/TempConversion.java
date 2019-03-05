/*
 * �ۼ���: ������
 * �ۼ���: 2019.03.05.
 * ����: ����->ȭ��
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
		setIconImage(img); // ������ �ֱ�

		JPanel panel = new JPanel();
		add(panel); // panel �����, �߰�

		JLabel label1 = new JLabel("ȭ�� �µ�");
		JLabel label2 = new JLabel("���� �µ�");
		field1 = new JTextField(15);
		field2 = new JTextField(15);
		button = new JButton("��ȯ"); // component ����
		button.addActionListener(this);

		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button); // panel component �߰�

		setTitle("�µ���ȯ��");
		setSize(310, 160);
		frameLocation();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // frame�� ���� ����

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == button) {
			// ���� �Է� �� ��ȯ��ư Ŭ�� �� ȭ�� ���
			double c = Integer.parseInt(field1.getText());
			double f = (c * 9 / 5) + 32;
			field1.setText(c + "��C");
			field2.setText(f + "��F");
		}

	}
}
