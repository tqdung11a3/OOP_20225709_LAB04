package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist,
			List<Track> tracks) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
	}
    
    
    
    

	public CompactDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		// TODO Auto-generated constructor stub
	}





	public String getArtist() {
		return artist;
	}



	public void setArtist(String artist) {
		this.artist = artist;
	}



	public List<Track> getTracks() {
		return tracks;
	}



	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}



	public void addTrack(Track t) {
        if (!tracks.contains(t)) {
            tracks.add(t);
            System.out.println("Track has been added: " + t);
        } else {
            System.out.println("Track has already been existed: " + t);
        }
    }

    public void removeTrack(Track t) {
        if (tracks.contains(t)) {
            tracks.remove(t);
            System.out.println("Track removed: " + t);
        } else {
            System.out.println("Track not found: " + t);
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track t : tracks) {
            totalLength += t.getLength();
        }
        return totalLength;
    }


    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Total Length: " + this.getLength() + " seconds");
        for (Track t : tracks) {
            t.play();
        }
    }

    public String toString() {
        return this.getId() + " " + " CD " + this.getTitle() + " " + this.getCategory() + " " + this.getDirector() + " " + this.artist + " " + this.getLength() + " " + this.getCost() + "$"; 
    }


    
}
