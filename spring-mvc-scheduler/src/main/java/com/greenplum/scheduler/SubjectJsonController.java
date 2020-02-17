package com.greenplum.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenplum.scheduler.domain.Subject;
import com.greenplum.scheduler.service.SubjectService;

@RestController
@CrossOrigin("*")
public class SubjectJsonController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/api/subject") 
	public List<Subject> list(){
		return subjectService.list();
	}
	
}
