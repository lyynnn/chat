package com.nan.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nan.dao.StudentDao;
import com.nan.pojo.Student;
import com.nan.pojo.Tbuser;
import com.nan.service.student.IstudentService;
import com.nan.service.tbuser.ItbuserService;
import com.nan.service.tbuser.TbuserServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)		//测试类加载配置文件
@ContextConfiguration(locations="classpath:applicationContext.xml")		//加载哪个配置文件
public class mytest {
	//注解 (只有加一次)
	@Resource
	IstudentService studentService;
	@Resource
	ItbuserService tbuserService;
	//Student student;
	@Test
	public void handler(){
		//测试代码
		//测试getStudentById方法
//		System.out.println(studentService.getStudentById(1).getName());
		//测试del方法
		//System.out.println((studentService==null)+"******************");
//		studentService.del(1);
		//测试add
		Student student = new Student();
		//System.out.println((student==null)+"------------------");
		student.setAge(1);
		student.setName("wshccc");
		student.setSex("malex");
		//studentService.update(student);
		studentService.add(student);
		int students = studentService.count(student);
		System.out.println(students);
		
//		测试tbuser
		Tbuser tbuser=new Tbuser();
	////将String类型格式化为timestamp
		String date = "2009-07-16"; // <input type="datetime-local"> 输入参数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		try { 
			Date dt = sdf.parse(date);
			tbuser.setBirthday(new Timestamp(dt.getTime()));
			} 
		catch (ParseException e) {
			e.printStackTrace();
			}	
//		tbuser.setId("15076022225");
//		tbuser.setPassword("123456");
//		tbuser.setUsertype("老师");
//		
//		
//		tbuser.setSex("女");
//		tbuser.setSign("爱你爱你");
//		
//		tbuserService.add(tbuser);
			System.out.println(tbuserService.getTbuserById("111111111111")!=null);
	
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}*/
}
