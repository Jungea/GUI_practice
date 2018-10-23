package jp18_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {

	public static void main(String[] args) throws IOException {  //포트키 이미 사용
		ServerSocket ss = new ServerSocket(9000);  //서버소켓
		try {
			while(true) {
				Socket socket = ss.accept();  //요청이 들어올때까지 기다린다.
				//클라이언트와 연결되면 새로운 소켓을 생성(앞으로는 이 소켓으로 상호대화)
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
