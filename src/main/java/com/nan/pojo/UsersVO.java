package com.nan.pojo;

import java.sql.Timestamp;

import com.nan.util.Table;

import lombok.Data;


@Data
public class UsersVO extends Tbuser{
	private String id;
	private String password;
	private String nickname;
	private String sex;
	private String face;
	private String usertype;
	private String sign;    
	private Timestamp birthday;
	private String uniqueToken;
}
