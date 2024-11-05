package fall24.hsf301.edu.vn.FALL24_HSF301_Slot_01.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fall24.hsf301.slot1.pojo.Student;
import fall24.hsf301.slot1.service.IStudentService;
import fall24.hsf301.slot1.service.StudentService;

@Controller
public class HomeController {

	private final IStudentService iStudentService;

	public HomeController() {
		this.iStudentService = new StudentService("JPAs", 2);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView("home");
		try {
			List<Student> studentList = iStudentService.getStudents();
			model.addObject("studentList", studentList != null ? studentList : new ArrayList<Object>());
		} catch (Exception e) {
			model.addObject("error", e.getMessage());
			model.addObject("studentList", new ArrayList<Object>());
		}
		return model;
	}

	@RequestMapping(value = "/manageStudent", method = RequestMethod.POST)
	public String manageStudent(HttpServletRequest request) throws IOException {
		try {
			String action = request.getParameter("btnManageStudent");
			int id = Integer.parseInt(request.getParameter("txtID"));
			Student student = new Student(id, request.getParameter("txtFirstName"), request.getParameter("txtLastName"),
					Integer.parseInt(request.getParameter("txtMark")));

			switch (action) {
			case "add":
				iStudentService.save(student);
				break;
			case "update":
				iStudentService.update(student);
				break;
			case "delete":
				iStudentService.delete(id);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}
}