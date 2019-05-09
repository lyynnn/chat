package com.nan.service.tbgroup;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nan.dao.TbgroupDao;
import com.nan.pojo.Tbgroup;

@Service
public class TbgroupServiceImpl implements ItbgroupService {
	@Resource
	TbgroupDao tbgroupDao;

	@Override
	public List<Tbgroup> getTbgroups(Tbgroup tbgroup) {
		// TODO Auto-generated method stub
		return tbgroupDao.getTbgroups(tbgroup);
	}

	@Override
	public Tbgroup getTbgroupById(String id) {
		// TODO Auto-generated method stub
		return tbgroupDao.getTbgroupById(id);
	}

	@Override
	public int add(Tbgroup tbgroup) {
		// TODO Auto-generated method stub
		return tbgroupDao.add(tbgroup);
	}

	@Override
	public int update(Tbgroup tbgroup) {
		// TODO Auto-generated method stub
		return tbgroupDao.update(tbgroup);
	}

	@Override
	public int del(String id) {
		// TODO Auto-generated method stub
		return tbgroupDao.del(id);
	}

	@Override
	public int count(Tbgroup tbgroup) {
		// TODO Auto-generated method stub
		return tbgroupDao.count(tbgroup);
	}
}