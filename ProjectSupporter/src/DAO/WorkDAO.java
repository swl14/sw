package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Room;
import VO.Work;
import VO.Worker;

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

	public ArrayList<Work> WorkList() {
		SqlSession session = null;
		ArrayList<Work> result = null;
		try {
			session = factory.openSession();
			WorkMapper mapper = session.getMapper(WorkMapper.class);
			result = mapper.WorkList();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
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
}
