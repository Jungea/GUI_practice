package jp18_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {

	public static void main(String[] args) throws IOException {  //��ƮŰ �̹� ���
		ServerSocket ss = new ServerSocket(9000);  //��������
		try {
			while(true) {
				Socket socket = ss.accept();  //��û�� ���ö����� ��ٸ���.
				//Ŭ���̾�Ʈ�� ����Ǹ� ���ο� ������ ����(�����δ� �� �������� ��ȣ��ȭ)
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(new Date().toString());
				}finally {
					socket.close();
				}
			}
			
		}finally {
			ss.close();
		}
	}

}
