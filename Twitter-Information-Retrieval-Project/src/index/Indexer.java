package index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import data.Post;
import data.Tweet;
import preprocessing.controlledVocabulary.Vocabulary;

public class Indexer {

	Map<String, ArrayList<Post>> indexes;
	public Vocabulary vocabulary;
	
	public Indexer() {
		this.indexes = new HashMap<String, ArrayList<Post>>();	
		this.vocabulary = new Vocabulary();
	}
	
	public void generateIndex(ArrayList<Tweet> tweets) {
		
		this.vocabulary.process(tweets);
		
		for (String term : this.vocabulary.getTerms().keySet()) {
			ArrayList<Post> postingsList = new ArrayList<Post>();
			this.indexes.put(term, postingsList);
			
//			i.frequency = this.vocabulary.getTerms().get(term);
			
			for (Tweet tweet : tweets) {
				if (tweet.getAnalyzed().contains(term)) {
					 float tf = (float) Math.log(1 + termFrequency(tweet, term));
					 
					 float tf_idf = tf * this.vocabulary.getTerms().get(term);
					 
					 Post p = new Post(tf_idf, tweet.getId());
					 postingsList.add(p);
				}
			}
		}
	}
	
	// term frequency per document
	private float termFrequency(Tweet tweet, String term) {
		float freq = Collections.frequency(tweet.getAnalyzed(), term);
		float tf = freq / tweet.getAnalyzed().size(); 
		return tf;
	}

	public Map<String, ArrayList<Post>> getIndexes() {
		return indexes;
	}

	public void setIndexes(Map<String, ArrayList<Post>> indexes) {
		this.indexes = indexes;
	}
}
