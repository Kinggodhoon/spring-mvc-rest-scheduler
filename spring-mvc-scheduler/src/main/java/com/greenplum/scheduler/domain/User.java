package com.greenplum.scheduler.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
	@ApiModelProperty(name="userid", notes="number of the user",hidden=true)
	private int userid;
	@ApiModelProperty(name="username", required=true, notes="name of the user")
	private String username;
	@ApiModelProperty(name="userpw", required=true, notes="password of the user")
	private String userpw;
}
