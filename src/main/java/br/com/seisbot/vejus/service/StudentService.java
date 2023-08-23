package br.com.seisbot.vejus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seisbot.vejus.model.Student;
import br.com.seisbot.vejus.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
}
