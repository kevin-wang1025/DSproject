<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        body{
            background-image:url("image\\search_img.jpg");
            background-size:cover;
        }
        .button{
            border-radius:50px;
            width:100px;
            height:40px;
        }
        .font-style{
            font-style:italic;
        }
        input:hover{
            background-color:lightskyblue;
        }
        #container{
            display:flex;
            flex-direction:column;
            width:100%;
            height:800px;
            justify-content:center;
            align-items:center;
        }
        #item1{
            width:100%;
            height:30%;
        }
        #item2{
            width:100%;
            height:20%;
            text-align:center;
        }
        #item3{
            width:100%;
            height:30%;
            text-align:center;
        }
    </style>
    <script src="jquery-3.6.0.min.js"></script>
</head>
<body>
    <div id="container">
        <form action="result_eng.jsp" method="get">
            <h1 id="item1" class="font-style">Welcome to food searching engine!</h1>
            <p id="item2"><input type="search" name="searching" autofocus placeholder="Please enter key word"></p>
            <p id="item3"><input type="submit" value="search!" class="button"></p>
        </form>
    </div>
    <script>
        $(document).ready(function(){
            $("#item1").fadeIn(3000);
        });
    </script>
</body>
</html>
</body>
</html>