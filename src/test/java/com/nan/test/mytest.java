package com.nan.test;

import java.util.List;

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
	//注解 (只有加一次)
	@Resource
	IstudentService studentService;
	//Student student;
	@Test
	public void handler(){
		//测试代码
		//测试getStudentById方法
//		System.out.println(studentService.getStudentById(1).getName());
		//测试del方法
		//System.out.println((studentService==null)+"******************");
		studentService.del(1);
		//测试add
		Student student = new Student();
		//System.out.println((student==null)+"------------------");
		student.setAge(1);
		student.setName("wsh");
		student.setSex("malex");
		//studentService.update(student);
		studentService.add(student);
		int students = studentService.count(student);
		
		System.out.println(students);
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}*/
}
