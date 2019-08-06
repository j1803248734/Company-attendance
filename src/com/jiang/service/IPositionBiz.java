package com.jiang.service;

import java.util.List;

import com.jiang.po.Employee;
import com.jiang.po.Position;

public interface IPositionBiz {
	public boolean addP(Position position);
	public boolean deleteP( int positionID );
	public boolean updateP(Position position);
	public Position findById(int positionID);
	public List<Position> findAll();
	public int getCount(Position position);
}
