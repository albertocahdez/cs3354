import java.util.*;

class LocalFile {
	String filename;

	LocalFile(String f) {
		this.filename = f;
	}
}


class CloudTrack {
	String url;

	CloudTrack(String u) {
		this.url = u;
	}
}


class PlaylistManager {
	// Different structures for different sources
	public List<LocalFile> localFiles = new ArrayList<>();
	public Stack<CloudTrack> cloudTracks = new Stack<>();

	public void playAll() {
		// Manually handling ArrayList
		for (int i = 0; i < localFiles.size(); i++) {
			System.out.println("Playing local: " + localFiles.get(i).filename);
		}

		// Manually handling Stack (different logic/ordering)
		while (!cloudTracks.isEmpty()) {
			System.out.println("Playing cloud: " + cloudTracks.pop().url);
		}
	}
}
