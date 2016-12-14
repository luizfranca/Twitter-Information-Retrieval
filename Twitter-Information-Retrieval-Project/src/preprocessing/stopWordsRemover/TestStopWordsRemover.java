package preprocessing.stopWordsRemover;

import java.util.ArrayList;

public class TestStopWordsRemover {

	public static void main(String[] args) {
		
		ArrayList<String> tokens = new ArrayList<String>();
		tokens.add("this");
		tokens.add("is");
		tokens.add("a");
		tokens.add("text");
		
		System.out.println(StopWordsRemover.removeStopWords(tokens, "stopwordslistOrigianl.txt"));
	}

}
