package utilities;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import data.Tweet;

public class TweetExtractor {
	
	/*
	 * May need changes on the content extraction
	 * it returns the url to the next page
	*/
	public static void getTweets(String page, ArrayList<Tweet> tweets) {		
		
		Document document = Jsoup.parse(page);
		
		Elements divs = document.getElementsByClass("content");
		
		for (Element div : divs) {
			Element contentDiv = div.getElementsByClass("js-tweet-text-container").get(0);
			Elements insideDiv = contentDiv.select("p");
			String content = insideDiv.get(0).ownText();
			
			Element authorsDiv = div.getElementsByClass("account-group").get(0);
			String author = authorsDiv.attr("href").substring(1);
			
			Element dateDiv = div.getElementsByClass("tweet-timestamp").get(0);
			String date = dateDiv.attr("title");
			
			
			Tweet tweet = new Tweet(author, content, date);
			
			tweets.add(tweet);	
		}
	}
}
