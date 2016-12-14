package index;

import java.util.ArrayList;
import java.util.Map;

import data.Post;
import data.Tweet;
import persistence.xml.XMLPersistence;

public class TestIndexer {

	public static void main(String[] args) throws Exception {

		// use this to test the function that generate the indexes
//		testGenerateIndex();
		
		// use this to test the reading of previously generated indexes
		testReadfromIndexedFile();
	}

	static void testReadfromIndexedFile() {
		ArrayList<Tweet> corpus = XMLPersistence.readTweet("tweetsEN20.xml");
		
		Map<String, ArrayList<Post>> indexes = XMLPersistence.readIndexes("Indexes.xml");
		
		Indexer indexer = new Indexer(corpus);
		indexer.setIndexes(indexes);

		System.out.println("Size: " + indexer.getIndexes().size());
	}
	
	static void testGenerateIndex() throws Exception {
		ArrayList<Tweet> corpus = XMLPersistence.readTweet("tweetsEN20.xml");
		
		Indexer indexer = new Indexer(corpus);
		
		indexer.generateIndex(corpus);

		System.out.println("Size: " + indexer.getIndexes().size());
		XMLPersistence.saveIndex(indexer.getIndexes(), "Indexes20.xml");
	}
}
