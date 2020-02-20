package com.greenplum.scheduler.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResponseResult {
	@ApiModelProperty(example="1")
	private int result;
	
	public ResponseResult(int result) {
		this.result = result;
	}

}
