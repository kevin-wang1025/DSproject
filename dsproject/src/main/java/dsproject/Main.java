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

public class Main {
	public static void main(String[] args) throws IOException{
		List<WebTree> tlst = new ArrayList<WebTree>();//存放每棵樹root的list
//		List<HashMap> rankwebs = new ArrayList<HashMap>();
		
		//使用者輸入關鍵字
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入搜尋關鍵字：");
		
		try {

//----------匯入Google網頁-----------------------------------------------------//
			GoogleQuery o =new GoogleQuery(input.nextLine());
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
/*----------匯入Gomaji網頁-----------------------------------------------------//
			GomajiQuery m =new GomajiQuery(input.nextLine());
			HashMap<String,String> gom = m.query();
			hamlst.add(gom);
			
			for(String key : gom.keySet()) {
				String url = gom.get(key);
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
				for(Keyword k : rootPage.getKeywordsList()) {
					System.out.println(k.toString());
				}
				
				//建立每個主網頁的樹(第一層)，同時算出每個節點網頁內容的關鍵字數量
				UrlCrawler u = new UrlCrawler(url);
				t.root.addSublinksChildren(u.query());
				
				
				//建立每個主網頁的樹(第二層)，同時算出每個節點網頁內容的關鍵字數量
				UrlCrawler c1 = new UrlCrawler(t.root.children.get(0).webPage.url);
				t.root.children.get(0).addSublinksChildren(c1.query());
				if(t.root.children.size()>1) {
					UrlCrawler c2 = new UrlCrawler(t.root.children.get(1).webPage.url);
					t.root.children.get(1).addSublinksChildren(c2.query());
				}
				
				}
//----------匯入Ptt網頁--------------------------------------------------------//
			PttQuery g = new PttQuery(input.nextLine());
			HashMap<String, String> ptt = g.query();
			hamlst.add(ptt);
			
			for(String key : ptt.keySet()) {
				String url = ptt.get(key);
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
				rootPage.getKeywordsList();//算出keywords個數並印出來
				//印出主網頁的Keyword List(分析網頁的結果)
				
				//建立每個主網頁的樹(第一層)，同時算出每個節點網頁內容的關鍵字數量
				UrlCrawler u = new UrlCrawler(url);
				t.root.addSublinksChildren(u.query());
				
				
				//建立每個主網頁的樹(第二層)，同時算出每個節點網頁內容的關鍵字數量
				if(t.root.children != null) {
					UrlCrawler c1 = new UrlCrawler(t.root.children.get(0).webPage.url);
					t.root.children.get(0).addSublinksChildren(c1.query());
					
					if(t.root.children.size()>1) {
						UrlCrawler c2 = new UrlCrawler(t.root.children.get(1).webPage.url);
						t.root.children.get(1).addSublinksChildren(c2.query());
					}
				}
				
				}
	*/		
//----------匯入Kklook網頁--------------------------------------------------------//
			//Kklook會擋爬蟲
			
//----------匯入Pixnet網頁--------------------------------------------------------//
//			PixQuery g = new PixQuery(input.nextLine());
		
				
	}
		
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}