/*
 * 작성자: 정은애
 * 작성일: 2019.02.20.
 * 내용: JTable 작성 연습
 */

package tableTest;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame {

	JTable table;

	public TableTest() {
		setSize(1000, 800);

		String[] header = { "학생이름", "국어", "영어", "수학" };
		String[][] context = { { "박영수", "90", "87", "98" }, { "김영희", "100", "99", "100" }, { "김철수", "30", "25", "9" } };
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
