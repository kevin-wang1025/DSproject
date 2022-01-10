package FinalProject;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

public class WordCounter {
	private String urlStr;
    private String content;
    
    public WordCounter(String urlStr){
    	this.urlStr = urlStr;
    }
    
    private String fetchContent() throws IOException{
    	this.urlStr = URLDecoder.decode(this.urlStr , "utf-8");
    	
    	
    	URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
		String retVal = "";
	
		String line = null;
		
		while ((line = br.readLine()) != null){
//			System.out.println(line);
		    retVal = retVal + line + "\n";
		}
		
		
		return retVal;
    }
    
    public int countKeyword(String keyword) throws IOException{
		if (content == null){
		    content = fetchContent();//把html文件化
		}
		
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
	
		//hw
		int retVal = 0;//找到個數
		int fromIdx = 0;//從哪個開始搜尋
		int found = -1;//找到的位置
	
		while ((found = content.indexOf(keyword, fromIdx)) != -1){
		   retVal++;
		   fromIdx = found + keyword.length();
		}
	    //
		
		return retVal;
    }
}