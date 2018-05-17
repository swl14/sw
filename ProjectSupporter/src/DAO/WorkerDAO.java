package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Room;
import VO.Worker;
import oracle.jdbc.OracleConnection.CommitOption;

public class WorkerDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public void insertWorker(Worker vo) { // 작성
		SqlSession session = null;
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			mapper.insertWorker(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public ArrayList<Worker> WorkerList(int room_seq) { // 리스트 저장
		SqlSession session = null;
		ArrayList<Worker> result = null;
		String input = String.valueOf(room_seq);
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			result = mapper.WorkerList(input);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	public boolean WorkerCheck(String id, String password) { // 비밀번호 확인
		SqlSession session = null;
		boolean result = false;
		String s = null;
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			Worker worker = new Worker();
			worker = mapper.WorkerCheck(id);
			if(worker==null) {
				return false;
			}
			s = worker.getPassword();
			if (s != null) {
				if (s.equals(password)) {
					return true;
				}
			} else {
				return false;
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public boolean idInsert(String id) { // 
		SqlSession session = null;
		boolean result = false;
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			Worker worker = new Worker();
			if (mapper.idInsert(id) == null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public void numUpdate(int row, String id) { // 방 입실 시 번호 업데이트
		SqlSession session = null;
		String number = String.valueOf(row);
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			Worker worker = new Worker();
			worker = mapper.idInsert(id);
			worker.setRoom_seq(number);
			mapper.numUpdate(worker);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public Worker workerFinder(String id) {
		SqlSession session = null;
		Worker worker = new Worker();
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			
			worker = mapper.idInsert(id);

			session.commit();
			
			return worker;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return worker;
	}
}
