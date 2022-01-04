package dsproject;

import java.util.*;

public class KeywordList {

	public LinkedList<Keyword> lst;

	// 穝跑计LinkedList柑杆Keywordname琌lst
	public KeywordList() {// KeywordListmethod
		this.lst = new LinkedList<Keyword>();
		// 硂よ猭柑lst琌newLinkedList
	}

	public void add(Keyword keyword) {
		// add keyword to proper index base on its count . DECENDING SORT(经猭) BY COUNT
		// AND WEIGHT
		//printKeywordList(lst): : you can check if elements are sorted
		for (int i = 0; i < lst.size(); i++) {
			Keyword k = lst.get(i);
			if (keyword.count <= k.count) {// 狦countゑセ碞璶玡,狦count单碞璶ゑweight
				if (keyword.count < k.count) {
					lst.add(i, keyword);
					//printKeywordList(lst);
					return;
				} else if (keyword.count == k.count && keyword.weight <= k.weight) {// count单,weight玡
					lst.add(i, keyword);
					//printKeywordList(lst);
					return;
				}
			}
		}
		lst.add(keyword);
		//printKeywordList(lst);

	}

	public void outputIndex(int i) {
		if (i > lst.size()) {
			System.out.println("InvalidOperation");
			return;
		}
		Keyword k = lst.get(i);
		System.out.println(k);
	}

	public void outputCount(int c) {
		LinkedList<Keyword> results = new LinkedList<>();
		for (int i = 0; i < lst.size(); i++) {
			Keyword k = lst.get(i);
			if (k.count == c) {
				results.add(k);
			}
		}
		if (results.isEmpty()) {
			System.out.println("NotFound");
		} else {
			printKeywordList(results);
		}
	}

	public void outputHas(String pattern) {
		LinkedList<Keyword> results = new LinkedList<>();
		for (int i = 0; i < lst.size(); i++) {
			Keyword k = lst.get(i);
			if (k.name.contains(pattern)) {
				results.add(k);
			}
		}
		if (results.isEmpty()) {
			System.out.println("NotFound");
		} else {
			printKeywordList(results);
		}
	}

	public void outputName(String pattern) {

		LinkedList<Keyword> results = new LinkedList<>();
		for (int i = 0; i < lst.size(); i++) {
			Keyword k = lst.get(i);
			if (k.name.equals(pattern)) {
				results.add(k);
			}
		}
		if (results.isEmpty()) {
			System.out.println("NotFound");
		} else {
			printKeywordList(results);
		}
	}

	public void outputFirstN(int n) {
		if (n > lst.size()) {
			System.out.println("InvalidOperation");
			return;
		}

		LinkedList<Keyword> found = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			Keyword k = lst.get(i);
			found.add(k);
		}

		printKeywordList(found);

	}

	public void outputScore() {
		float results = 0;
		for (int i = 0; i < lst.size(); i++) {
			Keyword k = lst.get(i);	
			results +=(k.weight*k.count);
			}
			// 1.To calculate all keyword's count*weight
			// results += ;
		System.out.println(results);
		}



public void deleteIndex(int i) {

	if (i >= lst.size()) {
		return;
	}

	lst.remove(i);
}

public void deleteCount(int c) {
	// 2. remove nodes that the count is equal to c
	LinkedList<Keyword> found = new LinkedList<>();
	for (int i=0; i<lst.size() ;i++) {
		if(lst.get(i).count==c) {
			found.add(lst.get(i));
		}
	}
	//System.out.println(found);
	if (!found.isEmpty()) {
		lst.removeAll(found);
	}
}

public void deleteHas(String pattern) {
	// 3. remove nodes that the name contains input name
	
	LinkedList<Keyword> found = new LinkedList<>();
	for (int i=0; i< lst.size(); i++) {
		if(lst.get(i).name == pattern) {
			found.add(lst.get(i));
			}
		}
	//System.out.println(found);
	if (!found.isEmpty()) {
		lst.removeAll(found);
	}

}

public void deleteName(String name) {
	// 4. remove nodes that the name is equal to input name
	LinkedList<Keyword> found = new LinkedList<>();
	for (int i =0; i<lst.size();i++) {
		if(lst.get(i).name==name) {
			found.add(lst.get(i));
		}
	}
	
	if (!found.isEmpty()) {
		lst.removeAll(found);
		//System.out.println(lst);
	}
	
}

public void deleteFirstN(int n) {
	// 5. remove first n nodes
	LinkedList<Keyword> found = new LinkedList<>();
	for(int i=0; i<=n;i++) {
			found.add(lst.get(i));
			//System.out.println(found);
		}
	if (!found.isEmpty()) {
		lst.removeAll(found);
	}
	//System.out.println(lst);

}

public void deleteAll() {
	lst = new LinkedList<Keyword>();
}

public void printKeywordList(LinkedList<Keyword> KLst) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < KLst.size(); i++) {
		Keyword k = KLst.get(i);
		if (i > 0)
			sb.append(" ");
		sb.append(k.toString());
	}
	System.out.println(sb.toString());
}
}
