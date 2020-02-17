package com.greenplum.scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenplum.scheduler.domain.Schedule;
import com.greenplum.scheduler.domain.Subject;
import com.greenplum.scheduler.service.ScheduleService;

@RestController
@CrossOrigin("*")
public class ScheduleJsonController {

	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping("/schedule")
	public Map<String,Object> insert(@RequestBody List<Map<String,Object>> body){
		Map<String,Object> map = new HashMap<>();
		
		int userid = Integer.parseInt(body.get(0).get("userid").toString());
		
		List<Schedule> list = new ArrayList<>();
		
		for(Map<String,Object> sc : body) {
			Schedule schedule = new Schedule();
			schedule.setUserid(userid);
			schedule.setSubjectid(Integer.parseInt(sc.get("subjectid").toString()));
			list.add(schedule);
		}
		
		scheduleService.init(userid);
		int result = scheduleService.insert(list);
		
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("/schdule/{userid}")
	public List<Subject> list(@PathVariable int userid){
		return scheduleService.list(userid);
	}
	
}
