package com.Test.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Test.Dao.StudentsDao;
import com.Test.DaoImpl.StudentsDaoImpl;
import com.Test.POJO.Student;


@Controller
public class StudentsController {

	StudentsDao studentsDao;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getAll(ModelMap model){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.studentsDao = (StudentsDaoImpl)context.getBean("studentDaoImpl");
		List<Student> students = studentsDao.getAll();
		model.addAttribute("studentsInfo", students);
		return "index";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateInfo(@ModelAttribute("SpringWeb") Student student,ModelMap model){
		model.addAttribute("student",student);
		this.studentsDao.update(student);
		return "index";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteInfo(@ModelAttribute("SpringWeb") int id){
		this.studentsDao.delete(id);
		return "index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addInfo(@ModelAttribute("SpringWeb") Student student){
		this.studentsDao.add(student);
		return "index";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchInfo(@ModelAttribute("SpringWeb") Student student, ModelMap model){
		Student result = this.studentsDao.Search(student.getId());
		model.addAttribute("result", result);
		return "index";
	}
}
