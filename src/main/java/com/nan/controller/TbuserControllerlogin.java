package com.nan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.nan.pojo.Tbuser;
import com.nan.pojo.UsersVO;
import com.nan.service.tbuser.ItbuserService;
import com.nan.util.DESUtils;

import redis.clients.jedis.Jedis;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement.Else;
import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.Session;
import com.nan.pojo.Student;

@Controller
@RequestMapping("/user")
public class TbuserControllerlogin {
	@Resource
	ItbuserService tbuserService;
	//DESUtils des=new DESUtils();
	
//	HttpSession session;
	
//	@RequestMapping("zhuce")
//	@ResponseBody
//	public List<Tbuser> add(Tbuser tbuser){
//		System.out.println("进入zhuece");
//		System.out.println(tbuser);
//		
////		if(tbuserService.getTbuserById(tbuser.getId()).getId().equals(tbuser.getId())){
////			System.out.println("kkkkkkkkkkkkk");
////			return "已有账号请登录";
////		}
////		else
////		{
////			System.out.println("lllllllllllllll");
////			tbuserService.add(tbuser);
////			return "注册成功";
////		}
//		tbuserService.add(tbuser);
//		return	(List<Tbuser>) tbuserService.getTbuserById(tbuser.getId());
//		
//		
//	}
	
	@RequestMapping("zhuce")
	@ResponseBody
	public Tbuser add(Tbuser tbuser){
		tbuserService.add(tbuser);
		Tbuser tbuser2= tbuserService.getTbuserById(tbuser.getId());
		 return tbuser2;
	}
	@RequestMapping("dl")
	@ResponseBody
	public Tbuser login(Tbuser tbuser,HttpServletRequest request){
		Tbuser object=null;
		Tbuser tbuser_sql=tbuserService.getTbuserById(tbuser.getId());
		if(tbuser_sql!=null){
			System.out.println(tbuser_sql.getPassword());
			System.out.println(tbuser.getPassword());
			if(tbuser_sql.getPassword().trim().equals(tbuser.getPassword().trim())){
				if(tbuser_sql.getUsertype().trim().equals(tbuser.getUsertype().trim())){
					System.out.println("正确哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦");
					return tbuser_sql;
				}
				else {
					System.out.println("用户类型哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦");
					return object;
				}
				
			}
			else {
				System.out.println("密码哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦");
				return object;
			}
		}
		else {
			System.out.println("没有哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦");
			return object;
		}
		
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public String exit(HttpServletRequest request,ModelMap map) {
		HttpSession session=request.getSession();
//		session=request.getSession();
//		System.out.println(request.getParameter("flag"));
		if("out".equals(request.getParameter("flag"))) {
			System.out.println("退出登录");
			if(session!=null) {
				session.invalidate();
				System.out.println("注销session，并返回到登录界面");
			}
			return "logout";
		}else {
			return "logout";
		}
	}
	
	/*@RequestMapping(value = "/*",method = RequestMethod.OPTIONS)
	public ResponseEntity handleOptions(){
	    return (ResponseEntity) ResponseEntity.noContent();
	}*/
	
	
	@RequestMapping("uploadFace")   
	@ResponseBody
	public int uploadFace(HttpServletRequest request){
//		HttpSession session=request.getSession();
		//List<MultipartFile> files=new ArrayList<>();
		/*files.add(request2.getFile("face"));
		for(MultipartFile file:files){
			if(file!=null){
				System.out.println(file.getOriginalFilename());
			}
		}*/
//		,@RequestParam("face")MultipartFile face
//		System.out.println(face.getOriginalFilename());
		System.out.println("4444444444444444444444444");
		String userid=request.getHeader("headerUserId");
		String userToken=request.getHeader("headerUserToken");    
		System.out.println(userid+",,,,,,,,,,,,,,,,,");
		
		String id = request.getParameter("id");
		System.out.println(id);
		String filePath = request.getParameter("filePath");
		System.out.println(filePath+"文件路径******");
		
//		String uniToken=(String)session.getAttribute("uniqueToken:"+id);
//		if(StringUtils.isNotBlank(userid)&&StringUtils.isNotBlank(userToken)){
//			
//		}
		return 0;
	}
	
	@RequestMapping("addFriend")
	@ResponseBody
	public Tbuser addFriend(Tbuser tbuser,HttpServletRequest request){
		System.out.println("addddddddddddddddddddddddddddd");
		Tbuser tbuser_sql=tbuserService.getTbuserById(tbuser.getId());
		if(tbuser_sql!=null){
			System.out.println(tbuser_sql);
			return tbuser_sql;
		}
		else {
			System.out.println("没有哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦");
			return null;
		}
	}
	}
	
	