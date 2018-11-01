package tictiactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(9000);
		System.out.println("Tic Tac Toe 서버가 시작되었습니다.");

		while (true) {
			Game game = new Game();

			Player player1 = new Player(game, ss.accept(), 'X');
			Player player2 = new Player(game, ss.accept(), 'O');
			
			player1.setOther(player2);
			player2.setOther(player1);
			
			player1.start();
			player2.start();
			System.out.println("페어가 만들어 졌습니다. ");
		}
	}

}

class Game {
	char[][] boards = new char[3][3];

	public void setBoard(int i, int j, char playerMark) {
		boards[i][j] = playerMark;
	}

	public char getBoard(int i, int j) {
		return boards[i][j];
	}

	public void printBoard() {
		for (int k = 0; k < 3; k++) {
			System.out.println(" " + boards[k][0] + "| " + boards[k][1] + "| " + boards[k][2]);
			if (k != 2)
				System.out.println("---|---|---");
		}
	}
}

class Player extends Thread {
	Game game;
	Socket socket;
	BufferedReader input;
	PrintWriter output;
	char playerMark;
	Player other;

	public Player(Game game, Socket socket, char playerMark) {
		this.game = game;
		this.socket = socket;
		this.playerMark = playerMark;

		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			output.println("START " + playerMark);
			output.println("PRINT 다른 경기자를 기다립니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("연결이 끊어졌습니다 . " + e);
		}
	}

	public void setOther(Player other) {
		this.other = other;
	}

	public void run() {
		try {
			output.println("PRINT 모든 경기자가 연결되었습니다. ");

			if (playerMark == 'X') {
				output.println("PRINT 당신 차례입니다.");
			}

			while (true) {

				String command = input.readLine();
				if (command == null)
					continue;
				if (command.startsWith("MOVE")) {
					int i = Integer.parseInt(command.substring(5, 6));
					int j = Integer.parseInt(command.substring(7, 8));
					game.setBoard(i, j, playerMark);
					game.printBoard();
					other.output.println("OTHER " + i + " " + j);
					output.println("PRINT 기다리세요!");
					other.output.println("PRINT 당신 차례입니다.");
				} else if (command.startsWith("QUIT")) {
					return;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("연결이 끊어졌습니다 . " + e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
