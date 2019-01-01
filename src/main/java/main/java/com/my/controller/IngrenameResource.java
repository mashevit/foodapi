package main.java.com.my.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import main.java.com.my.dao.IndishRepository;
import main.java.com.my.dao.IngrenameRepository;
import main.java.com.my.model.Indish;
import main.java.com.my.model.Ingrename;

@CrossOrigin
@RestController
public class IngrenameResource {
	@Autowired
	private IngrenameRepository ingrenameRepository;
	
	@Autowired
	private IndishRepository indishRepository;
	
	@GetMapping("/ingreds")
	public List<Ingrename> retrieveAllStudents() {
		return ingrenameRepository.findAll();
	}
	
	@GetMapping("/ingreds/{id}")
	public Ingrename retrieveStudent(@PathVariable int id) throws Exception {
		Optional<Ingrename> student = ingrenameRepository.findById(id);

		if (!student.isPresent())
			throw new Exception("Ingrename not found id-" + id);

		return student.get();
	}
	
	@DeleteMapping("/ingreds/{id}")
	public void deleteStudent(@PathVariable int id) {
		ingrenameRepository.deleteById(id);
	}
	
	
	@Transactional
	@DeleteMapping("/ingreds/{id}/dishes")
	public void deleteStudentplus(@PathVariable int id) {
		indishRepository.deleteByIngrenameIdingrenamesIn(id);
		ingrenameRepository.deleteById(id);
	}
	
	
	
	@PostMapping("/ingreds")
	public ResponseEntity<Object> createStudent(@RequestBody Ingrename student) {
		Ingrename savedStudent = ingrenameRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getIdingrenames()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	
	@PutMapping("/ingreds/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Ingrename student, @PathVariable int id) {

		Optional<Ingrename> studentOptional = ingrenameRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setIdingrenames(id);
		
		ingrenameRepository.save(student);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/ingreds/{id}/dishes")
	public List<Indish> retrieveDishesforIngred(@PathVariable int id) throws Exception {
		List<Indish> student = indishRepository.findByIngrenameIdingrenamesIn(id);

	/*	if (!student.isPresent())
			throw new Exception("Ingrename not found id-" + id);
*/
		return student;
	}
	
	
	@GetMapping("count/ingreds/{id}")
	public int countDishesforIngred(@PathVariable int id) throws Exception {
		int student = indishRepository.countByIngrenameIdingrenamesIn(id);

	/*	if (!student.isPresent())
			throw new Exception("Ingrename not found id-" + id);
*/
		return student;
	}
	
	@GetMapping("/ingreds/search")
	public List<Ingrename> findDish(@RequestParam("name") String name) {
		List<Ingrename> savedStudent = ingrenameRepository.findByingrnameContainingIgnoreCase(name);


		return savedStudent;

	}
	
}
