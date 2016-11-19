package utilities;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Data.Tweet;

public class TweetExtractor {
	//ArrayList<Tweet>
	public static void getTweets(String page) {		
		
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		
		Document document = Jsoup.parse(page);
		Elements divs = document.getElementsByClass("content");
		System.out.println(divs.size());
		for (Element div : divs) {
			Element contentDiv = div.getElementById("js-tweet-text-container");
			String content = contentDiv.select("p").get(0).ownText();
			String author = div.getElementsByClass("account-group").get(0).getElementsByAttribute("href").get(0).toString();
//			Tweet tweet = new Tweet();
////			System.out.println(div.toString());
//			Elements text = div.select("p");
//			for (Element element : text) {
//				tweet.setContent(element.ownText());
//				
//			}
//			
		}
		System.out.println(divs.get(0).toString());
		
	}
}
