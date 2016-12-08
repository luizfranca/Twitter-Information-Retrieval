package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import data.Tweet;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.TokenizerAnnotator;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.util.CoreMap;
import gate.AnnotationSet;
import gate.Corpus;
import gate.DataStore;
import gate.Document;
import gate.DocumentContent;
import gate.Factory;
import gate.FeatureMap;
import gate.Gate;
import gate.LanguageResource;
import gate.Resource;
import gate.creole.ExecutionException;
import gate.creole.ResourceInstantiationException;
import gate.creole.annic.apache.lucene.analysis.Token;
//import gate.creole.annic.apache.lucene.analysis.Tokenizer;
import gate.event.DocumentListener;
import gate.event.ProgressListener;
import gate.persist.PersistenceException;
import gate.twitter.Normaliser;
import gate.twitter.tokenizer.TokenizerEN;
import gate.util.InvalidOffsetException;
import persistence.englishLemmatization.EnglishLemmatization;
import persistence.xml.XMLPersistence;
import preprocessing.tokenizer.Tokenizer;

import java.io.FileReader;
import java.io.IOException;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;

import java.util.*; 
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*; 
import edu.stanford.nlp.ling.CoreAnnotations.*; 

public class Test2 {

	public static void main(String[] args) throws FileNotFoundException, ResourceInstantiationException {

		// ArrayList<String> args = new ArrayList<String>();
//		args = new String[] { "exemplo de texto para textar o texto @MrNobre https://t.co/ux57Tgi10F", "For me, my bed is the best place in the world followed by Chicago. I miss the time where they were in the same place #exemple #exemple-legal outro,teste,legal,separa,pfv1 aren’t" };
		
//		for (String arg : args) {
//			// option #1: By sentence.
//			
//			StringReader a = new StringReader(arg);
////			DocumentPreprocessor dp = new DocumentPreprocessor(a);
////			for (List<HasWord> sentence : dp) {
////				System.out.println(sentence);
////			}
//			// option #2: By token
//			PTBTokenizer<CoreLabel> ptbt = new PTBTokenizer<>(a, new CoreLabelTokenFactory(), "");
//			while (ptbt.hasNext()) {
//				CoreLabel label = ptbt.next();
//				System.out.println(label);
//			}
//			
////			System.out.println("\n\n\n\n\n\n\n");
//		}

		String text = "this is a text";
		
		System.out.println(Tokenizer.tokenize(text).toString());
		
		System.out.println(EnglishLemmatization.getLemmas(text).toString());
		
//		Properties props = new Properties(); 
//		
//        props.put("annotators", "tokenize, ssplit, pos, lemma"); 
//        StanfordCoreNLP pipeline = new StanfordCoreNLP(props, false);
////        String text = "feet" ;
////        Annotation document = pipeline.process(text);  
//
//        for(CoreMap sentence: document.get(SentencesAnnotation.class))
//        {    
//            for(CoreLabel token: sentence.get(TokensAnnotation.class))
//            {       
//                String word = token.get(TextAnnotation.class);      
//                String lemma = token.get(LemmaAnnotation.class); 
//                System.out.println("lemmatized version :" + lemma);
//            }
//        }
		
		
//		Properties props = new Properties();
//		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
//		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//
//		// read some text in the text variable
//		String text = "this is a text to test the annotator";
//
//		// create an empty Annotation just with the given text
//		Annotation document = new Annotation(text);
//
////		// run all Annotators on this text
////		pipeline.annotate(document);
//		String text= "this is an exemple";
//		FeatureMap params = Factory.newFeatureMap();
//		params.put(gate.Document.DOCUMENT_STRING_CONTENT_PARAMETER_NAME, text);
//		Document doc=(gate.Document)Factory.createResource("gate.corpora.DocumentImpl",params);
//
//		Corpus corpus = Factory.newCorpus("StandAloneAnnie corpus");
//		corpus.add(doc);
//		
//		TokenizerEN token = new TokenizerEN();
//		Normaliser a = new Normaliser();
//		try {
//			a.setCorpus(corpus);
////			a.setDocument(doc);
//			a.setDictURL(new URL("File:/Users/luizdaniel/GitHub/Twitter-Information-Retrieval/Twitter-Information-Retrieval-Project/resources/normaliser/english.jaspell"));
//			a.setOrthURL(new URL("File:/Users/luizdaniel/GitHub/Twitter-Information-Retrieval/Twitter-Information-Retrieval-Project/resources/normaliser/orth.en.csv"));
//			
//			a.init();
//			
////			gate.Document doc;
////			a.setDocument(doc);
//			a.execute();
////			token.setAnnotationSetName(text);
//			
//			
////			a.addProgressListener((ProgressListener) preprocessing.tokenize.Tokenizer.tokinize(text));
////			a.setOrigTextFeature("For me, my bed is the best place in the world followed by Chicago. I miss the time where they were in the same place 😴 😢🛌");
//			
//			
////			a.setDictURL(new URL("/Users/luizdaniel/GitHub/Twitter-Information-Retrieval/Twitter-Information-Retrieval-Project/libs/jaspell.jar"));
////			a.execute();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(a.);
//		a.addStatusListener(new  );
		
	}

}
