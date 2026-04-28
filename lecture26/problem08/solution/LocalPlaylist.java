import java.util.*;

public class LocalPlaylist {
	private List<String> tracks = new ArrayList<>();

	public void addTrack(String path) {
		tracks.add(path);
	}

	public TrackIterator createIterator() {
		return new LocalIterator();
	}

	private class LocalIterator implements TrackIterator {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < tracks.size();
		}

		@Override
		public String next() {
			return tracks.get(index++);
		}
	}
}
