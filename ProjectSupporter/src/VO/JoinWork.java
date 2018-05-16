package VO;

public class JoinWork {
	private String joinwork_seq;
	private String worker_num;
	private String room_num;
	
	public JoinWork(String joinwork_seq, String worker_num, String room_num) {
		super();
		this.joinwork_seq = joinwork_seq;
		this.worker_num = worker_num;
		this.room_num = room_num;
	}

	public JoinWork() {
		super();
	}

	public String getJoinwork_seq() {
		return joinwork_seq;
	}

	public void setJoinwork_seq(String joinwork_seq) {
		this.joinwork_seq = joinwork_seq;
	}

	public String getWorker_num() {
		return worker_num;
	}

	public void setWorker_num(String worker_num) {
		this.worker_num = worker_num;
	}

	public String getRoom_num() {
		return room_num;
	}

	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}

	
}
