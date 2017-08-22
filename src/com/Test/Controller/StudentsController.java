package com.Test.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		if(null == student.getArea()){
			student = this.students.get(student.getId());
			model.addAttribute("student",student);
			return "update";
		}else{
			this.studentsService.update(student);
			return "index";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteInfo(@ModelAttribute("SpringWeb") int id){
		this.studentsService.delete(id);
		return "index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addInfo(@ModelAttribute("SpringWeb") Student student){
		this.studentsService.add(student);
		return "index";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchInfo(@ModelAttribute("SpringWeb") Student student, ModelMap model){
		Student result = this.studentsService.search(student.getId());
		model.addAttribute("result", result);
		return "search";
	}
}
