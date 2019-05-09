package com.nan.pojo;

import com.nan.util.Table;

import lombok.Data;

@Table(value="groupuser")
@Data
public class Groupuser {
private String groupid;
private String userid;
}
