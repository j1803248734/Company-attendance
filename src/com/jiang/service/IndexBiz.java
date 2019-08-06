package com.jiang.service;

import java.util.List;

import com.jiang.po.Admin;


public interface IndexBiz {
	public Admin findAll( String username,String password);
	public Admin findAll( int adminID);
	public boolean update(Admin admin);
}
