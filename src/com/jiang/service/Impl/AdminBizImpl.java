package com.jiang.service.Impl;

import java.util.Arrays;
import java.util.List;

import com.jiang.dao.AdminDao;
import com.jiang.po.Admin;
import com.jiang.po.AdminPopeDom;
import com.jiang.service.IAdminBiz;
import com.jiang.util.PageUtil;

	public class AdminBizImpl  implements  IAdminBiz{
		private AdminDao dao = new AdminDao();
	@Override
	public List<Admin> findAll(PageUtil pageUtil,Admin admin) {
		String sql = "select  popedomID,admin.adminID,admin.adminAccount,admin.adminPwd,admin.adminState,admin.adminRight,admin.adminName, "
				+ " (select departmentName from department d1 where d.parentID = d1.departmentID)oneDName ,d.departmentName twoName ,d.departmentID oneDID,d.parentID twoDID	"
				+ "  from adminpopedom "
				+ " left join admin on admin.adminID = adminpopedom.adminID left join department d "
				+ " on d.departmentID = adminpopedom.departmentID "
				+ "  where 0=0 ";
		StringBuilder sb = new StringBuilder(sql);
		Object[] objs = new Object[]{};
		if( admin.getAdminAccount() != null 
				&& !admin.getAdminAccount().equals("") )
		{
			sb.append(" AND  admin.adminAccount like ? ");

			objs = Arrays.copyOf(objs, objs.length+1);
			objs[ objs.length - 1 ] = 
					"%" + admin.getAdminAccount() + "%";
			
			
		}
		sb.append(" limit ? , ? ");
		objs = Arrays.copyOf(objs, objs.length+1);
		objs[ objs.length - 1 ] = pageUtil.getStartIndex();
		
		objs = Arrays.copyOf(objs, objs.length+1);
		objs[ objs.length - 1 ] = pageUtil.getPageSize();
		
		return dao.query(sb.toString(), AdminPopeDom.class, objs);
	}
	@Override
	public int getCount() {
		String sql = "SELECT count(*) total from adminpopedom ";
		return (int) dao.getCount(sql, new Object[]{});
	}
	public List<Admin> findAll() {
		String sql = "select popedomID,admin.adminID,admin.adminAccount,admin.adminPwd,admin.adminState,admin.adminRight,admin.adminName, "
				+ " (select departmentName from department d1 where d.parentID = d1.departmentID)oneDName ,d.departmentName twoName ,d.departmentID oneDID,d.parentID twoDID	"
				+ "  from adminpopedom "
				+ " left join admin on admin.adminID = adminpopedom.adminID left join department d "
				+ " on d.departmentID = adminpopedom.departmentID ";
		return dao.query(sql, AdminPopeDom.class, new Object[]{  });
	}
	@Override
	public boolean deleteA(int popedomID) {
		String sql = "update adminpopedom set departmentID = null where popedomID = ?";
		return dao.update(sql, new Object[]{popedomID});
	}
	@Override
	public boolean updateA(AdminPopeDom ap) {
		String sql = "update adminpopedom set departmentID = ? where popedomID = ?";
		return dao.update(sql, new Object[]{ap.getTwoDID(),ap.getPopedomID()});
	}
}
