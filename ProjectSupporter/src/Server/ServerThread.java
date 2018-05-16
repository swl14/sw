package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Server.ServerThread;
import VO.Worker;
import Common.Data;
import DAO.WorkerDAO;
import Server.ServerThread;

public class ServerThread implements Runnable {

	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	String username;
	String addr;
	WorkerDAO wrdao = new WorkerDAO();
	

	public ServerThread(Socket socket) {
		try {
			System.out.println("stream okay");
			this.socket = socket;
			// 클라이언트와의 스트림 생성
			input = new ObjectInputStream(socket.getInputStream());
			//output = new ObjectOutputStream(socket.getOutputStream());
			addr = socket.getInetAddress().getHostAddress();
		} catch (IOException e) {
			System.out.println(addr + "실패");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Data data = null;
		int state = 0;
		String name = null;
		System.out.println("run okay");
		boolean flag = true;
		while (flag) {
			try {
				System.out.println("try문 들어옴");
				data = (Data) input.readObject();
				state = data.getState();
				System.out.println("status:" + state);

				switch (state) {
				case Data.Worker_REGIST:
					System.out.println("switch okay");
					Worker worker = new Worker();
					worker = data.getUser();
					wrdao.insertWorker(worker);
					input.close();
					flag = false;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

		}
	}

}
