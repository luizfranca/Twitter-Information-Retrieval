package preprocessing.tokenizer;

import java.io.StringReader;
import java.util.ArrayList;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;

public class Tokenizer {
	
	public static ArrayList<String> tokenize(String text) {
		StringReader stringReader = new StringReader(text);
		
		PTBTokenizer<CoreLabel> ptbt = new PTBTokenizer<>(stringReader, new CoreLabelTokenFactory(), "");
		
		ArrayList<String> tokens = new ArrayList<String>();
		
		while (ptbt.hasNext()) {
			tokens.add(ptbt.next().toString());
		}
		
		return tokens;
	}

}