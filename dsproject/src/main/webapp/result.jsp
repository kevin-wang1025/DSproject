<%@ page language="java" contentType="text/html; charset=BIG5"
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
		<h1 style="font-weight:bold;font-style:italic">�j�M���G</h1>
		<%
		String get=request.getParameter("searching") ;
		out.println("�z��J���j�M�O"+get);
		//test testt=new test();
		//out.println(testt.str);
		%>
	</div>
</body>
</html>