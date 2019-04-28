package com.nan.service.tbuser;

import java.util.List;

import com.nan.pojo.Tbuser;

public interface ItbuserService {
	List<Tbuser> getTbusers(Tbuser tbuser);
	Tbuser getTbuserById(String id);
	int add(Tbuser tbuser);
	int update(Tbuser tbuser);
	int del(String id);
	int count(Tbuser tbuser);
}