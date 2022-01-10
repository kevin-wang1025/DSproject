package FinalProject;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;


public class UrlCrawler{

	public String url;

	public String content;

	public UrlCrawler(String url){

		this.url = url;
	}
	/*
	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null)
		{
			retVal += line;

		}
		return retVal;
	}
	*/
	public HashMap<String, String> query() throws IOException{
/*		
		if(content==null)

		{

			content= fetchContent();

		}
*/
		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.connect(url)
				.userAgent("Chrome/7.0.517.44")
			    .referrer("http://www.google.com")
			    .timeout(1000*7)
			    .ignoreHttpErrors(true) 
			    .get();
		Elements lis = doc.select("div");
		lis = lis.select("a[href]");
//		lis = lis.select(".kCrYT");
		
//		Document doc = Jsoup.parse(content);
//		System.out.println(doc.text());
		
//		System.out.println(lis);
		int numofwebpage = 0 ;
		if(lis!=null) {
			for(Element li : lis)
			{
				if(numofwebpage< 2) {//每次只抓前兩個子網頁作為小孩
					try 

					{
						String citeUrl = li.attr("abs:href");
						//再過一層濾出url
						String title = li.text();
						//存title的標籤
						
						if(citeUrl.indexOf("ht") ==-1 || title.equals(" ") ) {
							//citeUrl.indexOf("https") ==-1 || citeUrl.indexOf("http")==-1 || title.equals("")|| title.length()<10
							continue;
						}
//						System.out.println(title + ","+citeUrl);
						retVal.put(title, citeUrl);
						numofwebpage +=1;
					} catch (IndexOutOfBoundsException e) {

//						e.printStackTrace();

					}
				}
				else {break;}
			}
		}
			return retVal;
	}
		
}