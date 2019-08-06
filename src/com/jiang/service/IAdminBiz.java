package com.jiang.service;

import java.util.List;

import com.jiang.po.Admin;
import com.jiang.po.AdminPopeDom;
import com.jiang.util.PageUtil;

public interface IAdminBiz {
	public List<Admin> findAll(PageUtil pageUtil,Admin admin);
	
	public int getCount();
	
	public List<Admin> findAll();
	//删除
	public boolean deleteA(int popedomID);
	//分配权限
	public boolean updateA(AdminPopeDom ap);
}
