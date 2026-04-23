public class AuthService {
	// This violates the Open/Closed Principle
	public boolean login(String username, String password, String region) {
		boolean isAllowed = false;

		// Hardcoded logic for different policies
		if (region.equals("US")) {
			// Token Bucket logic
			isAllowed = checkTokenBucket(username);
		} else if (region.equals("EU")) {
			// Fixed Window logic
			isAllowed = checkFixedWindow(username);
		} else if (region.equals("ASIA")) {
			// Sliding Window logic
			isAllowed = checkSlidingWindow(username);
		}

		if (!isAllowed) {
			System.out.println("Rate limit exceeded for region: " + region);
			return false;
		}

		// Proceed with authentication...
		return true;
	}

	private boolean checkTokenBucket(String user) {
		/* implementation */ return true;
	}

	private boolean checkFixedWindow(String user) {
		/* implementation */ return true;
	}

	private boolean checkSlidingWindow(String user) {
		/* implementation */ return true;
	}
}
