package com.Test.Dao;

import java.util.List;

import com.Test.POJO.Student;

public interface StudentsDao {

	public List<Student> getAll();
	
	public Student Search(int id);
	
	public void update(Student student);
	
	public void delete(Student student);
	
	public void add(Student student);
	
}
