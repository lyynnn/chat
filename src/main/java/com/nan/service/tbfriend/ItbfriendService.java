package com.nan.service.tbfriend;

import java.util.List;

import com.nan.pojo.Tbfriend;

public interface ItbfriendService {
	List<Tbfriend> getTbfriends(Tbfriend tbfriend);
	Tbfriend getTbfriendById(String hostphone);
	int add(Tbfriend tbfriend);
	int update(Tbfriend tbfriend);
	int del(String id);
	int count(Tbfriend tbfriend);
}