package com.nan.service.student;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nan.dao.StudentDao;
import com.nan.pojo.Student;

@Service
public class StudentServiceImpl implements IstudentService {
	@Resource
	StudentDao studentDao;

	@Override
	public List<Student> getStudents(Student student) {
		// TODO Auto-generated method stub
		return studentDao.getStudents(student);
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(id);
	}

	@Override
	public int add(Student student) {
		// TODO Auto-generated method stub
		return studentDao.add(student);
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return studentDao.update(student);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return studentDao.del(id);
	}

	@Override
	public int count(Student student) {
		// TODO Auto-generated method stub
		return studentDao.count(student);
	}
}