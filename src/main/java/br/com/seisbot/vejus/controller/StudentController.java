package br.com.seisbot.vejus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.seisbot.vejus.exception.StudentNotFoundException;
import br.com.seisbot.vejus.model.Student;
import br.com.seisbot.vejus.repository.StudentRepository;
import br.com.seisbot.vejus.service.StudentService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/")
	public String listStudent(Model model) {
		List<Student> students = studentRepository.findAll();
		model.addAttribute("studentList", students);
		return "/listStudent";
	}
	
	@GetMapping("/novo")
	public String newStudent(Model model) {
		Student student = new Student();
		model.addAttribute("objStudent",student);
		
		return "/newStudent";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("objStudent") @Valid Student student, BindingResult errors,
			RedirectAttributes atributes) {
		if(errors.hasErrors()) {
			return "/newStudent";
		}
		
		studentRepository.save(student);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
		System.out.println(id);
		Optional<Student> opt = studentRepository.findById(id);
			if(opt.isPresent()) {
				studentRepository.delete(opt.get());
			} else {
				throw new StudentNotFoundException("Student not found");
			}
			
			return "redirect:/";
	}

}
