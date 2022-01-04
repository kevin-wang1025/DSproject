package dsproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dsproject.WebNode;
import dsproject.WebPage;
import dsproject.WebTree;
import dsproject.Keyword;
import dsproject.KeywordList;
import dsproject.WordCounter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/aaa")
public class aaa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aaa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("searching")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("search.jsp").forward(request, response);
			return;
		}
		String str=request.getParameter("searching");
		request.setAttribute("str",str);
		request.getRequestDispatcher("back.jsp").forward(request, response);
		
		/*GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		HashMap<String, String> query = google.query();
		
		String[][] s = new String[query.size()][2];
		request.setAttribute("query", s);
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
		}*/
		
		//List<WebTree> tlst = new ArrayList<WebTree>();//存放每棵樹root的list
		//List<HashMap> rankwebs = new ArrayList<HashMap>();
		
		/*try {

//----------匯入Google網頁-----------------------------------------------------//
		GoogleQuery o =new GoogleQuery(request.getParameter("searching"));
		HashMap<String,String> goo = o.query();
		String[][] s = new String[goo.size()][2];
		request.setAttribute("goo", s);
		
		int num = 0;
		for(Entry<String, String> entry : goo.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
		}
			
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
				System.out.println("Webroot:"+key+","+url);
				//印出主網頁的Keyword List(分析網頁的結果)
				
				
			}
			
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
		
		
		request.getRequestDispatcher("back.jsp").forward(request, response); */
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
