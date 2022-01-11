package FinalProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import FinalProject.UrlCrawler;

public class Main {

	public static void main(String[] args) {
		ArrayList<WebTree> tlst = new ArrayList<WebTree>();//存放每棵樹root的list
		//webRankList ranklst= new webRankList();
		//使用者輸入關鍵字
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入搜尋關鍵字：");
		
		try {
			//System.out.println(new GoogleQuery(input.nextLine()).query());
			HashMap<String,String> goo = new GoogleQuery(input.nextLine()).query();
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
					/*HashMap<String, String> m = u.query();
					//System.out.println(m);??//{=https://icook.tw/login}
					
					for(String k : m.keySet()) {
							if(t.root.children.size()<2) {
								t.root.addChild(new WebNode(new WebPage(m.get(k) ,k)));
								//System.out.println(k+","+m.get(k));
							}
							else {break;}	
					}*/
					
					//addSublinksChildren：自創的method，用來加入每個tree的子網頁
					//加入第一個小孩的小孩（兩個）
					/*UrlCrawler c1 = new UrlCrawler(t.root.children.get(0).webPage.url);
					t.root.children.get(0).addSublinksChildren(c1.query());
					*/
					//加入第二個小孩的小孩（兩個）
					/*UrlCrawler c2 = new UrlCrawler(t.root.children.get(1).webPage.url);
					t.root.children.get(1).addSublinksChildren(c2.query());
					*/
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
				System.out.println(w.root.webPage.name +"," +w.root.nodeScore);
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
