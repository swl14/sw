package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Room;
import VO.Worker;
import oracle.jdbc.OracleConnection.CommitOption;

public class WorkerDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public void insertWorker(Worker vo) {
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

	public ArrayList<Worker> WorkerList() {
		SqlSession session = null;
		ArrayList<Worker> result = null;
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			result = mapper.WorkerList();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	public boolean WorkerCheck(String id, String password) {
		SqlSession session = null;
		boolean result = false;
		String s = null;
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			Worker worker = new Worker();
			worker = mapper.WorkerCheck(id);
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

	public boolean idInsert(String id) {
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
	
	public void numUpdate(Room room, String id) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			WorkerMapper mapper = session.getMapper(WorkerMapper.class);
			Worker worker = new Worker();
			worker = mapper.idInsert(id);
			worker.setRoom_seq(room.getRoom_seq());
			mapper.numUpdate(worker);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
