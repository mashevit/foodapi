package main.java.com.my.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import main.java.com.my.dao.IndishRepository;
import main.java.com.my.model.Indish;
@CrossOrigin
@RestController
public class IndishResource {
	@Autowired
	private IndishRepository indishRepository;
	
	@GetMapping("/indishes")
	public List<Indish> retrieveAllStudents() {
		return indishRepository.findAll();
	}
	
	@GetMapping("/indishes/{id}")
	public Indish retrieveStudent(@PathVariable int id) throws Exception {
		Optional<Indish> student = indishRepository.findById(id);

		if (!student.isPresent())
			throw new Exception("Indish not found id-" + id);

		return student.get();
	}
	
	@DeleteMapping("/indishes/{id}")
	public void deleteStudent(@PathVariable int id) {
		indishRepository.deleteById(id);
	}
	
	@PostMapping("/indishes")
	public ResponseEntity<Object> createStudent(@RequestBody Indish student) {
		Indish savedStudent = indishRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getIdindish()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	
	@PutMapping("/indishes/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Indish student, @PathVariable int id) {

		Optional<Indish> studentOptional = indishRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setIdindish(id);
		
		indishRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}
