package Demo;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Another {

	
	public static void main(String[] a) {

	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setOAuthConsumerKey("RjlThI9wLbLv4ah8tGjcAsEgb");
	    cb.setOAuthConsumerSecret("QKMYM1biCnvFQG0j208z9fHibwDzUXhGvOFWoJaf4Pvs8ZpbRy");
	    cb.setOAuthAccessToken("247019278-dDBJCABXdCfwrBv6hWhbjrxYWPmzkJmPAx0YLQAt");
	    cb.setOAuthAccessTokenSecret("gU7oqwrusWL5qBXw0DcOKE7hYrkF9iErHNuxp37oJeEZl");

	    Twitter twitter = new TwitterFactory(cb.build()).getInstance();

	    int pageno = 1;
	    String user = "tweetsauce";
	    List statuses = new ArrayList();

	    while (true) {

	      try {

	        int size = statuses.size(); 
	        Paging page = new Paging(pageno++, 100);
	        statuses.addAll(twitter.getUserTimeline(user, page));
	        if (statuses.size() == size)
	          break;
	      }
	      
	      catch(TwitterException e) {

	        e.printStackTrace();
	      }
	    }

	    System.out.println("Tweet: "+statuses.get(0).toString());
	    System.out.println("Total: "+statuses.size());
	}
	
}
