package index;

import java.util.ArrayList;
import java.util.Map;

import data.Post;
import data.Tweet;
import persistence.xml.XMLPersistence;

public class TestIndexer {

	public static void main(String[] args) throws Exception {

		Indexer indexer = new Indexer();
		
//		ArrayList<Tweet> corpus = XMLPersistence.readTweet("tweetsEN.xml");

		Map<String, ArrayList<Post>> indexes = XMLPersistence.readIndexes("Indexes.xml");
		indexer.setIndexes(indexes);
		
//		indexer.generateIndex(corpus);

//		System.out.println(indexer.vocabulary.getTerms().get("upload"));
	
		System.out.println(indexer.getIndexes().get("upload").get(0).getTf_idf());
		System.out.println(indexer.getIndexes().get("upload").get(0).getDocID());
		
//		XMLPersistence.saveIndex(indexer.getIndexes(), "Indexes.xml");
	}

}
