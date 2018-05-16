package VO;

import java.io.Serializable;

public class Worker implements Serializable{
	private String worker_seq;
	private String name;
	private String id;
	private String password;
	private String phone_number;
	private String email;
	private String room_seq;
	
	public Worker(String worker_seq, String name, String id, String password, String phone_number, String email,
			String room_seq) {
		super();
		this.worker_seq = worker_seq;
		this.name = name;
		this.id = id;
		this.password = password;
		this.phone_number = phone_number;
		this.email = email;
		this.room_seq = room_seq;
	}
	
	public Worker() {
		super();
	}
	
	public String getWorker_seq() {
		return worker_seq;
	}
	public void setWorker_seq(String worker_seq) {
		this.worker_seq = worker_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(String room_seq) {
		this.room_seq = room_seq;
	}
	
	@Override
	public String toString() {
		return "Worker [worker_seq=" + worker_seq + ", name=" + name + ", id=" + id + ", password=" + password
				+ ", phone_number=" + phone_number + ", email=" + email + ", room_seq=" + room_seq + "]";
	}
	
}
