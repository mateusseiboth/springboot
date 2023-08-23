package br.com.seisbot.vejus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seisbot.vejus.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
