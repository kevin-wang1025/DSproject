package dsproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UrlCleaner {
	public String title;
	public String url;
	
	public UrlCleaner(String title, String url) {
		this.title = title ; 
		this.url = url; 
	}
	
	public String gettitle() {
		return title;
	}
	
	public String geturl() {
		return url;
	}
	
	public void print() {
		System.out.println("["+title+","+url+"]");
	}
}
