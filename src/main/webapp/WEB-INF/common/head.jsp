<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String basepath="";
	if(request.getServerPort()!=80){
		basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	}else{
		basepath=request.getScheme()+"://"+request.getServerName()+request.getContextPath();
	}
	System.out.print(basepath);
	pageContext.setAttribute("basepath", basepath);
	pageContext.setAttribute("resource", "http://localhost:8080/cif/resource");
%>