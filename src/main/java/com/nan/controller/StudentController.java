package com.nan.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.nan.pojo.Student;
import com.nan.service.student.IstudentService;

@Controller
public class StudentController {
	@Resource
	IstudentService studentService;
	@ResponseBody
	@RequestMapping("/test")
	public String list(ModelMap map,int id){
		map.addAttribute("test", studentService.getStudentById(id));
		
		String aString=JSONObject.toJSONString(studentService.getStudentById(id));
		return aString;
		//return "test";
	}

}
