package com.Test.DaoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Test.Dao.StudentsDao;
import com.Test.Mapper.StudentMapper;
import com.Test.POJO.Student;

public class StudentsDaoImpl implements StudentsDao{

	private DataSource dataSourse;
	private JdbcTemplate jdbcTemplate;
	
	private List<Student> studentsInfo;
	public StudentsDaoImpl(DataSource dataSource){
		this.dataSourse = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSourse);
		String sql = "SELECT * FROM studenttable";
		this.studentsInfo = jdbcTemplate.query(sql,new StudentMapper());
	}
	
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return this.studentsInfo;
	}

	@Override
	public Student Search(int id){
		// TODO Auto-generated method stub
		if(id > this.studentsInfo.size()||id <= 0){
			return null;
		}else{
			for(Student record: studentsInfo){
				if(record.getId() == id){
					return record;
				}
			}
		}
		return null;
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		String sql = "UPDATE studenttable set sid = ?,  sname = ?, tname = ?, profession = ?, area = ? WHERE id = ?";
		jdbcTemplate.update(sql,student.getSid(),student.getSname(),student.getTname(),student.getProfession(),student.getArea(),student.getId());
		this.studentsInfo.remove(student.getId() - 1);
		this.studentsInfo.add(student);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE studenttable WHERE id = ?";
		jdbcTemplate.update(sql, id);
		this.studentsInfo.remove(id);
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO studenttable (id,sid,sname,tname,profession,area) values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, student.getId(),student.getSid(),student.getSname(),student.getTname(),student.getProfession(),student.getArea());
		this.studentsInfo.add(student);
	}

}
