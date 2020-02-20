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
import com.greenplum.scheduler.model.ResponseResult;
import com.greenplum.scheduler.model.UserParameter;
import com.greenplum.scheduler.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import springfox.documentation.schema.plugins.SchemaPluginsManager;

@RestController
@CrossOrigin("*")
public class UserJsonController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	@ApiOperation(value="회원가입", notes="성공시 DB에 유저 정보를 저장 후 1을 반환합니다")
	private ResponseResult register(@RequestBody User user){
		
		user.setUserpw(BCrypt.hashpw(user.getUserpw(), BCrypt.gensalt()));
		
		int result = userService.insert(user);
		
		ResponseResult rr = new ResponseResult(result);
		
		return rr;
	}
	
	@PostMapping("/api/user/login")
	@ApiOperation(value="로그인", notes="로그인 성공시 result:1과 유저 객체를 반환합니다")
	private Map<String,Object> login(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		
		User loginedUser = userService.login(user);
		
		if(loginedUser == null) {
			map.put("result", 0);
		}else {
			map.put("result", 1);
			map.put("user", loginedUser);
		}
		
		return map;
	}
	
	@PostMapping("/api/user/check")
	@ApiOperation(value="아이디중복검사", notes="중복되는 아이디가 없을 시 1을 반환, 있을 시 0을 반환합니다")
	@ApiImplicitParam(name = "body", value = "username", required = true,dataType="UserParameter")
	private ResponseResult check(@RequestBody UserParameter body){
		String username = body.getUsername();
		
		int result = userService.check(username);
		
		ResponseResult rr = new ResponseResult(result);
		
		return rr;
	}
	
}
