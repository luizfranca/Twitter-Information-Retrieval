package index;

import java.util.ArrayList;
import java.util.Map;

import data.Tweet;
import persistence.xml.XMLPersistence;

public class TestIndexer {

	public static void main(String[] args) throws Exception {

		Indexer indexer = new Indexer();
		
//		ArrayList<Tweet> corpus = XMLPersistence.readTweet("tweetsEN.xml");

		Map<String, Index> indexes = XMLPersistence.readIndexes("Indexes.xml");
		indexer.setIndexes(indexes);
		
//		indexer.generateIndex(corpus);

		System.out.println(indexer.getIndexes().get("upload").frequency);
		System.out.println(indexer.getIndexes().get("upload").getPostingsList());
		
//		XMLPersistence.saveIndex(indexer.getIndexes(), "Indexes.xml");
	}

}
