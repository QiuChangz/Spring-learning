package com.Test.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Test.Service.ServiceImpl.StudentsServiceImpl;
import com.Test.POJO.Student;
import com.Test.Service.StudentsService;


@Controller
public class StudentsController {

	private StudentsService studentsService;
	private List<Student> students;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getAll(ModelMap model){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.studentsService = (StudentsServiceImpl)context.getBean("studentsService");
		this.students = studentsService.getAll();
		model.addAttribute("studentsInfo", students);
		return "index";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateInfo(@ModelAttribute("SpringWeb") Student student,ModelMap model){
		student = this.students.get(student.getId());
		model.addAttribute("student",student);
		return "update";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveInfo(@ModelAttribute("SpringWeb")Student student,ModelMap model){
		this.studentsService.update(student);
		return "save";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteInfo(@PathVariable String id){
		this.studentsService.delete(Integer.parseInt(id)-1);
		return "index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addInfo(@ModelAttribute("SpringWeb") Student student){
		this.studentsService.add(student);
		return "index";
	}
	
	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public String searchInfo(@PathVariable String id, ModelMap model){
		Student result = this.studentsService.search(Integer.parseInt(id));
		model.addAttribute("result", result);
		return "search";
	}
}
