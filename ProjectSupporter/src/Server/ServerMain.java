package Server;

import java.net.ServerSocket;
import java.net.Socket;

//ä�� ���� ����
public class ServerMain {
	public static void main(String[] args) {

		try {
			System.out.println("���� ���� ����");
			ServerSocket ss = new ServerSocket(8888);
			Socket s = ss.accept();
			ServerThread thread = new ServerThread(s);

			new Thread(thread).start();

		} catch (Exception e) {
			System.out.println("���� ���� ����");
		}

	}

}
