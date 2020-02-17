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

@RestController
@CrossOrigin("*")
public class UserJsonController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	private Map<String,Object> register(@RequestBody Map<String,Object> body){
		Map<String,Object> map = new HashMap<>();
		
		User user = new User();
		
		user.setUsername(body.get("username").toString());
		user.setUserpw(BCrypt.hashpw(body.get("userpw").toString(), BCrypt.gensalt()));
		
		int result = userService.insert(user);
		
		map.put("result", result);
		
		return map;
	}
	
	@PostMapping("/api/user/login")
	private Map<String,Object> login(@RequestBody Map<String,Object> body){
		Map<String,Object> map = new HashMap<>();
		
		User user = new User();
		
		user.setUsername(body.get("username").toString());
		user.setUserpw(body.get("userpw").toString());
		
		int result = userService.login(user);
		
		map.put("result", result);
		
		return map;
	}
	
}
