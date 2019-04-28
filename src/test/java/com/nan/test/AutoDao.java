package com.nan.test;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.nan.util.Column;
import com.nan.util.Id;
import com.nan.util.Table;

public class AutoDao {
	public static void autoInterface(){
	  File file=new File(AutoUtils.BASEPATH+AutoUtils.DAOINTERFACE+AutoUtils.CLASSNAME+"Dao.java");
	  File tmpFile=new File(AutoUtils.TMPPATH+"daoTmp");
	  if(!file.exists()){		//判断文件是否存在
		  try {
			file.createNewFile();
			String tmpStr=FileUtils.readFileToString(tmpFile);
			String newStr=tmpStr.replaceAll("\\[ClassName\\]", AutoUtils.CLASSNAME)
					.replaceAll("\\[objName\\]", AutoUtils.OBJNAME);
			FileUtils.writeStringToFile(file, newStr, "UTF-8");			//传一个文件给你读成字符串
			System.out.println("写入dao接口文件完成");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }else{
		  System.out.println("dao接口文件已经存在无法生成");
	  }
	}
	public static void autoMapper(){
		 File file=new File(AutoUtils.RESPATH+AutoUtils.DAOINTERFACE+AutoUtils.CLASSNAME+"Dao.xml");
		 File tmpFile=new File(AutoUtils.TMPPATH+"mapperTmp");
		 if(!file.exists()){
			 try {
				 file.createNewFile();
				 //定义tablename
				 String tableName=AutoUtils.OBJNAME;
				 //定义resultMap
				 StringBuilder resultMap=new StringBuilder();
				 //定义selectList
				 List<String> selectList=new ArrayList<String>();
				 //定义insertColumns
				 StringBuilder insertColumns=new StringBuilder();
				 //定义insertValues
				 StringBuilder insertValues=new StringBuilder();
				 //定义updateList
				 StringBuilder updateList=new StringBuilder();
				 // 通过反射获取到class对象
				 Class clz=Class.forName(AutoUtils.PACKAGE+"."+AutoUtils.CLASSNAME);
				 //判断该class是否有Table注解
				Annotation ann = clz.getAnnotation(Table.class);
				//如果加了Table注解 则用注解的�?�替代tableName
				if(ann!=null){
					tableName=((Table)ann).value();
				}
				// 获取class的属性列�?
				Field[] fields = clz.getDeclaredFields();
				for (Field field : fields) {
					//获取属�?�名和数据库的字段名
					//假如没有加Column注解 我们认为字段名和属�?�名�?�?
					String columName= field.getName();
					if(field.isAnnotationPresent(Column.class)){
						columName=field.getAnnotation(Column.class).value();
					}
					//判断属�?�是否有id注解  如果有id注解则不添加�? insert列表�?
					if(!field.isAnnotationPresent(Id.class)){
						if(field.isAnnotationPresent(Column.class)){
							columName=field.getAnnotation(Column.class).value();
						}
						insertColumns.append("<if test=\""+field.getName()+"!=null\">\n\t\t\t\t\t");
						insertColumns.append(columName+",\n\t\t\t\t</if>\n\t\t\t\t");
						insertValues.append("<if test=\""+field.getName()+"!=null\">\n\t\t\t\t\t");
						insertValues.append("#{"+field.getName()+"},\n\t\t\t\t</if>\n\t\t\t\t");
						updateList.append("<if test=\""+field.getName()+"!=null\">\n\t\t\t\t\t");
						updateList.append(columName+"=#{"+field.getName()+"},\n\t\t\t\t</if>\n\t\t\t\t");
					}
					selectList.add(columName);
					resultMap.append("<result property=\""+field.getName()+"\" column=\""+columName+"\"></result>\n\t\t");
				}
				 //读取模板内容
				String tmpStr=FileUtils.readFileToString(tmpFile);
				//替换字符�?
				String data=tmpStr.replaceAll("\\[ClassName\\]", AutoUtils.CLASSNAME)
						.replaceAll("\\[objName\\]", AutoUtils.OBJNAME)
						.replaceAll("\\[tableName\\]", tableName)
						.replaceAll("\\[resultMap\\]", resultMap.toString())
						.replaceAll("\\[selectList\\]", selectList.toString().replaceAll("\\[", "").replaceAll("\\]", ""))
						.replaceAll("\\[insertColumns\\]", insertColumns.toString())
						.replaceAll("\\[insertValues\\]", insertValues.toString())
						.replaceAll("\\[updateList\\]", updateList.toString());
				FileUtils.writeStringToFile(file, data, "UTF-8");
				System.out.println("写入Mapper文件完成");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }else{
			 System.out.println("Mapper文件已经存在");
		 }
	}
}
