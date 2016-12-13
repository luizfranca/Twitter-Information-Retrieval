package demo;

import java.util.ArrayList;

import crawler.Crawler;
import data.Tweet;
import persistence.xml.XMLPersistence;

public class TestCrawler {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String oAuthConsumerKey = "RjlThI9wLbLv4ah8tGjcAsEgb";
		String oAuthConsumerSecret = "QKMYM1biCnvFQG0j208z9fHibwDzUXhGvOFWoJaf4Pvs8ZpbRy";
		String oAuthAccessToken = "247019278-dDBJCABXdCfwrBv6hWhbjrxYWPmzkJmPAx0YLQAt";
		String oAuthAccessTokenSecret = "gU7oqwrusWL5qBXw0DcOKE7hYrkF9iErHNuxp37oJeEZl";

		Crawler c = new Crawler(oAuthConsumerKey, oAuthConsumerSecret, oAuthAccessToken, oAuthAccessTokenSecret);

		ArrayList<Tweet> tweets = c.runCrawlerByUser("luizdaniel78", 2);
		
		System.out.println(tweets.size());
		
		XMLPersistence.saveTweets(tweets, "tweetsEN.xml");
	}

}
