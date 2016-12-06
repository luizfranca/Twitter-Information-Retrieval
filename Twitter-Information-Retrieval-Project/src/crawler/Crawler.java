package crawler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data.Tweet;
import persistence.xml.XMLHelper;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Crawler {

	Twitter twitter;

	private ArrayList<String> getTags(String text) {
		ArrayList<String> tags = new ArrayList<String>();

		Pattern p = Pattern.compile("(@\\w+)");
		Matcher m = p.matcher(text);

		while (m.find()) {
			tags.add(m.group().substring(1));
		}

		return tags;
	}

	private ArrayList<Status> getStatuses(String user) {

		ArrayList<Status> statuses = new ArrayList<Status>();

		int pageno = 1;

		while (true) {

			try {

				int size = statuses.size();
				Paging page = new Paging(pageno++, 100);
				statuses.addAll(twitter.getUserTimeline(user, page));
				if (statuses.size() == size)
					break;
			}

			catch (TwitterException e) {

				e.printStackTrace();
				break;
			}
		}

		return statuses;
	}

	public void runCrawler(String starter, int limit) throws Exception {

		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		
		ArrayList<String> tags = new ArrayList<String>();
		ArrayList<String> allTags = new ArrayList<String>();

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setOAuthConsumerKey("RjlThI9wLbLv4ah8tGjcAsEgb");
		cb.setOAuthConsumerSecret("QKMYM1biCnvFQG0j208z9fHibwDzUXhGvOFWoJaf4Pvs8ZpbRy");
		cb.setOAuthAccessToken("247019278-dDBJCABXdCfwrBv6hWhbjrxYWPmzkJmPAx0YLQAt");
		cb.setOAuthAccessTokenSecret("gU7oqwrusWL5qBXw0DcOKE7hYrkF9iErHNuxp37oJeEZl");

		this.twitter = new TwitterFactory(cb.build()).getInstance();

		int counter = 0;

		tags.add(starter);
		allTags.add(starter);
		
		do {
			ArrayList<Status> statuses = getStatuses(tags.get(0));

			

			counter++;

			for (Status status : statuses) {
				String author = status.getUser().getScreenName();
				String content = status.getText();
				String date = status.getCreatedAt().toString();

				Tweet tweet = new Tweet(author, content, date);

				tweets.add(tweet);

				ArrayList<String> temp = getTags(content);
				
				for (String string : temp) {
					if (!allTags.contains(string)) {
						allTags.add(string);
						tags.add(string);
					}
				}
			}

			System.out.println("End: " + counter + " - User: " + tags.get(0) + " - Number of tweets: " + tweets.size() + " - Number of tags: " + allTags.size());
			
			tags.remove(0);
			
		} while (!tags.isEmpty() && counter < limit);

		System.out.println("Number of tweets: " + tweets.size());
		System.out.println("Number of tags: " + allTags.size());
		
		XMLHelper.saveTweets(tweets);
	}

}
