package dsproject;

import java.io.IOException;
import java.util.ArrayList;


public class WebTree {
	public WebNode root;
	
	public WebTree(WebPage rootPage){
		this.root = new WebNode(rootPage);
	}
	
	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException{
		setPostOrderScore(root, keywords);
	}
	
	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) throws IOException{
		//1.compute the score of children nodes postorder
		for(WebNode child : startNode.children){
			setPostOrderScore(child, keywords);
		}
		//**setNode score of startNode
		startNode.setNodeScore(keywords);
		}

		
	/*public double postOrder(WebNode root) {
		double totalscore = 0;
		if (root == null) return 0;
		if(root.children.get(0) != null) {
			postOrder(root.children.get(0));
			totalscore += root.children.get(0).webPage.score;
			if(root.children.get(1)!=null) {
				postOrder(root.children.get(1));
				totalscore += root.children.get(1).webPage.score;
			}
		}
		return totalscore;
	}*/

	private String repeat(String str,int repeat){
		String retVal  = "";
		for(int i=0;i<repeat;i++){
			retVal+=str;
		}
		return retVal;
	}
}