package demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

import crawler.Crawler;
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
import grow.retriblog.preprocessing.englishFiltering.spec.prov.IEnglishFiltering;
import grow.retriblog.utilities.languageDetect.impl.*;
import grow.retriblog.utilities.languageDetect.spec.*;
import grow.retriblog.utilities.languageDetect.spec.prov.*;
import persistence.xml.XMLPersistence;
import preprocessing.englishLemmatisation.EnglishLemmatisation;
import preprocessing.stopWordsRemover.StopWordsRemover;
import preprocessing.tokenizer.Tokenizer;

import java.io.FileReader;
import java.io.FileWriter;
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

//		String text = "this is a text";
//		
//		System.out.println(Tokenizer.tokenize(text).toString());
//		
//		System.out.println(EnglishLemmatization.getLemmas(text).toString());
//		
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
		
		
//		File f = 
//		ArrayList<String> list = new ArrayList<String>();
//		list.addAll(readFile("stopwordslist.txt"));
//		ArrayList<String> lemmas = new ArrayList<String>();
//		for (String string : list) {
//			ArrayList<String> aux = EnglishLemmatization.getLemmas(string);
//			for (String string2 : aux) {
//				if (!lemmas.contains(string2)) {
//					lemmas.add(string2);
//				}
//			}
//		}
//		writeFile("test.txt", lemmas);
//		for (String string : list) {
//			System.out.println(string);
//		}
		/*
		String text = "I was very @this_is_a_test #imfucked pleased to know that you liked my show. So if you want to pass on this class, you better find how to do this. You have to make this code work TODAY. Not tomorrow, not the day after tomorrow but today.";
//		ArrayList<String> tokens = preprocessing.tokenizer.Tokenizer.tokenize(text);
		ArrayList<String> lemmas = EnglishLemmatisation.getLemmas(text);
//		ArrayList<String> results = StopWordsRemover.removeStopWords(lemmas, "stopwordslist.txt");
		
//		System.out.println(tokens.toString());
		System.out.println(lemmas.toString());
//		System.out.println(results.toString());
		*/
		
//		IManager m = LanguageDetectFactory.getManager();
//		ILanguageDetect ld = (ILanguageDetect) m.getProvidedInterface();
////	/*	
//		System.out.println(ld.detect("Esse texto foi escrito em português"));
//		System.out.println(ld.detect("And this text was written in English"));
//		System.out.println(ld.detect("text"));
////		*/
//		grow.retriblog.preprocessing.englishFiltering.spec.prov.IManager im =  grow.retriblog.preprocessing.englishFiltering.impl.EnglishFilteringFactory.getManager();
//		grow.retriblog.preprocessing.englishFiltering.spec.prov.IEnglishFiltering ef = (IEnglishFiltering) im.getProvidedInterface();
//		
//		
//		System.out.println(ef.analyzeString("And this text @luizdaniel78 #tbt was written in English"));	
//		
//		ld.getProvidedInterface();
		
		
		
		ArrayList<String> animals = new ArrayList<String>();
		animals.add("bat");
		animals.add("owl");
		animals.add("bat");
		animals.add("bat");
		
		int occurrences = Collections.frequency(animals, "baat");
		
		System.out.println(occurrences);
	}
	
	private static List<String> readFile(String filename)
	{
	  List<String> records = new ArrayList<String>();
	  try
	  {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
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
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}

	private static void writeFile(String filename, ArrayList<String> stopwords) {
		
		try {
	
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			
			for (String string : stopwords) {
				writer.write(string + "\n");
			}
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
