package com.greenplum.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenplum.scheduler.dao.ScheduleDao;
import com.greenplum.scheduler.domain.Schedule;
import com.greenplum.scheduler.domain.Subject;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDao scheduleDao;
	
	@Override
	public int insert(List<Schedule> list) {
		for(Schedule sc : list) {
			scheduleDao.insert(sc);
		}
		return 1;
	}

	@Override
	public List<Subject> list(int userid) {
		return scheduleDao.list(userid);
	}

	@Override
	public int init(int userid) {
		scheduleDao.init(userid);
		return 1;
	}
	
	

}
