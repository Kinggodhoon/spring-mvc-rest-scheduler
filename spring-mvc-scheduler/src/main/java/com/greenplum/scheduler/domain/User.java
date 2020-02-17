package com.greenplum.scheduler.domain;

import lombok.Data;

@Data
public class User {
	private int userid;
	private String username;
	private String userpw;
}
