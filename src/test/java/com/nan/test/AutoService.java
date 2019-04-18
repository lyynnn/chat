package com.nan.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class AutoService {
	public static void autoInterface(){
		  File pack=new File(AutoUtils.BASEPATH+AutoUtils.SERVICEINTERFACE+AutoUtils.OBJNAME);
		  if(!pack.exists()){
			  pack.mkdirs();
		  }
		  File file=new File(AutoUtils.BASEPATH+AutoUtils.SERVICEINTERFACE+AutoUtils.OBJNAME+"/I"+AutoUtils.OBJNAME+"Service.java");
		  File tmpFile=new File(AutoUtils.TMPPATH+"serviceInterfaceTmp");
		  if(!file.exists()){
			  try {
				file.createNewFile();
				String tmpStr=FileUtils.readFileToString(tmpFile);
				String newStr=tmpStr.replaceAll("\\[ClassName\\]", AutoUtils.CLASSNAME)
						.replaceAll("\\[objName\\]", AutoUtils.OBJNAME);
				FileUtils.writeStringToFile(file, newStr, "UTF-8");
				System.out.println("写入service接口文件完成");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }else{
			  System.out.println("service接口文件已经存在无法生成");
		  }
	}
	public static void autoImpl(){
		  File pack=new File(AutoUtils.BASEPATH+AutoUtils.SERVICEINTERFACE+AutoUtils.OBJNAME);
		  if(!pack.exists()){
			  pack.mkdirs();
		  }
		  File file=new File(AutoUtils.BASEPATH+AutoUtils.SERVICEINTERFACE+AutoUtils.OBJNAME+"/"+AutoUtils.CLASSNAME+"ServiceImpl.java");
		  File tmpFile=new File(AutoUtils.TMPPATH+"serviceImplTmp");
		  if(!file.exists()){
			  try {
				file.createNewFile();
				String tmpStr=FileUtils.readFileToString(tmpFile);
				String newStr=tmpStr.replaceAll("\\[ClassName\\]", AutoUtils.CLASSNAME)
						.replaceAll("\\[objName\\]", AutoUtils.OBJNAME);
				FileUtils.writeStringToFile(file, newStr, "UTF-8");
				System.out.println("写入service实现类文件完�?");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }else{
			  System.out.println("service实现类文件已经存在无法生�?");
		  }
	}
}
