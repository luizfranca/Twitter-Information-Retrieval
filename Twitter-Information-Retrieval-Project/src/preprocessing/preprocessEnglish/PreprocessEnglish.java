package preprocessing.preprocessEnglish;

import java.util.ArrayList;

import preprocessing.englishLemmatisation.EnglishLemmatisation;
import preprocessing.stopWordsRemover.StopWordsRemover;
import preprocessing.tokenizer.Tokenizer;

public class PreprocessEnglish {

	public static ArrayList<String> preprocess(String text) {
		
		ArrayList<String> tokens = Tokenizer.tokenize(text);
		
		ArrayList<String> tokenNoStopWords = StopWordsRemover.removeStopWords(tokens, "stopwordslistOrigianl.txt");
		
		ArrayList<String> lemmas = EnglishLemmatisation.getLemmas(tokenNoStopWords);
		
		return lemmas;
	}
	
}
