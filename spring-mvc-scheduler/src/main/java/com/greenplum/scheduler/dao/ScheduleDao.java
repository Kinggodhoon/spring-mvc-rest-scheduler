package com.greenplum.scheduler.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenplum.scheduler.domain.Schedule;
import com.greenplum.scheduler.domain.Subject;

@Repository
public class ScheduleDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insert(Schedule schedule) {
		return sqlSession.insert("schedule.insert",schedule);
	}
	
	public List<Subject> list(int userid){
		return sqlSession.selectList("schedule.list", userid);
	}
	
	public int init(int userid) {
		return sqlSession.delete("schedule.init",userid);
	}
}
