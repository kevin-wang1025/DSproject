package dsproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WebNode {
	public WebNode parent;
	public ArrayList<WebNode> children;
	public WebPage webPage;	//child element
	public double nodeScore;//main element This node's score += all its childrens nodeScore
	
	public WebNode(WebPage webPage){
		this.webPage = webPage;
		this.children = new ArrayList<WebNode>();
	}
	
	public void setNodeScore(ArrayList<Keyword> keywords) throws IOException{
		//this method should be called in post-order mode
		
		//**compute webPage score
		webPage.setScore();
		//**set webPage score to nodeScore
		nodeScore = webPage.score;
		
		
		//**nodeScore += all childrens nodeScore 
		for(WebNode child : children){
			nodeScore += child.nodeScore;
		}
		
				
			
	}
	
	public void addChild(WebNode child){
		//add the WebNode to its children list
		this.children.add(child);
		child.parent = this;
	}
	
	public boolean isTheLastChild(){
		if(this.parent == null) return true;
		ArrayList<WebNode> siblings = this.parent.children;
		
		return this.equals(siblings.get(siblings.size() - 1));
	}
	
	public int getDepth(){
		int retVal = 1;
		WebNode currNode = this;
		while(currNode.parent!=null){
			retVal ++;
			currNode = currNode.parent;
		}
		return retVal;
	}

	public void addSublinksChildren(HashMap<String, String> m) throws IOException{
		for(String k : m.keySet()) {
			if(children.size()<2) {
				addChild(new WebNode(new WebPage(m.get(k) ,k)));
				//System.out.println("第"+getDepth()+"層"+"第"+children.size()+"個小孩:"+k+","+m.get(k));
				}
			else {break;}	
			}
		}
	
	public void printkwlst(ArrayList<Keyword> kwlst) {
		for(Keyword k : kwlst ) {
			System.out.println(k.toString());
		}
		
	}
}

