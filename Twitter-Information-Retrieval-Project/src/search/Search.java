package search;

import java.util.ArrayList;
import java.util.Scanner;

import data.Post;
import data.Tweet;
import index.Indexer;
import persistence.xml.XMLPersistence;
import preprocessing.englishLemmatisation.EnglishLemmatisation;
import preprocessing.stopWordsRemover.StopWordsRemover;
import preprocessing.tokenizer.Tokenizer;

public class Search {

	static Indexer indexer;
	
	public static void main(String[] args) {
		indexer = new Indexer(XMLPersistence.readTweet("tweetsEN20.xml"));
		indexer.setIndexes(XMLPersistence.readIndexes("Indexes20.xml"));
		
		System.out.println("Digite sua pesquisa: ");
		Scanner in = new Scanner(System.in);
		
		String query = in.nextLine();
		
		ArrayList<Tweet> tweets = indexer.search(query);
		
		System.out.println("Number of results: " + tweets.size());
		
		for (int i = 0; i < 20 && i < tweets.size(); i++) {
			System.out.println(tweets.get(i).toString());
		}
	}
}
