package com.nan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nan.pojo.Tbuser;
import com.nan.service.tbuser.ItbuserService;
import com.nan.util.DESUtils;
import com.alibaba.fastjson.JSON;
import com.nan.pojo.Student;

@Controller
@RequestMapping("/user")
public class TbuserControllerlogin {
	@Resource
	ItbuserService tbuserService;
	DESUtils des=new DESUtils();
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
		System.out.println(tbuser.getId());
		Tbuser object=null;
		Tbuser tbuser_sql=tbuserService.getTbuserById(tbuser.getId());
		System.out.println(tbuser_sql!=null);
		
		if(tbuser_sql!=null){
			if(tbuser_sql.getPassword().equals(tbuser.getPassword())){
				if(tbuser.getUsertype().equals(tbuser.getUsertype())){
					HttpSession session=request.getSession();
					session.setAttribute("id", tbuser_sql.getId());
					session.setAttribute("password", tbuser_sql.getPassword());
					session.setAttribute("usertype", tbuser_sql.getUsertype());
					System.out.println("已经保存sess");
					System.out.println("验证通过");
					Tbuser tbuser2=tbuserService.getTbuserById(tbuser.getId());
					String aString=tbuser2.toString();
					System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
					return tbuser2;
				}else{
					System.out.println("用户类型错误");
					return object;
				}
			}
			else{
				System.out.println("密码错误");
				return object;
			}
		}else{
			System.out.println("用户不存在");
			return object;
		}
		
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public String exit(HttpServletRequest request,ModelMap map) {
		HttpSession session=request.getSession();
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
	
	@RequestMapping("uploadFace")
	@ResponseBody
	public int uploadFace(Tbuser tbuser){
		
		return 0;
	}

}
