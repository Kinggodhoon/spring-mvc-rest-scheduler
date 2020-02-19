package com.greenplum.scheduler.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class Subject {
	private int subjectid;
	private String subjectname;
	private int starttime;
	private int endtime;
	private int wday;
	private String color;
}
