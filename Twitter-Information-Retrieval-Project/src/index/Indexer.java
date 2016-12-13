package index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import data.Tweet;
import preprocessing.controlledVocabulary.Vocabulary;

public class Indexer {

	Map<String, Index> indexes;
	Vocabulary vocabulary;
	
	public Indexer() {
		this.indexes = new HashMap<String, Index>();	
		this.vocabulary = new Vocabulary();
	}
	
	public void generateIndex(ArrayList<Tweet> tweets) {
		
		this.vocabulary.process(tweets);
		
		for (String term : this.vocabulary.getTerms().keySet()) {
			Index i = new Index();
			this.indexes.put(term, i);
			
			i.frequency = this.vocabulary.getTerms().get(term);
			
			for (Tweet tweet : tweets) {
				if (tweet.getAnalyzed().contains(term)) {
//					 int freq = Collections.frequency(tweet.getAnalyzed(), term);
					 i.postingsList.add(tweet.getId());
				}
			}
		}
	}

	public Map<String, Index> getIndexes() {
		return indexes;
	}

	public void setIndexes(Map<String, Index> indexes) {
		this.indexes = indexes;
	}
}
