package com.nan.service.student;

import java.util.List;

import com.nan.pojo.Student;

public interface IstudentService {
	List<Student> getStudents(Student student);
	Student getStudentById(int id);
	int add(Student student);
	int update(Student student);
	int del(int id);
	int count(Student student);
}