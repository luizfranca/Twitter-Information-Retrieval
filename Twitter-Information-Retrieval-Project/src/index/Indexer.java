package index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import data.Post;
import data.Tweet;
import preprocessing.controlledVocabulary.Vocabulary;
import preprocessing.preprocessEnglish.PreprocessEnglish;

public class Indexer {

	Map<String, ArrayList<Post>> indexes;
	ArrayList<Tweet> tweets;
	public Vocabulary vocabulary;
	
	public Indexer(ArrayList<Tweet> tweets) {
		this.indexes = new HashMap<String, ArrayList<Post>>();	
		this.vocabulary = new Vocabulary();
		this.tweets = tweets;
	}
	
	public void generateIndex(ArrayList<Tweet> tweets) {
		
		this.tweets = tweets;
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
	
	public ArrayList<Tweet> search(String query) {
		
		ArrayList<String> tokens = PreprocessEnglish.preprocess(query);
		
		if (tokens.size() == 0) {
			
			return new ArrayList<Tweet>();
		}
		
		ArrayList<Post> posts = new ArrayList<Post>();
		
		for (String string : tokens) {
			ArrayList<Post> p = indexes.get(string);
			if (p != null && p.size() > 0) {
				posts.addAll(indexes.get(string));
			}
		}
		
		Map<Integer, Float> aux = new HashMap<Integer, Float>();
		
		for (Post post : posts) {	
			Float if_idf = aux.get(post.getDocID());
			aux.put(post.getDocID(), if_idf == null ? post.getTf_idf() : if_idf + post.getTf_idf());
		}
		
		ArrayList<Tweet> result = new ArrayList<Tweet>();
		
		for (Integer tweetID : aux.keySet()) {
			result.add(this.tweets.get(tweetID));
		}
		
		Collections.sort(result, new Comparator<Tweet>() {
			@Override
			public int compare(Tweet o1, Tweet o2) {
				
				int compare = Double.compare(aux.get(o1.getId()), aux.get(o2.getId()));
				return compare;
			}

	    });
		
		Collections.reverse(result);
		
		return result;		
	}

	public Map<String, ArrayList<Post>> getIndexes() {
		return indexes;
	}

	public void setIndexes(Map<String, ArrayList<Post>> indexes) {
		this.indexes = indexes;
	}
}
