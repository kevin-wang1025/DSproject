package dsproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import dsproject.UrlCrawler;

public class Main {

	public static void main(String[] args) {
		ArrayList<WebTree> tlst = new ArrayList<WebTree>();//�s��C�ʾ�root��list
		//webRankList ranklst= new webRankList();
		//�ϥΪ̿�J����r
		Scanner input = new Scanner(System.in);
		System.out.println("�п�J�j�M����r�G");
		
		
		try {
			//System.out.println(new GoogleQuery(input.nextLine()).query());
			HashMap<String,String> goo = new GoogleQuery(input.nextLine()).query();
			for(String key : goo.keySet()) {
				String url = goo.get(key);
				//If-else �M�z�C��url������url
				if(url.indexOf("&")!=-1) {
					url = url.substring(url.indexOf("h") , url.indexOf("&"));
					}
				else {
					url = url.substring(url.indexOf("h"));
				}
				
				WebPage rootPage = new WebPage(url, key);
				WebTree t = new WebTree(rootPage);
				tlst.add(t);//�N���s�ت���s�Jtlst
			}
			
			for (WebTree t : tlst) {
				try {
					//Get root score
//					t.root.nodeScore = t.root.webPage.setScore();
					//getkwlst()�Ψ�����C��webPage������keyword List(�]�tname, count, weight)
					//setScore()�G�Ngetkwlst��o������keyword List ��X�`��
					
					//�[�J�Ĥ@�h���p��
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
					
					//addSublinksChildren�G�۳Ъ�method�A�Ψӥ[�J�C��tree���l����
					//�[�J�Ĥ@�Ӥp�Ī��p�ġ]��ӡ^
					/*UrlCrawler c1 = new UrlCrawler(t.root.children.get(0).webPage.url);
					t.root.children.get(0).addSublinksChildren(c1.query());
					*/
					//�[�J�ĤG�Ӥp�Ī��p�ġ]��ӡ^
					/*UrlCrawler c2 = new UrlCrawler(t.root.children.get(1).webPage.url);
					t.root.children.get(1).addSublinksChildren(c2.query());
					*/
					//�p��Ӵʾ��`��
					t.setPostOrderScore(t.root.webPage.getkwlst());
					//System.out.println(t.root.nodeScore);
				}catch (IOException e) {
					continue;
				}
			}
			//�Ƨ�tlst�A�o��̲׵��G(�ϥ�quick Sort)
			sortTrees st = new sortTrees();
			st.tlst = tlst; 
			st.sort();
			//����
			for(WebTree w : st.tlst) {
				System.out.println(w.root.webPage.name +"," +w.root.nodeScore);
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}