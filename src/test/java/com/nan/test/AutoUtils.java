package com.nan.test;

import java.util.Properties;
import java.util.Set;

public class AutoUtils {
	public static String PACKAGE="com.nan.pojo";
	public static String BASEPATH=System.getProperty("user.dir")+"\\src\\main\\java\\";
	public static String RESPATH=System.getProperty("user.dir")+"\\src\\main\\resources\\";
	public static String CLASSNAME="Student";
	public static String OBJNAME=CLASSNAME.substring(0, 1).toLowerCase()+CLASSNAME.substring(1);
	public static String DAOINTERFACE="com/nan/dao/";
	public static String SERVICEINTERFACE="com/nan/service/";
	public static String TMPPATH=System.getProperty("user.dir")+"\\src\\test\\java\\com\\nan\\tmp\\";
	public static void main(String[] args) {
		AutoDao.autoInterface();
		AutoDao.autoMapper();
		AutoService.autoInterface();
		AutoService.autoImpl();
	}
}
