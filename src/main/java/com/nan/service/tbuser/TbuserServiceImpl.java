package com.nan.service.tbuser;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nan.dao.TbuserDao;
import com.nan.pojo.Tbuser;

@Service
public class TbuserServiceImpl implements ItbuserService {
	@Resource
	TbuserDao tbuserDao;

	@Override
	public List<Tbuser> getTbusers(Tbuser tbuser) {
		// TODO Auto-generated method stub
		return tbuserDao.getTbusers(tbuser);
	}

	@Override
	public Tbuser getTbuserById(String id) {
		// TODO Auto-generated method stub
		return tbuserDao.getTbuserById(id);
	}

	@Override
	public int add(Tbuser tbuser) {
		// TODO Auto-generated method stub
		return tbuserDao.add(tbuser);
	}

	@Override
	public int update(Tbuser tbuser) {
		// TODO Auto-generated method stub
		return tbuserDao.update(tbuser);
	}

	@Override
	public int del(String id) {
		// TODO Auto-generated method stub
		return tbuserDao.del(id);
	}

	@Override
	public int count(Tbuser tbuser) {
		// TODO Auto-generated method stub
		return tbuserDao.count(tbuser);
	}
	@Override
	public List<Tbuser> getLinkmenList(Tbuser tbuser){
		return tbuserDao.getLinkmenList(tbuser);
	}
}