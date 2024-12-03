package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    

    public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
    
    

	public Track() {
		super();
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public void play() {
        System.out.println("Playing Track: " + this.title);
        System.out.println("Track length: " + this.length);
    }

    public boolean equals(Track t) {
    	if (length == t.getLength() && title == t.getTitle()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
