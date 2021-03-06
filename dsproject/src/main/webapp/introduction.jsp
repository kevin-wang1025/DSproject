<%@ page language="java" import="dsproject.*,java.util.*,java.io.*,org.jsoup.*,javax.servlet.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
        #button{
            border-radius:50px;
            width:200px;
            height:50px;
        }
        .font{
            font-style:italic;
            font-weight:bold;
        }
        input:hover{
            background-color:lightskyblue;
        }
        #text4:hover{
            color:lightskyblue;
        }
        #container{
            display:flex;
            flex-direction:column;
            flex-wrap:wrap;
            width:100%;
            height:800px;
        }
        #item1{
            width:50%;
            height:10%;
            text-align:center;
            display:flex;
            flex-direction:row;
            justify-content:center;
            /*background-color:skyblue;*/
        }
        #item2{
            width:100%;
            height:35%;
            text-align:justify;
            
        }
        #item3{
            width:100%;
            height:40%;
            text-align:center;
            
        }
        #item4{
            display:flex;
            flex-direction:column;
            width:50%;
            height:85%;
            
            justify-content:center;
            align-items:center;
        }
        #item5{
            width:750px;
            height:100%;
            margin-right:-10px;
            background-size:cover;
        }
        #text4{
           text-decoration-line: underline; 
        }

        /*設定圖片輪播動畫*/
        @keyframes slide {
           0%{background-image:url("image\\slide0.jpg")}
           25%{background-image:url("image\\slide_2.jpg")}
           50%{background-image:url("image\\slide2.jpg")}
           75%{background-image:url("image\\slide3.jpg")}
           100%{background-image:url("image\\slide0.jpg")}
        }
        .slide{

            position:relative;
            animation-name:slide;
            animation-duration: 20s;
            animation-iteration-count: infinite;
            
        }
    </style>
    
    <!--javascript和jquery*/-->
    <script src="jquery-3.6.0.min.js"></script>
    <script>
       $(document).ready(function(){
           $("#text1").mouseenter(function(){
               $("#text1").animate({fontSize:"50px"})
                          /*.animate({color:"#fff"})*/
                          
           });
           $("#text1").mouseleave(function(){
               $("#text1").animate({fontSize:"30px"});
           })
       });
    </script>
    <script>
        //更換語言函式
        function switch_lan(){
            var x=document.getElementById("text1");
            if (x.textContent=="台北美食地圖"){
                document.getElementById("text1").innerHTML="Taipei Food Map<hr>";
                document.getElementById("text2").innerHTML="Still not decide what to eat for dinner? We provide<br>"+
                "fast and convenient food searching engine which<br>"+
                "allow you to find restaurant with high quality<br>"+
                "and good public transport network.There is no<br>"+
                "need to worry about tickling you taste buds.<br>"+
                "Press the button below and start your journey !<br>";
                document.getElementsByTagName("input")[0].value="Get Started";
                document.getElementsByTagName("input")[1].value="About Us";
                document.getElementById("text4").innerHTML="Switch Language";
            }
            else{
                document.getElementById("text1").innerHTML="台北美食地圖";
                document.getElementById("text2").innerHTML="還在為了晚餐吃什麼而煩惱嗎?我們為您提供最快捷、<br>"+
                "便利的美食搜尋引擎，讓你在短時間內找到交通便利<br>"+
                "、高品質的餐廳，從此不必為了滿足味蕾而煩惱！趕<br>"+
                "緊點擊下方按鈕來開始你的美食之旅吧！";
                document.getElementsByTagName("input")[0].value="開始搜尋";
                document.getElementsByTagName("input")[1].value="關於我們";
                document.getElementById("text4").innerHTML="點我切換語言";
            }
        }
        function jump1(){
            if (document.getElementsByClassName("text3")[0].value=="開始搜尋"){
                window.location.assign("search.jsp");
            }
            else{
                window.location.assign("search_eng.html");
            }
        }
        function jump2(){
            if (document.getElementsByClassName("text3")[1].value=="關於我們"){
                window.location.assign("about.html");
            }
            else{
                window.location.assign("about_eng.html");
            }
        }
    </script>
</head>
<body>
	<div id="container">
        <div id="item4">
            <header id="item1"><img src="image//logo_blue.png"><h1 class="font" id="text1">台北美食地圖</h1></header>
            <article>
                <section id="item2">
                <p id="text2">還在為了晚餐吃什麼而煩惱嗎?我們為您提供最快捷、<br>
                便利的美食搜尋引擎，讓你在短時間內找到交通便利<br>
                、高品質的餐廳，從此不必為了滿足味蕾而煩惱！趕<br>
                緊點擊下方按鈕來開始你的美食之旅吧！</p>
                </section>
                <section id="item3">
                <p>
                <p><h2><input type="button" value="開始搜尋" id="button" class="text3" onclick="jump1()"></h2></p>
                <p><h2><input type="button" value="關於我們" id="button" class="text3" onclick="jump2()"></h2></p>
                </p>
                <p id="text4" onclick="switch_lan()">點我切換語言</p>
                </section>
                <p id="test"></p>
            </article>
        </div>
        <div id="item5" class="slide">
        </div>
    </div>
</body>
</html>