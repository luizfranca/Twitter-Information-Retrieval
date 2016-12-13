package index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.Tweet;

public class Indexer {

	Map<String, Index> index;
	
	public Indexer() {
		this.index = new HashMap<String, Index>();		
	}
	
	public void generateIndex(ArrayList<Tweet> tweets) {
		for (Tweet tweet : tweets) {
			
//			this.index.put(a, (freq == null) ? 1 : freq + 1);
		}
	}
}
