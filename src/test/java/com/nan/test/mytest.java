package com.nan.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nan.dao.StudentDao;
import com.nan.pojo.Student;
import com.nan.service.student.IstudentService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class mytest {
	//ע�� (ֻ�м�һ��)
	@Resource
	IstudentService studentService;
	Student student;
	@Test
	public void handler(){
		//���Դ���
		//����getStudentById����
		//System.out.println(studentService.getStudentById(1).getName());
		//����del����
		//studentService.del(1);
		//����add
		student.setAge(1);
		student.setName("aa");
		student.setSex("nan");
		studentService.update(student);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
}
