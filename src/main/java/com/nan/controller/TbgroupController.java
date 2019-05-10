package com.nan.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nan.pojo.Tbgroup;
import com.nan.service.tbgroup.ItbgroupService;

@Controller
@RequestMapping("group")
public class TbgroupController {
@Resource
ItbgroupService itbgroupService;

@RequestMapping("groups")
@ResponseBody
public List<Tbgroup> List(Tbgroup tbgroup){
	return itbgroupService.getTbgroups(tbgroup);
}




@RequestMapping("create")
@ResponseBody
public Tbgroup create(Tbgroup tbgroup,HttpServletRequest request){
	String usertype= request.getParameter("usertype");
	if(usertype.equals("老师")){
		String groupid=UUID.randomUUID().toString().trim();
		String groupname=tbgroup.getGroupname();
		String grouphost=tbgroup.getGrouphost();
		tbgroup.setGrouphost(grouphost);
		tbgroup.setGroupid(groupid);
		tbgroup.setGroupname(groupname);
		System.out.println(grouphost);
		System.out.println(groupname);
		System.out.println(groupid);
		itbgroupService.add(tbgroup);
		return itbgroupService.getTbgroupById(groupid);
	}
	else{
		return null;
	}
}



}