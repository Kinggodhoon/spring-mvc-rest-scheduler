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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@RestController
@CrossOrigin("*")
public class ScheduleJsonController {

	@Autowired
	private ScheduleService scheduleService;
	
	
	@PostMapping("/api/schedule")
	@ApiOperation(value="시간표수정", notes="성공시 회원의 시간표를 초기화 후 삽입한 시간표로 수정합니다.")
	@ApiResponses({
		@ApiResponse(code=200, message="수정 성공"),
		@ApiResponse(code=400, message="잘못된 접근"),
		@ApiResponse(code=500, message="서버 에러")
	})
	public Map<String,Object> insert(@RequestBody List<Schedule> scheduleList){
		Map<String,Object> map = new HashMap<>();
		System.out.println(scheduleList);
		int userid = scheduleList.get(0).getUserid();
		
		scheduleService.init(userid);
		int result = scheduleService.insert(scheduleList);
		
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("/api/schedule/{userid}")
	@ApiOperation(value="시간표 조회", notes="성공시 회원 코드로 시간표를 조회해서 리스트를 반환합니다.")
	public List<Subject> list(@PathVariable int userid){
		return scheduleService.list(userid);
	}
	
}
