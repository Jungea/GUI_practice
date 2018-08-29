/*
 * 작성자: 정은애
 * 작성일: 2018.08.29.
 * 내용: 피자 주문 화면(형태만)
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
		setTitle("피자 주문");  // 프레임 설정
		
		JPanel bigPanel = new JPanel();
		add(bigPanel);  // 큰 패널
		//bigPanel.setBackground(Color.BLUE);  // 패널 확인
		
		
		JPanel smallPanel1 = new JPanel();
		bigPanel.add(smallPanel1);  // 큰 패널 - 작은 패널 1
		//smallPanel1.setBackground(Color.RED);  // 패널 확인
		
		JLabel lableQ = new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오.");
		smallPanel1.add(lableQ);  // 큰 패널 - 작은 패널 1 - 레이블
		
		JPanel smallPanel2 = new JPanel();		
		bigPanel.add(smallPanel2);  // 큰패널 - 작은 패널 2
		//smallPanel2.setBackground(Color.GREEN);  // 패널 확인
		
		
		JButton button1 = new JButton("콤보피자");
		smallPanel2.add(button1);  // 큰패널 - 작은 패널 2 - 버튼 1
		JButton button2 = new JButton("포테이토피자");
		smallPanel2.add(button2);  // 큰패널 - 작은 패널 2 - 버튼 2
		JButton button3 = new JButton("불고기피자");
		smallPanel2.add(button3);  // 큰패널 - 작은 패널 2 - 버튼 3
		JLabel lableNum = new JLabel("개수");
		smallPanel2.add(lableNum);  // 큰패널 - 작은 패널 2 - 레이블
		JTextField textField = new JTextField(5);
		smallPanel2.add(textField);  // 큰패널 - 작은 패널 2 - 텍스트필드
		
		setVisible(true);
	}
}