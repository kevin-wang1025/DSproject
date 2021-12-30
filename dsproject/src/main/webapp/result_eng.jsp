<%@ page language="java" import="java.util.*" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="BIG5">
	<title>Insert title here</title>
	<style>
		body{
			background-color:skyblue;
		}
		.container{
			
		}
	</style>
</head>
<body>
	<div class="container">
		<h1 style="font-weight:bold;font-style:italic">Searching Result</h1>
		<%
		String get=request.getParameter("searching") ;
		out.println("您輸入的搜尋是"+get);
		ArrayList<String> list=new ArrayList<String>();
		list.add(get);
		for (String str:list){
			out.println(str);
		}
		%>
	</div>
</body>
</html>