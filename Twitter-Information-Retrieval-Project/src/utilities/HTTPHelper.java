package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HTTPHelper {
	
	public static String getPage(String url) throws IOException {
		String line = "", page = "";
	    URL myUrl = null;
	    BufferedReader in = null;
	    try {
	        myUrl = new URL(url);
	        in = new BufferedReader(new InputStreamReader(myUrl.openStream()));

	        while ((line = in.readLine()) != null) {
	            page += line;
	        }
	    } finally {
	        if (in != null) {
	            in.close();
	        }
	    }

	    return page;
	}

}
