package demo;

import java.util.ArrayList;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Another {

	
	/*
	 * Code from: http://stackoverflow.com/questions/2943161/get-tweets-of-a-public-twitter-profile
	 * My keys from twitter dev app
	 * 
	 */
	
	public static void main(String[] a) throws TwitterException {

	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setOAuthConsumerKey("RjlThI9wLbLv4ah8tGjcAsEgb");
	    cb.setOAuthConsumerSecret("QKMYM1biCnvFQG0j208z9fHibwDzUXhGvOFWoJaf4Pvs8ZpbRy");
	    cb.setOAuthAccessToken("247019278-dDBJCABXdCfwrBv6hWhbjrxYWPmzkJmPAx0YLQAt");
	    cb.setOAuthAccessTokenSecret("gU7oqwrusWL5qBXw0DcOKE7hYrkF9iErHNuxp37oJeEZl");

	    Twitter twitter = new TwitterFactory(cb.build()).getInstance();

	    int pageno = 1;
	    String user = "nilmoretto";
	    ArrayList<Status> statuses = new ArrayList<Status>();
	    
	    
	    while (true) {

	      try {

	        int size = statuses.size(); 
	        Paging page = new Paging(pageno++, 100);
	        statuses.addAll(twitter.getUserTimeline(user, page));
//	        if (statuses.size() == size)
	          break;
	      }
	      
	      catch(TwitterException e) {

	        e.printStackTrace();
	      }
	    }
	    
	    
	    Status s = statuses.get(0);
	    
	    System.out.println("Author: " + s.getUser().getScreenName());
	    System.out.println("Is there: " + s.getText().contains("@"));
	    System.out.println("Test: " + s.getText().matches("(@\\w*)"));
	    System.out.println("Text: " + s.getText());
	    System.out.println("Tweet: "+ s);
	    System.out.println("Total: "+statuses.size());
	}
	
}
