package com.greenplum.scheduler.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Schedule {
	@ApiModelProperty(name="userid", required=true, notes="number of the user")
	private int userid;
	@ApiModelProperty(name="subjectid", required=true, notes="number of the subject")
	private int subjectid;
}
