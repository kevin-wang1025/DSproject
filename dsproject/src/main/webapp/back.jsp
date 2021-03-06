<%@ page language="java" import="dsproject.*,java.util.*,java.io.*,org.jsoup.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<style>
	.container{
		display:flex;
		flex-wrap:wrap;
		width:1600px;
		height:1500px;
		background-color:skyblue;
	}
	.header{
		font-style:italic;
		font-weight:bold;
		height:100px;
		width:1600%;
		background-color:#ABFFFF;
		text-align:center;
		
	}
	.result{
		background-color:#ABFFFF;
		width:1600px;
		height:1400px;
		margin-top:0px;
	}
</style>
<body>
<form action='${requestUri}' method='get'>
	<div class="container">
		<div class="header">
			<h1>搜尋結果</h1>
			<hr>
		</div>
		<div class="result">
		<%
		String str=(String) request.getAttribute("str");
		
		List<WebTree> tlst = new ArrayList<WebTree>();//存放每棵樹root的list
//		List<HashMap> rankwebs = new ArrayList<HashMap>();
		
		try {

//----------匯入Google網頁-----------------------------------------------------//
			GoogleQuery o =new GoogleQuery(str);
			HashMap<String,String> goo = o.query();

			
			//分析google網頁
			for(String key : goo.keySet()) {
				String url = goo.get(key);
				
				if(url.indexOf("&")!=-1) {
					url = url.substring(url.indexOf("h") , url.indexOf("&"));
					}
				else {
					url = url.substring(url.indexOf("h"));
				}
				
				
				WebPage rootPage = new WebPage(url, key);
				WebTree t = new WebTree(rootPage);
				tlst.add(t);
				%>
				
				<%out.println(key+","+url);%>
				<br><br>
			<%				//印出主網頁的Keyword List(分析網頁的結果)
				
			}
			%>
		
			<%
			for (WebTree t : tlst) {
//				t.root.webPage.getKeywordsList();//得到每個WebPage的Keywordlst
				
				//建立每個主網頁的樹(第一層)，同時算出每個節點網頁內容的關鍵字數量
				UrlCrawler u = new UrlCrawler(t.root.webPage.url);
				t.root.addSublinksChildren(u.query());
				
				
				//建立每個主網頁的樹(第二層)，同時算出每個節點網頁內容的關鍵字數量
				UrlCrawler c1 = new UrlCrawler(t.root.children.get(0).webPage.url);
				t.root.children.get(0).addSublinksChildren(c1.query());
				
				UrlCrawler c2 = new UrlCrawler(t.root.children.get(1).webPage.url);
				t.root.children.get(1).addSublinksChildren(c2.query());
				
				}

		}
		
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		%>
		</div>
	</div>
</form>
</body>
</html>