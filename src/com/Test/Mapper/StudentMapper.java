package com.Test.Mapper;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Test.POJO.Student;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet result, int RowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(result.getInt("id"));
		student.setSid(result.getInt("sid"));
		student.setSname(result.getString("Sname"));
		student.setTname(result.getString("tname"));
		student.setProfession(result.getString("profession"));
		student.setArea(result.getString("area"));
		return student;
	}
	
//	private String transfer(String str){
//		try {
//			return new String(str.getBytes("ISO-8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}
}
