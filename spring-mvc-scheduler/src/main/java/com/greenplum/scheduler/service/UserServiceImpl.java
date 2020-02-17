package com.greenplum.scheduler.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenplum.scheduler.dao.UserDao;
import com.greenplum.scheduler.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int insert(User user) {
		int result = 0;
		
		result = userDao.insert(user);
		
		return result;
	}

	@Override
	public int login(User loginUser) {
		int result = 0;
		
		User user = userDao.get(loginUser.getUsername());
		
		if(BCrypt.checkpw(loginUser.getUserpw(), user.getUserpw())) {
			result = 1;
		}
		
		return result;
	}

}
