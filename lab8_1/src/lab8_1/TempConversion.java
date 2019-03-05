/*
 * �ۼ���: ������
 * �ۼ���: 2019.03.05.
 * ����: ȭ��->����/ ĭ Ŭ���� ����/ ���ͷ� ��ȯ����
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

	// �������� ȭ�� ����� ��ġ
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
		field1.addMouseListener(this);
		field1.addKeyListener(this);

		field2 = new JTextField(15);
		field2.addMouseListener(this);
		field2.addKeyListener(this);

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

	// ����, ȭ�� ��ȯ �޼ҵ�
	public void conversion() {
		try {
			if (field1.getText().length() > 0) {
				// ���� �Է� �� ��ȯ��ư Ŭ�� �� ȭ�� ���
				double c = Integer.parseInt(field1.getText());
				double f = (c * 9 / 5) + 32;
				field1.setText(formatD(c) + "��C");
				field2.setText(formatD(f) + "��F");
			} else {
				// ȭ�� �Է� �� ��ȯ��ư Ŭ�� �� ���� ���
				double f = Integer.parseInt(field2.getText());
				double c = (f - 32) * 5 / 9;
				field1.setText(formatD(c) + "��C");
				field2.setText(formatD(f) + "��F");
			}
		} catch (NumberFormatException ex) { // �ʵ忡 ���ڰ� �Էµ� ���
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

	// �Ҽ����� ���ʿ��� ���(0) �����ִ�
	DecimalFormat df = new DecimalFormat("#.##");

	public String formatD(double number) {
		return df.format(number);
	}

	@Override
	public void mouseClicked(MouseEvent e) { // �ʵ� Ŭ���� ����
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) // ���ͷ� ��ȯ ����
			conversion();

	}

}
