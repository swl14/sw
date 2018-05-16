package Common;

import java.io.Serializable;
import java.util.ArrayList;

import VO.Worker;

public class Data implements Serializable {
	public static final int FIRST_CONNECTION = 1; // 새로운 접속자
	public static final int DISCONNECTION = 2; // 연결 종료
	public static final int Worker_LOGIN = 10;
	public static final int Worker_REGIST = 11;
	public static final int CHAT_MESSAGE = 100; // 채팅 내용 전송
	public static final int WORK_INSERT = 60;

	int state; // 전송되는 데이터 종류
	String name; // 대화내용 입력한 사용자 이름
	String message; // 메세지 내용
	ArrayList<String> usernames; // 접속자 이름 목록
	Worker worker;
	
	
	
	public Data(int state, String name) {
		this.state = state;
		this.name = name;
	}

	public Data(int state, String name, String message) {
		this.state = state;
		this.name = name;
		this.message = message;
	}

	public Data(int state, String name, String message, ArrayList<String> usernames) {
		this.state = state;
		this.name = name;
		this.message = message;
		this.usernames = usernames;
	}

	public Data(int state, Worker worker) {
		super();
		this.state = state;
		this.worker = worker;
	}
	public Worker getUser() {
		return worker;
	}

	public void setUser(Worker worker) {
		this.worker = worker;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<String> getUsernames() {
		return usernames;
	}

	public void setUsernames(ArrayList<String> usernames) {
		this.usernames = usernames;
	}

}
