public class MediaPlayer {
	public static void main(String[] args) {
		LocalPlaylist local = new LocalPlaylist();
		local.addTrack("song1.mp3");

		CloudPlaylist cloud = new CloudPlaylist();
		cloud.addTrack("https://stream.music/track10");

		// Uniform traversal
		System.out.println("--- Local Tracks ---");
		renderPlaylist(local.createIterator());

		System.out.println("\n--- Cloud Tracks ---");
		renderPlaylist(cloud.createIterator());
	}

	// This method doesn't care if it's local, cloud, or a stream!
	private static void renderPlaylist(TrackIterator iterator) {
		while (iterator.hasNext()) {
			System.out.println("Now Playing: " + iterator.next());
		}
	}
}
