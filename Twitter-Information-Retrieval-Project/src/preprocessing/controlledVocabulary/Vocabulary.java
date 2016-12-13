package preprocessing.controlledVocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.Tweet;
import preprocessing.englishLemmatisation.EnglishLemmatisation;
import preprocessing.preprocessEnglish.PreprocessEnglish;
import preprocessing.stopWordsRemover.StopWordsRemover;
import preprocessing.tokenizer.Tokenizer;

public class Vocabulary {
	
	/*
	 * https://github.com/vdurmont/emoji-java/blob/master/LICENSE.md
	 */

	// <Term, idf>
	Map<String, Float> terms;
	
	public Vocabulary() {
		this.terms = new HashMap<String, Float>();
	}
	
	public void process(ArrayList<Tweet> corpus) {
		int numDocuments = corpus.size();
		
		for (Tweet tweet : corpus) {
			ArrayList<String> terms = PreprocessEnglish.preprocess(tweet.getContent());
			
			tweet.setAnalyzed(terms);
			
			for (String term : terms) {
				this.terms.put(term, 0f);
			}
		}
		
		for (String term : this.terms.keySet()) {
			float freq = 0;
			
			for (Tweet tweet : corpus) {
				if (tweet.getAnalyzed().contains(term)) {
					freq ++;
				}
			}
			this.terms.put(term, freq);
		}
		
		for (String term : this.terms.keySet()) {
			float freq = this.terms.get(term);
			this.terms.put(term, (float) Math.log((numDocuments + 1 )/ freq));
		}
	}
	
	public Map<String, Float> getTerms() {
		return this.terms;
	}
}