/*
 * �ۼ���: ������
 * �ۼ���: 2018.08.28.
 * ����: �µ� ��ȯ�� ���� �ۼ�
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
		setIconImage(img); // ������ �ֱ�

		JPanel panel = new JPanel();
		add(panel); // panel �����, �߰�

		JLabel label1 = new JLabel("ȭ�� �µ�");
		JLabel label2 = new JLabel("���� �µ�");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("��ȯ"); // component ����

		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button); // panel component �߰�

		setTitle("�µ���ȯ��");
		setSize(310, 160);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // frame�� ���� ����

	}
}
