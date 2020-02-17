package com.greenplum.scheduler.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenplum.scheduler.domain.Subject;

@Repository
public class SubjectDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Subject> list(){
		return sqlSession.selectList("subject.list");
	}
}
