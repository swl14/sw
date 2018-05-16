package VO;

public class Room {
	private String room_seq;
	private String room_name;
	private String first_day;
	private String last_day;
	private String room_password;
	private String leader;
	
	public Room(String room_seq, String room_name, String first_day, String last_day, String room_password,
			String leader) {
		super();
		this.room_seq = room_seq;
		this.room_name = room_name;
		this.first_day = first_day;
		this.last_day = last_day;
		this.room_password = room_password;
		this.leader = leader;
	}

	public Room() {
		super();
	}

	public String getRoom_seq() {
		return room_seq;
	}

	public void setRoom_seq(String room_seq) {
		this.room_seq = room_seq;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getFirst_day() {
		return first_day;
	}

	public void setFirst_day(String first_day) {
		this.first_day = first_day;
	}

	public String getLast_day() {
		return last_day;
	}

	public void setLast_day(String last_day) {
		this.last_day = last_day;
	}

	public String getRoom_password() {
		return room_password;
	}

	public void setRoom_password(String room_password) {
		this.room_password = room_password;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	@Override
	public String toString() {
		return "\t" + room_seq+"      " + room_name + "\t" + first_day + "\t ~ \t"
				+ last_day + "\t\t";
	}

	
}
