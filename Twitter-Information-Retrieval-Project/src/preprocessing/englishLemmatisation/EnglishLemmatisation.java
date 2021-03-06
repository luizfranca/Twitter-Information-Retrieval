package preprocessing.englishLemmatisation;

import java.util.ArrayList;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class EnglishLemmatisation {

	public static ArrayList<String> getLemmas(String text) {
		
		ArrayList<String> lemmas = new ArrayList<String>();
		
		Properties props = new Properties(); 
        props.put("annotators", "tokenize, ssplit, pos, lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props, false);
         
        Annotation document = pipeline.process(text);
        
        for(CoreMap sentence: document.get(SentencesAnnotation.class))
        {   
            for(CoreLabel token: sentence.get(TokensAnnotation.class))
            {         
                String lemma = token.get(LemmaAnnotation.class);
                
                lemmas.add(lemma);
            }
        }
		return lemmas;
	}
	
	public static ArrayList<String> getLemmas(ArrayList<String> tokens) {
		
		String text = "";
	
		for (String string : tokens) {
			text += string + " ";
		}
		
		ArrayList<String> lemmas = new ArrayList<String>();
		
		Properties props = new Properties(); 
        props.put("annotators", "tokenize, ssplit, pos, lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props, false);
         
        Annotation document = pipeline.process(text);
        
        for(CoreMap sentence: document.get(SentencesAnnotation.class))
        {   
            for(CoreLabel token: sentence.get(TokensAnnotation.class))
            {         
                String lemma = token.get(LemmaAnnotation.class);
                
                lemmas.add(lemma);
            }
        }
		return lemmas;
	}
}