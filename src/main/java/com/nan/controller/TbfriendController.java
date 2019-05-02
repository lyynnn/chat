package com.nan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nan.pojo.Tbfriend;
import com.nan.service.tbfriend.ItbfriendService;

@Controller
@RequestMapping("friend")
public class TbfriendController {
	@Resource
	ItbfriendService friendService;
	@RequestMapping("confirmeAdd")
	@ResponseBody
	public int add(Tbfriend tbfriend){
		System.out.println("加朋友kkkkkkkkkkkkkkkkk");
		System.out.println(tbfriend);
		friendService.add(tbfriend);
		//Tbfriend tbfriend2=friendService.getTbfriendById(tbfriend.getFriendphone());
		 return 0;
	}
	@RequestMapping("friends")
	@ResponseBody
	public List<Tbfriend> list(Tbfriend tbfriend){
		System.out.println("friendslllllllllllllllllllllllllllll");
		String id=tbfriend.getHostphone();
		//String hostphone=request.getParameter("id");
		return  friendService.getTbfriends(tbfriend);
	}
	
	
}


