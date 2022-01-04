package dsproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.*;
import java.util.Date;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KklookQuery {

	public String searchKeyword;

	public String url;

	public String content;

	public KklookQuery(String searchKeyword)

	{
		this.searchKeyword = searchKeyword;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        
		this.url = "https://www.klook.com/zh-TW/search/result/?query="+searchKeyword+"&price_to=1500&currency=TWD&sort=most_relevant&start_time="+today+"T00%3A00%3A00Z";
//        this.url = "https://www.klook.com/zh-TW/search/result/?query="+searchKeyword+"&price_to=1500&currency=TWD&sort=most_relevant&start_time="+today+"T00%3A00%3A00Z";
		//20：單筆頁面呈現20筆資料
		//searchkeyword：搜尋bar中放的文字

	}

	

	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
		
//		conn.setConnectTimeout(1000*7);

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
	public HashMap<String, String> query() throws IOException

	{

		if(content==null)

		{

			content= fetchContent();

		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		
		
//		System.out.println(doc.text());
		Elements lis = doc.select("div");
//		 System.out.println(lis);
//原始碼存在lis裡面
		lis = lis.select(".kCrYT");
		//用.kCrYT這個class去過濾出子網頁
//		 System.out.println(lis.size());
		
		while(retVal.size()<10) {//爬出20筆資料
			for(Element li : lis)
			{
				try 

				{
					String citeUrl = li.select("a").get(0).attr("href");
					//再過一層濾出url
					String title = li.select("a").get(0).select(".vvjwJb").text();
					//存title的標籤
					if(title.equals("")) {
						continue;
						//去掉"地圖"
					}
					System.out.println(title + ","+citeUrl);
					retVal.put(title, citeUrl);

				} catch (IndexOutOfBoundsException e) {

//					e.printStackTrace();

				}

			}

		}
		
		return retVal;

	}

}
