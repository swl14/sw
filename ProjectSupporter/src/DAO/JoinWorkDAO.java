package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.JoinWork;

public class JoinWorkDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public void insertJoinWork(JoinWork vo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			JoinWorkMapper mapper = session.getMapper(JoinWorkMapper.class);
			mapper.insertJoinWork(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public ArrayList<JoinWork> RoomList() {
		SqlSession session = null;
		ArrayList<JoinWork> result = null;
		try {
			session = factory.openSession();
			JoinWorkMapper mapper = session.getMapper(JoinWorkMapper.class);
			result = mapper.JoinWorkList();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}
}
