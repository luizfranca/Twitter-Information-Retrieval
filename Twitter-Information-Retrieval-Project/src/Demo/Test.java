package Demo;

import java.io.IOException;

import utilities.HTTPHelper;
import utilities.TweetExtractor;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String page;
		try {
			page = HTTPHelper.getPage("https://twitter.com/luizdaniel78");
//			System.out.println(page);
			TweetExtractor.getTweets(page);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
