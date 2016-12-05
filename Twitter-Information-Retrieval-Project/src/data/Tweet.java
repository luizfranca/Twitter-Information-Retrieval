package data;

public class Tweet {
	
	static int idCounter = 0;
	int id;
	String author;
	String content;
	String date;
	
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
	
}