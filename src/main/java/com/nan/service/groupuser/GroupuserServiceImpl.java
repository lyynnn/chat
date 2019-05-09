package com.nan.service.groupuser;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nan.dao.GroupuserDao;
import com.nan.pojo.Groupuser;

@Service
public class GroupuserServiceImpl implements IgroupuserService {
	@Resource
	GroupuserDao groupuserDao;

	@Override
	public List<Groupuser> getGroupusers(Groupuser groupuser) {
		// TODO Auto-generated method stub
		return groupuserDao.getGroupusers(groupuser);
	}

	@Override
	public List<Groupuser> getGroupuserById(String id) {
		// TODO Auto-generated method stub
		return groupuserDao.getGroupuserById(id);
	}

	@Override
	public int add(Groupuser groupuser) {
		// TODO Auto-generated method stub
		return groupuserDao.add(groupuser);
	}

	@Override
	public int update(Groupuser groupuser) {
		// TODO Auto-generated method stub
		return groupuserDao.update(groupuser);
	}

	@Override
	public int del(String id) {
		// TODO Auto-generated method stub
		return groupuserDao.del(id);
	}

	@Override
	public int count(Groupuser groupuser) {
		// TODO Auto-generated method stub
		return groupuserDao.count(groupuser);
	}
}