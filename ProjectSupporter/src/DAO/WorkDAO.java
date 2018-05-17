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
			Work work = new Work();
			System.out.println(work.getWork_seq());
			mapper.deleteWork(work.getWork_seq());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void detailWork(String work_seq) {
		SqlSession session = null;
		try {
		session = factory.openSession();
		WorkMapper mapper = session.getMapper(WorkMapper.class);
		Work work = new Work();
		mapper.detailWork();
		session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
