package com.Test.Service;

import java.util.List;

import com.Test.POJO.Student;

public interface StudentsService {

	public List<Student> getAll();
	
	public void add(Student student);
	
	public void delete(int id);
	
	public void update(Student student);
	
	public Student search(int id);
}
