<%@ page language="java" import="dsproject.*,java.util.*,java.io.*,javax.servlet.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
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
		<h1 style="font-weight:bold;font-style:italic">搜尋結果</h1>
		<br>
		<%
		String get=request.getParameter("searching") ;
		ArrayList<WebTree> tlst = new ArrayList<WebTree>();//存放每棵樹root的list
		//webRankList ranklst= new webRankList();
		//使用者輸入關鍵字
		
		
		try {
			//System.out.println(new GoogleQuery(input.nextLine()).query());
			HashMap<String,String> goo = new GoogleQuery(get).query();
			for(String key : goo.keySet()) {
				String url = goo.get(key);
				//If-else 清理每個url為有效url
				if(url.indexOf("&")!=-1) {
					url = url.substring(url.indexOf("h") , url.indexOf("&"));
					}
				else {
					url = url.substring(url.indexOf("h"));
				}
				
				WebPage rootPage = new WebPage(url, key);
				WebTree t = new WebTree(rootPage);
				tlst.add(t);//將此新建的樹存入tlst
			}
			
			for (WebTree t : tlst) {
				try {
					//Get root score
//					t.root.nodeScore = t.root.webPage.setScore();
					//getkwlst()用來獲取每個webPage的完整keyword List(包含name, count, weight)
					//setScore()：將getkwlst獲得的完整keyword List 算出總分
					
					//加入第一層的小孩
					UrlCrawler u = new UrlCrawler(t.root.webPage.url);
					t.root.addSublinksChildren(u.query());
					
					//計算該棵樹的總分
					t.setPostOrderScore(t.root.webPage.getkwlst());
					//System.out.println(t.root.nodeScore);
				}catch (IOException e) {
					continue;
				}
			}
			//排序tlst，得到最終結果(使用quick Sort)
			sortTrees st = new sortTrees();
			st.tlst = tlst; 
			st.sort();
			//測試
			for(WebTree w : st.tlst) {
				out.println(w.root.webPage.name +"," +w.root.nodeScore);
			%>
			<br><br>
			<%
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		%>
	</div>
</body>
</html>