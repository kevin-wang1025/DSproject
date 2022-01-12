package dsproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dsproject.Keyword;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	
	public WebPage(String url,String name){
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);	
	}
	
	public double setScore() throws IOException{
		score = 0;
		ArrayList<Keyword> keywords = getkwlst();
//		3.calculate score??
		for(Keyword k : keywords){	
			score += (k.count * k.weight);
			//countkeyword:取得keyword的個數
		}
		return score;
	}
	public ArrayList<Keyword> getkwlst() throws IOException {
		ArrayList<Keyword> kwlst = new ArrayList<Keyword>();
		//讀入Keywords檔案中設定好的關鍵字及權重
		File file = new File("C:\\Users\\10830\\Desktop\\Keywords.txt");
		Scanner sc = new Scanner(file);
		int score = 0 ;
		
		while(sc.hasNext()){
				String name = sc.next();
				float weight = sc.nextFloat();
				int count = new WordCounter(url).countKeyword(name);
				//score += count*weight;
				Keyword k = new Keyword(name,count,weight);
//				System.out.println(k.toString());//Print all keywords 
				kwlst.add(k);
			}
		//System.out.println(score);//測試
	return kwlst;
}

}