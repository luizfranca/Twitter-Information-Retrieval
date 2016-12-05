package demo;

import java.io.IOException;
import java.util.ArrayList;

import data.Tweet;
import utilities.HTTPHelper;
import utilities.TweetExtractor;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String page;
		try {
			page = HTTPHelper.getPage("https://twitter.com/luizdaniel78");
//			System.out.println(page);
			
			ArrayList<Tweet> tweets = new ArrayList<Tweet>();
			TweetExtractor.getTweets(page, tweets);		
			System.out.println(tweets.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
