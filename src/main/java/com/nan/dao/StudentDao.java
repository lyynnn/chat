package com.nan.dao;

import java.util.List;

import com.nan.pojo.Student;

public interface StudentDao {
	List<Student> getStudents(String name);
	Student getStudentById(int id);
	int add(Student student);
	int update(Student student);
	int del(int id);
	int count(Student student);
}
