package com.nan.pojo;

import com.nan.util.Table;

import lombok.Data;

@Table (value="tbfriend")
@Data
public class Tbfriend {


	private String hostphone;
	private String friendphone;
	private String remarkname;
	private String friendlabel;
	
	
}
