package data;

public class Post {

	float tf_idf;
	Integer docID;
	
	public Post() {
		this.tf_idf = 0;
		this.docID = null; 
	}
	
	public Post(float tf_idf, int docID) {
		this.tf_idf = tf_idf;
		this.docID = docID;
	}

	public float getTf_idf() {
		return tf_idf;
	}

	public void setTf_idf(float tf_idf) {
		this.tf_idf = tf_idf;
	}

	public Integer getDocID() {
		return docID;
	}

	public void setDocID(Integer docID) {
		this.docID = docID;
	}
}
