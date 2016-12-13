package index;

import java.util.ArrayList;

import data.Tweet;
import persistence.xml.XMLPersistence;

public class TestIndexer {

	public static void main(String[] args) {

		Indexer indexer = new Indexer();
		
		ArrayList<Tweet> corpus = XMLPersistence.readTweet("tweetsEN.xml");
		
		indexer.generateIndex(corpus);

		System.out.println(indexer.getIndex().get("I").frequency);
	}

}
