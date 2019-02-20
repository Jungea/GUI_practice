/*
 * �ۼ���: ������
 * �ۼ���: 2019.02.20.
 * ����: JTable �ۼ� ����
 */

package tableTest;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame {

	JTable table;

	public TableTest() {
		setSize(1000, 800);

		String[] header = { "�л��̸�", "����", "����", "����" };
		String[][] context = { { "�ڿ���", "90", "87", "98" }, { "�迵��", "100", "99", "100" }, { "��ö��", "30", "25", "9" } };
		table = new JTable(context, header);
		JScrollPane sp = new JScrollPane(table);
		add(sp);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TableTest();
	}
}
