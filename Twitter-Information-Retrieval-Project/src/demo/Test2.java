package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		String test = "@RafaeIVentura @CdNLeon hahahshahahsha  @some_thing ";
		
		Pattern p = Pattern.compile("(@\\w+)");
		Matcher m = p.matcher(test);
		StringBuffer result = new StringBuffer();
		while (m.find()) {
			System.out.println("Found user " + m.group() + ".");
		}
	}

}
