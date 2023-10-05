<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// JSP 스크립트 요소 - 스크립트릿, 표현식
	//%@ page 지시자
	/*
	?
	fname=%ED%99%8D
	&
	lname=%EA%B8%B8%EB%8F%99
	*/
	//JSP 페이지에서 기본 제공 객체
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>ex01_ok.jsp</h3>
<h3>test</h3>
전송된 First Name : <input type="hidden" value="<%= fname %>"><br>
전송된 Last Name : <%= lname %><br>
</body>
</html>