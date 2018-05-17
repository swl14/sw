package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Room;
import VO.Worker;


public class RoomDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public void insertRoom(Room vo) {		
		SqlSession session = null;
		try {
		session = factory.openSession();
		RoomMapper mapper = session.getMapper(RoomMapper.class);
		mapper.insertRoom(vo);
		session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public int Room_seqFinder(String creater_id) {
		SqlSession session = null;
		int result = 0;
		Room room;
		try {
			session = factory.openSession();
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			room = mapper.Room_seqFinder(creater_id);
			result = Integer.parseInt(room.getRoom_seq());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}
	
	
	public ArrayList<Room> RoomList() {
		SqlSession session = null;
		ArrayList<Room> result = null;
		try {
			session = factory.openSession();
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			result = mapper.RoomList();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}
	
	public boolean RoomCheck(String seq, String check) {
		SqlSession session = null;
		boolean result = false;
		String s = null;
		try {
			session = factory.openSession();
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			Room r = new Room();
			r = mapper.RoomCheck(seq);
			if(r ==null) {
				return false;
			}
			s = r.getRoom_password();
			if (s != null) {
				if (s.equals(check)) {
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
	
}
