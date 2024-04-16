package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
		public String add(@RequestBody Student student) {
			studentService.saveStudent(student);
			return "New Student Is Added";
		}
	
	@GetMapping("/getAll")
	public List<Student> list(){
		return studentService.getAllStudent();	
		}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Student> get(@PathVariable Integer id) {
	            Student student = studentService.get(id);
	            return new ResponseEntity<Student>(student, HttpStatus.OK);

	        }
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable Integer id){
	            Student existingStuden=studentService.get(id);
	            studentService.saveStudent(student);
//	            return new ResponseEntity<>(HttpStatus.OK);
//	            return new ResponseEntity<>("Record Updated Sucessfully",HttpStatus.OK);
	            return new ResponseEntity<>(HttpStatus.OK);

	        }
	 
//	@RequestMapping(value="/student/{id}", method=RequestMethod.PUT)
//	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable("id") Integer id){
//		studentRepository.
//		
//		
//		
//	}
}
