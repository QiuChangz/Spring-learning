package com.Test.Service.ServiceImpl;

import java.util.List;

import javax.sql.DataSource;

import com.Test.Dao.StudentsDao;
import com.Test.Dao.DaoImpl.StudentsDaoImpl;
import com.Test.POJO.Student;
import com.Test.Service.StudentsService;

public class StudentsServiceImpl implements StudentsService{

	private StudentsDao studentsDao;
	private List<Student> studentsInfo;
	public StudentsServiceImpl(DataSource dataSource){
		this.studentsDao = new StudentsDaoImpl(dataSource);
	}
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		this.studentsInfo = this.studentsDao.getAll();
		return this.studentsInfo;
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		this.studentsDao.add(student);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.studentsDao.delete(this.studentsInfo.get(id));
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		this.studentsDao.update(student);
	}

	@Override
	public Student search(int id) {
		// TODO Auto-generated method stub
		return this.studentsDao.Search(id);
	}

}
