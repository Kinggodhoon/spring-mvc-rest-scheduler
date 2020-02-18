package com.greenplum.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenplum.scheduler.domain.Subject;
import com.greenplum.scheduler.service.SubjectService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
public class SubjectJsonController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/api/subject")
	@ApiOperation(value="과목조회", notes="성공시 전체 과목의 리스트를 반환합니다.")
	public List<Subject> list(){
		return subjectService.list();
	}
	
}
