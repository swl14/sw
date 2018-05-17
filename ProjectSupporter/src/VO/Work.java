package VO;

public class Work {
	private String work_seq;
	private String work_name;
	private String start_day;
	private String period;
	private String people;
	private String detail;
	private String progress;
	private String room_seq;
	
	public Work(String work_seq, String work_name, String start_day, String period, String people, String detail,
			String progress, String room_seq) {
		super();
		this.work_seq = work_seq;
		this.work_name = work_name;
		this.start_day = start_day;
		this.period = period;
		this.people = people;
		this.detail = detail;
		this.progress = progress;
		this.room_seq = room_seq;
	}

	public Work() {
		super();
	}

	public String getWork_seq() {
		return work_seq;
	}

	public void setWork_seq(String work_seq) {
		this.work_seq = work_seq;
	}

	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}

	public String getStart_day() {
		return start_day;
	}

	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getRoom_seq() {
		return room_seq;
	}

	public void setRoom_seq(String room_seq) {
		this.room_seq = room_seq;
	}

	@Override
	public String toString() {
		return "Work [work_seq=" + work_seq + ", work_name=" + work_name + ", start_day=" + start_day + ", period="
				+ period + ", people=" + people + ", detail=" + detail + ", progress=" + progress + ", room_seq="
				+ room_seq + "]";
	}

	
	
}
