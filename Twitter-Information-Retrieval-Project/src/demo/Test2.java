package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;

import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import data.Tweet;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.TokenizerAnnotator;
import edu.stanford.nlp.process.PTBTokenizer;
import gate.Gate;
import gate.creole.annic.apache.lucene.analysis.Token;
import gate.creole.annic.apache.lucene.analysis.Tokenizer;
import persistence.xml.XMLPersistence;
import preprocessing.tokenize.Tokenize;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;

public class Test2 {

	public static void main(String[] args) throws FileNotFoundException {

		// String test = "@RafaeIVentura @CdNLeon hahahshahahsha @some_thing ";
		//
		// Pattern p = Pattern.compile("(@\\w+)");
		// Matcher m = p.matcher(test);
		// StringBuffer result = new StringBuffer();
		// while (m.find()) {
		// System.out.println("Found user " + m.group() + ".");
		// }

		// LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
		//
		// if (hashSet.add("oi")) System.out.println("okay");
		//
		// if (!hashSet.add("oi")) System.out.println("okay");
		//
		//
		// ArrayList<String> test = new ArrayList<String>();
		// test.add("oi");
		// test.add("oi");
		// test.add("oit");
		//
		// System.out.println(hashSet.size());
		// hashSet.addAll(test);
		// System.out.println(hashSet.size());
		//
		//// hashSet.
		//
		// System.out.println(test.contains("ois"));
		//

		// ArrayList<Tweet> a = XMLHelper.readTweet();
		//// for (Tweet tweet : a) {
		//// System.out.println(tweet.toString());
		//// }
		//// System.out.println(Tweet.class.getFields()[0]);
		// Tokenizer v = new Tokenizer() {
		//
		// @Override
		// public Token next() throws IOException {
		// // TODO Auto-generated method stub
		// return null;
		// }
		// };

		// try {
		// // this should point to the ANNIE directory
		// // under the gate/plugins folder
		// File file = new File("c:/gate/plugins/ANNIE");
		// Gate.init();
		// Gate.getCreoleRegister().registerDirectories(file.toURL());
		//
		// // creating tokenizer
		// DefaultTokenizer tokeniser =
		// (gate.creole.tokeniser.DefaultTokeniser) Factory
		// .createResource("gate.creole.tokeniser.DefaultTokeniser");
		//
		// // creating an instance of document
		// // from the file specified as args[0]
		// FeatureMap params = Factory.newFeatureMap();
		// File docFile = new File(args[0]);
		// params.put("sourceUrl", docFile.toURL());
		// Document doc = (Document) Factory.createResource(
		// "gate.corpora.DocumentImpl", params);
		//
		// // setting document to tokenizer
		// tokenizer.setDocument(doc);
		// // executing it - this will run tokenizer on top of document
		// // and would generate tokens under the default annotation set
		// tokenizer.execute();
		//
		// // you have all annotations in annotSet
		// AnnotationSet annotSet = doc.getAnnotations();
		//
		// } catch(Exception e) {
		// e.printStackTrace();
		// }
		//
		//
		// PTBTokenizer.
		// TokenizerAnnotator a = new TokenizerAnnotator();
		// Annotation b = new Annotation("Exemplo de texto maior texto ainda");
		// a.annotate(b.);
		// System.out.println(b);

		// ArrayList<String> args = new ArrayList<String>();
		args = new String[] { "exemplo de texto para textar o texto @MrNobre https://t.co/ux57Tgi10F", "For me, my bed is the best place in the world followed by Chicago. I miss the time where they were in the same place #exemple #exemple-legal outro,teste,legal,separa,pfv1 aren’t" };
		
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
		
		System.out.println(Tokenize.tokinize(text).toString());
	}

}
