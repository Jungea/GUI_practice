package jp18_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket s = new Socket("Localhost",9000);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String res = input.readLine();
		System.out.println(res);
		System.exit(0);
	}

}
