package com.greenplum.scheduler.service;

import java.util.List;

import com.greenplum.scheduler.domain.Schedule;
import com.greenplum.scheduler.domain.Subject;

public interface ScheduleService {

	public int insert(List<Schedule> list);
	
	public List<Subject> list(int userid);
	
	public int init(int userid);
}
