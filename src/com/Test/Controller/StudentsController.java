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
import org.springframework.web.servlet.ModelAndView;

import com.Test.Service.ServiceImpl.StudentsServiceImpl;
import com.Test.POJO.Student;
import com.Test.Service.StudentsService;


@Controller
public class StudentsController {

	private StudentsService studentsService;
	private List<Student> students;
	private ModelAndView view = new ModelAndView();

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getAll(ModelMap model){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.studentsService = (StudentsServiceImpl)context.getBean("studentsService");
		this.students = studentsService.getAll();
		model.addAttribute("studentsInfo", students);
		return "index";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateInfo(@PathVariable String id,ModelMap model){
		Student student = this.students.get(Integer.parseInt(id)-1);
		model.addAttribute("student",student);
		return "update";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveInfo(@ModelAttribute("SpringWeb")Student student,ModelMap model){
		this.studentsService.update(student);
		return "save";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteInfo(@PathVariable String id){
		this.studentsService.delete(Integer.parseInt(id)-1);
		return refresh();
	}
	
	@RequestMapping(value = "/search/{sid}", method = RequestMethod.GET)
	public String searchInfo(@PathVariable String sid, ModelMap model){
		Student result = this.studentsService.search(Integer.parseInt(sid));
		if(null==result){
			return "error";
		}else{
			model.addAttribute("result", result);
			return "search";
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addInfo(@ModelAttribute("SpringWeb") Student student){
		this.studentsService.add(student);
		return refresh();
	}
	
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	public ModelAndView refresh(){
		this.view.setViewName("redirect:http://localhost:8081/Spring-learning/index");
		return this.view;
	}
	
}
