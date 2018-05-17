package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Work;

public class WorkDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public void insertWork(Work vo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			WorkMapper mapper = session.getMapper(WorkMapper.class);
			mapper.insertWork(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public ArrayList<Work> WorkList(int room_seq) {
		SqlSession session = null;
		ArrayList<Work> result = null;
		String input = String.valueOf(room_seq);
		try {
			session = factory.openSession();
			WorkMapper mapper = session.getMapper(WorkMapper.class);
			result = mapper.WorkList(input);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public void updateWork(Work w) {
		SqlSession session = null;
		try {
		session = factory.openSession();
		WorkMapper mapper = session.getMapper(WorkMapper.class);
		mapper.updateWork(w);
		session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}

	public void deleteWork(String work_seq) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			WorkMapper mapper = session.getMapper(WorkMapper.class);
			mapper.deleteWork(work_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void finishWork(String room_seq) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			WorkMapper mapper = session.getMapper(WorkMapper.class);
			mapper.finishWork(room_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
