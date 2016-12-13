package data;

import java.util.ArrayList;

public class Tweet {
	
	static int idCounter = 0;
	int id;
	String author;
	String content;
	String date;
	
	ArrayList<String> analyzed;
	
	public Tweet(){
		this.id = Tweet.idCounter++;
	}
	
	public Tweet(String author, String content, String date) {
		this.id = Tweet.idCounter++;
		this.author = author;
		this.content = content;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public ArrayList<String> getAnalyzed() {
		return analyzed;
	}

	public void setAnalyzed(ArrayList<String> analyzed) {
		this.analyzed = analyzed;
	}

	@Override
    public String toString() {
            return "Tweet [id=" + id + ", author=" + author + ", content="
                            + content + ", date=" + date + "]";
    }
}