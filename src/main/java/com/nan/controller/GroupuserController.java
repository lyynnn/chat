package com.nan.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nan.pojo.Groupuser;
import com.nan.service.groupuser.IgroupuserService;

@Controller
@RequestMapping("groupuser")
public class GroupuserController {

	@Resource
	IgroupuserService igroupuserService;
	
	@RequestMapping("addgroupuser")
	@ResponseBody
	public int addgroupuser(Groupuser groupuser){
		String userid=groupuser.getUserid();
		String groupid=groupuser.getGroupid();
		List<Groupuser> list=igroupuserService.getGroupuserById(groupid);
//		遍历该群所有用户，如有则不添加，反之添加此用户
		for (Groupuser groupuser2:list) {
			if(groupuser2.getUserid().equals(userid)){
				return 1;	//用户存在
			}
		}
			System.out.println(groupuser.getGroupid());
			igroupuserService.add(groupuser);
			return 0;		//添加用户成功
		
	}
	
	@RequestMapping("join_groups")
	@ResponseBody
	public List<Groupuser> list(Groupuser groupuser){
		System.out.println(groupuser.getUserid());
		System.out.println(igroupuserService.getGroupuserByuserId(groupuser.getUserid().toString().trim()));
		return  igroupuserService.getGroupuserByuserId(groupuser.getUserid().toString().trim());
	}
	
	
}
