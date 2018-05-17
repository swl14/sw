package DAO;

import java.util.ArrayList;

import VO.Work;

public interface WorkMapper {

	public void insertWork(Work vo);

	public ArrayList<Work> WorkList(String room_seq);

	public void deleteWork(String work_seq);

	public void updateWork(Work w);
	
	public void finishWork(String room_seq);

}
