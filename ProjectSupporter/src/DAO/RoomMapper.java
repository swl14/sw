package DAO;

import java.util.ArrayList;

import VO.Room;
import VO.Worker;

public interface RoomMapper {

	public void insertRoom(Room vo);

	public ArrayList<Room> RoomList();

	public Room RoomCheck(String room_seq);

	public Room Room_seqFinder(String room_creater);

	public Room RoomFinder(String room_seq);

	public void roomUpdate(Room room);

}
