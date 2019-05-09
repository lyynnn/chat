package com.nan.dao;

import java.util.List;

import com.nan.pojo.Tbfriend;

public interface TbfriendDao {
	List<Tbfriend> getTbfriends(Tbfriend tbfriend);
	Tbfriend  getTbfriendById(String hostphone);
	int add(Tbfriend tbfriend);
	int update(Tbfriend tbfriend);
	int del(String id);
	int count(Tbfriend tbfriend);
	
//	联表查询
	List <Tbfriend> getLinkList (Tbfriend tbfriend);
}
