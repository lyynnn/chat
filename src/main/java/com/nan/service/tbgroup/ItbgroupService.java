package com.nan.service.tbgroup;

import java.util.List;

import com.nan.pojo.Tbgroup;

public interface ItbgroupService {
	List<Tbgroup> getTbgroups(Tbgroup tbgroup);
	Tbgroup getTbgroupById(String id);
	int add(Tbgroup tbgroup);
	int update(Tbgroup tbgroup);
	int del(String id);
	int count(Tbgroup tbgroup);
}