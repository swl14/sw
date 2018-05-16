package DAO;

import java.util.ArrayList;

import VO.Worker;

public interface WorkerMapper {

	public void insertWorker(Worker vo);

	public ArrayList<Worker> WorkerList();

	public Worker WorkerCheck(String id);

	public Worker idInsert(String id);
	
	public void numUpdate(Worker worker);
	
}
