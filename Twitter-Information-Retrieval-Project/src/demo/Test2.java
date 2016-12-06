package demo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import data.Tweet;
import utilities.XMLHelper;

public class Test2 {

	public static void main(String[] args) {
		
//		String test = "@RafaeIVentura @CdNLeon hahahshahahsha  @some_thing ";
//		
//		Pattern p = Pattern.compile("(@\\w+)");
//		Matcher m = p.matcher(test);
//		StringBuffer result = new StringBuffer();
//		while (m.find()) {
//			System.out.println("Found user " + m.group() + ".");
//		}
		
//		LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
//		
//		if (hashSet.add("oi")) System.out.println("okay");
//		
//		if (!hashSet.add("oi")) System.out.println("okay");
//		
//		
//		ArrayList<String> test = new ArrayList<String>();
//		test.add("oi");
//		test.add("oi");
//		test.add("oit");
//		
//		System.out.println(hashSet.size());
//		hashSet.addAll(test);
//		System.out.println(hashSet.size());
//		
////		hashSet.
//		
//		System.out.println(test.contains("ois"));
//		
		
		ArrayList<Tweet> a = XMLHelper.readTweet();
//		for (Tweet tweet : a) {
//			System.out.println(tweet.toString());
//		}
	}

}
