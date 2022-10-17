package com.example.SpringEmpAssesment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MyController {

	@Autowired
	EmployeeService service;
	@RequestMapping("/")
	public String showHome(Model model)
	{
		System.out.println("Data displayed..!!!!");
		List<Employee> list=service.displayDta();
		for(Employee p : list)
		{
			System.out.println(p.getId()+" "+p.getName());
		}
		model.addAttribute("abc", list);
		return "show";
	}
	@RequestMapping("/addData")
	public String newData(Model model)
	{
		Employee employee= new Employee();
		model.addAttribute("employee",employee);
		return "add_pro";
	}
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String saveAfter(@ModelAttribute("employee") Employee employee)
	{
		service.saveEmp(employee);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView editData(@PathVariable(name="id")long id)
	{
		ModelAndView modelAndView = new ModelAndView("edit_data");
		Employee employee=service.getEmp(id);
		modelAndView.addObject("employee",employee);
		return modelAndView ;
		
	}
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable(name="id")long id)
	{
		service.delete(id);
		return "redirect:/";
		
	}
}
