package com.nan.controller;

import java.util.List;

import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nan.pojo.Student;
import com.nan.service.student.IstudentService;
import com.nan.service.student.StudentServiceImpl;
//把这些东西放到map中去
@Controller		//加了@Controller就会被spring.mvc中的包扫描---扫描controller所在包，在需要被扫描的类上加注解	
@RequestMapping("/studentJson")		//方法对应一个url,把url加在这个方法上注解是@RequestMapping相当于webservlet,当服务器启动的时候就读springmvc配置文件进行加载

//在需要被扫描的方法上加@RequestMapping，/studentJson作为key,方法作为value
public class StudentController {
@Resource
	IstudentService studentService;
		@RequestMapping("/list")
		@ResponseBody
		public List<Student> list(String name){	
			
			return studentService.getStudents(name);
		}
	
//	public ModelAndView list(){
//		ModelAndView modelAndView=new ModelAndView("index");
//		List<Student> students=studentService.getStudents(new Student());
//		modelAndView.addObject("students", students);
//		return modelAndView;
//	}

}
