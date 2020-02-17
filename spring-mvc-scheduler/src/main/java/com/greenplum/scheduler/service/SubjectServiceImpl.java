package com.greenplum.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenplum.scheduler.dao.SubjectDao;
import com.greenplum.scheduler.domain.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public List<Subject> list() {
		return subjectDao.list();
	}

}
