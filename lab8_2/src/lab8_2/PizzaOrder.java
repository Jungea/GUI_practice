/*
 * �ۼ���: ������
 * �ۼ���: 2018.08.29.
 * ����: ���� �ֹ� ȭ��(���¸�)
 */

package lab8_2;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PizzaOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();
	}

}

class MyFrame extends JFrame {
	public MyFrame() {		
		setSize(600,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���� �ֹ�");  // ������ ����
		
		JPanel bigPanel = new JPanel();
		add(bigPanel);  // ū �г�
		//bigPanel.setBackground(Color.BLUE);  // �г� Ȯ��
		
		
		JPanel smallPanel1 = new JPanel();
		bigPanel.add(smallPanel1);  // ū �г� - ���� �г� 1
		//smallPanel1.setBackground(Color.RED);  // �г� Ȯ��
		
		JLabel lableQ = new JLabel("�ڹ� ���ڿ� ���� ���� ȯ���մϴ�. ������ ������ �����Ͻÿ�.");
		smallPanel1.add(lableQ);  // ū �г� - ���� �г� 1 - ���̺�
		
		JPanel smallPanel2 = new JPanel();		
		bigPanel.add(smallPanel2);  // ū�г� - ���� �г� 2
		//smallPanel2.setBackground(Color.GREEN);  // �г� Ȯ��
		
		
		JButton button1 = new JButton("�޺�����");
		smallPanel2.add(button1);  // ū�г� - ���� �г� 2 - ��ư 1
		JButton button2 = new JButton("������������");
		smallPanel2.add(button2);  // ū�г� - ���� �г� 2 - ��ư 2
		JButton button3 = new JButton("�Ұ������");
		smallPanel2.add(button3);  // ū�г� - ���� �г� 2 - ��ư 3
		JLabel lableNum = new JLabel("����");
		smallPanel2.add(lableNum);  // ū�г� - ���� �г� 2 - ���̺�
		JTextField textField = new JTextField(5);
		smallPanel2.add(textField);  // ū�г� - ���� �г� 2 - �ؽ�Ʈ�ʵ�
		
		setVisible(true);
	}
}