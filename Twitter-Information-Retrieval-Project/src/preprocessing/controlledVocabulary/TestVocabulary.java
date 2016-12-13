package preprocessing.controlledVocabulary;

import java.util.ArrayList;
import java.util.Collections;

import data.Tweet;
import persistence.xml.XMLPersistence;

public class TestVocabulary {

	public static void main(String[] args) {
		Vocabulary v = new Vocabulary();
		
		ArrayList<Tweet> corpus = XMLPersistence.readTweet("tweetsEN.xml");
		
		v.process(corpus);
		
		System.out.println("Size of corpus: " + corpus.size());
		System.out.println("Number of terms: " + v.getTerms().size());
		
		ArrayList<Integer> freq = new ArrayList<Integer>(v.getTerms().values());
		
		Collections.sort(freq);
		
		System.out.println("first: " + freq.get(v.getTerms().size() - 1));
	}
}
