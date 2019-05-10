package com.nan.pojo;

import com.nan.util.Table;

import lombok.Data;

@Table(value="tbgroup")
@Data
public class Tbgroup {
private String groupid;
private String groupname;
private String grouphost;

}
