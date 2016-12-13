package crawler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data.Tweet;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Crawler {

	Twitter twitter;

	public Crawler(String oAuthConsumerKey, String oAuthConsumerSecret, String oAuthAccessToken,
			String oAuthAccessTokenSecret) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setOAuthConsumerKey(oAuthConsumerKey);
		cb.setOAuthConsumerSecret(oAuthConsumerSecret);
		cb.setOAuthAccessToken(oAuthAccessToken);
		cb.setOAuthAccessTokenSecret(oAuthAccessTokenSecret);
		
		this.twitter = new TwitterFactory(cb.build()).getInstance();	
	}

	private ArrayList<String> getTags(String text) {
		ArrayList<String> tags = new ArrayList<String>();

		Pattern p = Pattern.compile("(@\\w+)");
		Matcher m = p.matcher(text);

		while (m.find()) {
			tags.add(m.group().substring(1));
		}

		return tags;
	}

	private ArrayList<Status> getStatusesByUser(String user) {

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

	public ArrayList<Tweet> runCrawlerByUser(String starter, int limit) throws Exception {

		ArrayList<Tweet> tweets = new ArrayList<Tweet>();

		ArrayList<String> tags = new ArrayList<String>();
		ArrayList<String> allTags = new ArrayList<String>();

		int counter = 0;

		tags.add(starter);
		allTags.add(starter);

		do {
			ArrayList<Status> statuses = getStatusesByUser(tags.get(0));

			counter++;

			for (Status status : statuses) {

				String author = status.getUser().getScreenName();
				String content = status.getText();
				String date = status.getCreatedAt().toString();

				ArrayList<String> temp = getTags(content);

				for (String string : temp) {
					if (!allTags.contains(string)) {
						allTags.add(string);
						tags.add(string);
					}
				}

				if (!status.getLang().equals("en")) {
					continue;
				}

				Tweet tweet = new Tweet(author, content, date);
				
				tweets.add(tweet);
			}

//			System.out.println("End: " + counter + " - User: " + tags.get(0) + " - Number of tweets: " + tweets.size()
//					+ " - Number of tags: " + allTags.size());

			tags.remove(0);

		} while (!tags.isEmpty() && counter < limit);

//		System.out.println("Number of tweets: " + tweets.size());
//		System.out.println("Number of tags: " + allTags.size());

		return tweets;
	}
}
