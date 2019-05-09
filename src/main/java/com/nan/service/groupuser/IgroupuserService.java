package com.nan.service.groupuser;

import java.util.List;

import com.nan.pojo.Groupuser;

public interface IgroupuserService {
	List<Groupuser> getGroupusers(Groupuser groupuser);
	List<Groupuser> getGroupuserById(String id);
	int add(Groupuser groupuser);
	int update(Groupuser groupuser);
	int del(String id);
	int count(Groupuser groupuser);
}