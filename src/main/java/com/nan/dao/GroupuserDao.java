package com.nan.dao;

import java.util.List;

import com.nan.pojo.Groupuser;

public interface GroupuserDao {
	List<Groupuser> getGroupusers(Groupuser groupuser);
	List<Groupuser> getGroupuserById(String groupid);
	List<Groupuser> getGroupuserByuserId(String userid);
	
	int add(Groupuser groupuser);
	int update(Groupuser groupuser);
	int del(String id);
	int count(Groupuser groupuser);
}
