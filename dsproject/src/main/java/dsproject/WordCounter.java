package dsproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
	private String urlStr;
	private String content;
	public List<String> keywordslist = new ArrayList<String>();
	
	
	public WordCounter(String urlStr) {
		this.urlStr = urlStr;
	}

	
	private String fetchContent() throws IOException {
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String retVal = "";

		String line = null;

		while ((line = br.readLine()) != null) {
			retVal = retVal + line + "\n";
		}

		return retVal;
	}

	public int countKeyword(String keyword) throws IOException {
		if (content == null) {
			content = fetchContent();
		}
		// To do a case-insensitive search, we turn the whole content and keyword into
		// upper-case:
		
/*		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
*/
		int retVal = 0;
		int m = keyword.length();
		int n = content.length();
		int i =m-1;
		int j = m-1; 
		int l;
		
		while(i < n) {
			if (content.charAt(i) == keyword.charAt(j)) {
				if (j == 0) {
					retVal += 1;

				} else {
					i -= 1;
					j -= 1;
				}
				i = i + (m+1);
				//why m+1?
				return i;
			}

			else {// shift
				l = keyword.indexOf(content.charAt(i));
				j = m - 1;
				i = i + m - Math.min(j, 1 + l);
				
			}

		}
		return retVal;

		// 1. calculates appearances of keyword
	}
}

