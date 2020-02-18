package com.greenplum.scheduler.domain;

import lombok.Data;

@Data
public class Subject {
	private int subjectid;
	private String subjectname;
	private int starttime;
	private int endtime;
	private int wday;
	private String color;
}
