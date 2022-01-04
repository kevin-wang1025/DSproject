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
		List<WebTree> tlst = new ArrayList<WebTree>();//�s��C�ʾ�root��list
//		List<HashMap> rankwebs = new ArrayList<HashMap>();
		
		//�ϥΪ̿�J����r
		Scanner input = new Scanner(System.in);
		System.out.println("�п�J�j�M����r�G");
		
		try {

//----------�פJGoogle����-----------------------------------------------------//
			GoogleQuery o =new GoogleQuery(input.nextLine());
			HashMap<String,String> goo = o.query();

			
			//���Rgoogle����
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
				//�L�X�D������Keyword List(���R���������G)
				
			}
			
			for (WebTree t : tlst) {
//				t.root.webPage.getKeywordsList();//�o��C��WebPage��Keywordlst
				
				//�إߨC�ӥD��������(�Ĥ@�h)�A�P�ɺ�X�C�Ӹ`�I�������e������r�ƶq
				UrlCrawler u = new UrlCrawler(t.root.webPage.url);
				t.root.addSublinksChildren(u.query());
				
				
				//�إߨC�ӥD��������(�ĤG�h)�A�P�ɺ�X�C�Ӹ`�I�������e������r�ƶq
				UrlCrawler c1 = new UrlCrawler(t.root.children.get(0).webPage.url);
				t.root.children.get(0).addSublinksChildren(c1.query());
				
				UrlCrawler c2 = new UrlCrawler(t.root.children.get(1).webPage.url);
				t.root.children.get(1).addSublinksChildren(c2.query());
				
				}
/*----------�פJGomaji����-----------------------------------------------------//
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
				//�L�X�D������Keyword List(���R���������G)
				for(Keyword k : rootPage.getKeywordsList()) {
					System.out.println(k.toString());
				}
				
				//�إߨC�ӥD��������(�Ĥ@�h)�A�P�ɺ�X�C�Ӹ`�I�������e������r�ƶq
				UrlCrawler u = new UrlCrawler(url);
				t.root.addSublinksChildren(u.query());
				
				
				//�إߨC�ӥD��������(�ĤG�h)�A�P�ɺ�X�C�Ӹ`�I�������e������r�ƶq
				UrlCrawler c1 = new UrlCrawler(t.root.children.get(0).webPage.url);
				t.root.children.get(0).addSublinksChildren(c1.query());
				if(t.root.children.size()>1) {
					UrlCrawler c2 = new UrlCrawler(t.root.children.get(1).webPage.url);
					t.root.children.get(1).addSublinksChildren(c2.query());
				}
				
				}
//----------�פJPtt����--------------------------------------------------------//
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
				rootPage.getKeywordsList();//��Xkeywords�ӼƨæL�X��
				//�L�X�D������Keyword List(���R���������G)
				
				//�إߨC�ӥD��������(�Ĥ@�h)�A�P�ɺ�X�C�Ӹ`�I�������e������r�ƶq
				UrlCrawler u = new UrlCrawler(url);
				t.root.addSublinksChildren(u.query());
				
				
				//�إߨC�ӥD��������(�ĤG�h)�A�P�ɺ�X�C�Ӹ`�I�������e������r�ƶq
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
//----------�פJKklook����--------------------------------------------------------//
			//Kklook�|�ת���
			
//----------�פJPixnet����--------------------------------------------------------//
//			PixQuery g = new PixQuery(input.nextLine());
		
				
	}
		
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}