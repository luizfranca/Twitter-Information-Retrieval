package preprocessing.controlledVocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.Tweet;
import preprocessing.englishLemmatisation.EnglishLemmatisation;
import preprocessing.stopWordsRemover.StopWordsRemover;
import preprocessing.tokenizer.Tokenizer;

public class Vocabulary {
	
	/*
	 * https://github.com/vdurmont/emoji-java/blob/master/LICENSE.md
	 */

	Map<String, Integer> terms;
	
	public Vocabulary() {
		this.terms = new HashMap<String, Integer>();
	}
	
	private ArrayList<String> preprocess(String text) {
		
		ArrayList<String> tokens = Tokenizer.tokenize(text);
		
		ArrayList<String> tokenNoStopWords = StopWordsRemover.removeStopWords(tokens, "stopwordslistOrigianl.txt");
		
		ArrayList<String> lemmas = EnglishLemmatisation.getLemmas(tokenNoStopWords);
		
		return lemmas;
	}
	
	public void process(ArrayList<Tweet> corpus) {
		for (Tweet tweet : corpus) {
			ArrayList<String> terms = preprocess(tweet.getContent());
			
			tweet.setAnalyzed(terms);
			
			for (String term : terms) {
				Integer freq = this.terms.get(term); 
				
				this.terms.put(term, (freq == null) ? 1 : freq + 1);
			}
		}
	}
	
	public Map<String, Integer> getTerms() {
		return this.terms;
	}
}