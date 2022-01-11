package FinalProject;

import java.util.ArrayList;

public class sortTrees {
	public ArrayList<WebTree> tlst;
	
	public sortTrees() {
		this.tlst = new ArrayList<WebTree>();
	}
	
	public void add(WebTree t) {
		tlst.add(t);
	}
	public void sort() {
		if(tlst.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			quickSort(0,tlst.size()-1);
//			System.out.println("Done");
		}
	}
	
	private void quickSort(int leftbound, int rightbound){
	
		if (leftbound < rightbound) 
		{
			int i = (leftbound-1);
			
			for (int j = leftbound; j <= rightbound - 1; j++) 
			{
				if (tlst.get(j).root.nodeScore > tlst.get(rightbound).root.nodeScore) 
				{
//					System.out.println(j+" "+rightbound+" "+lst.get(j).count);
					i++;
					swap(i , j);
				}
			}
			swap((i+1), rightbound);

			quickSort(leftbound, i);
			quickSort(i + 2, rightbound);
		}

	}
	private void swap(int aIndex, int bIndex){
		WebTree temp = tlst.get(aIndex);
		tlst.set(aIndex, tlst.get(bIndex));
		tlst.set(bIndex, temp);
	}
	
	
	public void output(){
		//TODO: write output and remove all element logic here...
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<tlst.size();i++){
			WebTree k = tlst.get(i);
			if(i>0)sb.append(" ");
			sb.append(k.toString());
		}
		
		System.out.println(sb.toString());	
	}
}
