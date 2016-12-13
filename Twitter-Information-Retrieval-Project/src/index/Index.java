package index;

import java.util.ArrayList;

public class Index {

	float frequency;
	ArrayList<Integer> postingsList;
	
	public Index() {
		this.frequency = 0;
		this.postingsList = new ArrayList<Integer>();
	}

	public float getFrequency() {
		return frequency;
	}

	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	public ArrayList<Integer> getPostingsList() {
		return postingsList;
	}

	public void setPostingsList(ArrayList<Integer> postingsList) {
		this.postingsList = postingsList;
	}
	
	
}
