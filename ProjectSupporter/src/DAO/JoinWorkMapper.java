package DAO;

import java.util.ArrayList;

import VO.JoinWork;

public interface JoinWorkMapper {

	public void insertJoinWork(JoinWork vo);

	public ArrayList<JoinWork> JoinWorkList();

}
