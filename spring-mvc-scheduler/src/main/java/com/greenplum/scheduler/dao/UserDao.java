package com.greenplum.scheduler.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenplum.scheduler.domain.User;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insert(User user) {
		return sqlSession.insert("user.insert",user);
	}
	
	public User get(String username) {
		return sqlSession.selectOne("user.get", username);
	}
}
