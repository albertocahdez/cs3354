import java.util.*;

public class CloudPlaylist {
	private Stack<String> tracks = new Stack<>();

	public void addTrack(String url) {
		tracks.push(url);
	}

	public TrackIterator createIterator() {
		return new CloudIterator();
	}

	private class CloudIterator implements TrackIterator {
		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < tracks.size();
		}

		@Override
		public String next() {
			// Accessing stack elements by index for traversal without popping
			return tracks.get(current++);
		}
	}
}
