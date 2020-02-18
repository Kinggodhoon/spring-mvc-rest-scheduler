package com.greenplum.scheduler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenplum.scheduler.domain.User;
import com.greenplum.scheduler.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
public class UserJsonController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	@ApiOperation(value="회원가입", notes="성공시 DB에 유저 정보를 저장 후 1을 반환합니다")
	private Map<String,Object> register(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		
		int result = userService.insert(user);
		
		map.put("result", result);
		
		return map;
	}
	
	@PostMapping("/api/user/login")
	@ApiOperation(value="로그인", notes="로그인 성공시 1을 반환합니다")
	private Map<String,Object> login(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		
		int result = userService.login(user);
		
		map.put("result", result);
		
		return map;
	}
	
}
