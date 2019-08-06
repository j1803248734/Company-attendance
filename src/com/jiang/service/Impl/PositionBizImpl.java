package com.jiang.service.Impl;

import java.sql.Connection;
import java.util.List;

import com.jiang.dao.PositionDao;
import com.jiang.po.Position;
import com.jiang.service.IPositionBiz;
import com.jiang.util.JDBCUtils;

public class PositionBizImpl implements IPositionBiz{
	private PositionDao dao = new PositionDao();
	@Override
	public boolean addP(Position position) {
		String sql="insert into position (positionName) values(?) ";
		Object [] params = {
							position.getPositionName()
							};
		return dao.update(sql, params);
	}

	@Override
	public boolean deleteP(int positionID) {
		boolean result = true;
		Connection conn = JDBCUtils.getConnection();
		
		try{
			
			String sql1="select * from position left join employee on position.positionID = employee.positionID where employee.positionID = ?";
			Object [] param1 = { positionID };
			Position position =  (Position) dao.get(conn, sql1, Position.class, param1);
			
			if(position != null)
			{
				return result = false;
			}else{
				
				String sql2 = "delete from position where positionID = ? ";
				Object [] param2 = {positionID};
				dao.update(sql2, param2);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean updateP(Position position) {
		String sql = "update position set positionName = ? where positionID = ?";
		Object [] params = {
			position.getPositionName(),
			position.getPositionID()
		};
		return dao.update(sql, params);
	}

	@Override
	public Position findById(int positionID) {
		String sql = "select * from position where positionID = ?";
		Object [] params = { positionID };
		return (Position) dao.get(sql, Position.class, params);
	}

	@Override
	public List<Position> findAll() {
		String sql = "select * from position";
		Object [] params = {};
		return dao.query(sql, Position.class, params);
	}

	@Override
	public int getCount(Position position) {
		
			
			
			String sql = " SELECT count(*) total  "
					+ " FROM position ";

			return  (int) dao.getCount(sql, new Object[]{});
		
			
		
	}

}
