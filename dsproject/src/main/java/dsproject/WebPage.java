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
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		score = 0;
//		3.calculate score??
		for(Keyword k : keywords){	
			score += (counter.countKeyword(k.name) * k.weight);
			//countkeyword:取得keyword的個數
		}
	}
	
	public ArrayList<Keyword> getKeywordsList() throws IOException {
		ArrayList<Keyword> kwlst = new ArrayList<Keyword>();
		
		File file = new File("Keywords.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()){
				String name = sc.next();
				float weight = sc.nextFloat();
				int count = new WordCounter(url).countKeyword(name);
				Keyword k = new Keyword(name,count,weight);
				System.out.println(k.toString());
				kwlst.add(k);
			}
			
	return kwlst;
}
	
}
