package com.nan.pojo;
import com.nan.util.Id;
import com.nan.util.Table;
import lombok.Data;
@Data
@Table(value="student")
public class Student {
	@Id
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
}
