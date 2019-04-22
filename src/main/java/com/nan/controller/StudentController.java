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
//����Щ�����ŵ�map��ȥ
@Controller		//����@Controller�ͻᱻspring.mvc�еİ�ɨ��---ɨ��controller���ڰ�������Ҫ��ɨ������ϼ�ע��	
@RequestMapping("/studentJson")		//������Ӧһ��url,��url�������������ע����@RequestMapping�൱��webservlet,��������������ʱ��Ͷ�springmvc�����ļ����м���

//����Ҫ��ɨ��ķ����ϼ�@RequestMapping��/studentJson��Ϊkey,������Ϊvalue
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
