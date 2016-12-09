package preprocessing.stopWordsRemover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StopWordsRemover {

	
	private static ArrayList<String> loadStopWords(String stopwords) {
		
		ArrayList<String> records = new ArrayList<String>();
		  try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(stopwords));
		    String line;
		    while ((line = reader.readLine()) != null)
		    {
		      records.add(line);
		    }
		    reader.close();
		    return records;
		  }
		  catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", stopwords);
		    e.printStackTrace();
		    return null;
		  }
	}
	
	public static ArrayList<String> removeStopWords(ArrayList<String> tokens, String stopwords) {
		
		ArrayList<String> stopWords = loadStopWords(stopwords);
		ArrayList<String> results = new ArrayList<String>();
		
		for (String token : tokens) {
			if (!stopWords.contains(token)) {
				results.add(token);
			}
		}
		
		return results;
	}
}