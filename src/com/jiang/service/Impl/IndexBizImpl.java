package com.jiang.service.Impl;



import java.util.List;

import com.jiang.dao.IndexDao;
import com.jiang.po.Admin;
import com.jiang.service.IndexBiz;

public class IndexBizImpl implements IndexBiz{
	private IndexDao dao = new IndexDao();

	public Admin findAll( String username,String password) {
		String sql = "select * from  admin  where adminAccount = ? and adminPwd = ? " ;
		return (Admin) dao.get(sql, Admin.class, new Object[]{username,password});
	}
	public Admin findAll(int  adminID)
	{
		String sql = " select admin.adminID,admin.adminAccount,admin.adminName,admin.adminPwd,adminRight,adminpopedom.departmentID "
				+ " from admin left join adminpopedom on admin.adminID = adminpopedom.adminID where adminpopedom.adminID = ? " ;
		return (Admin) dao.get(sql,Admin.class,new Object[]{ adminID });
	}
	public boolean update(Admin admin)
	{
		String sql  = "update admin set adminAccount =? , adminPwd = ? where adminID = ?";
		return dao.update(sql, new Object []{admin.getAdminAccount(),admin.getAdminPwd(),admin.getAdminID()});
	}
}
