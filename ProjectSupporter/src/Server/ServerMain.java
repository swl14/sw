package Server;

import java.net.ServerSocket;
import java.net.Socket;

//채팅 서버 메인
public class ServerMain {
	public static void main(String[] args) {

		try {
			System.out.println("서버 동작 성공");
			ServerSocket ss = new ServerSocket(8888);
			Socket s = ss.accept();
			ServerThread thread = new ServerThread(s);

			new Thread(thread).start();

		} catch (Exception e) {
			System.out.println("서버 동작 실패");
		}

	}

}
