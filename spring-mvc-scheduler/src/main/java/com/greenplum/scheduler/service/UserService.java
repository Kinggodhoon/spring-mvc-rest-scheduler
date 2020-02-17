package com.greenplum.scheduler.service;

import com.greenplum.scheduler.domain.User;

public interface UserService {

	public int insert(User user);
	
	public int login(User loginUser);
}
