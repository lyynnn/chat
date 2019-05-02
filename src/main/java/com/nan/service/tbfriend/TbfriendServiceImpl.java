package com.nan.service.tbfriend;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nan.dao.TbfriendDao;
import com.nan.pojo.Tbfriend;

@Service
public class TbfriendServiceImpl implements ItbfriendService {
	@Resource
	TbfriendDao tbfriendDao;

	@Override
	public List<Tbfriend> getTbfriends(Tbfriend tbfriend) {
		// TODO Auto-generated method stub
		return tbfriendDao.getTbfriends(tbfriend);
	}

	@Override
	public Tbfriend getTbfriendById(String hostphone) {
		// TODO Auto-generated method stub
		return tbfriendDao.getTbfriendById(hostphone);
	}

	@Override
	public int add(Tbfriend tbfriend) {
		// TODO Auto-generated method stub
		return tbfriendDao.add(tbfriend);
	}

	@Override
	public int update(Tbfriend tbfriend) {
		// TODO Auto-generated method stub
		return tbfriendDao.update(tbfriend);
	}

	@Override
	public int del(String id) {
		// TODO Auto-generated method stub
		return tbfriendDao.del(id);
	}

	@Override
	public int count(Tbfriend tbfriend) {
		// TODO Auto-generated method stub
		return tbfriendDao.count(tbfriend);
	}
}